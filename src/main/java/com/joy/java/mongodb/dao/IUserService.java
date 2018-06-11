package com.joy.java.mongodb.dao;

import com.joy.java.mongodb.entity.Users;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Package: com.joy.java.mongodb.dao
 * @Class: IUserService
 * @Author: 冯前进
 * @date: 2018/6/11 12:27
 * @Description: TODO
 * @Param: param
 * @ReturnType: 
 * @Exception   
 **/
public interface IUserService {
    public void saveUser(Users users);

    public Users findUserByName(String name);

    public void removeUser(String name);

    public void updateUser(String name, String key, String value);

    public List<Users> listUser();

    List<Users> getGroup(String companyName);

    Page<Users> paginationQuery(Integer pageNum, Integer pageSize);
}
