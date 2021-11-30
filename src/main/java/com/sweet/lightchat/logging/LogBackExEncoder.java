package com.sweet.lightchat.logging;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;

/**
 * @author wuqing
 * @date 2021/11/25 15:37
 * @description
 */
public class LogBackExEncoder extends PatternLayoutEncoder {
    static {
        PatternLayout.DEFAULT_CONVERTER_MAP.put("ThreadNum", ThreadIdConverter.class.getName());
        PatternLayout.DEFAULT_CONVERTER_MAP.put("Lev", LogLevelIntConverter.class.getName());
        PatternLayout.DEFAULT_CONVERTER_MAP.put("Code", LogSuccessCodeConverter.class.getName());
        PatternLayout.DEFAULT_CONVERTER_MAP.put("msg", LogMessageRecode.class.getName());
    }
}
