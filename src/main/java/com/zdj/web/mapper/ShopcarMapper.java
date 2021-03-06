package com.zdj.web.mapper;

import com.zdj.web.model.ShopCarModel;
import com.zdj.web.pojo.Shopcar;
import com.zdj.web.pojo.ShopcarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopcarMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopcar
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    long countByExample(ShopcarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopcar
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    int deleteByExample(ShopcarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopcar
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopcar
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    int insert(Shopcar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopcar
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    int insertSelective(Shopcar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopcar
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    List<Shopcar> selectByExample(ShopcarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopcar
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    Shopcar selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopcar
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    int updateByExampleSelective(@Param("record") Shopcar record, @Param("example") ShopcarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopcar
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    int updateByExample(@Param("record") Shopcar record, @Param("example") ShopcarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopcar
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    int updateByPrimaryKeySelective(Shopcar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopcar
     *
     * @mbg.generated Wed Apr 25 18:08:55 CST 2018
     */
    int updateByPrimaryKey(Shopcar record);

    List<ShopCarModel> getShopCarByUserIdAndId(@Param("userId") Integer userId, @Param("ids") List<Integer> ids);
}