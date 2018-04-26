package com.zdj.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.zdj.web.model.BankModel;
import com.zdj.web.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private BankService bankService;
    private final static Logger logger = LoggerFactory.getLogger(BankController.class);

    @ResponseBody
    @RequestMapping(value = "/getBank", method = {RequestMethod.GET, RequestMethod.POST})
    public String getBank() {
        logger.info("获取银行信息");
        List<List<BankModel>> bankResult = bankService.getBanks();
        return JSONObject.toJSONString(bankResult);
    }

}
