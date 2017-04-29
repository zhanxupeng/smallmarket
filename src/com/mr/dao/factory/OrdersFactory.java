package com.mr.dao.factory;

import com.mr.dao.OrdersDao;
import com.mr.dao.impl.OrdersDaoImpl;

public class OrdersFactory {
	public static OrdersDao getOrdersDao(){
		return new OrdersDaoImpl();
	}
}
