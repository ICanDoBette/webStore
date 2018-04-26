package com.zdj.web.model;

public class AddAddressRequestModel {
    private String addreess;
    private Integer addressTel;
    private String name;

    public String getAddreess() {
        return addreess;
    }

    public void setAddreess(String addreess) {
        this.addreess = addreess;
    }

    public Integer getAddressTel() {
        return addressTel;
    }

    public void setAddressTel(Integer addressTel) {
        this.addressTel = addressTel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
