package com.example.tollfreeproject.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.example.tollfreeproject.domain.User;
import com.example.tollfreeproject.domain.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean isValidUserAndPass(User user) throws Exception {
		User userFromDb = userRepository.findOne(user.getUsername());
		if ((userFromDb != null) && (userFromDb.getPasswordenc().equals(encryptPassword(user.getPassword())))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void createUser(User user) throws Exception {
		// TODO validate User information

		// encrypt password
		user.setPasswordenc(encryptPassword(user.getPassword()));

		userRepository.save(user);
	}

	@Override
	public User getUser(String username) {
		return userRepository.findOne(username);
	}

	protected String encryptPassword(String pass) throws Exception {
		// TODO SALT considerations
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hash = md.digest(pass.getBytes("UTF-8"));

		// converting byte array to Hexadecimal String
		StringBuilder sb = new StringBuilder(2 * hash.length);
		for (byte b : hash) {
			sb.append(String.format("%02x", b & 0xff));
		}

		return sb.toString();
	}

}
