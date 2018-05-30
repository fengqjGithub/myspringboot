package com.joy.config.jedisConfig;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.clients.jedis.JedisPool;

/** 
 * @Project: myspringboot
 * @Package: com.joy.config.jedisConfig
 * @Author: 冯前进
 * @Date: 2018-05-25 10:59
 * @Description: TODO
 **/
@Configuration
public class JedisConfiguration {
    @Value("${spring.redis.database}")
    private String database;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;

    /**
     * 配置jedis
     * @return
     */
    @Bean
//    @Profile("redisPool")
    public JedisPool getJedisPool() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        JedisPool jedisPool = new JedisPool(poolConfig, host, port,
                10000, password, 0);
        return jedisPool;
    }
}
