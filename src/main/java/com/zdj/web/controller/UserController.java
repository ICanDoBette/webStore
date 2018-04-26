package com.zdj.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.zdj.web.mapper.UserMapper;
import com.zdj.web.model.AddressModel;
import com.zdj.web.model.CommonResponseModel;
import com.zdj.web.model.ShopCarModel;
import com.zdj.web.pojo.Address;
import com.zdj.web.service.UserService;
import com.zdj.web.utils.StringToIdsUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/addAddress")
    public String addAddress(@RequestBody Map<String, String> values, HttpSession session) {
        String addreess = values.get("addreess");
        String addressTelTemp = values.get("addressTel");
        String name = values.get("name");
        int tel = 0;
        CommonResponseModel commonResponseModel = new CommonResponseModel();
        if (StringUtils.isBlank(name) || StringUtils.isBlank(addreess) || StringUtils.isBlank(addressTelTemp)) {
            commonResponseModel.setMsg("地址，电话，收件人必填");
            return JSONObject.toJSONString(commonResponseModel);
        } else {
            try {
                tel = Integer.parseInt(addressTelTemp);
            } catch (NumberFormatException e) {
                logger.info("电话号码格式不正确", e);
                commonResponseModel.setMsg("不是正确的电话号码");
                return JSONObject.toJSONString(commonResponseModel);
            }
            int finalTel = tel;
            Address address = new Address() {
                {
                    Integer userId = (Integer) session.getAttribute("id");
                    String userName = (String) session.getAttribute("name");
                    setAddres(addreess);
                    setName(name);
                    setCreateTime(new Date());
                    setCreateUser(userName);
                    setIsDelete(new Byte("0"));
                    setLevel(1);
                    setTel(finalTel);
                    setUpdateTime(new Date());
                    setUpdateUser(userName);
                    setUserId(userId);
                }
            };
            try {
                userService.addAddress(address);
                commonResponseModel.setMsg("ok");
                return JSONObject.toJSONString(commonResponseModel);
            } catch (Exception e) {
                logger.error("数据库插入发生异常", e);
                commonResponseModel.setMsg("数据库插入发生异常" + e.getMessage());
                return JSONObject.toJSONString(commonResponseModel);
            }
        }
    }

    @RequestMapping("/getAddresses")
    public String getAddresses(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("id");
        List<AddressModel> addressModels = userService.getAddressesByUserId(userId);
        return JSONObject.toJSONString(addressModels);
    }

    @RequestMapping("/getShopCar")
    public String getShopCar(@RequestBody Map<String, String> values, HttpSession session) {
        String idStr = values.get("id");
        List<Integer> ids = null;
        if (StringUtils.isNotBlank(idStr)) {
            try {
                ids = StringToIdsUtil.getIdByString(idStr);
            } catch (NumberFormatException e) {
                CommonResponseModel commonResponseModel = new CommonResponseModel();
                commonResponseModel.setMsg("输入数据异常" + e.getMessage());
                return JSONObject.toJSONString(commonResponseModel);
            }
        }
        List<ShopCarModel> shopCarModels = userService.getShopCarByUserIdAndId((Integer) session.getAttribute("id"), ids);
        return JSONObject.toJSONString(shopCarModels);
    }

}