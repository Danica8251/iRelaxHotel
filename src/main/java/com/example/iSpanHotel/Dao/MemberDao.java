package com.example.iSpanHotel.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.iSpanHotel.model.Member;

public interface MemberDao extends JpaRepository<Member, Long>{
	
	Integer countByAccount(String account);
	
	Integer countByEmail(String email);
	
	Member findByAccount(String account);
	
	@Query("SELECT c FROM Member c WHERE c.email = ?1")
    public Member findByEmail(String email); 
    
	@Query("SELECT c FROM Member c WHERE c.resetPasswordToken = ?1")
    public Member findByResetPasswordToken(String token);
}
