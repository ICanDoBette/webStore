package com.zdj.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.zdj.web.model.BigNewsModel;
import com.zdj.web.model.GoodCommentModel;
import com.zdj.web.model.GoodDetailModel;
import com.zdj.web.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

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
    @RequestMapping(value = "/addShopCar", method = {RequestMethod.GET, RequestMethod.POST})
    public String addShopCar(@RequestBody Map<String, String> values) {
        return "{\"msg\":\"ok\",\"count\":\"1\"}";
    }
}
