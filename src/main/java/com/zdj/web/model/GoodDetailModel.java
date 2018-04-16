package com.zdj.web.model;

public class GoodDetailModel {
    private Integer id;
    private String name;
    private String picturePath;
    private Integer bigType;
    private Integer smallType;
    private Integer count;
    private Integer price;
    private String information;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Integer getBigType() {
        return bigType;
    }

    public void setBigType(Integer bigType) {
        this.bigType = bigType;
    }

    public Integer getSmallType() {
        return smallType;
    }

    public void setSmallType(Integer smallType) {
        this.smallType = smallType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
