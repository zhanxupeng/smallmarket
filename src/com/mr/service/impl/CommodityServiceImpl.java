package com.mr.service.impl;

import java.util.List;

import com.mr.dao.CommodityDao;
import com.mr.dao.factory.CommodityFactory;
import com.mr.domain.Commodity;
import com.mr.service.CommodityService;

public class CommodityServiceImpl implements CommodityService{
	private CommodityDao dao=CommodityFactory.getCommodityDao();
	@Override
	public List<Commodity> selectByCategory(String category) {
		// TODO Auto-generated method stub
		List<Commodity> list=dao.selectByCategory(category);
		return list;
	}

	@Override
	public Commodity selectById(int id) {
		// TODO Auto-generated method stub
		Commodity commodity=dao.selectById(id);
		return commodity;
	}

}
