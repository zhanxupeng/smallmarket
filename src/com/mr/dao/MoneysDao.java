package com.mr.dao;

import com.mr.domain.Moneys;

public interface MoneysDao {
	/**
	 * 查找卡号和密码是否正确
	 */
	Moneys selectByIdAndPwd(int id,String password);
	/**
	 * 修改余额
	 */
	void updateMoneys(Moneys moneys);
}
