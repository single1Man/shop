
package com.dao;

import com.pojo.Category;
import com.utils.JDBCDBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.SQLException;
import java.util.List;

public class categoryDao {

    QueryRunner qr=new QueryRunner(JDBCDBCPUtils.getDataSource());

    public List<Category> findAll() {
        String sql="select * from category";
        List<Category> categoryList=null;
        try {
            categoryList=qr.query(sql,new BeanListHandler<>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
}
