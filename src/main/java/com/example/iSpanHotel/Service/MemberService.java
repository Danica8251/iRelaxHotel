package com.example.iSpanHotel.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dto.MemberDto;
import com.example.iSpanHotel.model.Member;

import jakarta.servlet.http.HttpServletRequest;

@Service
public interface MemberService {

	// 創建會員帳號
	String create(MemberDto memberDto);

	// 刪除會員帳號
	String delete(Long id);

	// 修改會員帳號
	String update(Long id, MemberDto memberDto);

	// 查詢所有會員帳號
	List<Member> findAll();
	
	// 根據id查詢會員帳號
	Member findById(Long id);
		
	// 登入token驗證
	Boolean checkLogin(String token);
	
	// 登入驗證
	String login(String username, String password);
	
	// 根據token查詢會員
	Member getByResetPasswordToken(String token);
	
	// 根據token修改密碼
	String processResetPassword(HttpServletRequest request, MemberDto memberDto);
}
