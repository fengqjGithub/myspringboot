package com.joy.config.dataBaseConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Project: myspringboot
 * @Package: com.joy.config.dataBaseConfig
 * @Author: 冯前进
 * @Date: 2018-05-31 18:04
 * @Description: TODO
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DS {
    String value() default "sqlserverDataSource";
}
