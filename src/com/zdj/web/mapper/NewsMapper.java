package com.zdj.web.mapper;

import com.zdj.web.pojo.News;
import com.zdj.web.pojo.NewsExample;
import com.zdj.web.pojo.NewsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    long countByExample(NewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int deleteByExample(NewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int insert(NewsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int insertSelective(NewsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    List<NewsWithBLOBs> selectByExampleWithBLOBs(NewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    List<News> selectByExample(NewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    NewsWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int updateByExampleSelective(@Param("record") NewsWithBLOBs record, @Param("example") NewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") NewsWithBLOBs record, @Param("example") NewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int updateByExample(@Param("record") News record, @Param("example") NewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int updateByPrimaryKeySelective(NewsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(NewsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Thu Apr 19 00:34:54 CST 2018
     */
    int updateByPrimaryKey(News record);
}