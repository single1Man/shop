package com.dao;

import com.pojo.Coupon;
import com.utils.JDBCDBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class couponDao {
    QueryRunner qr=new QueryRunner(JDBCDBCPUtils.getDataSource());
    public List<Coupon> findCoupons(StringBuilder coupon_ids) {
        String sql="select * from coupon where coupon_id in "+coupon_ids;
        List<Coupon> coupons = null;
        try {
            coupons = qr.query(sql, new BeanListHandler<>(Coupon.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coupons;
    }
}
