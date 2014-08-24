package com.lounge.stat.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by jsarafajr on 22.08.14.
 */
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

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
