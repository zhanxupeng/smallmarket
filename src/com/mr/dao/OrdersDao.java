package com.mr.dao;

import java.util.List;

import com.mr.domain.Orders;

public interface OrdersDao {
	/*
	 * 添加订单
	 */
	void insertOrders(String name,String picture,int number,int userid);
	/*
	 * 删除订单
	 */
	void deleteOrders(int id);
	/*
	 * 根据userid查询订单
	 */
	List<Orders> selectByUser(int userid);
}
