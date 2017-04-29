package com.mr.service.impl;

import com.mr.dao.UserDao;
import com.mr.dao.factory.UserFactory;
import com.mr.domain.User;
import com.mr.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao dao=UserFactory.getUserDao();
	@Override
	public User selectUser(int id, String password) {
		// TODO Auto-generated method stub
		User user=dao.selectByIdAndPwd(id, password);
		return user;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		dao.updateUser(user);
	}

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		boolean result=false;
		User myuser=dao.selectById(user.getId());
		if(myuser==null){
		dao.insertUser(user);
		result=true;
		}
		return result;
	}

}
