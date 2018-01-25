package com.manager.service;

import com.manager.beans.User;
import com.manager.dao.UserDao;

public class UserService{
	UserDao udao = new UserDao();
	
	public boolean checkLogin(String phone,String password) {
			return udao.selectUser(phone,password);
	}

	public User selectUserByPhone(String phone) {
		User user = udao.selectUserByPhone(phone);
		return user;
	}
}
