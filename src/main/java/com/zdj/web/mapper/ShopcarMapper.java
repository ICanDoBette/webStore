package com.zdj.web.mapper;

import com.zdj.web.pojo.Shopcar;
import com.zdj.web.pojo.ShopcarExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShopcarMapper {
    long countByExample(ShopcarExample example);

    int deleteByExample(ShopcarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shopcar record);

    int insertSelective(Shopcar record);

    List<Shopcar> selectByExample(ShopcarExample example);

    Shopcar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Shopcar record, @Param("example") ShopcarExample example);

    int updateByExample(@Param("record") Shopcar record, @Param("example") ShopcarExample example);

    int updateByPrimaryKeySelective(Shopcar record);

    int updateByPrimaryKey(Shopcar record);
}