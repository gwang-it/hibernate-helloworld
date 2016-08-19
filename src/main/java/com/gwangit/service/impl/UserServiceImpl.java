package com.gwangit.service.impl;

import com.gwangit.dao.AbstractDao;
import com.gwangit.dao.impl.UserDaoImpl;
import com.gwangit.dao.inter.UserDaoInter;
import com.gwangit.model.User;
import com.gwangit.service.AbstractService;
import com.gwangit.service.inter.UserServiceInter;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import java.util.List;


public class UserServiceImpl extends AbstractService<User> implements UserServiceInter{
    private UserDaoInter userDao = new UserDaoImpl();
    protected AbstractDao<User> getDao(){
        return (AbstractDao<User>)userDao;
    }

    @Override
    public List<User> findUserByName(String name) {
        Transaction tx = getDao().getCurrentSession().getTransaction();
        List<User> users = null;
        try{
            tx.begin();
            users = userDao.findUserByName(name);
            tx.commit();
        }catch (final HibernateException he){
            if (tx != null)
                tx.rollback();
            he.printStackTrace();
        }catch (final Exception e){
            e.printStackTrace();
        }
        return users;
    }
}
