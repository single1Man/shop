package com.pojo;

public class Coupon {
    private Integer coupon_id;
    private String coupon;

    public Coupon() {
    }

    public Coupon(Integer coupon_id, String coupon) {
        this.coupon_id = coupon_id;
        this.coupon = coupon;
    }

    public Integer getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(Integer coupon_id) {
        this.coupon_id = coupon_id;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }
}
