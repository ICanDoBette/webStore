package com.zdj.web.service.impl;

import com.zdj.web.mapper.AddressMapper;
import com.zdj.web.mapper.ShopcarMapper;
import com.zdj.web.model.AddressModel;
import com.zdj.web.model.ShopCarModel;
import com.zdj.web.pojo.Address;
import com.zdj.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ShopcarMapper shopcarMapper;
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Transactional
    @Override
    public void addAddress(Address address) {
        int i = addressMapper.insertSelective(address);
        if (i != 1) {
            logger.error("数据库插入错误，条数为{}", i);
        }
        return;
    }

    @Override
    public List<AddressModel> getAddressesByUserId(Integer userId) {
        List<AddressModel> addressModels = addressMapper.getAddressesByUserId(userId);
        return addressModels;
    }

    @Override
    public List<ShopCarModel> getShopCarByUserIdAndId(Integer userId, List<Integer> ids) {
        List<ShopCarModel> shopCarModels = shopcarMapper.getShopCarByUserIdAndId(userId, ids);
        return shopCarModels;
    }
}
