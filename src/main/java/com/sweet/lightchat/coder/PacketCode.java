package com.sweet.lightchat.coder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sweet.lightchat.request.Command;
import com.sweet.lightchat.request.LoginReq;
import com.sweet.lightchat.request.MessageReq;
import com.sweet.lightchat.request.Packet;
import com.sweet.lightchat.serializer.Serializer;
import io.netty.buffer.ByteBuf;

/**
 * @author wuqing
 * @date 2021/11/28 23:20
 * @description
 */
public class PacketCode {
    public static final PacketCode INSTANCE = new PacketCode();

    private PacketCode() {
    }

    public static final int MAGIC_NUMBER = 0x12345678;

    public void encode(ByteBuf byteBuf, Packet packet) {
        byte[] bytes = Serializer.Default.serializer(packet);
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.Default.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
    }


    public Packet decode(ByteBuf byteBuf) {
        byteBuf.skipBytes(4);
        byteBuf.skipBytes(1);
        // 序列化算法
        byte serializeAlgorithm = byteBuf.readByte();
        // 指令
        byte command = byteBuf.readByte();
        int length = byteBuf.readInt();
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);
        Class<? extends Packet> packetClass = getPacketByCommand(command);
        Serializer serializer = getSerializer(serializeAlgorithm);
        Packet packet = serializer.deSerializer(packetClass, bytes);
        return packet;

    }


    public String encode(Packet packet) {
        return JSON.toJSONString(packet);
    }

    public Packet decode(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        int command = (int) jsonObject.get("command");
        Class<? extends Packet> clazz = getPacketByCommand((byte) command);
        return jsonObject.toJavaObject(clazz);
    }

    public Class<? extends Packet> getPacketByCommand(byte command) {
        if (command==Command.LOGIN_RRQ)
            return LoginReq.class;
        else
            return MessageReq.class;
//        switch (command) {
//            case Command.LOGIN_RRQ:
//                return LoginReq.class;
//            case Command.LOGIN_RESP :
//                return LoginResp.class;
//            case Command.SEND_MESSAGE_RESP :
//                return MessageResp.class;
//            case Command.ADD_USER_REQ :
//                return AddUserReq.class;
//            case Command.ADD_USER_RESP :
//                return AddUserResp.class;
//            case Command.ADD_USER_SELF_RESP :
//                return AddUserSelfResp.class;
//            case Command.CREATE_GROUP_REQ :
//                return CreateGroupReq.class;
//            case Command.CREATE_GROUP_RESP :
//                return CreateGroupResp.class;
//            case Command.INVITE_GROUP_REQ :
//                return InviteGroupReq.class;
//            case Command.INVITE_GROUP_RESP :
//                return InviteGroupResp.class;
//            case Command.INVITE_GROUP_SELF_RESP :
//                return InviteGroupSelfResp.class;
//            case Command.GROUP_MESSAGE_REQ :
//                return GroupMessageReq.class;
//            case Command.GROUP_MESSAGE_RESP :
//                return GroupMessageResp.class;
//            case Command.ACCEPT_GROUP_REQ :
//                return AcceptGroupReq.class;
//            case Command.ACCEPT_GROUP_RESP :
//                return AcceptGroupResp.class;
//            case Command.ACCEPT_REQ :
//                return AcceptReq.class;
//            case Command.ACCEPT_RESP :
//                return AcceptResp.class;
//            case Command.REGISTER_REQ :
//                return RegisterReq.class;
//            case Command.REGISTER_RESP :
//                return RegisterResp.class;
//            case Command.UPDATE_PASSWD_REQ :
//                return UpdatePasswdReq.class;
//            case Command.UPDATE_PASSWD_RESP :
//                return UpdatePasswdResp.class;
//            case Command.MESSAGE_SELF_RESP :
//                return MessageSelfResp.class;
//            case Command.HEAT_BEAT_REQ :
//                return HertBeatReq.class;
//            case Command.HEAT_BEAT_RESP :
//                return HertBeatResp.class;
//            default:
//                return MessageReq.class;
//        }
    }

    private Serializer getSerializer(byte serializeAlgorithm) {
        return Serializer.Default;
    }
}
