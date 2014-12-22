package com.lounge.stat.repository;

import com.lounge.stat.model.LastCustomPredictionEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jsarafajr on 03.09.14.
 */
@Repository
public class LastPredDao extends GenericDao<LastCustomPredictionEntity> {
    @Override
    public LastCustomPredictionEntity get(LastCustomPredictionEntity object) {
        Session session = getSession();

        Query query = session.createQuery("from LastCustomPredictionEntity m where m=:entity");
        query.setParameter("entity", object);

        return (LastCustomPredictionEntity) query.uniqueResult();
    }

    @Override
    public List<LastCustomPredictionEntity> getAll() {
        Session session = getSession();

        Criteria criteria = session.createCriteria(LastCustomPredictionEntity.class);
        criteria.addOrder(Order.desc("date"));

        return criteria.list();
    }
}
