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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/afterSale")
public class AfterSaleController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private AfterSaleSrevice afterSaleSrevice;
    @Autowired
    private RedisTemplate redisTemplate;

    @ResponseBody
    @RequestMapping("/addComment")
    public String addComment(@RequestBody Map<String, String> values, HttpSession session) {
        String commentStr = values.get("commentStr");
        String alreadyBuyIdStr = values.get("buyId");
        String commentStarStr = values.get("commentStar");
        int alreadyBuyId, commentStar;
        CommonResponseModel commonResponseModel = new CommonResponseModel();
        if (StringUtils.isBlank(commentStr) || StringUtils.isBlank(alreadyBuyIdStr) || StringUtils.isBlank(commentStarStr)) {
            commonResponseModel.setMsg("评价内容和星级不能为空！");
            return JSONObject.toJSONString(commonResponseModel);
        }
        try {
            alreadyBuyId = Integer.parseInt(alreadyBuyIdStr);
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
                setIsDelete(new Byte("0"));
                setStar(commentStar);
                setUpdateTime(new Date());
                setUpdateUser(userName);
                setUserId(userId);
            }
        };
        try {
            afterSaleSrevice.addCommentByShopCarId(comment, alreadyBuyId);
            commonResponseModel.setMsg("ok");
            return JSONObject.toJSONString(commonResponseModel);
        } catch (Exception e) {
            logger.error("数据库插入发生异常", e);
            commonResponseModel.setMsg("数据库插入发生异常" + e.getMessage());
            return JSONObject.toJSONString(commonResponseModel);
        }
    }

    @ResponseBody
    @RequestMapping("/getAlreadyBuy")
    public String getAlreadyBuy(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("id");
        String catchStr = (String) redisTemplate.opsForValue().get("_afterSale_getAlreadyBuy?userId=" + userId);
        if (StringUtils.isNotBlank(catchStr)) {
            return catchStr;
        }
        List<AlreadyBuyModel> alreadyBuyModelList = afterSaleSrevice.getAlreadyBuy(userId);
        String result = JSONObject.toJSONString(alreadyBuyModelList);
        redisTemplate.opsForValue().set("_afterSale_getAlreadyBuy?userId=" + userId, result, 5, TimeUnit.HOURS);
        return result;
    }
}
