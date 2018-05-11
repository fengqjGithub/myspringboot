package com.joy.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.lang.reflect.Type;
import java.nio.charset.Charset;

/**
 * fastjson定义redis存储的序列化方式
 *
 * @Project: myspringbootlearning
 * @Package: com.joy.config
 * @Author: 冯前进
 * @Date: 2018-05-11 11:05
 * @Description: TODO
 **/
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private Class<T> clazz;
    public FastJsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        byte[] bytes = JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
        String str = new String(bytes, DEFAULT_CHARSET);
        System.out.println(str+"------------");
        return bytes;
    }
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);
        System.out.println(str);
        return (T) JSON.parseObject(str, clazz);
    }

//    public static void main(String[] args) {
//        String a=JSON.parseObject("\"中国\"", (Type) Object.class);
//        System.out.println(a);
//    }
}
