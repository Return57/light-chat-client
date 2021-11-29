package com.sweet.lightchat;

import com.sweet.lightchat.config.ServerConfig;
import com.sweet.lightchat.netty.ClientChannelInitializer;
import com.sweet.lightchat.request.LoginReq;
import com.sweet.lightchat.util.Cache;
import com.sweet.lightchat.util.DateUtils;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author wuqing
 * @date 2021/11/24 11:28
 * @description
 */
public class LightChatApplication extends Application {
    public static volatile Channel channelCache = null;

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group).channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ClientChannelInitializer());
        connect(bootstrap, 5);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            if (channelCache == null || !channelCache.isActive() || !channelCache.isOpen() || !channelCache.isWritable()) {
                System.out.println(channelCache.id());
                connect(bootstrap, 1);
            }
        }, 30, 30, TimeUnit.SECONDS);

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(LightChatApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 540, 420);
        stage.setTitle("轻聊");
        stage.setScene(scene);
        stage.show();
    }

    private static void reLogin(Channel channelCache) {
        LoginReq req = new LoginReq();
        req.setUsername(Cache.currentUser.getUsername());
        req.setPassword(Cache.currentUser.getPassword());
        req.setDateTime(DateUtils.now());
        System.out.println("重新登录！");
        System.out.println(channelCache.id());
        channelCache.writeAndFlush(req);
    }


    private static void connect(Bootstrap bootstrap, final int retry) {
        bootstrap.connect(ServerConfig.IP, ServerConfig.NETTY_PORT).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("启动连接成功");
                boolean needLogin = false;
                if (channelCache != null) {
                    channelCache.close();
                    needLogin = true;
                }
                channelCache = ((ChannelFuture) future).channel();
                if (needLogin) {
                    reLogin(channelCache);
                }
            } else if (retry == 0) {
                System.out.println("不在重试连接");
            } else {
                int sleepSecond = 1 << retry;
                Thread.sleep(sleepSecond);
                connect(bootstrap, retry - 1);
            }
        });
    }

}
