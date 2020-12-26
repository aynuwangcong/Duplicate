package com.wcc.service;

import com.wcc.beans.User;
import com.wcc.dao.IUserDao;

public class IUserServiceImpl implements IUserService {
    IUserDao userDao;
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public User queryUser(String username, String password) {
        User user = this.userDao.findUser(username,password);
        return user;
    }

    @Override
    public void addUser(User user) {
        this.userDao.AddUser(user);
    }

    @Override
    public void updateUser(User user) {
        this.userDao.updateser(user);
    }


}
