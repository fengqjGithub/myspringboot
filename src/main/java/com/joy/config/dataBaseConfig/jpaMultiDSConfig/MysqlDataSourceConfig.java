package com.joy.config.dataBaseConfig.jpaMultiDSConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @Project: myspringboot
 * @Package: com.joy.config.dataBaseConfig.jpaMultiDSConfig
 * @Author: Joy
 * @Date: 2018-06-06 17:01
 * @Description: TODO
 **/
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "mysqlDataSourceEntityManagerFactory",//配置连接工厂 entityManagerFactory
//        transactionManagerRef = "mysqlDataSourceTransactionManager",//配置 事物管理器  transactionManager
//        basePackages = {"com.joy.java.jpa.mysql"})//设置dao（repo）所在位置
public class MysqlDataSourceConfig {
//    @Resource
//    @Qualifier("mysqlDataSource")
//    private DataSource mysqlDataSource;
//
//    @Bean(name = "entityManagerPrimary")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return mysqlDataSourceEntityManagerFactory(builder).getObject().createEntityManager();
//    }
//
//    @Resource
//    private JpaProperties jpaProperties;
//
//    private Map<String, Object> getVendorProperties() {
//        return jpaProperties.getHibernateProperties(new HibernateSettings());
//    }
//
//    /**
//     * 设置实体类所在位置
//     */
//    @Bean(name = "mysqlDataSourceEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean mysqlDataSourceEntityManagerFactory(EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(mysqlDataSource)
//                .packages("com.joy.java.jpa.mysql")
//                .persistenceUnit("mysqlDataSourceUnit")
//                .properties(getVendorProperties())
//                .build();
//    }
//
//    @Bean(name = "mysqlDataSourceTransactionManager")
//    public PlatformTransactionManager mysqlDataSourceTransactionManager(EntityManagerFactoryBuilder builder) {
//        return new JpaTransactionManager(mysqlDataSourceEntityManagerFactory(builder).getObject());
//    }
}
