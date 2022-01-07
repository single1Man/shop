package com.service;

import com.dao.userDao;
import com.pojo.User;

public class userService {
    userDao userDao=new userDao();

    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    public int register(User user) {
        return userDao.register(user);
    }
}
