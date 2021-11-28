package com.sweet.lightchat.support;

import lombok.Data;

/**
 * @author wuqing
 * @date 2021/11/28 23:29
 * @description
 */
@Data
public class Session {
    private String userId;
    private String userName;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userId + ":" + userName;
    }
}
