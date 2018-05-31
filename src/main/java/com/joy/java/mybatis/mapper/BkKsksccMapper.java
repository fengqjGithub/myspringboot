package com.joy.java.mybatis.mapper;

import com.joy.java.mybatis.model.BkKskscc;
import com.joy.java.mybatis.model.BkKsksccKey;

public interface BkKsksccMapper {
    int deleteByPrimaryKey(BkKsksccKey key);

    int insert(BkKskscc record);

    int insertSelective(BkKskscc record);

    BkKskscc selectByPrimaryKey(BkKsksccKey key);

    int updateByPrimaryKeySelective(BkKskscc record);

    int updateByPrimaryKey(BkKskscc record);
}