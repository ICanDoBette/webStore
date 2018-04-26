package com.zdj.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zdj.web.enums.BuyStateEnum;
import com.zdj.web.exception.InputException;
import com.zdj.web.exception.PayException;
import com.zdj.web.mapper.AddressMapper;
import com.zdj.web.mapper.AlreadybuyMapper;
import com.zdj.web.mapper.GoodsMapper;
import com.zdj.web.mapper.ShopcarMapper;
import com.zdj.web.model.AddShopCarModel;
import com.zdj.web.model.PayModel;
import com.zdj.web.pay.PayInterFace;
import com.zdj.web.pojo.*;
import com.zdj.web.service.BuyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.*;

@Service
public class BuyServiceImpl implements BuyService {
    private static Map<Integer, Object> locks = new HashMap<>();
    @Autowired
    private ShopcarMapper shopcarMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private AlreadybuyMapper alreadybuyMapper;
    private final static Logger logger = LoggerFactory.getLogger(BuyServiceImpl.class);

    @Transactional
    @Override
    public AddShopCarModel addShopCar(int userId, int goodId, int buyNum) throws InputException, SQLException {
        AddShopCarModel addShopCarModel = new AddShopCarModel();
        if (locks.get(goodId) == null) {
            locks.put(goodId, new Object());
        }
        synchronized (locks.get(goodId)) {
            GoodsWithBLOBs l = goodsMapper.selectByPrimaryKey(goodId);
            if (l == null || l.getIsDelete().intValue() == 1 || l.getIsDown().intValue() == 1) {
                throw new InputException("商品id");
            }
            if (l.getCount() < buyNum) {
                addShopCarModel.setShopCarId(-1);
                addShopCarModel.setCount(l.getCount());
                addShopCarModel.setMsg("对不起，货物不足！");
            } else {
                GoodsWithBLOBs temp = new GoodsWithBLOBs();
                temp.setId(goodId);
                temp.setCount(l.getCount() - buyNum);
                int i = goodsMapper.updateByPrimaryKeySelective(temp);
                if (i != 1) {
                    throw new SQLException("购买异常！");
                }
                List<Shopcar> shopcars = shopcarMapper.selectByExample(new ShopcarExample() {{
                    or().andUserIdEqualTo(userId).andGoodIdEqualTo(goodId).andIsDeleteEqualTo(new Byte("0"));
                }});
                Shopcar shopcar = null;
                if (shopcars.size() != 0) {
                    shopcar = shopcars.get(0);
                    shopcar.setGoodCount(shopcar.getGoodCount() + buyNum);
                    shopcar.setUpdateTime(new Date());
                    i = shopcarMapper.updateByPrimaryKeySelective(shopcar);
                    if (i != 1) {
                        throw new SQLException("购买异常！");
                    }
                } else {
                    shopcar = new Shopcar();
                    shopcar.setCreateTime(new Date());
                    shopcar.setCreateUser("Sys");
                    shopcar.setGoodCount(buyNum);
                    shopcar.setGoodId(goodId);
                    shopcar.setIsDelete(new Byte("0"));
                    shopcar.setUpdateTime(new Date());
                    shopcar.setUpdateUser("Sys");
                    shopcar.setUserId(userId);
                    i = shopcarMapper.insertSelective(shopcar);
                    if (i != 1) {
                        throw new SQLException("购买异常！");
                    }
                    shopcar.setId(shopcarMapper.selectByExample(new ShopcarExample() {{
                        or().andUserIdEqualTo(userId).andGoodIdEqualTo(goodId);
                    }}).get(0).getId());
                }
                addShopCarModel.setShopCarId(shopcar.getId());
                addShopCarModel.setCount(l.getCount() - buyNum);
                addShopCarModel.setMsg("ok");
            }
        }
        return addShopCarModel;
    }

