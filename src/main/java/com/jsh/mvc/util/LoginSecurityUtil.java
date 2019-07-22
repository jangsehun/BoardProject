package com.jsh.mvc.util;

import java.security.MessageDigest;

public class LoginSecurityUtil {

	public String encryptPassword(String member_pw) throws Exception {

		byte[] hashValue = null;
		String hashString = null;

		MessageDigest md = MessageDigest.getInstance("SHA-256");

		md.reset();
		md.update(member_pw.getBytes("UTF-8"));

		hashValue = md.digest();

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < hashValue.length; i++) {
			sb.append(Integer.toString((hashValue[i] & 0xff) + 0x100, 16).substring(1));
		}

		hashString = sb.toString();

		return hashString;
	}
}
