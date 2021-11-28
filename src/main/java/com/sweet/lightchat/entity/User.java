package com.sweet.lightchat.entity;

import com.sweet.lightchat.util.Cache;
import lombok.Data;

/**
 * @author wuqing
 * @date 2021/11/28 23:10
 * @description
 */
@Data
public class User {
    private String userId;
    private String username;
    private String password;
    private String nickname;
    private String avatar;
    private String signature;
    private String token;
    private String remark;

    @Override
    public String toString() {
        Integer num = Cache.userMessageNumMap.get(userId);
        if (num == null || num == 0) {
            if (remark != null && !"".equals(remark)) {
                return remark;
            } else {
                return username;
            }
        } else {
            if (remark != null && !"".equals(remark)) {
                return remark + "        " + num + "未读";
            } else {
                return username + "        " + num + "未读";
            }
        }
    }
}