    @Transactional
    @Override
    public String payShopCar(PayModel payModel) throws SQLException {
        String result;
        try {
            List<Integer> shopCartId = payModel.getShopCartId();
            List<Integer> shopCars = new ArrayList<>(shopCartId.size());
            List<Shopcar> finalShopCar = new ArrayList<>(shopCartId.size());
            //检查参数
            Class<?> payClass = Class.forName("Pay" + payModel.getPayWay());
            for (Integer integer : shopCartId) {
                ShopcarExample shopcarExample = new ShopcarExample();
                shopcarExample.or().andUserIdEqualTo(payModel.getUserId()).andIdEqualTo(integer).andIsDeleteEqualTo(new Byte("0"));
                List<Shopcar> shopcars = shopcarMapper.selectByExample(shopcarExample);
                if (shopcars == null || shopcars.size() <= 0) {
                    throw new PayException("这不是你的货物！");
                }
                finalShopCar.add(shopcars.get(0));
            }
            AddressExample addressExample = new AddressExample();
            addressExample.or().andIdEqualTo(payModel.getAddressId()).andUserIdEqualTo(payModel.getUserId()).andIsDeleteEqualTo(new Byte("0"));
            if (0 >= addressMapper.countByExample(addressExample)) {
                throw new PayException("这不是你的收货地址！");
            }
            //付款
            PayInterFace o = (PayInterFace) payClass.newInstance();
            String step = o.beforePay(payModel.getShopCartId());
            if (!"ok".equals(step)) {
                throw new PayException(step);
            }
            step = o.pay(payModel.getShopCartId());
            Integer money = 0;
            if (!"ok".equals(step.split(",")[0])) {
                throw new PayException(step);
            } else {
                money = Integer.parseInt(step.split(",")[1]);
            }
            step = o.afterPay(payModel.getShopCartId());
            if (!"ok".equals(step)) {
                throw new PayException(step);
            }
            //出仓
            Alreadybuy alreadybuy = null;
            for (Shopcar shopcar : finalShopCar) {
                alreadybuy = new Alreadybuy();
                BeanUtils.copyProperties(shopcar, alreadybuy);
                alreadybuy.setId(null);
                alreadybuy.setAddressId(payModel.getAddressId());
                alreadybuy.setPay(money);
                alreadybuy.setState(BuyStateEnum.NOTDELIVERY.getStateNum().byteValue());
                alreadybuy.setCreateTime(new Date());
                alreadybuy.setCreateUser(payModel.getUserName());
                alreadybuy.setUpdateTime(new Date());
                alreadybuy.setUpdateUser(payModel.getUserName());
                shopcar.setIsDelete(new Byte("1"));
                if (1 != alreadybuyMapper.insertSelective(alreadybuy) || 1 != shopcarMapper.updateByPrimaryKeySelective(shopcar)) {
                    //退款
                    String fail = o.fail(payModel.getShopCartId());
                    String errorMsg = null;
                    if (!"ok".equals(fail)) {
                        errorMsg = "用户" + payModel.getUserId() + "购买数据库插入异常！付款成功且退款失败！购物车单号为:" + payModel.getShopCartId() + "失败信息为:" + fail;
                        logger.error(errorMsg);
                        throw new SQLException(errorMsg);
                    } else {
                        errorMsg = "用户" + payModel.getUserId() + "购买数据库插入异常！付款成功退款成功！购物车单号为:" + payModel.getShopCartId();
                        logger.error(errorMsg);
                        throw new SQLException(errorMsg);
                    }
                }
            }
            logger.info("用户{}购买成功！");
            return "ok";
        } catch (ClassNotFoundException e) {
            logger.info("没有该付款方式:" + payModel.getPayWay(), e);
            return "没有该付款方式:" + payModel.getPayWay();
        } catch (IllegalAccessException | InstantiationException e) {
            logger.error("付款方式获取错误:" + payModel.getPayWay(), e);
            return "付款方式获取错误:" + payModel.getPayWay();
        } catch (PayException e) {
            logger.info("付款失败:", e);
            return "付款失败:" + e.getMessage();
        }
    }
}
