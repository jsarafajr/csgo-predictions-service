package com.lounge.stat.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jsarafajr on 22.08.14.
 */
@Repository
@Transactional
public abstract class GenericDao<T> {
    @Autowired
    protected SessionFactory sessionFactory;

    public abstract T get(T object);

    public abstract List<T> getAll();

    public boolean isExist(T object) {
        return get(object) != null;
    }

    public void save(T object) {
        getSession().save(object);
    }

    public void update(T object) {
        getSession().update(object);
    }

    public void delete(T object) {
        getSession().delete(object);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
