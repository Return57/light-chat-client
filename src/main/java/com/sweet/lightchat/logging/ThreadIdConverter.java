package com.sweet.lightchat.logging;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @author wuqing
 * @date 2021/11/25 15:41
 * @description
 */
public class ThreadIdConverter extends ClassicConverter {
    // 当需要显示线程ID时，返回当前调用线程的ID
    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        return String.valueOf(Thread.currentThread().getId());
    }
}
