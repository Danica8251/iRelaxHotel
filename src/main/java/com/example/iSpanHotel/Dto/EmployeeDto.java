package com.example.iSpanHotel.Dto;

public class EmployeeDto {
	private Long id;
	private String account;
	private String passwd;
	private String realName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	@Override
	public String toString() {
		return "EmployeeController [account=" + account + ", passwd=" + passwd + ", realName=" + realName + "]";
	}

}
