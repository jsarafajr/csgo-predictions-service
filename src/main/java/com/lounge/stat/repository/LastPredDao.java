package com.lounge.stat.repository;

import com.lounge.stat.model.LastPredEntity;
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
public class LastPredDao extends GenericDao<LastPredEntity> {
    @Override
    public LastPredEntity get(LastPredEntity object) {
        Session session = getSession();

        Query query = session.createQuery("from LastPredEntity m where m=:entity");
        query.setParameter("entity", object);

        return (LastPredEntity) query.uniqueResult();
    }

    @Override
    public List<LastPredEntity> getAll() {
        Session session = getSession();

        Criteria criteria = session.createCriteria(LastPredEntity.class);
        criteria.addOrder(Order.desc("date"));

        return criteria.list();
    }
}
