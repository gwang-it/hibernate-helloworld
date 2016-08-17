package com.gwangit.dao.inter;

import com.gwangit.common.InterfaceCommon;
import com.gwangit.model.User;

import java.util.List;

/**
 * Created by wgz on 8/14/2016.
 */
public interface UserDaoInter extends InterfaceCommon<User> {
    List<User> findUserByName(String name);
}
