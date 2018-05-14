package com.zdj.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.zdj.web.mapper.UserMapper;
import com.zdj.web.model.LoginModel;
import com.zdj.web.model.RegistModel;
import com.zdj.web.pojo.User;
import com.zdj.web.pojo.UserExample;
import com.zdj.web.service.RegistService;
import com.zdj.web.utils.IdentifyUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RegistService registService;
    @Autowired
    private RedisTemplate redisTemplate;
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    private static final String NO_LOGIN;
    private static final String LOGOUT;

    static {
        LoginModel loginModel = new LoginModel();
        loginModel.setName("");
        loginModel.setIsLogin(false);
        loginModel.setId(-1);
        NO_LOGIN = JSONObject.toJSONString(loginModel);
        LOGOUT = "{\"OK\":true}";
    }

    @RequestMapping("/")
    public void index(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        logger.info("进入首页");
        httpServletResponse.sendRedirect("/statics/index.html");
        return;
    }

    @RequestMapping(value = "/a", method = {RequestMethod.GET, RequestMethod.POST})
    public String test(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpServletRequest.setAttribute("END", "和llo ");
        logger.error("这个是重点消息！");
        logger.info("使用成功！");
        redisTemplate.opsForValue().set("123", "456");
        logger.info(redisTemplate.opsForValue().get("123").toString());
        redisTemplate.delete("123");
        try {
            logger.info(redisTemplate.opsForValue().get("123").toString());
        } catch (Exception e) {
            logger.error("异常" + e);
        }
        return "index";
    }

    @RequestMapping(value = "/checkLogin", method = {RequestMethod.POST})
    @ResponseBody
    public String checkLogin(HttpSession session) {
        LoginModel loginModel = new LoginModel();
        try {
            String username = session.getAttribute("name").toString();
            Integer id = (Integer) session.getAttribute("id");
            if (StringUtils.isNotBlank(username) && id != null && id > 0) {
                loginModel.setId(id);
                loginModel.setIsLogin(true);
                loginModel.setName(username);
            }
        } catch (Exception e) {
            logger.error("登录发生异常", e);
        }

        return JSONObject.toJSONString(loginModel);
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ResponseBody
    public String login(@RequestBody Map<String, String> values, HttpSession session) {
        String name = values.get("name");
        String password = values.get("password");
        if (StringUtils.isBlank(name) || StringUtils.isBlank(password)) {
            session.setAttribute("name", "");
            session.setAttribute("id", -1);
            return NO_LOGIN;
        }
        String catchStr = (String) redisTemplate.opsForValue().get("_login?name=" + name + "&id=" + "&pass=" + password);
        if (StringUtils.isNotBlank(catchStr)) {
            User user = JSONObject.parseObject(catchStr, User.class);
            session.setAttribute("name", user.getName());
            session.setAttribute("id", user.getId());
            return catchStr;
        }
        UserExample userExample = new UserExample();
        userExample.or().andNameEqualTo(name).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        LoginModel loginModel = new LoginModel();
        if (users == null || users.isEmpty()) {
            session.setAttribute("name", "");
            session.setAttribute("id", -1);
            return NO_LOGIN;
        } else {
            User user = users.get(0);
            BeanUtils.copyProperties(user, loginModel);
            loginModel.setIsLogin(true);
            session.setAttribute("name", user.getName());
            session.setAttribute("id", user.getId());
            String result = JSONObject.toJSONString(loginModel);
            redisTemplate.opsForValue().set("_login?name=" + name + "&id=" + "&pass=" + password, result, 5, TimeUnit.HOURS);
            return result;
        }
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String logout(HttpSession session) {
        session.setAttribute("name", "");
        session.setAttribute("id", -1);
        return LOGOUT;
    }

    @RequestMapping(value = "/regist", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String regist(@RequestBody Map<String, String> values, HttpSession session) {
        RegistModel registModel = new RegistModel();
        LoginModel loginModel = new LoginModel();
        String email, name, password;
        String tel;
        try {
            name = values.get("name").toString();
            password = values.get("password").toString();
            email = values.get("email").toString();
            tel = values.get("tel");
            if (!IdentifyUtil.isEmail(email)||!IdentifyUtil.isTel(tel)){
                throw new NumberFormatException("电话或邮箱不合规");
            }
        } catch (NumberFormatException | NullPointerException e) {
            logger.info("参数异常:", e);
            registModel.setIsRegist(false);
            registModel.setRegistMessage("参数不正确，请检查邮箱或电话是否标准，是否有未填项");
            registModel.setLoginModel(loginModel);
            return JSONObject.toJSONString(registModel);
        }
        if ("Sys".equals(name)) {
            registModel.setIsRegist(false);
            registModel.setRegistMessage("Sys为系统用户，不能注册");
            registModel.setLoginModel(loginModel);
            return JSONObject.toJSONString(registModel);
        }
        User user = new User();
        user.setName(name);
        user.setTel(tel);
        user.setPassword(password);
        user.setEmail(email);
        user.setCreateTime(new Date());
        user.setCreateUser(name);
        user.setUpdateTime(new Date());
        user.setUpdateUser(name);
        user.setIsDelete(new Byte("0"));
        try {
            return registService.regist(user, session);
        } catch (Exception e) {
            logger.info("数据库操作异常:", e);
            registModel.setRegistMessage("系统异常，请联系管理员！");
            registModel.setLoginModel(loginModel);
            registModel.setIsRegist(false);
            return JSONObject.toJSONString(registModel);
        }
    }

    @RequestMapping(value = "/_healthCheck", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String healthCheck() {
        return LOGOUT;
    }

}
