package com.zdj.web.pojo;

import java.util.Date;

public class Address {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.id
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.user_id
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.tel
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    private String tel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.name
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.level
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.create_time
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.create_user
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    private String createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.update_time
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.update_user
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    private String updateUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.is_delete
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    private Byte isDelete;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.addres
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    private String addres;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.id
     *
     * @return the value of address.id
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.id
     *
     * @param id the value for address.id
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.user_id
     *
     * @return the value of address.user_id
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.user_id
     *
     * @param userId the value for address.user_id
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.tel
     *
     * @return the value of address.tel
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.tel
     *
     * @param tel the value for address.tel
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.name
     *
     * @return the value of address.name
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.name
     *
     * @param name the value for address.name
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.level
     *
     * @return the value of address.level
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.level
     *
     * @param level the value for address.level
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.create_time
     *
     * @return the value of address.create_time
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.create_time
     *
     * @param createTime the value for address.create_time
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.create_user
     *
     * @return the value of address.create_user
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.create_user
     *
     * @param createUser the value for address.create_user
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.update_time
     *
     * @return the value of address.update_time
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.update_time
     *
     * @param updateTime the value for address.update_time
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.update_user
     *
     * @return the value of address.update_user
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.update_user
     *
     * @param updateUser the value for address.update_user
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.is_delete
     *
     * @return the value of address.is_delete
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.is_delete
     *
     * @param isDelete the value for address.is_delete
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.addres
     *
     * @return the value of address.addres
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public String getAddres() {
        return addres;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.addres
     *
     * @param addres the value for address.addres
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    public void setAddres(String addres) {
        this.addres = addres == null ? null : addres.trim();
    }
}