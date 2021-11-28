package com.sweet.lightchat.netty;

import com.sweet.lightchat.coder.PacketDecoder;
import com.sweet.lightchat.coder.PacketEncoder;
import com.sweet.lightchat.coder.Spliter;
import com.sweet.lightchat.handler.LoginHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author wuqing
 * @date 2021/11/28 22:45
 * @description
 */
public class ClientChannelInitializer extends ChannelInitializer<NioSocketChannel> {
    @Override
    protected void initChannel(NioSocketChannel ch) throws Exception {
        ch.pipeline().addLast(new Spliter());
        ch.pipeline().addLast(new PacketDecoder());

        ch.pipeline().addLast(LoginHandler.INSTANCE);

        ch.pipeline().addLast(new PacketEncoder());
    }
}
