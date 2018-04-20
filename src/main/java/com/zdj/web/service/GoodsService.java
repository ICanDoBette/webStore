package com.zdj.web.service;

import com.zdj.web.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService {
    public GoodDetailModel getGoodDetail(int id);

    public GoodCommentModel getGoodConmment(int id);

    public List<SelectGoodResultModel> getSelectGoods(SelectGoodModel selectGoodModel);

    public List<TypesModel> getTypes();

    public List<BoardModel> getBoardList();
}
