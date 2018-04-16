package com.zdj.web.service.impl;

import com.zdj.web.mapper.NewsMapper;
import com.zdj.web.model.BigNewsModel;
import com.zdj.web.model.NewsDetailModel;
import com.zdj.web.model.SmallNewsModel;
import com.zdj.web.pojo.NewsExample;
import com.zdj.web.pojo.NewsWithBLOBs;
import com.zdj.web.service.NewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<BigNewsModel> getBigNews() {
        NewsExample newsExample = new NewsExample();
        newsExample.setOrderByClause("priority desc");
        newsExample.or().andTypeEqualTo(2);
        List<NewsWithBLOBs> newsWithBLOBs = newsMapper.selectByExampleWithBLOBs(newsExample);
        List<BigNewsModel> bigNewsModels = new ArrayList<>(newsWithBLOBs.size());
        BigNewsModel bigNewsModel;
        for (int i = 0; i < newsWithBLOBs.size(); i++) {
            NewsWithBLOBs withBLOBs = newsWithBLOBs.get(i);
            bigNewsModel = new BigNewsModel();
            bigNewsModel.setTitle(withBLOBs.getTitle());
            bigNewsModel.setHref("index.html#/news/" + withBLOBs.getId());
            bigNewsModel.setSrc(withBLOBs.getPicturePath());
            bigNewsModels.add(bigNewsModel);
        }
        return bigNewsModels;
    }

    @Override
    public NewsDetailModel getNewsDetail(int id) {
        NewsWithBLOBs newsWithBLOBs = newsMapper.selectByPrimaryKey(id);
        NewsDetailModel newsDetailModel = new NewsDetailModel();
        BeanUtils.copyProperties(newsWithBLOBs, newsDetailModel);
        return newsDetailModel;
    }

    @Override
    public List<SmallNewsModel> getSmallNews() {
        NewsExample newsExample = new NewsExample();
        newsExample.setOrderByClause("priority desc");
        newsExample.or().andTypeEqualTo(1);
        List<NewsWithBLOBs> newsWithBLOBs = newsMapper.selectByExampleWithBLOBs(newsExample);
        SmallNewsModel smallNewsModel;
        List<SmallNewsModel> smallNewsModels = new ArrayList<>(newsWithBLOBs.size());
        for (int i = 0; i < newsWithBLOBs.size(); i++) {
            NewsWithBLOBs withBLOBs = newsWithBLOBs.get(i);
            smallNewsModel = new SmallNewsModel();
            smallNewsModel.setTitle(withBLOBs.getTitle());
            smallNewsModel.setUrl("index.html#/news/" + withBLOBs.getId());
            smallNewsModel.setHot(withBLOBs.getHot().equals(new Byte("1")));
            smallNewsModels.add(smallNewsModel);
        }
        return smallNewsModels;
    }
}
