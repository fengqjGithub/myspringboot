package com.joy.java.mybatis.mapper;

import com.github.pagehelper.Page;
import com.joy.java.mybatis.model.BasisMember;

import java.util.List;

public interface BasisMemberMapper {
    int deleteByPrimaryKey(Integer memberid);

    int insert(BasisMember record);

    int insertSelective(BasisMember record);

    BasisMember selectByPrimaryKey(Integer memberid);

    int updateByPrimaryKeySelective(BasisMember record);

    int updateByPrimaryKey(BasisMember record);

    Page<BasisMember> selectAll();
}