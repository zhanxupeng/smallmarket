package com.mr.dao.factory;

import com.mr.dao.CommodityDao;
import com.mr.dao.impl.CommodityDaoImpl;

public class CommodityFactory {
	public static CommodityDao getCommodityDao(){
		return new CommodityDaoImpl();
	}
}
