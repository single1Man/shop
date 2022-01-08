package com.service;

import com.dao.couponDao;
import com.pojo.Coupon;

import java.util.List;

public class couponService {
    couponDao couponDao=new couponDao();

    public List<Coupon> findCoupons(StringBuilder coupon_ids) {
        return couponDao.findCoupons(coupon_ids);
    }
}
