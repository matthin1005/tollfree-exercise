package com.example.tollfreeproject.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class User {
	
	protected  User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String passwordenc, String password) {
		this.username = username;
		this.passwordenc = passwordenc;
		this.password = password;
	}
	
	@Id
	private String username;
	
	@Transient
	private String password;
	
	private String passwordenc;

	public String getPasswordenc() {
		return passwordenc;
	}
	public void setPasswordenc(String passwordenc) {
		this.passwordenc = passwordenc;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
