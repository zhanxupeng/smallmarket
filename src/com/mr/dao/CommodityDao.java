package com.mr.dao;

import java.util.List;

import com.mr.domain.Commodity;

public interface CommodityDao {
	/**
	 * 根据种类返回所有结果的list
	 */
	List<Commodity> selectByCategory(String category);
	/**
	 * 根据id查询信息
	 */
	Commodity selectById(int id);
	/**
	 * 根据id跟新数量
	 */
	void updateCommodity(Commodity commodity);
	/**
	 * 删除商品
	 */
	void deleteCommodity(int id);
}
