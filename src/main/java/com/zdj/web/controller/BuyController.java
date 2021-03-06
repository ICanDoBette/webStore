package com.zdj.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.zdj.web.model.AddShopCarModel;
import com.zdj.web.model.ChangeShopCarCountModel;
import com.zdj.web.model.CommonResponseModel;
import com.zdj.web.model.PayModel;
import com.zdj.web.service.BuyService;
import com.zdj.web.utils.StringToIdsUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/buy")
public class BuyController {
    @Autowired
    private BuyService buyService;
    private final static Logger logger = LoggerFactory.getLogger(BuyController.class);

    @ResponseBody
    @RequestMapping(value = "/addShopCar", method = {RequestMethod.GET, RequestMethod.POST})
    public String addShopCar(@RequestBody Map<String, String> values, HttpSession session) {
        AddShopCarModel addShopCarModel = null;
        try {
            int goodId = Integer.parseInt(values.get("id"));
            int buyNum = Integer.parseInt(values.get("buyNum"));
            int userId = Integer.parseInt(session.getAttribute("id").toString());
            addShopCarModel = buyService.addShopCar(userId, goodId, buyNum);
        } catch (Exception r) {
            addShopCarModel = new AddShopCarModel();
            logger.error("发生异常:", r);
            addShopCarModel.setMsg("锁定发生异常" + r.getMessage());
            addShopCarModel.setCount(-1);
            addShopCarModel.setShopCarId(-1);
        }
        return JSONObject.toJSONString(addShopCarModel);
    }

    @ResponseBody
    @RequestMapping(value = "/pay", method = {RequestMethod.GET, RequestMethod.POST})
    public String payForShopCar(@RequestBody Map<String, String> values, HttpSession session) {
        CommonResponseModel commonResponseModel = new CommonResponseModel();
        String idStr = values.get("id");
        String payWayStr = values.get("payWay");
        String addressStr = values.get("address");
        List<Integer> ids = null;
        int payWay, address;
        if (StringUtils.isBlank(idStr) || StringUtils.isBlank(payWayStr) || StringUtils.isBlank(addressStr)) {
            commonResponseModel.setMsg("id,付款方式,收货地址必填");
            return JSONObject.toJSONString(commonResponseModel);
        }
        try {
            ids = StringToIdsUtil.getIdByString(idStr);
            payWay = Integer.parseInt(payWayStr);
            address = Integer.parseInt(addressStr);
        } catch (NumberFormatException e) {
            logger.info("id、付款方式或地址格式不正确", e);
            commonResponseModel.setMsg("id、付款方式或地址格式不正确");
            return JSONObject.toJSONString(commonResponseModel);
        }
        PayModel payModel = new PayModel();
        payModel.setAddressId(address);
        payModel.setShopCartId(ids);
        payModel.setUserId(Integer.parseInt(session.getAttribute("id").toString()));
        payModel.setPayWay(payWay);
        payModel.setUserName((String) session.getAttribute("name"));
        String result = null;
        try {
            result = buyService.payShopCar(payModel);
        } catch (SQLException e) {
            result = "系统异常，请联系客服，具体信息为" + e.getMessage();
            logger.error("数据库更新异常!", e);
        }
        commonResponseModel.setMsg(result);
        return JSONObject.toJSONString(commonResponseModel);
    }

    @ResponseBody
    @RequestMapping(value = "/changeCount", method = {RequestMethod.GET, RequestMethod.POST})
    public String changeCount(@RequestBody Map<String, String> values, HttpSession session) {
        CommonResponseModel commonResponseModel = new CommonResponseModel();
        String shopCarIdStr = values.get("id");
        String buyNumStr = values.get("buyNum");
        if (StringUtils.isBlank(shopCarIdStr) || StringUtils.isBlank(buyNumStr)) {
            commonResponseModel.setMsg("购物车标识或购买数量不能为空");
            return JSONObject.toJSONString(commonResponseModel);
        }
        int shopCarId, buyNum;
        try {
            shopCarId = Integer.parseInt(shopCarIdStr);
            buyNum = Integer.parseInt(buyNumStr);
        } catch (NumberFormatException e) {
            commonResponseModel.setMsg("购物车标识或购买数量必须为数字");
            return JSONObject.toJSONString(commonResponseModel);
        }
        ChangeShopCarCountModel changeShopCarCountModel = new ChangeShopCarCountModel() {
            {
                setBuyNum(buyNum);
                setShopCarId(shopCarId);
                setUserId(Integer.parseInt(session.getAttribute("id").toString()));
                setUserName((String) session.getAttribute("name"));
            }
        };
        try {
            commonResponseModel.setMsg(buyService.changeCount(changeShopCarCountModel));
        } catch (Exception e) {
            logger.error("更新购物车数量发生异常！", e);
            commonResponseModel.setMsg("更新购物车数量发生异常！" + e.getMessage());
        }
        return JSONObject.toJSONString(commonResponseModel);
    }

    @ResponseBody
    @RequestMapping(value = "/resetCar", method = {RequestMethod.GET, RequestMethod.POST})
    public String resetCar(HttpSession session) {
        CommonResponseModel commonResponseModel = new CommonResponseModel();
        try {
            buyService.resetCar(Integer.parseInt(session.getAttribute("id").toString()));
            commonResponseModel.setMsg("ok");
        } catch (Exception e) {
            logger.error("清空购物车数量发生异常！", e);
            commonResponseModel.setMsg("清空购物车数量发生异常！" + e.getMessage());
        }
        return JSONObject.toJSONString(commonResponseModel);
    }
}
