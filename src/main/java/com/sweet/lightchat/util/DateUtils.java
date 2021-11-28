package com.sweet.lightchat.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wuqing
 * @date 2021/11/28 23:06
 * @description
 */
public class DateUtils {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private static final DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM-dd HH:mm:ss");

    public static String now() {
        return LocalDateTime.now().format(formatter);
    }

    public static String convertShowTime(String standardTime) {
        if (standardTime.contains("-")) {
            return standardTime;
        }
        return standardTime.substring(4, 6) + "-" + standardTime.substring(6, 8) + " " +
                standardTime.substring(8, 10) + ":" + standardTime.substring(10, 12) +
                ":" + standardTime.substring(12);
    }
}
