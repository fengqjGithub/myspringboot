package com.joy.java.mybatis.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.joy.config.dataBaseConfig.DS;
import com.joy.java.mybatis.mapper.BkKsMapper;
import com.joy.java.mybatis.service.BasisMemberService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: myspringboot
 * @Package: com.joy.java.mybatis.controller
 * @Author: Joy
 * @Date: 2018-05-30 16:19
 * @Description: TODO
 **/
@RestController
@RequestMapping("mybatis")
@Api(description = "mybatis查询接口")
public class BasisMemberController {
    @Autowired
    private BasisMemberService basisMemberService;
    @Autowired
    BkKsMapper bkKsMapper;

    @DS("mysqlDataSource")
    @RequestMapping(value = "/getOne",method = RequestMethod.POST)
    public String getOne() {
        return JSON.toJSONString(basisMemberService.getMemberById());
    }
    /**
     * 分页
     */
    @DS("mysqlDataSource")
    @RequestMapping(value = "/getAllmysqlDataSource",method = RequestMethod.POST)
    public String getAllmysqlDataSource() {
        PageHelper.startPage(0,4);
        return JSON.toJSONString(basisMemberService.getAll());
    }
    @DS("sqlserverDataSource")
    @RequestMapping(value = "/getAllsqlserverDataSource",method = RequestMethod.POST)
    public String getAllsqlserverDataSource() {
        PageHelper.startPage(0,4);
        return JSON.toJSONString(basisMemberService.getAll());
    }

    /**
     * 多条件
     *
     * @return
     */
    @RequestMapping(value = "/getbkks",method = RequestMethod.POST)
    public String getbkks() {
        return JSON.toJSONString(bkKsMapper.selectBkksQykc("刘凯", "1"));
    }

    /**
     * 联表查询
     *
     * @return
     */
    @RequestMapping(value = "/getleft",method = RequestMethod.POST)
    public String getleft() {
        return JSON.toJSONString(bkKsMapper.selectLeft("刘凯"));
    }
}
