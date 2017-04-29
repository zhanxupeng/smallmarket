package com.mr.service.factory;

import com.mr.service.UserService;
import com.mr.service.impl.UserServiceImpl;

public class UserServiceFactory {
	public static UserService getUserService(){
		return new UserServiceImpl();
	}
}
