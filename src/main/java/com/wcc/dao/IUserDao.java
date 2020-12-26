package com.wcc.dao;

import com.wcc.beans.User;
import org.apache.ibatis.annotations.Param;

public interface IUserDao {
    User findUser(@Param("username") String username,@Param("password") String password);

    void AddUser(User user);
    void updateser(User user);

}
