package com.zdj.web.mapper;

import com.zdj.web.pojo.Type;
import com.zdj.web.pojo.TypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    long countByExample(TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int deleteByExample(TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int insert(Type record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int insertSelective(Type record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    List<Type> selectByExample(TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    Type selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int updateByPrimaryKeySelective(Type record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int updateByPrimaryKey(Type record);
}