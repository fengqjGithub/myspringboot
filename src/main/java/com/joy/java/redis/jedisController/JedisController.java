package com.joy.java.redis.jedisController;

import com.joy.config.jedisConfig.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: myspringboot
 * @Package: com.joy.java.redis.jedisController
 * @Author: Joy
 * @Date: 2018-05-25 11:25
 * @Description: TODO
 **/
@RestController
@RequestMapping(value = "/jedis")
//@Profile("redisPool")
public class JedisController {
    @Autowired
    JedisClient jedisClientPool;

    @RequestMapping("/setValue")
    public String setValue() {
       jedisClientPool.set("我是","feng");
       return "成功";
    }
    @RequestMapping("/getValue")
    public String getValue() {
       return jedisClientPool.get("我是");
    }
}
