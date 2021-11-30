package com.sweet.lightchat.logging;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @author wuqing
 * @date 2021/11/25 15:50
 * @description
 */
public class LogSuccessCodeConverter extends ClassicConverter {

    private static final String SUCCESS_CODE = "1001";
    private static final String USURAL_CODE = "6666666";

    @Override
    public String convert(ILoggingEvent event) {
        String message = event.getMessage();
        if (message != null && message.trim().toUpperCase().startsWith("STARTUP")) {
            return SUCCESS_CODE;
        }
        return USURAL_CODE;
    }
}
