package com.gwangit.service.impl;

import com.gwangit.common.InterfaceCommon;
import com.gwangit.dao.AbstractDao;
import com.gwangit.dao.impl.UserDaoImpl;
import com.gwangit.dao.inter.UserDaoInter;
import com.gwangit.model.User;
import com.gwangit.service.AbstractService;
import com.gwangit.service.inter.UserServiceInter;

import java.util.List;

/**
 * Created by gwang on 8/17/2016.
 */
public class UserServiceImpl extends AbstractService<User> implements UserServiceInter{

    private UserDaoInter userDao = new UserDaoImpl();

    protected AbstractDao<User> getDao(){
        return (AbstractDao<User>)userDao;
    }

    @Override
    public List<User> findUserByName(String name) {
        return null;
    }
}
