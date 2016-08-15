package com.example.tollfreeproject.service;

import java.security.NoSuchAlgorithmException;

import com.example.tollfreeproject.domain.User;

public interface UserService {
	
	//TODO review this service Exception throwing. Create UserServiceException.
	public boolean isValidUserAndPass(User user) throws Exception ;
	
	public void createUser(User user) throws Exception ;
	
	public User getUser(String username) throws Exception ;

}
