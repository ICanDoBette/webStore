package com.zdj.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.zdj.web.model.AddressModel;
import com.zdj.web.model.CommonResponseModel;
import com.zdj.web.model.ShopCarModel;
import com.zdj.web.model.UserModel;
import com.zdj.web.pojo.Address;
import com.zdj.web.service.UserService;
import com.zdj.web.utils.StringToIdsUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping("/addAddress")
    public String addAddress(@RequestBody Map<String, String> values, HttpSession session) {
        String addreess = values.get("addreess");
        String addressTelTemp = values.get("addressTel");
        String name = values.get("name");
        Integer userId = (Integer) session.getAttribute("id");
        CommonResponseModel commonResponseModel = new CommonResponseModel();
        if (StringUtils.isBlank(name) || StringUtils.isBlank(addreess) || StringUtils.isBlank(addressTelTemp)) {
            commonResponseModel.setMsg("地址，电话，收件人必填");
            return JSONObject.toJSONString(commonResponseModel);
        } else {
            Address address = new Address() {
                {
                    String userName = (String) session.getAttribute("name");
                    setAddres(addreess);
                    setName(name);
                    setCreateTime(new Date());
                    setCreateUser(userName);
                    setIsDelete(new Byte("0"));
                    setLevel(1);
                    setTel(addressTelTemp);
                    setUpdateTime(new Date());
                    setUpdateUser(userName);
                    setUserId(userId);
                }
            };
            try {
                userService.addAddress(address);
                redisTemplate.delete("_user_getAddresses?userId=" + userId);
                commonResponseModel.setMsg("ok");
                return JSONObject.toJSONString(commonResponseModel);
            } catch (Exception e) {
                logger.error("数据库插入发生异常", e);
                commonResponseModel.setMsg("数据库插入发生异常" + e.getMessage());
                return JSONObject.toJSONString(commonResponseModel);
            }
        }
    }

    @ResponseBody
    @RequestMapping("/getAddresses")
    public String getAddresses(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("id");
        String catchStr = (String) redisTemplate.opsForValue().get("_user_getAddresses?userId=" + userId);
        if (StringUtils.isNotBlank(catchStr)) {
            return catchStr;
        }
        List<AddressModel> addressModels = userService.getAddressesByUserId(userId);
        String result = JSONObject.toJSONString(addressModels);
        redisTemplate.opsForValue().set("_user_getAddresses?userId=" + userId, result, 5, TimeUnit.HOURS);
        return result;
    }

    @ResponseBody
    @RequestMapping("/getShopCar")
    public String getShopCar(@RequestBody(required = false) Map<String, String> values, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("id");
        List<Integer> ids = null;
        if (values != null) {
            String idStr = values.get("id");
            if (StringUtils.isNotBlank(idStr)) {
                try {
                    ids = StringToIdsUtil.getIdByString(idStr);
                } catch (NumberFormatException e) {
                    CommonResponseModel commonResponseModel = new CommonResponseModel();
                    commonResponseModel.setMsg("输入数据异常" + e.getMessage());
                    return JSONObject.toJSONString(commonResponseModel);
                }
            }
        }
        String catchStr = (String) redisTemplate.opsForValue().get("_user_getShopCar?userId=" + userId + "&values=" + ids);
        if (StringUtils.isNotBlank(catchStr)) {
            return catchStr;
        }
        List<ShopCarModel> shopCarModels = userService.getShopCarByUserIdAndId(userId, ids);
        String result = JSONObject.toJSONString(shopCarModels);
        redisTemplate.opsForValue().set("_user_getShopCar?userId=" + userId + "&values=" + ids, result, 5, TimeUnit.HOURS);
        return result;
    }

    @ResponseBody
    @RequestMapping("/getUserInfo")
    public String getUserInfo(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("id");
        String catchStr = (String) redisTemplate.opsForValue().get("_user_getUserInfo?userId=" + userId);
        if (StringUtils.isNotBlank(catchStr)) {
            return catchStr;
        }
        UserModel userModel = userService.getUserInfoByUserId(userId);
        String result = JSONObject.toJSONString(userModel);
        redisTemplate.opsForValue().set("_user_getUserInfo?userId=" + userId, result, 5, TimeUnit.HOURS);
        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteAddress")
    public String deleteAddress(@RequestBody(required = false) Map<String, String> values, HttpSession session) {
        CommonResponseModel commonResponseModel = new CommonResponseModel();
        List<Integer> ids = null;
        if (values != null) {
            String idStr = values.get("id");
            if (StringUtils.isNotBlank(idStr)) {
                try {
                    ids = StringToIdsUtil.getIdByString(idStr);
                } catch (NumberFormatException e) {
                    commonResponseModel.setMsg("输入数据异常" + e.getMessage());
                    return JSONObject.toJSONString(commonResponseModel);
                }
            }
        }
        UserModel userModel = new UserModel();
        userModel.setId((Integer) session.getAttribute("id"));
        userModel.setName((String) session.getAttribute("name"));
        try {
            commonResponseModel.setMsg(userService.deleteAddressByAddressIdAndUserId(ids, userModel));
        } catch (Exception e) {
            logger.error("删除地址发生异常!", e);
            commonResponseModel.setMsg("删除地址发生异常" + e.getMessage());
        }
        return JSONObject.toJSONString(commonResponseModel);
    }

    @ResponseBody
    @RequestMapping("/changeInfo")
    public String changeInfo(@RequestBody Map<String, String> values, HttpSession session) {
        CommonResponseModel commonResponseModel = new CommonResponseModel();
        String name = values.get("name");
        String telStr = values.get("tel");
        String email = values.get("email");
        if (StringUtils.isBlank(name) || StringUtils.isBlank(telStr) || StringUtils.isBlank(email)) {
            commonResponseModel.setMsg("姓名，电话，邮箱必填");
            return JSONObject.toJSONString(commonResponseModel);
        } else if ("Sys".equals(name)) {
            commonResponseModel.setMsg("Sys为系统用户，不能修改");
            return JSONObject.toJSONString(commonResponseModel);
        }
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setId((Integer) session.getAttribute("id"));
        userModel.setEmail(email);
        userModel.setTel(telStr);
        try {
            commonResponseModel.setMsg(userService.changeInfoByUserModel(userModel));
        } catch (Exception e) {
            logger.error("用户信息修改发生异常!", e);
            commonResponseModel.setMsg("用户信息修改发生异常!" + e.getMessage());
        }
        return JSONObject.toJSONString(commonResponseModel);
    }
}