package com.gwangit.dao.impl;

import com.gwangit.dao.common.AbstractDao;
import com.gwangit.dao.inter.UserDaoInter;
import com.gwangit.model.User;

/**
 * Created by wgz on 8/14/2016.
 */
public class UserDaoImpl extends AbstractDao<User> implements UserDaoInter{
    public UserDaoImpl() {
        super();
        setClazz(User.class);
    }
}
