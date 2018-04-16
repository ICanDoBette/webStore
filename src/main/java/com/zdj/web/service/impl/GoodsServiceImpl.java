package com.zdj.web.service.impl;

import com.zdj.web.mapper.GoodsMapper;
import com.zdj.web.model.GoodCommentModel;
import com.zdj.web.model.GoodDetailModel;
import com.zdj.web.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public GoodDetailModel getGoodDetail(int id) {
        return null;
    }

    @Override
    public GoodCommentModel getGoodConmment(int id) {
        return null;
    }
}
