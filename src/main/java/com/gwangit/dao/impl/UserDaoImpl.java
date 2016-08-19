package com.gwangit.dao.impl;

import com.gwangit.dao.AbstractDao;
import com.gwangit.dao.inter.UserDaoInter;
import com.gwangit.model.User;
import java.util.List;


public class UserDaoImpl extends AbstractDao<User> implements UserDaoInter{
    public UserDaoImpl() {
        super();
        setClazz(User.class);
    }
    public List<User> findUserByName(String name) {
        return getCurrentSession().createQuery("from User where name = :name")
                .setParameter("name", name).list();
    }
}
