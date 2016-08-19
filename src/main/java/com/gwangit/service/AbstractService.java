package com.gwangit.service;

import com.gwangit.common.InterfaceCommon;
import com.gwangit.dao.AbstractDao;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import java.io.Serializable;
import java.util.List;


public abstract class AbstractService<T extends Serializable> implements InterfaceCommon<T> {

    @Override
    public T findOne(final long id) {
        Transaction tx = getDao().getCurrentSession().getTransaction();
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
        Transaction tx = getDao().getCurrentSession().getTransaction();
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
        Transaction tx = getDao().getCurrentSession().getTransaction();
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
        Transaction tx = getDao().getCurrentSession().getTransaction();
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
        Transaction tx = getDao().getCurrentSession().getTransaction();
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
