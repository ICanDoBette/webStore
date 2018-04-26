package com.zdj.web.service;

import com.zdj.web.model.AddressModel;
import com.zdj.web.model.ShopCarModel;
import com.zdj.web.pojo.Address;

import java.util.List;

public interface UserService {

    public void addAddress(Address address);


    public List<AddressModel> getAddressesByUserId(Integer userId);


    public List<ShopCarModel> getShopCarByUserIdAndId(Integer userId, List<Integer> ids);
}
