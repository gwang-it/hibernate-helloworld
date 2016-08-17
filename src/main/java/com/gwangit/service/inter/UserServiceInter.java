package com.gwangit.service.inter;

import com.gwangit.common.InterfaceCommon;
import com.gwangit.model.User;

import java.util.List;

/**
 * Created by gwang on 8/17/2016.
 */
public interface UserServiceInter extends InterfaceCommon<User> {
    List<User> findUserByName(String name);
}
