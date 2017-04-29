package com.mr.dao;

import com.mr.domain.User;

public interface UserDao {
	/**
	 * 查询用户，根据id和密码查询
	 */
	User selectByIdAndPwd(int id,String password);
	
	/**
	 * 修改用户
	 */
	void updateUser(User user);
	/**
	 * 添加用户
	 */
	void insertUser(User user);
	/**
	 * 删除用户
	 */
	void deleteUser(int id);
	/**
	 * 根据id查询用户
	 */
	User selectById(int id);
}
