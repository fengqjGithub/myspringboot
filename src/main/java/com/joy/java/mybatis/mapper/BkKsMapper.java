package com.joy.java.mybatis.mapper;

import com.joy.java.mybatis.bean.BkksQykc;
import com.joy.java.mybatis.model.BkKs;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BkKsMapper {
    int deleteByPrimaryKey(Integer ksid);

    int insert(BkKs record);

    int insertSelective(BkKs record);

    BkKs selectByPrimaryKey(Integer ksid);

    int updateByPrimaryKeySelective(BkKs record);

    int updateByPrimaryKey(BkKs record);

    List<BkksQykc> selectBkksQykc(@Param(value="ksXm")String ksXm, @Param(value="kmId")String kmId);
    List<BkKs> selectLeft(String ksxm);
}