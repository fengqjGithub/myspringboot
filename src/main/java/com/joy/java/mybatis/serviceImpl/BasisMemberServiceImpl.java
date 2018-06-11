package com.joy.java.mybatis.serviceImpl;

import com.github.pagehelper.Page;
import com.joy.config.dataBaseConfig.DS;
import com.joy.java.mybatis.mapper.BasisMemberMapper;
import com.joy.java.mybatis.model.BasisMember;
import com.joy.java.mybatis.service.BasisMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: myspringboot
 * @Package: com.joy.java.mybatis.serviceImpl
 * @Author: 冯前进
 * @Date: 2018-05-30 16:17
 * @Description: TODO
 **/
@Service
public class BasisMemberServiceImpl implements BasisMemberService {
    @Autowired
    private BasisMemberMapper basisMemberMapper;

    public BasisMember getMemberById(){
        return basisMemberMapper.selectByPrimaryKey(1);
    }
    public Page<BasisMember> getAll(){
        return basisMemberMapper.selectAll();
    }

}
