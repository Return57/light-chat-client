package com.sweet.lightchat.request;

/**
 * @author wuqing
 * @date 2021/11/28 22:58
 * @description
 */
public class Command {
    /**
     * 登录
     */
    public static byte LOGIN_RRQ = 1;
    public static byte LOGIN_RESP = 2;
    /**
     * 登出
     */
    public static byte LOGOUT_REQ = 3;
    public static byte LOGOUT_RESP = 4;
    /**
     * 发送信息
     */
    public static byte SEND_MESSAGE_REQ = 5;
    public static byte SEND_MESSAGE_RESP = 6;
    public static byte ADD_USER_REQ = 7;
    public static byte ADD_USER_RESP = 8;
    public static byte ADD_USER_SELF_RESP = 9;
    public static byte CREATE_GROUP_REQ = 10;
    public static byte CREATE_GROUP_RESP = 11;
    public static byte INVITE_GROUP_REQ = 12;
    public static byte INVITE_GROUP_RESP = 13;
    public static byte INVITE_GROUP_SELF_RESP = 14;
    public static byte GROUP_MESSAGE_REQ = 15;
    public static byte GROUP_MESSAGE_RESP = 16;
    public static byte ACCEPT_GROUP_REQ = 17;
    public static byte ACCEPT_GROUP_RESP = 18;
    public static byte ACCEPT_REQ = 19;
    public static byte ACCEPT_RESP = 20;
    public static byte REGISTER_REQ = 21;
    public static byte REGISTER_RESP = 22;
    public static byte UPDATE_PASSWD_REQ = 23;
    public static byte UPDATE_PASSWD_RESP = 24;
    public static byte MESSAGE_SELF_RESP = 25;
    public static byte HEAT_BEAT_REQ = 26;
    public static byte HEAT_BEAT_RESP = 27;
}
