package com.zdj.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.zdj.web.model.*;
import com.zdj.web.service.GoodsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping(value = "/boardList", method = {RequestMethod.GET, RequestMethod.POST})
    public String getBoardList() {
        List<BoardModel> boardList = goodsService.getBoardList();
        return JSONObject.toJSONString(boardList);
    }

    @ResponseBody
    @RequestMapping(value = "/detail", method = {RequestMethod.GET, RequestMethod.POST})
    public String getGoodsDetail(@RequestBody Map<String, String> values) {
        GoodDetailModel goodDetailModel = goodsService.getGoodDetail(Integer.parseInt(values.get("id")));
        return JSONObject.toJSONString(goodDetailModel);
    }

    @ResponseBody
    @RequestMapping(value = "/comment", method = {RequestMethod.GET, RequestMethod.POST})
    public String getGoodsComment(@RequestBody Map<String, String> values) {
        GoodCommentModel goodCommentModel = goodsService.getGoodConmment(Integer.parseInt(values.get("id")));
        return JSONObject.toJSONString(goodCommentModel);
    }

    @ResponseBody
    @RequestMapping(value = "/type", method = {RequestMethod.GET, RequestMethod.POST})
    public String getType() {
        List<TypesModel> typesModels = goodsService.getTypes();
        return JSONObject.toJSONString(typesModels);
    }


    @ResponseBody
    @RequestMapping(value = "/select", method = {RequestMethod.GET, RequestMethod.POST})
    public String getSelectGoods(@RequestBody Map<String, String> values) {
        SelectGoodModel selectGoodModel = new SelectGoodModel();
        String selectMoneyBigStr = values.get("selectMoneyBig");
        String selectMoneySmallStr = values.get("selectMoneySmall");
        String selectNameStr = values.get("selectName");
        String bigTypeValueStr = values.get("bigTypeValue");
        String smallTypeValueStr = values.get("smallTypeValue");
        if (StringUtils.isNumeric(selectMoneyBigStr)) {
            selectGoodModel.setSelectMoneyBig(Integer.parseInt(selectMoneyBigStr));
        }
        if (StringUtils.isNumeric(selectMoneySmallStr)) {
            selectGoodModel.setSelectMoneySmall(Integer.parseInt(selectMoneySmallStr));
        }
        if (StringUtils.isNumeric(bigTypeValueStr)) {
            selectGoodModel.setBigTypeValue(Integer.parseInt(bigTypeValueStr));
        }
        if (StringUtils.isNumeric(smallTypeValueStr)) {
            selectGoodModel.setSmallTypeValue(Integer.parseInt(smallTypeValueStr));
        }
        if (StringUtils.isNotBlank(selectNameStr)) {
            selectGoodModel.setSelectName(selectNameStr);
        }
        List<SelectGoodResultModel> selectGoodResultModel = goodsService.getSelectGoods(selectGoodModel);
        return JSONObject.toJSONString(selectGoodResultModel);
    }
}
