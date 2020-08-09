package com.motoshop.spring.security.entity;

import org.springframework.security.core.GrantedAuthority;

public class MotoGrantedAuthority implements GrantedAuthority {

	private static final long serialVersionUID = 1293810830363367061L;

	private String authority;

	@Override
	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
