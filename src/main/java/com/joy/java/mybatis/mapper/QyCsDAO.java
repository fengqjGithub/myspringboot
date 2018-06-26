package com.joy.java.mybatis.mapper;

import com.joy.java.mybatis.model.QyCs;
import com.joy.java.mybatis.model.QyCsExample;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.NotEmpty;

public interface QyCsDAO {
    long countByExample(QyCsExample example);

    int deleteByExample(QyCsExample example);

    int deleteByPrimaryKey(Integer csid);

    int insert(QyCs record);

    int insertSelective(QyCs record);

    List<QyCs> selectByExample(QyCsExample example);

    QyCs selectByPrimaryKey(Integer csid);

    int updateByExampleSelective(@Param("record") QyCs record, @Param("example") QyCsExample example);

    int updateByExample(@Param("record") QyCs record, @Param("example") QyCsExample example);

    int updateByPrimaryKeySelective(QyCs record);

    int updateByPrimaryKey(QyCs record);
}