package com.joy.java.mongodb.controller;

import com.alibaba.fastjson.JSON;
import com.joy.java.mongodb.dao.IUserService;
import com.joy.java.mongodb.dao.LogDao;
import com.joy.java.mongodb.entity.Log;
import com.joy.java.mongodb.entity.Users;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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

    @Autowired
    LogDao logDao;

    @RequestMapping(value = "/test0", method = RequestMethod.POST)
    public String getone() {
        return JSON.toJSONString(userServiceimpl.findUserByName("小明"));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public String findAll() {
        return JSON.toJSONString(userServiceimpl.listUser());
    }

    @RequestMapping(value = "/saveUsers", method = RequestMethod.POST)
    public String saveUsers() {
        try {
            for (int i = 0; i < 100; i++) {
                Users users = new Users("1", "小明", 10);
                users.setAddress("青岛市");
                userServiceimpl.saveUser(users);
                List<Users> list = userServiceimpl.listUser();
            }
            for (int i = 0; i < 100; i++) {
                Users users = new Users("1", "小红", 20);
                users.setAddress("北京市");
                userServiceimpl.saveUser(users);
                List<Users> list = userServiceimpl.listUser();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
        return "success";
    }
    @RequestMapping(value = "/saveLog", method = RequestMethod.POST)
    public String saveLog(){
        Log l =new Log();
        l.setId("213123");
        l.setMemberid(1);
        l.setAddtime(new Date());
        logDao.save(l);
        return "保存成功";
    }
}
