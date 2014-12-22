package com.lounge.stat.repository;

import com.lounge.stat.model.PredictionEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jsarafajr on 24.08.14.
 */
@Repository
public class PredictionDao extends GenericDao<PredictionEntity> {

    public PredictionEntity get(int id) {
        Session session = getSession();

        Query query = session.createQuery("from PredictionEntity p where p.id=:id");
        query.setParameter("id", id);

        return (PredictionEntity) query.uniqueResult();
    }

    @Override
    public PredictionEntity get(PredictionEntity prediction) {
        Session session = getSession();

        Query query = session.createQuery("from PredictionEntity p where p.date=:date " +
                "and p.team1=:team1 and p.team2=:team2");
        query.setParameter("date", prediction.getDate());
        query.setParameter("team1", prediction.getTeam1());
        query.setParameter("team2", prediction.getTeam2());

        return (PredictionEntity) query.uniqueResult();
    }

    @Override
    public List<PredictionEntity> getAll() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(PredictionEntity.class);
        return criteria.list();
    }

    public List<PredictionEntity> getAllSorted() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(PredictionEntity.class);
        criteria.addOrder(Order.asc("date"));
        return criteria.list();
    }

}
