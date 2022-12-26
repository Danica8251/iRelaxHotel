package com.example.iSpanHotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "account", nullable = false, unique = true)
	private String account;
	
	@Column(name = "passwd", nullable = false, unique = false)
	private String passwd;
	
	@Column(name = "realname", nullable = false, unique = false)
	private String realName;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "tel", nullable = false, unique = true)
	private String tel;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", account=" + account + ", passwd=" + passwd + 
					", realName=" + realName + ", email=" + email + ", tel=" + tel +"]";
	}
}
