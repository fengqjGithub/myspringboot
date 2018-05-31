package com.joy.java.mybatis.mapper;

import com.joy.java.mybatis.model.QyKc;

public interface QyKcMapper {
    int deleteByPrimaryKey(Integer kcid);

    int insert(QyKc record);

    int insertSelective(QyKc record);

    QyKc selectByPrimaryKey(Integer kcid);

    int updateByPrimaryKeySelective(QyKc record);

    int updateByPrimaryKey(QyKc record);
}