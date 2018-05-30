package com.joy.mybatis.mapper;

import com.joy.mybatis.model.BasisMember;

public interface BasisMemberMapper {
    int deleteByPrimaryKey(Integer memberid);

    int insert(BasisMember record);

    int insertSelective(BasisMember record);

    BasisMember selectByPrimaryKey(Integer memberid);

    int updateByPrimaryKeySelective(BasisMember record);

    int updateByPrimaryKey(BasisMember record);
}