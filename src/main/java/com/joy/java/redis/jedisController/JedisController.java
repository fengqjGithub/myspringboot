package com.joy.java.redis.jedisController;

import com.joy.config.jedisConfig.JedisClient;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@Api(description = "jedis查询接口")
//@Profile("redisPool")
public class JedisController {
    @Autowired
    JedisClient jedisClientPool;

    @RequestMapping(value = "/setValue",method = RequestMethod.POST)
    public String setValue() {
       jedisClientPool.set("我是","feng");
       return "成功";
    }
    @RequestMapping(value = "/getValue",method = RequestMethod.POST)
    public String getValue() {
       return jedisClientPool.get("我是");
    }
}
