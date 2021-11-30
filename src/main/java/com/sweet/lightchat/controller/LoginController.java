package com.sweet.lightchat.controller;

import com.sweet.lightchat.LightChatApplication;
import com.sweet.lightchat.request.LoginReq;
import com.sweet.lightchat.util.Cache;
import com.sweet.lightchat.util.DateUtils;
import io.netty.channel.Channel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


/**
 * @author wuqing
 * @date 2021/11/29 23:34
 * @description
 */
public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Circle icon;

    @FXML
    public void initialize() {
        // 设置头像
        Image img = new Image("/images/icon.png");
        icon.setFill(new ImagePattern(img));
    }


    public void login() {
        LoginReq req = new LoginReq();
        req.setUsername(username.getText());
        req.setPassword(password.getText());
        Cache.currentUser.setPassword(password.getText());
        req.setDateTime(DateUtils.now());
        Channel channel = LightChatApplication.channelCache;
        channel.writeAndFlush(req);
    }
}
