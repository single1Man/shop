package com.dao;

import com.pojo.Product;
import com.utils.JDBCDBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class productDao {
    QueryRunner qr=new QueryRunner(JDBCDBCPUtils.getDataSource());

    public List<Product> findPaging(int pageNumber, int pageSize) {

        String sql="select *from product  limit ?,?";
        List<Product> list =null;
        try {
            list = qr.query(sql, new BeanListHandler<>(Product.class),pageNumber,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  list;
    }

    public Integer findAllProductCount() {
        String sql="select count(*) from product";
        Long count=0L;
        try {
            count = qr.query(sql, new ScalarHandler<>());
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return count.intValue();
    }

    public int addProduct(Product product) {
        String sql="insert into product values(?,?,?,?,?,?,?,?,?,?)";
        Object[] params={product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),
        product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCid()};
        try {
            return qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int deleteProduct(String pid) {
        String sql="delete from product where pid=?";
        try {
            return qr.update(sql,pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Product findProductByPid(String pid) {
        String sql="select * from product where pid=?";
        Product product=null;
        try {
            product= qr.query(sql,new BeanHandler<>(Product.class),pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public int deleteProducts(StringBuilder pidBuilder) {
        String sql="delete from product where pid in "+pidBuilder;
        try {
            return qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int editProduct(Product product) {
        String sql="update product set pname=?,is_hot=?,market_price=?,shop_price=?,cid=?,pdesc=? where pid=?";
        Object[] params={product.getPname(),product.getIs_hot(),product.getMarket_price(),product.getShop_price(),product.getCid(),product.getPdesc(),product.getPid()};
        try {
            return qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public List<Product> findAll(String condition,Object[] params){
        String sql="select *from product where 1=1 " +condition +" limit ?,?";

        List<Product> list =null;
        try {
            list = qr.query(sql, new BeanListHandler<>(Product.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  list;
    }

    public Integer findProductCountByCondition(String condition, Object[] params1) {
        String sql="select count(*) from product where 1=1 "+condition;
        Long count=0L;
        try {
            count = qr.query(sql, new ScalarHandler<>(),params1);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return count.intValue();
    }
}
