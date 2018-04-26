package com.zdj.web.model;

import java.util.Date;

public class ShopCarModel {
    private Integer id;
    private String picturePath;
    private String name;
    private Integer price;
    private Integer counts;
    private Date updateTime;
    private Integer allCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }
}
