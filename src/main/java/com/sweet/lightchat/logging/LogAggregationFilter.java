package com.sweet.lightchat.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.AbstractMatcherFilter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * @author wuqing
 * @date 2021/11/25 20:15
 * @description
 */
public class LogAggregationFilter extends AbstractMatcherFilter<ILoggingEvent> {

    private Level level;

    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }
        Level level = event.getLevel();
        if (level.levelInt >= Level.ALL_INT) {
            return onMatch;
        } else {
            return onMismatch;
        }
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public void start() {
        if (this.level != null) {
            super.start();
        }
    }
}
