package com.sweet.lightchat.response;

import com.sweet.lightchat.request.Command;
import com.sweet.lightchat.request.Packet;
import lombok.Data;

/**
 * @author wuqing
 * @date 2021/11/28 23:27
 * @description
 */
@Data
public class LoginResp extends Packet {
    /** userId*/
    private String userId;
    private String userName;
    private String token;
    private boolean success;

    private String reason;
    @Override
    public byte getCommand() {
        return Command.LOGIN_RESP;
    }
}
