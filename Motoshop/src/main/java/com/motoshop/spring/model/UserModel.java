package com.motoshop.spring.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserModel {

	private Integer userId;
	private String password;
	private Integer role;
	private String userName;

	public UserModel() {
		super();
	}

	public UserModel(@JsonProperty("userId") Integer userId, @JsonProperty("password") String password,
			@JsonProperty("role") Integer role, @JsonProperty("userName") String userName) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.userName = userName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
