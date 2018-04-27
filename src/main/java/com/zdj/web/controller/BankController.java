package com.zdj.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.zdj.web.model.BankModel;
import com.zdj.web.service.BankService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private BankService bankService;
    @Autowired
    private RedisTemplate redisTemplate;
    private final static Logger logger = LoggerFactory.getLogger(BankController.class);

    @ResponseBody
    @RequestMapping(value = "/getBank", method = {RequestMethod.GET, RequestMethod.POST})
    public String getBank() {
        logger.info("获取银行信息");
        String catchStr = (String) redisTemplate.opsForValue().get("_getBank");
        if (StringUtils.isNotBlank(catchStr)) {
            return catchStr;
        }
        List<List<BankModel>> bankResult = bankService.getBanks();
        String result = JSONObject.toJSONString(bankResult);
        redisTemplate.opsForValue().set("_getBank", result, 5, TimeUnit.HOURS);
        return result;
    }

}
