package com.joy.java.mybatis.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.joy.java.mybatis.mapper.BkKsMapper;
import com.joy.java.mybatis.service.BasisMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: myspringboot
 * @Package: com.joy.java.mybatis.controller
 * @Author: 冯前进
 * @Date: 2018-05-30 16:19
 * @Description: TODO
 **/
@RestController
@RequestMapping("mybatis")
public class BasisMemberController {
    @Autowired
    private BasisMemberService basisMemberService;
    @Autowired
    BkKsMapper bkKsMapper;

    @RequestMapping("/getOne")
    public String getOne() {
        return JSON.toJSONString(basisMemberService.getMemberById());
    }
    /**
     * 分页
     */
    @RequestMapping("/getAll")
    public String getAll() {
        PageHelper.startPage(0,4);
        return JSON.toJSONString(basisMemberService.getAll());
    }

    /**
     * 多条件
     *
     * @return
     */
    @RequestMapping("/getbkks")
    public String getbkks() {
        return JSON.toJSONString(bkKsMapper.selectBkksQykc("刘凯", "1"));
    }

    /**
     * 联表查询
     *
     * @return
     */
    @RequestMapping("/getleft")
    public String getleft() {
        return JSON.toJSONString(bkKsMapper.selectLeft("刘凯"));
    }
}
