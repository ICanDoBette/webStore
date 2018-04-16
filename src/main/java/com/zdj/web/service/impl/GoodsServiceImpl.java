package com.zdj.web.service.impl;

import com.zdj.web.mapper.CommentMapper;
import com.zdj.web.mapper.GoodsMapper;
import com.zdj.web.model.CommentsModel;
import com.zdj.web.model.GoodCommentModel;
import com.zdj.web.model.GoodDetailModel;
import com.zdj.web.pojo.GoodsWithBLOBs;
import com.zdj.web.service.GoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public GoodDetailModel getGoodDetail(int id) {
        GoodsWithBLOBs goodsWithBLOBs = goodsMapper.selectByPrimaryKey(id);
        GoodDetailModel goodDetailModel=new GoodDetailModel();
        BeanUtils.copyProperties(goodsWithBLOBs,goodDetailModel);
        return goodDetailModel;
    }

    @Override
    public GoodCommentModel getGoodConmment(int id) {
        List<CommentsModel> comments = commentMapper.selectCommentsById(id);
        Long star=0L;
        for (CommentsModel comment : comments) {
            star+=comment.getStar();
        }
        star=comments.size()==0?0:star/comments.size();
        GoodCommentModel goodCommentModel=new GoodCommentModel();
        goodCommentModel.setComments(comments);
        goodCommentModel.setAvg(star.intValue());
        return goodCommentModel;
    }
}
