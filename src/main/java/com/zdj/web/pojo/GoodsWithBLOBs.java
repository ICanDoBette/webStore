package com.zdj.web.pojo;

public class GoodsWithBLOBs extends Goods {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.picture_path
     *
     * @mbg.generated Wed Apr 18 10:45:34 CST 2018
     */
    private String picturePath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.information
     *
     * @mbg.generated Wed Apr 18 10:45:34 CST 2018
     */
    private String information;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.picture_path
     *
     * @return the value of goods.picture_path
     *
     * @mbg.generated Wed Apr 18 10:45:34 CST 2018
     */
    public String getPicturePath() {
        return picturePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.picture_path
     *
     * @param picturePath the value for goods.picture_path
     *
     * @mbg.generated Wed Apr 18 10:45:34 CST 2018
     */
    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath == null ? null : picturePath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.information
     *
     * @return the value of goods.information
     *
     * @mbg.generated Wed Apr 18 10:45:34 CST 2018
     */
    public String getInformation() {
        return information;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.information
     *
     * @param information the value for goods.information
     *
     * @mbg.generated Wed Apr 18 10:45:34 CST 2018
     */
    public void setInformation(String information) {
        this.information = information == null ? null : information.trim();
    }
}