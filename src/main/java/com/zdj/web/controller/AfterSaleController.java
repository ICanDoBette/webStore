package com.zdj.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.zdj.web.model.AlreadyBuyModel;
import com.zdj.web.model.CommonResponseModel;
import com.zdj.web.pojo.Comment;
import com.zdj.web.service.AfterSaleSrevice;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/afterSale")
public class AfterSaleController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private AfterSaleSrevice afterSaleSrevice;

    @RequestMapping("/addComment")
    public String addComment(@RequestBody Map<String, String> values, HttpSession session) {
        String commentStr = values.get("commentStr");
        String buyIdStr = values.get("buyId");
        String commentStarStr = values.get("commentStar");
        int buyId, commentStar;
        CommonResponseModel commonResponseModel = new CommonResponseModel();
        if (StringUtils.isBlank(commentStr) || StringUtils.isBlank(buyIdStr) || StringUtils.isBlank(commentStarStr)) {
            commonResponseModel.setMsg("评价内容和星级不能为空！");
            return JSONObject.toJSONString(commonResponseModel);
        }
        try {
            buyId = Integer.parseInt(buyIdStr);
            commentStar = Integer.parseInt(commentStarStr);
        } catch (NumberFormatException e) {
            commonResponseModel.setMsg("星级不合法！");
            return JSONObject.toJSONString(commonResponseModel);
        }
        Comment comment = new Comment() {
            {
                Integer userId = (Integer) session.getAttribute("id");
                String userName = (String) session.getAttribute("name");
                setComment(commentStr);
                setCreateTime(new Date());
                setCreateUser(userName);
                setGoodId(buyId);
                setIsDelete(new Byte("0"));
                setStar(commentStar);
                setUpdateTime(new Date());
                setUpdateUser(userName);
                setUserId(userId);
            }
        };
        try {
            afterSaleSrevice.addComment(comment);
            commonResponseModel.setMsg("ok");
            return JSONObject.toJSONString(commonResponseModel);
        } catch (Exception e) {
            logger.error("数据库插入发生异常", e);
            commonResponseModel.setMsg("数据库插入发生异常" + e.getMessage());
            return JSONObject.toJSONString(commonResponseModel);
        }
    }

    @RequestMapping("/getAlreadyBuy")
    public String getAlreadyBuy(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("id");
        List<AlreadyBuyModel> alreadyBuyModelList = afterSaleSrevice.getAlreadyBuy(userId);
        return JSONObject.toJSONString(alreadyBuyModelList);
    }
}
