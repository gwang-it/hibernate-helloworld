package com.gwangit.service.inter;

import com.gwangit.common.InterfaceCommon;
import com.gwangit.model.User;
import java.util.List;


public interface UserServiceInter extends InterfaceCommon<User> {
    List<User> findUserByName(String name);
}
