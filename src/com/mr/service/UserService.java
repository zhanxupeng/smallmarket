package com.mr.service;

import com.mr.domain.User;

public interface UserService {
	/**
	 * 用户登录
	 */
	User selectUser(int id,String password);
	/**
	 * 修改用户信息,只能修改姓名和密码
	 */
	void updateUser(User user);
	/**
	 * 注册用户,先检测是否id重复，重复返回false否则返回true
	 */
	boolean insertUser(User user);
	
}
