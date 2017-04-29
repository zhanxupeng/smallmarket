package com.mr.service;

import java.util.List;

import com.mr.domain.Commodity;

public interface CommodityService {
	/**
	 * 根据类型查询商品
	 */
	List<Commodity> selectByCategory(String category);
	/**
	 * 根据id查询商品
	 */
	Commodity selectById(int id);
}
