package com.joy.java.jpa.jpadao;

import com.joy.java.jpa.jpaentity.TjsjTjdiyijbEn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Package: com.joy.java.jpa.jpadao
 * @Class: TjsjTjdiyijbDao
 * @Author: 冯前进
 * @date: 2018/5/15 15:09
 * @Description: TODO
 * @Param: param
 * @ReturnType: 
 * @Exception   
 **/
public interface TjsjTjdiyijbDao extends JpaSpecificationExecutor<TjsjTjdiyijbEn>, JpaRepository<TjsjTjdiyijbEn, Integer> {
    @Query(value = "SELECT *, ROW_NUMBER() OVER(order by tjdiyijb_tjlblxno,tjdiyijb_col1) AS RN FROM tjsj_tjdiyijb_v " +
            " WHERE 1=1 and tjdiyijb_tjlblxno = '4' and tjdiyijb_tjlxno = '101001' and tjdiyijb_col1 = ?1 ", nativeQuery = true)
    List<TjsjTjdiyijbEn> getMachineList(String t_csno);


    @Query(value = "SELECT *,ROW_NUMBER() OVER(order by tjdiyijb_tjlblxno,tjdiyijb_col1) AS RN FROM tjsj_tjdiyijb_v " +
            " WHERE 1=1 and tjdiyijb_tjlblxno = '3' and tjdiyijb_tjlxno = '101001'", nativeQuery = true)
    List<TjsjTjdiyijbEn> getMachineList();

    @Query(value = "select *,ROW_NUMBER() OVER(order by tjdiyijb_tjlblxno,tjdiyijb_col1) AS RN  FROM tjsj_tjdiyijb_v " +
            " WHERE 1=1 and tjdiyijb_tjlblxno = '4' and tjdiyijb_tjlxno = '101004'", nativeQuery = true)
    List<TjsjTjdiyijbEn> getQmList();

    @Query(value = "select *,ROW_NUMBER() OVER(order by tjdiyijb_tjlblxno,tjdiyijb_col1)  AS RN " +
            " FROM tjsj_tjdiyijb_v WHERE 1=1 " +
            " and tjdiyijb_tjlxno='101002' and tjdiyijb_tjlblxno = '3'", nativeQuery = true)
    List<TjsjTjdiyijbEn> getXiaZai();

    @Query(value = "select *,ROW_NUMBER() OVER(order by tjdiyijb_tjlblxno,tjdiyijb_col1)  AS RN " +
            " FROM tjsj_tjdiyijb_v WHERE 1=1 " +
            " and tjdiyijb_tjlxno='101002' and tjdiyijb_tjlblxno = '4' and tjdiyijb_col1 = ?1 ", nativeQuery = true)
    List<TjsjTjdiyijbEn> getXiaZai(String t_csno);

    @Query(value = "select *,ROW_NUMBER() OVER(order by tjdiyijb_tjlblxno,tjdiyijb_col1) " +
            " FROM tjsj_tjdiyijb_v WHERE 1=1 " +
            "and tjdiyijb_tjlxno='105003' and tjdiyijb_tjlblxno = '4' and tjdiyijb_col7 ='100' ", nativeQuery = true)
    List<TjsjTjdiyijbEn> getHuiShou();

    @Query(value = "select * FROM tjsj_tjdiyijb_v WHERE tjdiyijb_tjlxno=?1 and tjdiyijb_tjlblxno in (?2) order by tjdiyijb_tjlblxno,tjdiyijb_col1", nativeQuery = true)
    List<TjsjTjdiyijbEn> getDiyijibieColomnList(Integer tjlxNo, int[] tjdiyijb_tjlblxno);

    @Query(value = "select * FROM tjsj_tjdiyijb_v WHERE tjdiyijb_tjlxno=?1 and tjdiyijb_tjlblxno= ?2 and tjdiyijb_col7 = ?3 order by tjdiyijb_col7,tjdiyijb_col9,tjdiyijb_col1", nativeQuery = true)
    List<TjsjTjdiyijbEn> getTjsjTjdiyijb7List(Integer tjlxNo, int type, String ksccno);

    @Query(value = "select * FROM tjsj_tjdiyijb_v WHERE tjdiyijb_tjlxno=?1 and tjdiyijb_tjlblxno= ?2 order by tjdiyijb_col7,tjdiyijb_col9,tjdiyijb_col1 ", nativeQuery = true)
    List<TjsjTjdiyijbEn> getTjsjTjdiyijbList(Integer tjlxNo, int type);

    @Query(value = "SELECT *,ROW_NUMBER() OVER(ORDER BY tjdiyijb_col7) FROM tjsj_tjdiyijb_v WHERE tjdiyijb_tjlblxno='4' AND tjdiyijb_tjlxno=?1 AND tjdiyijb_tjlblxno=?2 AND tjdiyijb_col7=?3", nativeQuery = true)
    List<TjsjTjdiyijbEn> findAllByNo(String tjlxno, String tjlblxno, String ksccno);

    @Query(value = "SELECT *,ROW_NUMBER() OVER(ORDER BY tjdiyijb_col7) FROM  tjsj_tjdiyijb_v WHERE tjdiyijb_tjlblxno='4' AND tjdiyijb_tjlxno=?1 AND tjdiyijb_col7=?2", nativeQuery = true)
    public List<TjsjTjdiyijbEn> findAllByNo(String tjlxno, String ksccno);

    @Query(value = "SELECT *,ROW_NUMBER() OVER(ORDER BY tjdiyijb_col9) FROM tjsj_tjdiyijb_v WHERE tjdiyijb_tjlblxno='4' AND tjdiyijb_tjlxno=?1", nativeQuery = true)
    public List<TjsjTjdiyijbEn> findAllByNo(String tjlxno);

    //考后汇总数据，列表类型为3，合计数据
    @Query(value = "SELECT * FROM tjsj_tjdiyijb_v WHERE tjdiyijb_tjlblxno='3' AND tjdiyijb_tjlxno=?1", nativeQuery = true)
    public List<TjsjTjdiyijbEn> getHz(String tjlxno);

    //考后汇总数据，列表类型为4，具体数据
    @Query(value = "SELECT * FROM tjsj_tjdiyijb_v WHERE tjdiyijb_tjlblxno='4' AND tjdiyijb_tjlxno=?1", nativeQuery = true)
    public List<TjsjTjdiyijbEn> getHzOne(String tjlxno);

}
