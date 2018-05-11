package com.joy.java.dao;

import com.joy.java.entity.BasisMemberEn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BasisMemberDao extends JpaRepository<BasisMemberEn, Long> {

    @Query(value = "select * from basis_member where member_structid =? and member_no=? ", nativeQuery = true)
    List<BasisMemberEn> getmemberByno(String structId, String memberNo);
}
