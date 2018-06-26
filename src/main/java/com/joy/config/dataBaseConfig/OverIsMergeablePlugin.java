package com.joy.config.dataBaseConfig;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 使用过MyBatis逆向工程的朋友都应该知道，这东西有个BUG，
 * 就是重复生成的时候它并不会覆盖掉原来的内容（特指xml映射文件），
 * 而是会在后面重新生成一遍，这有点儿头疼，所以首先需要解决这个问题：
 *
 * @Project: myspringboot
 * @Package: com.joy.config.dataBaseConfig
 * @Author: Joy
 * @Date: 2018-06-14 15:39
 * @Description: TODO
 **/
public class OverIsMergeablePlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        try {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
