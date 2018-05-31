package com.joy.java.mybatis.service;

import com.joy.java.mybatis.model.BasisMember;

import java.util.List;

/**
 * @Project: myspringboot
 * @Package: com.joy.java.mybatis.service
 * @Author: 冯前进
 * @Date: 2018-05-30 16:17
 * @Description: TODO
 **/
public interface BasisMemberService {
    BasisMember getMemberById();
    List<BasisMember> getAll();
}
