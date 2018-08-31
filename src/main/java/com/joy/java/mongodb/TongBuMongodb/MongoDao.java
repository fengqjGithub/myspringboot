package com.joy.java.mongodb.TongBuMongodb; /**
 * @Project: mongodboperate
 * @Package: PACKAGE_NAME
 * @Author: 冯前进
 * @Date: 2018-08-30 15:16
 * @Description: TODO
 **/

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Map;

public interface MongoDao {
    public Map<String, Integer> queryByID(MongoDatabase db, String table, Object Id) throws Exception;

    /**
     * Insert Data
     *
     * @param db
     * @param table
     */
    public boolean insert(MongoDatabase db, String table, Document doc);

    /**
     * Delete Many Data.if doc is empty will delete all Data
     *
     * @param db
     * @param table
     */
    public boolean delete(MongoDatabase db, String table, BasicDBObject doc);

    /**
     * Update All Data
     *
     * @param db
     * @param table
     * @param oldDoc
     * @param newDoc
     */
    public boolean update(MongoDatabase db, String table, BasicDBObject oldDoc,
                          BasicDBObject newDoc);
}
