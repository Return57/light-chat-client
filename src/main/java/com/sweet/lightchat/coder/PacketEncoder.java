package com.sweet.lightchat.coder;

import com.sweet.lightchat.request.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author wuqing
 * @date 2021/11/28 23:19
 * @description
 */
public class PacketEncoder  extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet msg, ByteBuf out) throws Exception {
        PacketCode.INSTANCE.encode(out, msg);
    }
}
