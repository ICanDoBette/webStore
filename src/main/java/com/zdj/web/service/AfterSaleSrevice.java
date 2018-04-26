package com.zdj.web.service;

import com.zdj.web.model.AlreadyBuyModel;
import com.zdj.web.pojo.Comment;

import java.util.List;

public interface AfterSaleSrevice {
    public void addComment(Comment comment);

    public List<AlreadyBuyModel> getAlreadyBuy(Integer userId);
}
