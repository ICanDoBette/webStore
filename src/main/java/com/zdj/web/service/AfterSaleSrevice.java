package com.zdj.web.service;

import com.zdj.web.model.AlreadyBuyModel;
import com.zdj.web.pojo.Comment;

import java.sql.SQLException;
import java.util.List;

public interface AfterSaleSrevice {
    public void addCommentByShopCarId(Comment comment, Integer alreadyBuyId) throws Exception;

    public List<AlreadyBuyModel> getAlreadyBuy(Integer userId);
}
