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

    public StringBuilder findCoupon_ids(String username) {
        StringBuilder coupon_ids=new StringBuilder();
        coupon_ids.append("(");
        for (Object coupon_id : userDao.findCoupon_ids(username)) {
            coupon_ids.append(coupon_id);
        }
        coupon_ids.append(")");
        return coupon_ids;
    }
}
