package com.zdj.web.model;

public class SelectGoodModel {
    private Integer selectMoneyBig=null;
    private Integer selectMoneySmall=null;
    private String selectName=null;
    private Integer bigTypeValue=null;
    private Integer smallTypeValue=null;

    public Integer getSelectMoneyBig() {
        return selectMoneyBig;
    }

    public void setSelectMoneyBig(Integer selectMoneyBig) {
        this.selectMoneyBig = selectMoneyBig;
    }

    public Integer getSelectMoneySmall() {
        return selectMoneySmall;
    }

    public void setSelectMoneySmall(Integer selectMoneySmall) {
        this.selectMoneySmall = selectMoneySmall;
    }

    public String getSelectName() {
        return selectName;
    }

    public void setSelectName(String selectName) {
        this.selectName = selectName;
    }

    public Integer getBigTypeValue() {
        return bigTypeValue;
    }

    public void setBigTypeValue(Integer bigTypeValue) {
        this.bigTypeValue = bigTypeValue;
    }

    public Integer getSmallTypeValue() {
        return smallTypeValue;
    }

    public void setSmallTypeValue(Integer smallTypeValue) {
        this.smallTypeValue = smallTypeValue;
    }

    @Override
    public String toString() {
        return "SelectGoodModel{" +
                "selectMoneyBig=" + selectMoneyBig +
                ", selectMoneySmall=" + selectMoneySmall +
                ", selectName='" + selectName + '\'' +
                ", bigTypeValue=" + bigTypeValue +
                ", smallTypeValue=" + smallTypeValue +
                '}';
    }
}
