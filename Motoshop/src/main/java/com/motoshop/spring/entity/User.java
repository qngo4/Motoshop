package com.motoshop.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "USER_ID")
	private Long userId;
	@Column(name= "USERNAME")
	private String userName;
	@Column(name ="PASSWORD")
	private String password;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="USER_ROLE_ID")
	private List<UserRoles> roles = new ArrayList<UserRoles>();
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<UserRoles> getRoles() {
		return roles;
	}
	public void setRoles(List<UserRoles> roles) {
		this.roles = roles;
	}
	
	


}
