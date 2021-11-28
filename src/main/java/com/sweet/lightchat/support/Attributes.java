package com.sweet.lightchat.support;

import io.netty.util.AttributeKey;

/**
 * @author wuqing
 * @date 2021/11/28 23:29
 * @description
 */
public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
