package com.dao;

import com.pojo.Collect;
import com.utils.JDBCDBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class collectDao {
    QueryRunner qr=new QueryRunner(JDBCDBCPUtils.getDataSource());
    public int addCollect(String username, String pid,String pname) {
        String sql="insert into collect values(?,?,?,?)";
        Object[] params={null,username,pname,pid};
        try {
            return qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int deleteCollect(String username, String pid) {
        String sql="delete from collect where username=? and productPid=?";
        Object[] params={username,pid};
        try {
            return qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<Collect> findCollectsByUsername(String username) {
        String sql="select * from collect where username=?";
        List<Collect> collects=null;
        try {
            collects = qr.query(sql, new BeanListHandler<>(Collect.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collects;
    }

    public Collect findCollect(String username, String pid) {
        String sql="select * from collect where username=? and productPid=?";
        Collect collect=null;
        try {
            collect = qr.query(sql, new BeanHandler<>(Collect.class),username,pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collect;
    }
}
