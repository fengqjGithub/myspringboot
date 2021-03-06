package com.joy.java.redis.redisContoller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: myspringboot
 * @Package: com.joy.java.basecontroller
 * @Author: Joy
 * @Date: 2018-05-11 11:51
 * @Description: TODO
 **/
@RestController
@Api(description = "redis查询接口")
public class RedisController {
    @Autowired
    private StringRedisTemplate template;

    @RequestMapping(value = "/setValue",method = RequestMethod.POST)
    public String setValue() {
        if (!template.hasKey("juedi")) {
//            template.setValueSerializer(new FastJsonRedisSerializer<Object>(Object.class));
//            template.opsForValue().set("juedi", "\"绝地求饶\"");
            template.opsForValue().set("juedi", "绝地求饶");
            return "使用redis缓存保存数据成功";
        } else {
//            template.delete("shabao");
            return "key已存在";
        }
    }

    @RequestMapping(value = "/getValue",method = RequestMethod.POST)
    public String getValue() {
//        template.setValueSerializer(new FastJsonRedisSerializer<Object>(Object.class));
        if (!template.hasKey("juedi")) {
            return "key不存在，请先保存数据";
        } else {
            String shabao = template.opsForValue().get("juedi");//根据key获取缓存中的val
            return "获取到缓存中的数据：juedi=" + shabao;
        }
    }

    @RequestMapping(value = "/delValue",method = RequestMethod.POST)
    public String delValue() {
        if (template.hasKey("juedi")) {
            template.delete("juedi");
        }
        return "删除成功";
    }
}
