package com.zdj.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.zdj.web.model.*;
import com.zdj.web.service.GoodsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private RedisTemplate redisTemplate;

    @ResponseBody
    @RequestMapping(value = "/boardList", method = {RequestMethod.GET, RequestMethod.POST})
    public String getBoardList() {
        String catchStr = (String) redisTemplate.opsForValue().get("_goods_boardList");
        if (StringUtils.isNotBlank(catchStr)) {
            return catchStr;
        }
        List<BoardModel> boardList = goodsService.getBoardList();
        String result = JSONObject.toJSONString(boardList);
        redisTemplate.opsForValue().set("_goods_boardList", result, 5, TimeUnit.HOURS);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/detail", method = {RequestMethod.GET, RequestMethod.POST})
    public String getGoodsDetail(@RequestBody Map<String, String> values) {
        String catchStr = (String) redisTemplate.opsForValue().get("_goods_detail?" + values.get("id"));
        if (StringUtils.isNotBlank(catchStr)) {
            return catchStr;
        }
        GoodDetailModel goodDetailModel = goodsService.getGoodDetail(Integer.parseInt(values.get("id")));
        String result = JSONObject.toJSONString(goodDetailModel);
        redisTemplate.opsForValue().set("_goods_detail?" + values.get("id"), result, 5, TimeUnit.HOURS);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/comment", method = {RequestMethod.GET, RequestMethod.POST})
    public String getGoodsComment(@RequestBody Map<String, String> values) {
        String catchStr = (String) redisTemplate.opsForValue().get("_goods_comment?id=" + Integer.parseInt(values.get("id")));
        if (StringUtils.isNotBlank(catchStr)) {
            return catchStr;
        }
        GoodCommentModel goodCommentModel = goodsService.getGoodConmment(Integer.parseInt(values.get("id")));
        String result = JSONObject.toJSONString(goodCommentModel);
        redisTemplate.opsForValue().set("_goods_comment?id=" + Integer.parseInt(values.get("id")), result, 5, TimeUnit.HOURS);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/type", method = {RequestMethod.GET, RequestMethod.POST})
    public String getType() {
        String catchStr = (String) redisTemplate.opsForValue().get("_goods_type");
        if (StringUtils.isNotBlank(catchStr)) {
            return catchStr;
        }
        List<TypesModel> typesModels = goodsService.getTypes();
        String result = JSONObject.toJSONString(typesModels);
        redisTemplate.opsForValue().set("_goods_type", result, 5, TimeUnit.HOURS);
        return result;
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
        String catchStr = (String) redisTemplate.opsForValue().get("_goods_select?" + selectGoodModel.toString());
        if (StringUtils.isNotBlank(catchStr)) {
            return catchStr;
        }
        List<SelectGoodResultModel> selectGoodResultModel = goodsService.getSelectGoods(selectGoodModel);
        String result = JSONObject.toJSONString(selectGoodResultModel);
        redisTemplate.opsForValue().set("_goods_select?" + selectGoodModel.toString(), result, 5, TimeUnit.HOURS);
        return result;
    }
}
