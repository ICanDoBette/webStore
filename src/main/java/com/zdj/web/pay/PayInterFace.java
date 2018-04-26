package com.zdj.web.pay;

import java.util.List;

public interface PayInterFace {
    //ok
    public String beforePay(List<Integer> id);
    //ok,300
    public String pay(List<Integer> id);
    //ok
    public String afterPay(List<Integer> id);
    //ok
    public String fail(List<Integer> id);
}
