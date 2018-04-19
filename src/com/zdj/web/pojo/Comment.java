package com.zdj.web.pojo;

import java.util.Date;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.id
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.good_id
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    private Integer goodId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.user_id
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.star
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    private Integer star;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.comment
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    private String comment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.create_time
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.create_user
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    private String createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.update_time
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.update_user
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    private String updateUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.is_delete
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    private Byte isDelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.id
     *
     * @return the value of comment.id
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.id
     *
     * @param id the value for comment.id
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.good_id
     *
     * @return the value of comment.good_id
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public Integer getGoodId() {
        return goodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.good_id
     *
     * @param goodId the value for comment.good_id
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.user_id
     *
     * @return the value of comment.user_id
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.user_id
     *
     * @param userId the value for comment.user_id
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.star
     *
     * @return the value of comment.star
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public Integer getStar() {
        return star;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.star
     *
     * @param star the value for comment.star
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public void setStar(Integer star) {
        this.star = star;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.comment
     *
     * @return the value of comment.comment
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.comment
     *
     * @param comment the value for comment.comment
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.create_time
     *
     * @return the value of comment.create_time
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.create_time
     *
     * @param createTime the value for comment.create_time
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.create_user
     *
     * @return the value of comment.create_user
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.create_user
     *
     * @param createUser the value for comment.create_user
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.update_time
     *
     * @return the value of comment.update_time
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.update_time
     *
     * @param updateTime the value for comment.update_time
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.update_user
     *
     * @return the value of comment.update_user
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.update_user
     *
     * @param updateUser the value for comment.update_user
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.is_delete
     *
     * @return the value of comment.is_delete
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.is_delete
     *
     * @param isDelete the value for comment.is_delete
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}