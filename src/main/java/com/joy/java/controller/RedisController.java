package com.joy.java.controller;

import com.joy.config.FastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: myspringbootlearning
 * @Package: com.joy.java.controller
 * @Author: 冯前进
 * @Date: 2018-05-11 11:51
 * @Description: TODO
 **/
@RestController
public class RedisController {
    @Autowired
    private StringRedisTemplate template;

    @RequestMapping("/setValue")
    public String setValue() {
        if (!template.hasKey("juedi")) {
            template.setValueSerializer(new FastJsonRedisSerializer<Object>(Object.class));
//            template.opsForValue().set("juedi", "\"绝地求饶\"");
            template.opsForValue().set("juedi", "绝地求饶");
            return "使用redis缓存保存数据成功";
        } else {
//            template.delete("shabao");
            return "key已存在";
        }
    }

    @RequestMapping("/getValue")
    public String getValue() {
        template.setValueSerializer(new FastJsonRedisSerializer<Object>(Object.class));
        if (!template.hasKey("juedi")) {
            return "key不存在，请先保存数据";
        } else {
            String shabao = template.opsForValue().get("juedi");//根据key获取缓存中的val
            return "获取到缓存中的数据：juedi=" + shabao;
        }
    }

    @RequestMapping("/delValue")
    public String delValue() {
        if (template.hasKey("juedi")) {
            template.delete("juedi");
        }
        return "删除成功";
    }
}
