package com.mr.service.factory;

import com.mr.service.OrdersService;
import com.mr.service.impl.OrdersServiceImpl;

public class OrdersServiceFactory {
	public static OrdersService getOrdersService(){
		return new OrdersServiceImpl();
	}
}
