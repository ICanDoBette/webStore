package com.zdj.web.pojo;

import java.util.Date;

public class Type {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column type.id
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column type.level
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column type.name
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column type.father_id
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    private Integer fatherId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column type.priority
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    private Integer priority;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column type.create_time
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column type.create_user
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    private String createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column type.update_time
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column type.update_user
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    private String updateUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column type.is_delete
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    private Byte isDelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column type.id
     *
     * @return the value of type.id
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column type.id
     *
     * @param id the value for type.id
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column type.level
     *
     * @return the value of type.level
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column type.level
     *
     * @param level the value for type.level
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column type.name
     *
     * @return the value of type.name
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column type.name
     *
     * @param name the value for type.name
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column type.father_id
     *
     * @return the value of type.father_id
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public Integer getFatherId() {
        return fatherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column type.father_id
     *
     * @param fatherId the value for type.father_id
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column type.priority
     *
     * @return the value of type.priority
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column type.priority
     *
     * @param priority the value for type.priority
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column type.create_time
     *
     * @return the value of type.create_time
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column type.create_time
     *
     * @param createTime the value for type.create_time
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column type.create_user
     *
     * @return the value of type.create_user
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column type.create_user
     *
     * @param createUser the value for type.create_user
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column type.update_time
     *
     * @return the value of type.update_time
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column type.update_time
     *
     * @param updateTime the value for type.update_time
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column type.update_user
     *
     * @return the value of type.update_user
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column type.update_user
     *
     * @param updateUser the value for type.update_user
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column type.is_delete
     *
     * @return the value of type.is_delete
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column type.is_delete
     *
     * @param isDelete the value for type.is_delete
     *
     * @mbg.generated Fri Apr 20 00:23:12 CST 2018
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}