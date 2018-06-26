package com.joy.config.dataBaseConfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

/**
 * @Project: myspringboot
 * @Package: com.joy.config.dataBaseConfig
 * @Author: Joy
 * @Date: 2018-06-06 14:37
 * @Description: TODO
 **/
@Configuration
@EnableTransactionManagement
@MapperScan("com.joy.java.mybatis.mapper")
public class SessionFactoryConfig {
    @Autowired
    private DynamicDataSource dataSource;

    private String typeAliasPackage = "com.joy.java.mybatis.model";

    /**
     * 创建sqlSessionFactoryBean 实例
     * 并且设置configtion 如驼峰命名.等等
     * 设置mapper 映射路径
     * 设置datasource数据源
     * @return
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() {
        try{
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapping/*.xml"));
            sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
            return sqlSessionFactoryBean;
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
