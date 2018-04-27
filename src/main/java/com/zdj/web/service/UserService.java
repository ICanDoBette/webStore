package com.zdj.web.service;

import com.zdj.web.model.AddressModel;
import com.zdj.web.model.ShopCarModel;
import com.zdj.web.model.UserModel;
import com.zdj.web.pojo.Address;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    @Transactional
    public void addAddress(Address address);


    public List<AddressModel> getAddressesByUserId(Integer userId);


    public List<ShopCarModel> getShopCarByUserIdAndId(Integer userId, List<Integer> ids);

    public UserModel getUserInfoByUserId(Integer userId);

    @Transactional
    public String deleteAddressByAddressIdAndUserId(List<Integer> addressIds, UserModel userModel);

    @Transactional
    public String changeInfoByUserModel(UserModel userModel) throws SQLException;
}
