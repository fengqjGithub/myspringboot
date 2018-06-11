package com.joy.java.mongodb.controller;

import com.alibaba.fastjson.JSON;
import com.joy.java.mongodb.dao.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: myspringboot
 * @Package: com.joy.java.mongodb.controller
 * @Author: 冯前进
 * @Date: 2018-06-11 12:27
 * @Description: TODO
 **/
@RestController
@RequestMapping("mongo")
@Api(description = "mongoDb查询接口")
public class MongodbController {
    @Autowired
    private IUserService userServiceimpl;
    @RequestMapping(value ="/test0",method = RequestMethod.POST)
    public String getone(){
        return JSON.toJSONString(userServiceimpl.findUserByName("小明"));
    }
    @RequestMapping(value ="/findAll",method = RequestMethod.POST)
    public String findAll(){
        return JSON.toJSONString(userServiceimpl.listUser());
    }

}
