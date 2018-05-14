package com.zdj.web.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdentifyUtil {
    private static String emailIdentifyStr = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    //手机号
    private static String telIdentifyStr1 = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
    //固话
    private static String telIdentifyStr2 = "^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$";

    public static boolean isEmail(String email) {
        //Pattern pattern = Pattern.compile(emailIdentifyStr);
        //忽略大小写
        Pattern pattern = Pattern.compile(emailIdentifyStr, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isTel(String tel) {
        //Pattern pattern = Pattern.compile(emailIdentifyStr);
        //忽略大小写
        Pattern pattern = Pattern.compile(telIdentifyStr1, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(tel);
        if (!matcher.matches()) {
            pattern = Pattern.compile(telIdentifyStr2, Pattern.CASE_INSENSITIVE);
            return matcher.matches();
        } else {
            return true;
        }
    }
}
