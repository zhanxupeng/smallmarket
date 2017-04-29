package com.mr.dao.factory;

import com.mr.dao.UserDao;
import com.mr.dao.impl.UserDaoImpl;

public class UserFactory {
	public static UserDao getUserDao(){
		return new UserDaoImpl();
	}
}
