package com.sweet.lightchat.logging;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @author wuqing
 * @date 2021/11/25 15:50
 * @description
 */
public class LogMessageRecode extends ClassicConverter {

    private String splice = " | ";

    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        String message = iLoggingEvent.getFormattedMessage();
        String[] split = message.split("\\|");
        if (split.length < 2) {
            String name = iLoggingEvent.getLoggerName();
            String[] names = name.split("\\.");
            String temp = "";
            if (names.length > 0) {
                temp = names[names.length - 1];
            }
            StringBuilder sb = new StringBuilder();
            sb.append(temp).append(splice).append(message);
            return sb.toString();
        }

        return message;
    }
}
