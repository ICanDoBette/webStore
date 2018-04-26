package com.zdj.web.pay;

import java.util.List;

public class Pay201 implements PayInterFace {
    @Override
    public String beforePay(List<Integer> id) {
        return "ok";
    }

    @Override
    public String pay(List<Integer> id) {
        return "ok,300";
    }

    @Override
    public String afterPay(List<Integer> id) {
        return "ok";
    }

    @Override
    public String fail(List<Integer> id) {
        return "ok";
    }
}
