package com.pojo;

public class Collect {
    private Integer uid;
    private String username;
    private String productName;
    private String productPid;

    public Collect() {
    }

    public Collect(Integer uid, String username, String productName, String productPid) {
        this.uid = uid;
        this.username = username;
        this.productName = productName;
        this.productPid = productPid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPid() {
        return productPid;
    }

    public void setProductPid(String productPid) {
        this.productPid = productPid;
    }
}
