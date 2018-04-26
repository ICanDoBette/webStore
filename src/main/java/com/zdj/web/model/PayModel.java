package com.zdj.web.model;

import java.util.List;

public class PayModel {
    private List<Integer> shopCartId;
    private Integer userId;
    private Integer addressId;
    private Integer payWay;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public List<Integer> getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(List<Integer> shopCartId) {
        this.shopCartId = shopCartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
}
