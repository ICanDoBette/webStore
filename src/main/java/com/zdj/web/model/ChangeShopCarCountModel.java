package com.zdj.web.model;

public class ChangeShopCarCountModel {
    private int shopCarId, buyNum;
    private int userId;
    private String userName;

    public int getShopCarId() {
        return shopCarId;
    }

    public void setShopCarId(int shopCarId) {
        this.shopCarId = shopCarId;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
