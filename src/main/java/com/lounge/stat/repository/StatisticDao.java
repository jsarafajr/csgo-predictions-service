package com.lounge.stat.repository;

import com.lounge.stat.model.StatisticEntity;
import com.lounge.stat.model.TeamEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jsarafajr on 16.08.14.
 */
@Repository
@Transactional
public class StatisticDao {
    @Autowired
    protected SessionFactory sessionFactory;

    public void addTeamStatistic(StatisticEntity statistic) {
        getSession().save(statistic);
    }

    public StatisticEntity getTeamStatistic(TeamEntity team) {
        Session session = getSession();
        Query query = session.createQuery("from StatisticEntity s where s.team=:team");
        query.setParameter("team", team);
        return (StatisticEntity) query.uniqueResult();
    }

    public boolean isTeamExist(TeamEntity team) {
        return getTeamStatistic(team) != null;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
