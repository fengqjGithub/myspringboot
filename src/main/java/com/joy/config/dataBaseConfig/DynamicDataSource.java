package com.joy.config.dataBaseConfig;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Project: myspringboot
 * @Package: com.joy.config.dataBaseConfig
 * @Author: Joy
 * @Date: 2018-05-31 18:31
 * @Description: TODO
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("数据源为=========================="+DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }
}
