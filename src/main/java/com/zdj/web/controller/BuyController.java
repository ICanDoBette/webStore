package com.zdj.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.zdj.web.model.AddShopCarModel;
import com.zdj.web.service.BuyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
        AddShopCarModel addShopCarModel=null;
        try {
            int goodId = Integer.parseInt(values.get("id"));
            int buyNum = Integer.parseInt(values.get("buyNum"));
            int userId = Integer.parseInt(session.getAttribute("id").toString());
            addShopCarModel=buyService.addShopCar(userId,goodId,buyNum);
        }catch (Exception r){
            addShopCarModel=new AddShopCarModel();
              logger.error("发生异常:",r);
              addShopCarModel.setMsg("锁定发生异常"+r.getMessage());
              addShopCarModel.setCount(-1);
              addShopCarModel.setShopCarId(-1);
        }
        return JSONObject.toJSONString(addShopCarModel);
    }

}
