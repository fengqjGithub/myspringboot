package com.joy.java.mongodb.TongBuMongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * @Project: mongodboperate
 * @Package: PACKAGE_NAME
 * @Author: 冯前进
 * @Date: 2018-08-30 15:23
 * @Description: TODO
 **/
public class MongoHelper2 {


    static final String DBName = "pica";
    static final String ServerAddress = "192.168.1.37";
    static final int PORT = 27017;

    public MongoHelper2() {
    }

    public MongoClient getMongoClient() {
        MongoClient mongoClient = null;
        try {
            // 连接到 mongodb 服务
            mongoClient = new MongoClient(ServerAddress, PORT);
            System.out.println("Connect to mongodb successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return mongoClient;
    }

    public MongoDatabase getMongoDataBase(MongoClient mongoClient) {
        MongoDatabase mongoDataBase = null;
        try {
            if (mongoClient != null) {
                // 连接到数据库
                mongoDataBase = mongoClient.getDatabase(DBName);
                System.out.println("Connect to DataBase successfully");
            } else {
                throw new RuntimeException("MongoClient不能够为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mongoDataBase;
    }

    public void closeMongoClient(MongoDatabase mongoDataBase, MongoClient mongoClient) {
        if (mongoDataBase != null) {
            mongoDataBase = null;
        }
        if (mongoClient != null) {
            mongoClient.close();
        }
        System.out.println("CloseMongoClient successfully");

    }
}
