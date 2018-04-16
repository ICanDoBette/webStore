package com.zdj.web.service;

import com.zdj.web.model.BigNewsModel;
import com.zdj.web.model.NewsDetailModel;
import com.zdj.web.model.SmallNewsModel;

import java.util.List;

public interface NewsService {
    public List<BigNewsModel> getBigNews();

    public NewsDetailModel getNewsDetail(int id);

    List<SmallNewsModel> getSmallNews();
}
