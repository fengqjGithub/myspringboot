package com.joy.java.mybatis.cache;

import com.joy.java.mybatis.model.BkKs;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @Project: myspringboot
 * @Package: com.joy.java
 * @Author: Joy
 * @Date: 2018-05-31 14:55
 * @Description: TODO
 **/
public class TestTwoLevelCache {
    /*
    1、开启二级缓存，在userMapper.xml文件中添加如下配置
    <mapper namespace="me.gacl.mapping.userMapper">
    <!-- 开启二级缓存 -->
    <cache/>
     * 测试二级缓存
     * 使用两个不同的SqlSession对象去执行相同查询条件的查询，第二次查询时不会再发送SQL语句，而是直接从缓存中取出数据
     */
    /**
     * 二级缓存补充说明
     * 　　1. 映射语句文件中的所有select语句将会被缓存。
     * 　　2. 映射语句文件中的所有insert，update和delete语句会刷新缓存。
     * 　　3. 缓存会使用Least Recently Used（LRU，最近最少使用的）算法来收回。
     * 　　4. 缓存会根据指定的时间间隔来刷新。
     * 　　5. 缓存会存储1024个对象
     */
    public void testCache2() {
        String statement = "me.gacl.mapping.userMapper.getUser";
        SqlSessionFactory factory = MybatisUtil.getSqlSessionFactory();
        //开启两个不同的SqlSession
        SqlSession session1 = factory.openSession();
        SqlSession session2 = factory.openSession();
        //使用二级缓存时，User类必须实现一个Serializable接口===> User implements Serializable
        BkKs user = session1.selectOne(statement, 1);
        session1.commit();//不懂为啥，这个地方一定要提交事务之后二级缓存才会起作用
        System.out.println("user=" + user);

        //由于使用的是两个不同的SqlSession对象，所以即使查询条件相同，一级缓存也不会开启使用
        user = session2.selectOne(statement, 1);
        //session2.commit();
        System.out.println("user2=" + user);
    }
}
