package com.gwangit.service;

import com.gwangit.common.InterfaceCommon;
import com.gwangit.dao.AbstractDao;
import com.gwangit.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gwang on 8/17/2016.
 */
public abstract class AbstractService<T extends Serializable> implements InterfaceCommon<T> {
    Session session = null;
    Transaction tx = null;

    @Override
    public T findOne(final long id) {
        session = getDao().getCurrentSession();
        tx = session.getTransaction();
        T user = null;
        try{
            tx.begin();
            user = getDao().findOne(id);
            tx.commit();
        }catch (final HibernateException he){
            if (tx != null)
                tx.rollback();
            he.printStackTrace();
        }catch (final Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<T> findAll() {
        session = getDao().getCurrentSession();
        tx = session.getTransaction();
        List<T> resultList = null;
        try{
            tx.begin();
            resultList = getDao().findAll();
            tx.commit();
        }catch (final HibernateException he){
            if (tx != null)
                tx.rollback();
            he.printStackTrace();
        }catch (final Exception e){
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public void create(final T entity) {
        session = getDao().getCurrentSession();
        tx = session.getTransaction();
        try{
            tx.begin();
            getDao().create(entity);
            tx.commit();
        }catch (final HibernateException he){
            if (tx != null)
                tx.rollback();
            he.printStackTrace();
        }catch (final Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(final T entity) {
        session = getDao().getCurrentSession();
        tx = session.getTransaction();
        try{
            tx.begin();
            getDao().update(entity);
            tx.commit();
        }catch (final HibernateException he){
            if (tx != null)
                tx.rollback();
            he.printStackTrace();
        }catch (final Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(final T entity) {
        session = getDao().getCurrentSession();
        tx = session.getTransaction();
        try{
            tx.begin();
            getDao().delete(entity);
            tx.commit();
        }catch (final HibernateException he){
            if (tx != null)
                tx.rollback();
            he.printStackTrace();
        }catch (final Exception e){
            e.printStackTrace();
        }
    }

    protected abstract AbstractDao<T> getDao();
}
