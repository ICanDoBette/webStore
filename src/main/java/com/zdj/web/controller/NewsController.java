package com.zdj.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.zdj.web.model.BigNewsModel;
import com.zdj.web.model.NewsDetailModel;
import com.zdj.web.model.SmallNewsModel;
import com.zdj.web.service.NewsService;
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
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private RedisTemplate redisTemplate;

    @ResponseBody
    @RequestMapping(value = "/getBigNews", method = {RequestMethod.GET, RequestMethod.POST})
    public String getBigNews() {
        String catchStr = (String) redisTemplate.opsForValue().get("_news_getBigNews");
        if (StringUtils.isNotBlank(catchStr)) {
            return catchStr;
        }
        List<BigNewsModel> bigNews = newsService.getBigNews();
        String result = JSONObject.toJSONString(bigNews);
        redisTemplate.opsForValue().set("_news_getBigNews", result, 5, TimeUnit.HOURS);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getSmallNews", method = {RequestMethod.GET, RequestMethod.POST})
    public String getSmallNews() {
        String catchStr = (String) redisTemplate.opsForValue().get("_news_getSmallNews");
        if (StringUtils.isNotBlank(catchStr)) {
            return catchStr;
        }
        List<SmallNewsModel> smallNews = newsService.getSmallNews();
        String result = JSONObject.toJSONString(smallNews);
        redisTemplate.opsForValue().set("_news_getSmallNews", result, 5, TimeUnit.HOURS);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getNewsDetail", method = {RequestMethod.GET, RequestMethod.POST})
    public String getNewsDetail(@RequestBody Map<String, String> values) {
        int id = Integer.parseInt(values.get("id"));
        String catchStr = (String) redisTemplate.opsForValue().get("_news_getNewsDetail?id="+id);
        if (StringUtils.isNotBlank(catchStr)) {
            return catchStr;
        }
        NewsDetailModel newsDetail = newsService.getNewsDetail(id);
        String result = JSONObject.toJSONString(newsDetail);
        redisTemplate.opsForValue().set("_news_getNewsDetail?id="+id, result, 5, TimeUnit.HOURS);
        return result;
    }
}
