package com.zdj.web.mapper;

import com.zdj.web.pojo.Headgood;
import com.zdj.web.pojo.HeadgoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HeadgoodMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table headgood
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    long countByExample(HeadgoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table headgood
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int deleteByExample(HeadgoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table headgood
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table headgood
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int insert(Headgood record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table headgood
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int insertSelective(Headgood record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table headgood
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    List<Headgood> selectByExampleWithBLOBs(HeadgoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table headgood
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    List<Headgood> selectByExample(HeadgoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table headgood
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    Headgood selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table headgood
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int updateByExampleSelective(@Param("record") Headgood record, @Param("example") HeadgoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table headgood
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") Headgood record, @Param("example") HeadgoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table headgood
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int updateByExample(@Param("record") Headgood record, @Param("example") HeadgoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table headgood
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int updateByPrimaryKeySelective(Headgood record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table headgood
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Headgood record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table headgood
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int updateByPrimaryKey(Headgood record);
}