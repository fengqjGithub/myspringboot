package com.joy.java.dao;

import com.joy.java.entity.SfrzRzysbgjEn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Project: sfrzapi
 * @Package: com.hnzr.dao
 * @Author: 冯前进
 * @Date: 2018-01-25 10:20
 * @Description: TODO
 **/
public interface SfrzRzysbgjDao extends JpaRepository<SfrzRzysbgjEn,Integer> {
    @Query(value = "select * from sfrz_rzysbgj where rzysbgj_kcno= ?1 and rzysbgj_zipmc = ?2",nativeQuery = true)
    List<SfrzRzysbgjEn> findByRzysbgj_kcnoAndAndRzysbgj_zipmc(String mcno, String mczip);

    @Modifying
    @Query(value = "update sfrz_rzysbgj set rzysbgj_clzt =?1 where rzysbgj_kcno= ?2 and rzysbgj_zipmc = ?3",nativeQuery = true)
    int updateClzt(int state, String mcno, String mczip);
}
