package com.joy.java.controller;

import com.alibaba.fastjson.JSON;
import com.joy.java.redis.daoImpl.RedisHandle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Project: myspringbootlearning
 * @Package: com.joy.java.controller
 * @Author: 冯前进
 * @Date: 2018-05-11 15:09
 * @Description: TODO
 **/
@RestController
public class RedisHandleController {
    @Resource
    RedisHandle rdh;
    @RequestMapping("/getAllKeys")
    public String getAllKeys(){
        Set set =rdh.getAllKeys();
        return JSON.toJSONString(set);
    }
    @RequestMapping("/getAllString")
    public String getAllString(){
        Map map =rdh.getAllString();
        return JSON.toJSONString(map);
    }
    @RequestMapping("/setKeyValue")
    public String setKeyValue(){
        rdh.set("test88888","这是测试号码");
        return "成功";
    }
    @RequestMapping("/getvalues")
    public String getvalues(){
        String value = JSON.toJSONString(rdh.get("juedi"));
        System.out.println("绝地求饶".equals(value));
        System.out.println("\"绝地求饶\"".equals(value));
        return value;
    }
    @RequestMapping("/getvaluestest88888")
    public String getvaluestest88888(){
        String value = JSON.toJSONString(rdh.get("test88888"));
        System.out.println("这是测试号码".equals(value)+"------");
        System.out.println("\"这是测试号码\"".equals(value)+"------");
        return value;
    }
    @RequestMapping("/addList")
    public String addList(){
        List list=new ArrayList();
        list.add("光明1");
        list.add("光明2");
        list.add("光明3");
        rdh.addList("myList",list);
        return "成功";
    }
    @RequestMapping("/getList")
    public String getList(){
        List list =rdh.getList("myList");
        return JSON.toJSONString(list);
    }
}
