package com.dao;

import com.pojo.Comment;
import com.utils.JDBCDBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class commentDao {

    QueryRunner qr=new QueryRunner(JDBCDBCPUtils.getDataSource());
    public int addComment(String username, String pname, String content, String date) {
        String sql="insert into comment values(?,?,?,?,?)";
        Object[] params={null,username,pname,content,date};
        try {
            return qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<Comment> findCommentByPid(String pname) {
        String sql="select * from comment where pname=?";
        List<Comment> comments = null;
        try {
            comments=qr.query(sql, new BeanListHandler<>(Comment.class),pname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
}
