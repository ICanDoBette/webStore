package com.zdj.web.service.impl;

import com.zdj.web.exception.InputException;
import com.zdj.web.mapper.GoodsMapper;
import com.zdj.web.mapper.ShopcarMapper;
import com.zdj.web.model.AddShopCarModel;
import com.zdj.web.pojo.GoodsExample;
import com.zdj.web.pojo.GoodsWithBLOBs;
import com.zdj.web.pojo.Shopcar;
import com.zdj.web.pojo.ShopcarExample;
import com.zdj.web.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuyServiceImpl implements BuyService {
    private static Map<Integer, Object> locks = new HashMap<>();
    @Autowired
    private ShopcarMapper shopcarMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Transactional
    @Override
    public AddShopCarModel addShopCar(int userId, int goodId, int buyNum) throws InputException, SQLException {
        AddShopCarModel addShopCarModel = new AddShopCarModel();
        if (locks.get(goodId) == null) {
            locks.put(goodId, new Object());
        }
        synchronized (locks.get(goodId)) {
            GoodsWithBLOBs l = goodsMapper.selectByPrimaryKey(goodId);
            if (l == null || l.getIsDelete().intValue() == 1 || l.getIsDown().intValue()==1) {
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
                    shopcar.setState(new Byte("0"));
                    shopcar.setUpdateTime(new Date());
                    shopcar.setUpdateUser("Sys");
                    shopcar.setUserId(userId);
                    shopcar.setAddressId(-1);
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
}
