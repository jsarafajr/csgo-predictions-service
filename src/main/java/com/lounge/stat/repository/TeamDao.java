package com.lounge.stat.repository;

import com.lounge.stat.model.TeamEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jsarafajr on 13.08.14.
 */
@Repository
@Transactional
public class TeamDao extends GenericDao<TeamEntity> {

    public TeamEntity get(String teamName) {
        Session session = getSession();
        Query query = session.createQuery("from TeamEntity team where team.name='" + teamName + "'");
        return (TeamEntity) query.uniqueResult();
    }

    @Override
    public TeamEntity get(TeamEntity team) {
        return get(team.getName());
    }

    @Override
    public List<TeamEntity> getAll() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(TeamEntity.class);
        criteria.addOrder(Order.asc("name"));
        return criteria.list();
    }

}
