package com.zdj.web.service;

import com.zdj.web.model.GoodCommentModel;
import com.zdj.web.model.GoodDetailModel;
import org.springframework.stereotype.Service;

@Service
public interface GoodsService {
    public GoodDetailModel getGoodDetail(int id);

    public GoodCommentModel getGoodConmment(int id);
}
