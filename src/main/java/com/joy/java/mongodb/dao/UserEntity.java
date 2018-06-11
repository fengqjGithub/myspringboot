package com.joy.java.mongodb.dao;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Project: myspringboot
 * @Package: com.joy.java.mongodb.dao
 * @Author: 冯前进
 * @Date: 2018-06-05 17:53
 * @Description: TODO
 **/
@Document(collection = "myUser")
public class UserEntity implements Serializable {
    @Id
    private String id;
    private String name;
    private String age;
    private String pass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
