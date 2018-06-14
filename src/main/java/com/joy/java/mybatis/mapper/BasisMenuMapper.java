package com.joy.java.mybatis.mapper;

import com.joy.java.mybatis.model.BasisMenu;

public interface BasisMenuMapper {
    int deleteByPrimaryKey(Integer menuid);

    int insert(BasisMenu record);

    int insertSelective(BasisMenu record);

    BasisMenu selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(BasisMenu record);

    int updateByPrimaryKey(BasisMenu record);
}