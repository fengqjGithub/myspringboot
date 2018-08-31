package com.joy.java.mongodb.TongBuMongodb.util;

import com.mongodb.util.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project: mongodboperate
 * @Package: util
 * @Author: 冯前进
 * @Date: 2018-08-30 15:21
 * @Description: TODO
 **/
public class JsonStrToMap {
    public static Map<String, Integer> jsonStrToMap(String jsonString) {
        Object parseObj = JSON.parse(jsonString); // 反序列化 把json 转化为对象
        Map<String, Integer> map = (HashMap<String, Integer>) parseObj; // 把对象转化为map
        return map;
    }
}
