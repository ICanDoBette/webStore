package com.zdj.web.service.impl;

import com.zdj.web.enums.BuyStateEnum;
import com.zdj.web.mapper.AlreadybuyMapper;
import com.zdj.web.mapper.CommentMapper;
import com.zdj.web.model.AlreadyBuyModel;
import com.zdj.web.pojo.Alreadybuy;
import com.zdj.web.pojo.Comment;
import com.zdj.web.service.AfterSaleSrevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class AfterSaleSreviceImpl implements AfterSaleSrevice {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private AlreadybuyMapper alreadybuyMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    private final static Logger logger = LoggerFactory.getLogger(AfterSaleSreviceImpl.class);

    @Transactional
    @Override
    public void addCommentByShopCarId(Comment comment, Integer alreadyBuyId) throws Exception {
        Alreadybuy alreadybuy = alreadybuyMapper.selectByPrimaryKey(alreadyBuyId);
        if (alreadybuy == null) {
            throw new Exception("没有该货物");
        }
        comment.setGoodId(alreadybuy.getGoodId());
        redisTemplate.delete("_goods_comment?id="+alreadybuy.getGoodId());
        int i = commentMapper.insertSelective(comment);
        if (i != 1) {
            logger.error("数据库插入错误，条数为{}", i);
            throw new SQLException("增加评论数据库出现错误");
        }
        return;
    }

    @Override
    public List<AlreadyBuyModel> getAlreadyBuy(Integer userId) {
        List<AlreadyBuyModel> alreadybuys = alreadybuyMapper.getAlreadyBuyModelsByUserId(userId);
        for (int i = 0; i < alreadybuys.size(); i++) {
            AlreadyBuyModel alreadyBuyModel = alreadybuys.get(i);
            alreadyBuyModel.setState(BuyStateEnum.getWordsByStae(Integer.parseInt(alreadyBuyModel.getState())));
            alreadybuys.set(i, alreadyBuyModel);
        }
        return alreadybuys;
    }
}
