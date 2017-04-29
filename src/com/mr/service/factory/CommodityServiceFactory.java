package com.mr.service.factory;

import com.mr.service.CommodityService;
import com.mr.service.impl.CommodityServiceImpl;

public class CommodityServiceFactory {
	public static CommodityService getCommodityService(){
		return new CommodityServiceImpl();
	}
}
