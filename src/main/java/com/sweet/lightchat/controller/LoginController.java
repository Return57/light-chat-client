package com.sweet.lightchat.controller;

import com.sweet.lightchat.LightChatApplication;
import com.sweet.lightchat.request.LoginReq;
import com.sweet.lightchat.util.Cache;
import com.sweet.lightchat.util.DateUtils;
import io.netty.channel.Channel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


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

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        username.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
//            if (KeyCode.ENTER == event.getCode()) {
//                login();
//            }
//        });
//        password.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
//            if (KeyCode.ENTER == event.getCode()) {
//                login();
//            }
//        });
//    }

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
