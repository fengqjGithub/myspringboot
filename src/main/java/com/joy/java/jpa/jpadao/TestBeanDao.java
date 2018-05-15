package com.joy.java.jpa.jpadao;

import com.joy.java.jpa.bean.TestBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Package: com.joy.java.jpa.jpadao
 * @Class: TestBeanDao
 * @Author: 冯前进
 * @date: 2018/5/15 15:08
 * @Description: TODO
 * @Param: param
 * @ReturnType: 
 * @Exception   
 **/
public interface TestBeanDao extends JpaRepository<TestBean,Integer> {
    //获取所有考试场次信息
    @Query(value = "select  csid as ksccid, cs_no as kscc_mc,cs_no as kscc_no,cs_no as kscc_kssj," +
            "cs_no as kscc_jssj,cs_no as kscc_sjms,cs_no as kscc_zskssj,cs_no as kscc_zsjssj from qy_cs where csid =1 ",nativeQuery = true)
    List<TestBean> tests11();
}
