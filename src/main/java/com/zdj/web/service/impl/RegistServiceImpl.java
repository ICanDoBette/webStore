package com.zdj.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zdj.web.mapper.UserMapper;
import com.zdj.web.model.LoginModel;
import com.zdj.web.model.RegistModel;
import com.zdj.web.pojo.User;
import com.zdj.web.pojo.UserExample;
import com.zdj.web.service.RegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class RegistServiceImpl implements RegistService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public String regist(User user, HttpSession session) {
        RegistModel registModel = new RegistModel();
        LoginModel loginModel = new LoginModel();
        UserExample userExample = new UserExample();
        userExample.or().andNameEqualTo(user.getName());
        long l = userMapper.countByExample(userExample);
        if (l == 1L) {
            registModel.setRegistMessage("该用户名已经被注册！");
            registModel.setLoginModel(loginModel);
            registModel.setIsRegist(false);
            return JSONObject.toJSONString(registModel);
        }else {
            int i = userMapper.insertSelective(user);
            if (i == 1) {
                userExample = new UserExample();
                userExample.or().andNameEqualTo(user.getName());
                List<User> users = userMapper.selectByExample(userExample);
                if (users.size() == 1) {
                    user = users.get(0);
                    loginModel.setIsLogin(true);
                    loginModel.setId(user.getId());
                    loginModel.setName(user.getName());
                    session.setAttribute("name", user.getName());
                    session.setAttribute("id", user.getId());
                    registModel.setLoginModel(loginModel);
                    registModel.setRegistMessage("OK!");
                    registModel.setIsRegist(true);
                    return JSONObject.toJSONString(registModel);
                } else {
                    throw new RuntimeException("数据库操作异常！回滚");
                }
            } else {
                throw new RuntimeException("数据库操作异常！回滚");
            }
        }
    }
}
