package com.service;

import com.dao.Login_DAO;
public class Login_Service {
	public static String validate(String user,String pw) {
		String role = null;
		role = Login_DAO.validate(user,pw);
		return role;
	}
}
