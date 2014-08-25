package com.lounge.stat.repository;

import com.lounge.stat.model.PredictionEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jsarafajr on 24.08.14.
 */
@Repository
public class PredictionDao extends GenericDao<PredictionEntity> {

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
        return null;
    }

}
