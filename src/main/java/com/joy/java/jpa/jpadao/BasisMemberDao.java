package com.joy.java.jpa.jpadao;

import com.joy.java.jpa.jpaentity.BasisMemberEn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 * @Package: com.joy.java.jpa.jpadao
 * @Class: BasisMemberDao
 * @Author: 冯前进
 * @date: 2018/5/15 15:08
 * @Description: TODO
 * @Param: param
 * @ReturnType: 
 * @Exception   
 **/
public interface BasisMemberDao extends JpaRepository<BasisMemberEn, Long> {

    @Query(value = "select * from basis_member where member_structid =? and member_no=? ", nativeQuery = true)
    List<BasisMemberEn> getmemberByno(String structId, String memberNo);
}
