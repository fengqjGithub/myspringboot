package com.joy.config.dataBaseConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Project: sfrzapi
 * @Package: com.hnzr.kqzb
 * @Author: Joy
 * @Date: 2018-02-28 8:56
 * @Description: TODO
 **/
@Configuration
public class JDBCConn {

    public static String URL = "";
    public static String USER = "";
    public static String PASSWORD = "";
    public static String className = "";

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    //注入静态变量
    @PostConstruct
    public void init() {
        USER = username;
        URL = dbUrl;
        PASSWORD = password;
        className = driverClassName;
    }

    /**
     * JDBC连接数据库，但是特殊设置了不自动提交
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * JDBC连接数据库
     *
     * @return
     */
    public static Connection getConnectionCommitAuto() {
        Connection conn = null;
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConn(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
