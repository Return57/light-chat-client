package com.sweet.lightchat.request;

import lombok.Data;

/**
 * @author wuqing
 * @date 2021/11/28 22:51
 * @description
 */
@Data
public class LoginReq extends Packet {
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    @Override
    public byte getCommand() {
        return Command.LOGIN_RRQ;
    }
}
