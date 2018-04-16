package com.zdj.web.model;

public class LoginModel {
    private int id;
    private String name;
    private boolean isLogin;

    public LoginModel() {
        id = -1;
        name = "";
        isLogin = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean login) {
        isLogin = login;
    }
}
