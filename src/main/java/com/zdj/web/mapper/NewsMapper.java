package com.zdj.web.mapper;

import com.zdj.web.pojo.News;
import com.zdj.web.pojo.NewsExample;
import com.zdj.web.pojo.NewsWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NewsMapper {
    long countByExample(NewsExample example);

    int deleteByExample(NewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NewsWithBLOBs record);

    int insertSelective(NewsWithBLOBs record);

    List<NewsWithBLOBs> selectByExampleWithBLOBs(NewsExample example);

    List<News> selectByExample(NewsExample example);

    NewsWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NewsWithBLOBs record, @Param("example") NewsExample example);

    int updateByExampleWithBLOBs(@Param("record") NewsWithBLOBs record, @Param("example") NewsExample example);

    int updateByExample(@Param("record") News record, @Param("example") NewsExample example);

    int updateByPrimaryKeySelective(NewsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(NewsWithBLOBs record);

    int updateByPrimaryKey(News record);
}