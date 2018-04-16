package com.zdj.web.service;

import com.zdj.web.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

public interface RegistService {
    @Transactional
    public String regist(User user, HttpSession session);
}
