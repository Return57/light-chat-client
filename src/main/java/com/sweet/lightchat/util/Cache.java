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
public class Cache {
    public static Map<String, Stage> ControllerMap = new HashMap<>();
    public static User currentUser = new User();
    public static Map<String, Integer> userMessageNumMap = new HashMap<>();
    public static List<User> cacheUsers = new ArrayList<>();
    public static Map<String, User> cacheUserMap = new HashMap<>();
}
