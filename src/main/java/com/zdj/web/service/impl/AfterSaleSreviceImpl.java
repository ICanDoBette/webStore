package com.zdj.web.service.impl;

import com.zdj.web.mapper.AlreadybuyMapper;
import com.zdj.web.mapper.CommentMapper;
import com.zdj.web.model.AlreadyBuyModel;
import com.zdj.web.pojo.Alreadybuy;
import com.zdj.web.pojo.AlreadybuyExample;
import com.zdj.web.pojo.Comment;
import com.zdj.web.service.AfterSaleSrevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AfterSaleSreviceImpl implements AfterSaleSrevice {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private AlreadybuyMapper alreadybuyMapper;
    private final static Logger logger = LoggerFactory.getLogger(AfterSaleSreviceImpl.class);

    @Transactional
    @Override
    public void addComment(Comment comment) {
        int i = commentMapper.insertSelective(comment);
        if (i != 1) {
            logger.error("数据库插入错误，条数为{}", i);
        }
        return;
    }

    @Override
    public List<AlreadyBuyModel> getAlreadyBuy(Integer userId) {
        List<AlreadyBuyModel> alreadybuys = alreadybuyMapper.getAlreadyBuyModelsByUserId(userId);
        return alreadybuys;
    }
}
