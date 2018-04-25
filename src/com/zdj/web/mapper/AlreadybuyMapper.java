package com.zdj.web.mapper;

import com.zdj.web.pojo.Alreadybuy;
import com.zdj.web.pojo.AlreadybuyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlreadybuyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alreadybuy
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    long countByExample(AlreadybuyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alreadybuy
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    int deleteByExample(AlreadybuyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alreadybuy
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alreadybuy
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    int insert(Alreadybuy record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alreadybuy
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    int insertSelective(Alreadybuy record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alreadybuy
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    List<Alreadybuy> selectByExample(AlreadybuyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alreadybuy
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    Alreadybuy selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alreadybuy
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    int updateByExampleSelective(@Param("record") Alreadybuy record, @Param("example") AlreadybuyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alreadybuy
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    int updateByExample(@Param("record") Alreadybuy record, @Param("example") AlreadybuyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alreadybuy
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    int updateByPrimaryKeySelective(Alreadybuy record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alreadybuy
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    int updateByPrimaryKey(Alreadybuy record);
}