package com.example.tollfreeproject.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserServiceImplTest {

	@Test
	public void testEncryptPassword() throws Exception {
		String md5ForPass1234 = "b4af804009cb036a4ccdc33431ef9ac9";
		UserServiceImpl usersvc = new UserServiceImpl();
		String md5 = usersvc.encryptPassword("pass1234");
		assertEquals(md5ForPass1234, md5);
	}
	
}
