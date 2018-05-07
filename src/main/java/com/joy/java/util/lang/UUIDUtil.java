package com.joy.java.util.lang;

import java.util.UUID;

/**
 * UUID工具类
 */
public class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
