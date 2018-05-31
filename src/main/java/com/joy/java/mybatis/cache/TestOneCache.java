package com.joy.java.mybatis.cache;

import com.joy.java.mybatis.model.BkKs;
import org.apache.ibatis.session.SqlSession;

/**
 * @Project: myspringboot
 * @Package: com.joy.java.mybatis
 * @Author: 冯前进
 * @Date: 2018-05-31 14:48
 * @Description: TODO
 **/
///////看到这篇文章解释的比较清晰，记录下来
public class TestOneCache {
    /*
     * 一级缓存: 也就Session级的缓存(默认开启)
     */
    public void testCache1() {
        SqlSession session = MybatisUtil.getSqlSession();
        String statement = "me.gacl.mapping.BkKsMapper.getBkKs";
        BkKs BkKs = session.selectOne(statement, 1);
        System.out.println(BkKs);

        /*
         * 一级缓存默认就会被使用
         */
        BkKs = session.selectOne(statement, 1);
        System.out.println(BkKs);
        session.close();
        /*
         1. 必须是同一个Session,如果session对象已经close()过了就不可能用了
         */
        session = MybatisUtil.getSqlSession();
        BkKs = session.selectOne(statement, 1);
        System.out.println(BkKs);

        /*
         2. 查询条件是一样的
         */
        BkKs = session.selectOne(statement, 2);
        System.out.println(BkKs);

        /*
         3. 没有执行过session.clearCache()清理缓存
         */
        //session.clearCache();
        BkKs = session.selectOne(statement, 2);
        System.out.println(BkKs);

        /*
         4. 没有执行过增删改的操作(这些操作都会清理缓存)
         */
        session.update("me.gacl.mapping.BkKsMapper.updateBkKs",
                new BkKs());
        BkKs = session.selectOne(statement, 2);
        System.out.println(BkKs);
    }
}
