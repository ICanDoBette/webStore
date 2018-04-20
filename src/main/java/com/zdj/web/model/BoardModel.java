package com.zdj.web.model;

public class BoardModel {
    private int goodId;
    private String name;
    private String picturePath;
    private String comment;
    private boolean saleout;

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isSaleout() {
        return saleout;
    }

    public void setSaleout(boolean saleout) {
        this.saleout = saleout;
    }
}
