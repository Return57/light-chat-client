package com.sweet.lightchat.handler;

import com.sweet.lightchat.entity.User;
import com.sweet.lightchat.response.LoginResp;
import com.sweet.lightchat.service.UiBaseService;
import com.sweet.lightchat.service.UserService;
import com.sweet.lightchat.support.Session;
import com.sweet.lightchat.util.Cache;
import com.sweet.lightchat.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.List;

/**
 * @author wuqing
 * @date 2021/11/28 23:18
 * @description
 */
@ChannelHandler.Sharable
public class LoginHandler extends SimpleChannelInboundHandler<LoginResp> {
    private LoginHandler() {}
    public static LoginHandler INSTANCE = new LoginHandler();
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResp msg) throws Exception {
        if (msg.isSuccess()) {
            System.out.println("恭喜你登录成功了, 你的userId：" + msg.getUserId());
            SessionUtil.bindSession(new Session(msg.getUserId(), msg.getUserName()), ctx.channel());
            Stage login = Cache.ControllerMap.get("login");
            UiBaseService.INSTANCE.runTaskInFxThread(()->{
                login.close();
                Stage main = Cache.ControllerMap.get("main");
                Cache.currentUser.setUserId(msg.getUserId());
                Cache.currentUser.setUsername(msg.getUserName());
                Cache.currentUser.setToken(msg.getToken());
                ListView userListView = (ListView)main.getScene().getRoot().lookup("#userListView");
                List<User> users = UserService.getInstance().getFriendByUserId(msg.getUserId());
                ObservableList userList = userListView.getItems();
                userList.clear();
                if (users != null) {
                    userList.addAll(users);
                }
                main.setTitle("【轻聊】       " + msg.getUserName() + " --在线， id: " + msg.getUserId());
                main.show();
            });

        } else {
            Stage login = Cache.ControllerMap.get("login");
            UiBaseService.INSTANCE.printErrorMsg(login, msg.getReason());
        }
    }
}
