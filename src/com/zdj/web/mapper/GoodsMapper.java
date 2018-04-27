package com.zdj.web.mapper;

import com.zdj.web.pojo.Goods;
import com.zdj.web.pojo.GoodsExample;
import com.zdj.web.pojo.GoodsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    long countByExample(GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int deleteByExample(GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int insert(GoodsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int insertSelective(GoodsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    List<GoodsWithBLOBs> selectByExampleWithBLOBs(GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    List<Goods> selectByExample(GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    GoodsWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int updateByExampleSelective(@Param("record") GoodsWithBLOBs record, @Param("example") GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") GoodsWithBLOBs record, @Param("example") GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int updateByPrimaryKeySelective(GoodsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(GoodsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Fri Apr 27 16:10:06 CST 2018
     */
    int updateByPrimaryKey(Goods record);
}