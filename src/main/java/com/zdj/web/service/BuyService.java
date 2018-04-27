package com.zdj.web.service;

import com.zdj.web.exception.InputException;
import com.zdj.web.model.AddShopCarModel;
import com.zdj.web.model.ChangeShopCarCountModel;
import com.zdj.web.model.PayModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public interface BuyService {
    @Transactional
    public AddShopCarModel addShopCar(int userId, int goodId, int buyNum) throws InputException, SQLException;

    @Transactional
    public String payShopCar(PayModel payModel) throws SQLException;

    @Transactional
    public String changeCount(ChangeShopCarCountModel changeShopCarCountModel) throws SQLException;

    @Transactional
    public void resetCar(int userId) throws SQLException;
}
