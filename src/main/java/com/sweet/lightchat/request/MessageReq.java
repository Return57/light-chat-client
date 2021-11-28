package com.sweet.lightchat.request;

import com.sweet.lightchat.util.AES;
import com.sweet.lightchat.util.Cache;
import com.sweet.lightchat.util.DateUtils;
import lombok.Data;

/**
 * @author wuqing
 * @date 2021/11/28 23:24
 * @description
 */
@Data
public class MessageReq extends Packet {
    /** 消息接收方*/
    private String receiver;
    /** 消息内容*/
    private String message;
    /**
     * 消息类型
     */
    private int messageType = 0;
    @Override
    public byte getCommand() {
        return Command.SEND_MESSAGE_REQ;
    }
    @Override
    public String toString(){
        return Cache.currentUser.getUsername() + " " + DateUtils.convertShowTime(dateTime) + ": \n    " + AES.decrypt(message, dateTime+"ab");
    }
}

