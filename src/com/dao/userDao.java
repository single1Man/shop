package com.dao;

import com.pojo.User;
import com.utils.JDBCDBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class userDao {
    QueryRunner qr=new QueryRunner(JDBCDBCPUtils.getDataSource());
    public User findUserByUsername(String username) {
        String sql="select * from user where username=?";
        User user=null;
        try {
            user=qr.query(sql,new BeanHandler<>(User.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public int register(User user) {
        String sql="insert into user values(?,?,?,?,?,?,?,?,?,?)";
        Object[] params={user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode()};
        try {
            return qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
