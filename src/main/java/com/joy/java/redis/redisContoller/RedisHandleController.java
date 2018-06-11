package com.joy.java.redis.redisContoller;

import com.alibaba.fastjson.JSON;
import com.joy.java.redis.daoImpl.RedisHandle;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Project: myspringboot
 * @Package: com.joy.java.basecontroller
 * @Author: Joy
 * @Date: 2018-05-11 15:09
 * @Description: TODO
 **/
@RestController
@Api(description = "redisHandle查询接口")
public class RedisHandleController {
    @Resource
    RedisHandle rdh;

    @RequestMapping(value = "/getAllKeys",method = RequestMethod.POST)
    public String getAllKeys() {
        Set set = rdh.getAllKeys();
        return JSON.toJSONString(set);
    }

    @RequestMapping(value = "/getAllString",method = RequestMethod.POST)
    public String getAllString() {
        Map map = rdh.getAllString();
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/setKeyValue",method = RequestMethod.POST)
    public String setKeyValue() {
        rdh.set("test88888", "这是测试号码");
        return "成功";
    }

    @RequestMapping(value = "/getvalues",method = RequestMethod.POST)
    public String getvalues() {
        String value = JSON.toJSONString(rdh.get("juedi"));
        System.out.println("绝地求饶".equals(value));
        System.out.println("\"绝地求饶\"".equals(value));
        return value;
    }

    @RequestMapping(value = "/getvaluestest88888",method = RequestMethod.POST)
    public String getvaluestest88888() {
        String value = JSON.toJSONString(rdh.get("test88888"));
        System.out.println(value);
        System.out.println("这是测试号码");
        System.out.println("这是测试号码".equals(value) + "------");
        System.out.println("\"这是测试号码\"".equals(value) + "------");
        return value;
    }

    @RequestMapping(value = "/addList",method = RequestMethod.POST)
    public String addList() {
        List list = new ArrayList();
        list.add("光明1");
        list.add("光明2");
        list.add("光明3");
        rdh.addList("myList", list);
        return "成功";
    }

    @RequestMapping(value = "/getList",method = RequestMethod.POST)
    public String getList() {
        List list = rdh.getList("myList");
        return JSON.toJSONString(list);
    }
}
