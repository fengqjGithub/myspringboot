package com.joy.java.mybatis.service;

import com.joy.config.dataBaseConfig.DS;
import com.joy.java.mybatis.model.BasisMember;

import java.util.List;

/**
 * @Project: myspringboot
 * @Package: com.joy.java.mybatis.service
 * @Author: Joy
 * @Date: 2018-05-30 16:17
 * @Description: TODO
 **/
public interface BasisMemberService {
    List<BasisMember> getAll();
    BasisMember getMemberById();
}
