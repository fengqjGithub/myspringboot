package com.joy.java.jpa.jpadao;

import com.joy.java.jpa.jpaentity.SfrzRzysbgjEn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Package: com.joy.java.jpa.jpadao
 * @Class: SfrzRzysbgjDao
 * @Author: Joy
 * @date: 2018/5/15 15:08
 * @Description: TODO
 * @Param: param
 * @ReturnType: 
 * @Exception   
 **/
public interface SfrzRzysbgjDao extends JpaRepository<SfrzRzysbgjEn,Integer> {
    @Query(value = "select * from sfrz_rzysbgj where rzysbgj_kcno= ?1 and rzysbgj_zipmc = ?2",nativeQuery = true)
    List<SfrzRzysbgjEn> findByRzysbgj_kcnoAndAndRzysbgj_zipmc(String mcno, String mczip);

    @Modifying
    @Query(value = "update sfrz_rzysbgj set rzysbgj_clzt =?1 where rzysbgj_kcno= ?2 and rzysbgj_zipmc = ?3",nativeQuery = true)
    int updateClzt(int state, String mcno, String mczip);
}
