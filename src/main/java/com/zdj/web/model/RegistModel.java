package com.zdj.web.model;

public class RegistModel {
    private boolean isRegist;
    private LoginModel loginModel;
    private String registMessage;

    public boolean getIsRegist() {
        return isRegist;
    }

    public void setIsRegist(boolean regist) {
        isRegist = regist;
    }

    public String getRegistMessage() {
        return registMessage;
    }

    public void setRegistMessage(String registMessage) {
        this.registMessage = registMessage;
    }

    public LoginModel getLoginModel() {

        return loginModel;
    }

    public void setLoginModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }
}
