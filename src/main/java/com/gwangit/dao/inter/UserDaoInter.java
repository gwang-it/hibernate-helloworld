package com.gwangit.dao.inter;

import com.gwangit.common.InterfaceCommon;
import com.gwangit.model.User;
import java.util.List;

public interface UserDaoInter extends InterfaceCommon<User> {
    List<User> findUserByName(String name);
}
