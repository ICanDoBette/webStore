package com.zdj.web.exception;

public class PayException extends Exception {
    public PayException(String objectNames) {
        super("付款失败：" + objectNames);
    }
}
