package com.joy.java.dao;

import com.joy.java.entity.TjsjTjdierjbEn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Project: sfrzapi
 * @Package: com.hnzr.login.dao
 * @Author: 冯前进
 * @Date: 2018-01-16 16:12
 * @Description: TODO
 **/
public interface TjsjTjdierjbDao extends JpaSpecificationExecutor<TjsjTjdierjbEn>, JpaRepository<TjsjTjdierjbEn, Integer> {


    @Query(value = " select *,ROW_NUMBER() OVER(order by tjdierjb_tjlblxno) AS RN FROM tjsj_tjdierjb_v " +
            " WHERE 1=1 and tjdierjb_tjlblxno = '4' and tjdierjb_tjlxno = '101001' and tjdierjb_col1 = ?1 and tjdierjb_col3 = ?2 ", nativeQuery = true)
    List<TjsjTjdierjbEn> getMachineList(String t_csno, String t_xqno);

    @Query(value = "select *,ROW_NUMBER() OVER(order by tjdierjb_tjlblxno) AS RN  FROM tjsj_tjdierjb_v " +
            " WHERE 1=1 and tjdierjb_tjlblxno = '4' and tjdierjb_tjlxno = '101004' and tjdierjb_col1 = ?1", nativeQuery = true)
    List<TjsjTjdierjbEn> getQmList(String t_csno);

    @Query(value = "select *,ROW_NUMBER() OVER(order by tjdierjb_tjlblxno)  AS RN " +
            " FROM tjsj_tjdierjb_v WHERE 1=1 " +
            "and tjdierjb_tjlxno='101002' and tjdierjb_tjlblxno = '4' and tjdierjb_col1 = ?1 and tjdierjb_col3=?2 ; ", nativeQuery = true)
    List<TjsjTjdierjbEn> getXiaZai(String t_csno, String t_xqno);


    @Query(value = "select *,ROW_NUMBER() OVER(order by tjdierjb_tjlblxno) AS RN  FROM tjsj_tjdierjb_v " +
            "  WHERE 1=1 and tjdierjb_tjlblxno = '4' and tjdierjb_tjlxno = '105003'and tjdierjb_col7 ='100' and tjdierjb_col1 = ?1", nativeQuery = true)
    List<TjsjTjdierjbEn> getHuiShou(String t_csno);

    @Query(value = "select * FROM tjsj_tjdierjb_v WHERE tjdierjb_tjlxno=?1 and tjdierjb_tjlblxno in (?2) order by tjdierjb_tjlblxno", nativeQuery = true)
    List<TjsjTjdierjbEn> getDierjibieColomnList(Integer tjlxNo, int[] tjdierjb_tjlblxno);

    @Query(value = "select * FROM tjsj_tjdierjb_v WHERE tjdierjb_tjlblxno=?1 and tjdierjb_tjlxno = ?2  and tjdierjb_col1 = ?3 and tjdierjb_col7=?4 order by tjdierjb_col9,tjdierjb_col3 ", nativeQuery = true)
    List<TjsjTjdierjbEn> getTjsjTjdierjb7List(Integer tjdierjb_tjlblxno, int tjdierjb_tjlxno, String tjdierjb_col1, String tjdierjb_col7);

    @Query(value = "select * FROM tjsj_tjdierjb_v WHERE tjdierjb_tjlblxno=?1 and tjdierjb_tjlxno = ?2  and tjdierjb_col1 = ?3 order by tjdierjb_col9,tjdierjb_col3", nativeQuery = true)
    List<TjsjTjdierjbEn> getTjsjTjdierjbList(Integer tjdierjb_tjlblxno, int tjdierjb_tjlxno, String tjdierjb_col1);

    //yongdao csno,ksccno
    @Query(value = "SELECT *,ROW_NUMBER() OVER(ORDER BY tjdierjb_col1) AS RN FROM tjsj_tjdierjb_v WHERE tjdierjb_tjlblxno='4' AND tjdierjb_tjlxno=?1 AND tjdierjb_col1=?2 AND tjdierjb_col7=?3", nativeQuery = true)
    List<TjsjTjdierjbEn> findAllByNo(String tjlxno, String csno, String ksccno);

    //yongdao csno
    @Query(value = "SELECT *,ROW_NUMBER() OVER(ORDER BY tjdierjb_col1) AS RN FROM tjsj_tjdierjb_v WHERE tjdierjb_tjlblxno='4' AND tjdierjb_tjlxno=?1 AND tjdierjb_col1=?2", nativeQuery = true)
    List<TjsjTjdierjbEn> findAllByNo(String tjlxno, String csno);

    //获取市级具体数据，数据汇总情况，列表类型4
    @Query(value = "SELECT * FROM tjsj_tjdierjb_v WHERE tjdierjb_tjlblxno='4' AND tjdierjb_tjlxno=?1 AND tjdierjb_col1=?2", nativeQuery = true)
    List<TjsjTjdierjbEn> getSjHzone(String tjlxno, String csno);

    //获取市级合计数据，数据汇总情况，列表类型3
    @Query(value = "SELECT * FROM tjsj_tjdierjb_v WHERE tjdierjb_tjlblxno='3' AND tjdierjb_tjlxno=?1 AND tjdierjb_col1=?2", nativeQuery = true)
    List<TjsjTjdierjbEn> getSjHz(String tjlxno, String csno);

}
