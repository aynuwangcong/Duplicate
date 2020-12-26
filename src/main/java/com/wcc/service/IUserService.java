package com.wcc.service;

import com.wcc.beans.User;
import org.apache.ibatis.annotations.Param;

public interface IUserService {
   User queryUser (String username, String password);

    void addUser(User user);
    void updateUser(User user);

}
