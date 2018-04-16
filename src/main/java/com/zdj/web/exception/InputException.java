package com.zdj.web.exception;

public class InputException extends Exception {
    public InputException(String objectNames){
        super("值错误:"+objectNames.toString());
    }
}
