package com.zdj.web.service.impl;

import com.zdj.web.mapper.*;
import com.zdj.web.model.*;
import com.zdj.web.pojo.*;
import com.zdj.web.service.GoodsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ShopcarMapper shopcarMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private HeadgoodMapper headgoodMapper;

    @Override
    public GoodDetailModel getGoodDetail(int id) {
        GoodsWithBLOBs goodsWithBLOBs = goodsMapper.selectByPrimaryKey(id);
        GoodDetailModel goodDetailModel = new GoodDetailModel();
        if (goodsWithBLOBs.getIsDelete().intValue() == 0 && goodsWithBLOBs.getIsDown().intValue() == 0) {
            BeanUtils.copyProperties(goodsWithBLOBs, goodDetailModel);
        }
        return goodDetailModel;
    }

    @Override
    public GoodCommentModel getGoodConmment(int id) {
        List<CommentsModel> comments = commentMapper.selectCommentsById(id);
        Long star = 0L;
        for (CommentsModel comment : comments) {
            star += comment.getStar();
        }
        star = comments.size() == 0 ? 0 : star / comments.size();
        GoodCommentModel goodCommentModel = new GoodCommentModel();
        goodCommentModel.setComments(comments);
        goodCommentModel.setAvg(star.intValue());
        return goodCommentModel;
    }

    @Override
    public List<SelectGoodResultModel> getSelectGoods(SelectGoodModel selectGoodModel) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria or = goodsExample.or();
        if (StringUtils.isNotBlank(selectGoodModel.getSelectName())) {
            or.andNameLike("%" + selectGoodModel.getSelectName() + "%");
        }
        if (selectGoodModel.getSelectMoneyBig() != null) {
            or.andPriceLessThanOrEqualTo(selectGoodModel.getSelectMoneyBig());
        }
        if (selectGoodModel.getSelectMoneySmall() != null) {
            or.andPriceGreaterThanOrEqualTo(selectGoodModel.getSelectMoneySmall());
        }
        if (selectGoodModel.getSmallTypeValue() != null) {
            or.andSmallTypeEqualTo(selectGoodModel.getSmallTypeValue());
        } else if (selectGoodModel.getBigTypeValue() != null) {
            or.andBigTypeEqualTo(selectGoodModel.getBigTypeValue());
        }
        or.andIsDeleteEqualTo(new Byte("0")).andIsDownEqualTo(new Byte("0"));
        final List<GoodsWithBLOBs> goodsWithBLOBs = goodsMapper.selectByExampleWithBLOBs(goodsExample);
        List<SelectGoodResultModel> selectGoodResultModels = new ArrayList<SelectGoodResultModel>() {
            {
                ShopcarExample shopcarExample = new ShopcarExample();
                for (GoodsWithBLOBs goodsWithBLOB : goodsWithBLOBs) {
                    shopcarExample.or().andGoodIdEqualTo(goodsWithBLOB.getId()).andIsDeleteEqualTo(new Byte("0"));
                    SelectGoodResultModel selectGoodResultModel = new SelectGoodResultModel();
                    BeanUtils.copyProperties(goodsWithBLOB, selectGoodResultModel);
                    selectGoodResultModel.setBuyCount(shopcarMapper.countByExample(shopcarExample));
                    add(selectGoodResultModel);
                    shopcarExample.clear();
                }
            }
        };
        return selectGoodResultModels;
    }

    @Override
    public List<TypesModel> getTypes() {
        List<TypesModel> typesModels = new ArrayList<TypesModel>() {
            {
                TypeExample typeExample = new TypeExample();
                typeExample.setOrderByClause("priority desc");
                typeExample.or().andIsDeleteEqualTo(new Byte("0")).andLevelEqualTo(1).andFatherIdEqualTo(-1);
                List<Type> types = typeMapper.selectByExample(typeExample);
                TypesModel typesModel;
                for (Type type : types) {
                    typesModel = new TypesModel();
                    BeanUtils.copyProperties(type, typesModel);
                    add(typesModel);
                }
            }
        };
        selectAllChrildType(typesModels);
        return typesModels;
    }

    @Override
    public List<BoardModel> getBoardList() {
        return headgoodMapper.selectBoardList();
    }

    private void selectAllChrildType(List<TypesModel> typesModels) {
        for (TypesModel typesModel : typesModels) {
            TypeExample typeExample = new TypeExample();
            typeExample.setOrderByClause("priority desc");
            typeExample.or().andIsDeleteEqualTo(new Byte("0")).andFatherIdEqualTo(typesModel.getId());
            List<Type> types = typeMapper.selectByExample(typeExample);
            if (types.size() != 0) {
                List<TypesModel> chrildTypesModels = new ArrayList<TypesModel>() {
                    {
                        TypesModel typesModel;
                        for (Type type : types) {
                            typesModel = new TypesModel();
                            BeanUtils.copyProperties(type, typesModel);
                            add(typesModel);
                        }
                    }
                };
                selectAllChrildType(chrildTypesModels);
                typesModel.setSmallTypes(chrildTypesModels);
            }
        }
    }
}
