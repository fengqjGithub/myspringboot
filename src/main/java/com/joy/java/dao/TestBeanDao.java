package com.joy.java.dao;

import com.joy.java.bean.TestBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Project: sfrzapi
 * @Package: com.hnzr.dao
 * @Author: 冯前进
 * @Date: 2018-04-14 9:46
 * @Description: TODO
 **/
public interface TestBeanDao extends JpaRepository<TestBean,Integer> {
    //获取所有考试场次信息
    @Query(value = "select  csid as ksccid, cs_no as kscc_mc,cs_no as kscc_no,cs_no as kscc_kssj," +
            "cs_no as kscc_jssj,cs_no as kscc_sjms,cs_no as kscc_zskssj,cs_no as kscc_zsjssj from qy_cs where csid =1 ",nativeQuery = true)
    List<TestBean> tests11();
}
