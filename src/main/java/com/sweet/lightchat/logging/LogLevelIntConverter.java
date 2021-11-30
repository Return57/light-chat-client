package com.sweet.lightchat.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @author wuqing
 * @date 2021/11/25 15:45
 * @description
 */
public class LogLevelIntConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {
        Level level = event.getLevel();
        int toInt = level.toInt();
        String result = "-1";
        switch (toInt) {
            case 5000:
                result = "0";
                break;
            case 10000:
                result = "1";
                break;
            case 20000:
                result = "2";
                break;
            case 30000:
                result = "3";
                break;
            case 40000:
                result = "4";
                break;
            default:
                result = "-1";
        }
        return result;
    }
}
