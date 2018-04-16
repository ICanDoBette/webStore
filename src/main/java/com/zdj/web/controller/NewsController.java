package com.zdj.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.zdj.web.model.BigNewsModel;
import com.zdj.web.model.NewsDetailModel;
import com.zdj.web.model.SmallNewsModel;
import com.zdj.web.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @ResponseBody
    @RequestMapping(value = "/getBigNews", method = {RequestMethod.GET, RequestMethod.POST})
    public String getBigNews() {
        List<BigNewsModel> bigNews = newsService.getBigNews();
        return JSONObject.toJSONString(bigNews);
    }

    @ResponseBody
    @RequestMapping(value = "/getSmallNews", method = {RequestMethod.GET, RequestMethod.POST})
    public String getSmallNews() {
        List<SmallNewsModel> smallNews = newsService.getSmallNews();
        return JSONObject.toJSONString(smallNews);
    }

    @ResponseBody
    @RequestMapping(value = "/getNewsDetail", method = {RequestMethod.GET, RequestMethod.POST})
    public String getNewsDetail(@RequestBody Map<String, String> values) {
        int id = Integer.parseInt(values.get("id"));
        NewsDetailModel newsDetail = newsService.getNewsDetail(id);
        return JSONObject.toJSONString(newsDetail);
    }
}
