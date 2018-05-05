package com.joy.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: myspringboot
 * @Package: com.joy.demo
 * @Author: 冯前进
 * @Date: 2018-05-04 11:55
 * @Description: TODO
 **/
@RestController
public class TestController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
