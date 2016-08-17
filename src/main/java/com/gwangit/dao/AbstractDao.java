package com.gwangit.dao;

import com.gwangit.common.InterfaceCommon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wgz on 8/14/2016.
 */
public abstract class AbstractDao<T extends Serializable> implements InterfaceCommon<T> {
    private Class<T> clazz;

    private static SessionFactory sessionFactory;

    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }


    public final T findOne(final long id) {
        return getCurrentSession().get(clazz, id);
    }


    public final List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    public final void create(final T entity) {
        getCurrentSession().saveOrUpdate(entity);
    }


    public final void update(final T entity) {
        getCurrentSession().update(entity);
    }


    public final void delete(final T entity) {
        getCurrentSession().delete(entity);
    }

    public final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


}
