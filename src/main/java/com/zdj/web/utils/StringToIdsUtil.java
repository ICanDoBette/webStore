package com.zdj.web.utils;

import java.util.ArrayList;
import java.util.List;

public class StringToIdsUtil {
    public static List<Integer> getIdByString(String idStr) {
        String[] split = idStr.trim().split(",");
        List<Integer> ids = new ArrayList<>(split.length);
        for (String s : split) {
            ids.add(Integer.parseInt(s));
        }
        return ids;
    }
}
