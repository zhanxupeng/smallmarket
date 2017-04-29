package com.mr.service;

import java.util.List;

import com.mr.domain.Orders;

public interface OrdersService {
	/**
	 * 用户下单
	 * 获得的信息有商品id和数量，银行卡号和密码，用户账号
	 * 返回的结果为0表示账号或密码错误，1表示余额不足，2表示成功
	 */
	int placeOrder(int id,int number,int card_id,String password,int userid);
	/**
	 * 按用户id查询订单
	 */
	List<Orders> selectOrdersByUserId(int userid);
}
