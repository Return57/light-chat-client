package com.sweet.lightchat.request;

import lombok.Data;

/**
 * @author wuqing
 * @date 2021/11/28 22:53
 * @description
 */
@Data
public abstract class Packet {
    private transient byte version = 1;
    /** 时间*/
    protected String dateTime;

    public abstract byte getCommand();
}
