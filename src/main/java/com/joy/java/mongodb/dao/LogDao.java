package com.joy.java.mongodb.dao;

import com.joy.java.mongodb.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Package: com.joy.java.mongodb.dao
 * @Class: LogDao
 * @Author: 冯前进
 * @date: 2018/6/11 15:29
 * @Description: TODO
 * @Param: param
 * @ReturnType: 
 * @Exception   
 **/
public interface LogDao extends MongoRepository<Log,String> {
}
