package com.joy.java.mongodb.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.query.Update;

/**
 * @Project: myspringboot
 * @Package: com.joy.java.mongodb.dao
 * @Author: 冯前进
 * @Date: 2018-06-05 18:03
 * @Description: TODO
 **/
public interface BaseDao <T> {
    boolean remove(String id);

    T  get(String id);

    void insert(T t);

    boolean update(Update update, String id) ;

    Page list(Integer pageNum, Integer pageSize);

}
