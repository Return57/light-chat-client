package com.sweet.lightchat.util;

import com.sweet.lightchat.support.Attributes;
import com.sweet.lightchat.support.Session;
import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuqing
 * @date 2021/11/28 23:28
 * @description
 */
public class SessionUtil {
    private static Map<String, Channel> userChannelMap = new ConcurrentHashMap<>();

    public static boolean hasLogin(Channel channel) {
        return channel.attr(Attributes.SESSION).get() != null;
    }

    public static Channel getChannel(String userId) {
        return userChannelMap.get(userId);
    }

    public static void bindSession(Session session, Channel channel) {
        userChannelMap.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    public static void unbindSession(Channel channel) {
        if (hasLogin(channel)) {
            Session session = channel.attr(Attributes.SESSION).get();
            userChannelMap.remove(session.getUserId());
            channel.attr(Attributes.SESSION).set(null);
        }
    }
}
