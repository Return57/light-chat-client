package com.sweet.lightchat.util;

import com.sweet.lightchat.entity.User;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuqing
 * @date 2021/11/28 23:08
 * @description
 */
public interface Cache {
    Map<String, Stage> ControllerMap = new HashMap<>();
    User currentUser = new User();
    Map<String, Integer> userMessageNumMap = new HashMap<>();
    List<User> cacheUsers = new ArrayList<>();
    Map<String, User> cacheUserMap = new HashMap<>();
}
