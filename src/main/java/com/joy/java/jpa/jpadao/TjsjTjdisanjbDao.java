package com.joy.java.jpa.jpadao;

import com.joy.java.jpa.jpaentity.TjsjTjdisanjbEn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Package: com.joy.java.jpa.jpadao
 * @Class: TjsjTjdisanjbDao
 * @Author: 冯前进
 * @date: 2018/5/15 15:09
 * @Description: TODO
 * @Param: param
 * @ReturnType: 
 * @Exception   
 **/
public interface TjsjTjdisanjbDao extends JpaSpecificationExecutor<TjsjTjdisanjbEn>, JpaRepository<TjsjTjdisanjbEn, Integer> {


    @Query(value = "select *,ROW_NUMBER() OVER(order by tjdisanjb_tjlblxno) AS RN  FROM tjsj_tjdisanjb_v " +
            " WHERE 1=1 and tjdisanjb_tjlblxno = '4' and tjdisanjb_tjlxno = '101004' and tjdisanjb_col1 = ?1 and tjdisanjb_col3 = ?2", nativeQuery = true)
    List<TjsjTjdisanjbEn> getQmList(String t_csno, String t_xqno);

    @Query(value = "select *,ROW_NUMBER() OVER(order by tjdisanjb_tjlblxno) AS RN  FROM tjsj_tjdisanjb_v " +
            " WHERE 1=1 and tjdisanjb_tjlblxno = '4' and tjdisanjb_tjlxno = '105003' and tjdisanjb_col7 = '100' and tjdisanjb_col1 = ?1 and tjdisanjb_col3 = ?2", nativeQuery = true)
    List<TjsjTjdisanjbEn> getHuiShou(String t_csno, String t_xqno);

    @Query(value = "select * FROM tjsj_tjdisanjb_v WHERE tjdisanjb_tjlxno=?1 and tjdisanjb_tjlblxno in (?2) order by tjdisanjb_tjlblxno", nativeQuery = true)
    List<TjsjTjdisanjbEn> getDisanjibieColomnList(Integer tjlxNo, int[] tjdisanjb_tjlblxno);

    @Query(value = "select * FROM tjsj_tjdisanjb_v WHERE tjdisanjb_tjlxno=?1 and tjdisanjb_tjlblxno =?2 and tjdisanjb_col7=?3 and tjdisanjb_col1=?4 and tjdisanjb_col3=?5 ", nativeQuery = true)
    List<TjsjTjdisanjbEn> getTjsjTjdisanjb7List(Integer tjlxNo, Integer tjlblxno, String ksccno, String csno, String xqno);

    @Query(value = "select * FROM tjsj_tjdisanjb_v WHERE tjdisanjb_tjlxno=?1 and tjdisanjb_tjlblxno =?2 and tjdisanjb_col1=?3 and tjdisanjb_col3=?4 ", nativeQuery = true)
    List<TjsjTjdisanjbEn> getTjsjTjdisanjbList(Integer tjlxNo, Integer tjlblxno, String csno, String xqno);

    @Query(value = "SELECT *,ROW_NUMBER() OVER(order by tjdisanjb_col1) AS RN  FROM tjsj_tjdisanjb_v WHERE tjdisanjb_tjlblxno='4' AND tjdisanjb_tjlxno=?1 AND tjdisanjb_col1=?2 AND tjdisanjb_col3=?3 AND tjdisanjb_col7=?4", nativeQuery = true)
    List<TjsjTjdisanjbEn> findAllByNo(String tjlxno, String csno, String xqno, String ksccno);

    @Query(value = "SELECT *,ROW_NUMBER() OVER(order by tjdisanjb_col1) AS RN  FROM tjsj_tjdisanjb_v WHERE tjdisanjb_tjlblxno='4' AND tjdisanjb_tjlxno=?1 AND tjdisanjb_col1=?2 AND tjdisanjb_col3=?3", nativeQuery = true)
    List<TjsjTjdisanjbEn> findAllByNo(String tjlxno, String csno, String xqno);

    //考后数据汇总，列表类型为3，合计数据
    @Query(value = "SELECT * FROM tjsj_tjdisanjb_v WHERE tjdisanjb_tjlblxno='3' AND tjdisanjb_tjlxno=?1 AND tjdisanjb_col1=?2 AND tjdisanjb_col3=?3", nativeQuery = true)
    List<TjsjTjdisanjbEn> getHz(String tjlxno, String csno, String xqno);

    //考后数据汇总，列表类型为4，具体数据
    @Query(value = "SELECT * FROM tjsj_tjdisanjb_v WHERE tjdisanjb_tjlblxno='4' AND tjdisanjb_tjlxno=?1 AND tjdisanjb_col1=?2 AND tjdisanjb_col3=?3", nativeQuery = true)
    List<TjsjTjdisanjbEn> getHzOne(String tjlxno, String csno, String xqno);

    //根据城市id获取统计数据
    @Query(value = "SELECT * FROM tjsj_tjdisanjb_v WHERE tjdisanjb_tjlxno=?1 AND tjdisanjb_col1=?2 and Tjdisanjb_tjlblxno in (3,4)", nativeQuery = true)
    List<TjsjTjdisanjbEn> getDisanBycsid(String tjlxno, String csId);

    //根据县区id获取统计数据
    @Query(value = "SELECT * FROM tjsj_tjdisanjb_v WHERE tjdisanjb_tjlxno=?1 AND tjdisanjb_col3=?2 and Tjdisanjb_tjlblxno in (3,4)", nativeQuery = true)
    List<TjsjTjdisanjbEn> getDisanByxqid(String tjlxno, String xqId);

    //根据考点no获取统计数据
    @Query(value = "SELECT * FROM tjsj_tjdisanjb_v WHERE tjdisanjb_tjlxno=?1 AND tjdisanjb_col5=?2 and Tjdisanjb_tjlblxno in (3,4)", nativeQuery = true)
    List<TjsjTjdisanjbEn> getDisanBykcno(String tjlxno, String kcno);

    //根据统计类型获取统计数据
    @Query(value = "SELECT * FROM tjsj_tjdisanjb_v WHERE tjdisanjb_tjlxno=?1 and Tjdisanjb_tjlblxno in (3,4)", nativeQuery = true)
    List<TjsjTjdisanjbEn> getDisanBytjlx(String tjlxno);
}
