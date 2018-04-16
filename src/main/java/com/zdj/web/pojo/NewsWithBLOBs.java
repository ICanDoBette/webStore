package com.zdj.web.pojo;

public class NewsWithBLOBs extends News {
    private String picturePath;

    private String contain;

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath == null ? null : picturePath.trim();
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain == null ? null : contain.trim();
    }
}