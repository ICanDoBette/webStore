package com.zdj.web.service.impl;

import com.zdj.web.mapper.AddressMapper;
import com.zdj.web.mapper.ShopcarMapper;
import com.zdj.web.mapper.UserMapper;
import com.zdj.web.model.AddressModel;
import com.zdj.web.model.ShopCarModel;
import com.zdj.web.model.UserModel;
import com.zdj.web.pojo.Address;
import com.zdj.web.pojo.AddressExample;
import com.zdj.web.pojo.User;
import com.zdj.web.pojo.UserExample;
import com.zdj.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ShopcarMapper shopcarMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;
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

    @Override
    public UserModel getUserInfoByUserId(Integer userId) {
        UserExample userExample = new UserExample();
        userExample.or().andIdEqualTo(userId).andIsDeleteEqualTo(new Byte("0"));
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null || users.size() <= 0) {
            return new UserModel();
        }
        User user = users.get(0);
        UserModel result = new UserModel();
        BeanUtils.copyProperties(user, result);
        return result;
    }

    @Override
    public String deleteAddressByAddressIdAndUserId(List<Integer> addressIds, UserModel userModel) {
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.or().andUserIdEqualTo(userModel.getId()).andIsDeleteEqualTo(new Byte("0"));
        if (addressIds != null && addressIds.size() > 0) {
            criteria.andIdIn(addressIds);
        }
        Address address = new Address();
        address.setIsDelete(new Byte("1"));
        address.setUpdateUser(userModel.getName());
        address.setUpdateTime(new Date());
        int i = addressMapper.updateByExampleSelective(address, addressExample);
        if (i <= 0) {
            return "不能操作不是自己的收货地址";
        } else {
            redisTemplate.delete("_user_getAddresses?userId="+userModel.getId());
            return "ok";
        }
    }

    @Override
    public String changeInfoByUserModel(UserModel userModel) throws SQLException {
        UserExample userExample=new UserExample();
        userExample.or().andNameEqualTo(userModel.getName()).andIsDeleteEqualTo(new Byte("0"));
        List<User> users = userMapper.selectByExample(userExample);
        if (users!=null&&users.size()>0){
            return "该用户名已经被注册";
        }
        User user=new User();
        BeanUtils.copyProperties(userModel,user);
        user.setUpdateTime(new Date());
        user.setUpdateUser(userModel.getName());
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i!=1){
            throw new SQLException("数据库修改失败！");
        }
        redisTemplate.delete("_user_getUserInfo?userId="+userModel.getId());
        return "ok";
    }
}
