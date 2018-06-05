package com.joy.config.dataBaseConfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project: myspringboot
 * @Package: com.joy.config.dataBaseConfig
 * @Author: 冯前进
 * @Date: 2018-05-31 18:30
 * @Description: TODO
 **/
@Configuration
public class DataSourceConfig extends AbstractDruidDBConfig {
    @Value("${spring.datasource.master.url}")
    private String dbUrl1;

    @Value("${spring.datasource.master.username}")
    private String username1;

    @Value("${spring.datasource.master.password}")
    private String password1;

    @Value("${spring.datasource.master.driverClassName}")
    private String driverClassName1;


    @Value("${spring.datasource.db1.url}")
    private String dbUrl2;

    @Value("${spring.datasource.db1.username}")
    private String username2;

    @Value("${spring.datasource.db1.password}")
    private String password2;

    @Value("${spring.datasource.db1.driverClassName}")
    private String driverClassName2;

    //数据源1
    @Primary
    @Bean(name = "sqlserverDataSource", initMethod = "init", destroyMethod = "close")
    public DruidDataSource sqlserverDataSource() {
        System.out.println(driverClassName1 + "---------driverClassName1-----------" + dbUrl1);
        return super.createDataSource(driverClassName1, dbUrl1, username1, password1);
    }

    //数据源2
    @Bean(name = "mysqlDataSource", initMethod = "init", destroyMethod = "close")
    public DruidDataSource mysqlDataSource() {
        System.out.println(driverClassName2 + "---------driverClassName2-----------" + dbUrl2);
        return super.createDataSource(driverClassName2, dbUrl2, username2, password2);
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     *
     * @return
     */
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(sqlserverDataSource());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap();
        dsMap.put("sqlserverDataSource", sqlserverDataSource());
        dsMap.put("mysqlDataSource", mysqlDataSource());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

    /**
     * 配置@Transactional注解事物
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
