package com.zdj.web.enums;

public enum BuyStateEnum {
    NOTDELIVERY(0, "未发货"), DELIVERY(1, "已发货"), RECEIVE(2, "待领取"), DONE(3, "交易完成"), AFTERSALE(4, "申请售后");

    private BuyStateEnum(int stateNum, String words) {
        this.stateNum = stateNum;
        this.words = words;
    }

    private String words;
    private int stateNum;

    public static String getWordsByStae(int stateNum) {
        for (BuyStateEnum buyStateEnum : BuyStateEnum.values()) {
            if (stateNum == buyStateEnum.getStateNum()) {
                return buyStateEnum.getWords();
            }
        }
        return null;
    }

    public String getWords() {
        return words;
    }


    public Integer getStateNum() {
        return stateNum;
    }

}
