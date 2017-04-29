package com.mr.service.impl;

import java.util.List;

import com.mr.dao.CommodityDao;
import com.mr.dao.MoneysDao;
import com.mr.dao.OrdersDao;
import com.mr.dao.factory.CommodityFactory;
import com.mr.dao.factory.MoneysFactory;
import com.mr.dao.factory.OrdersFactory;
import com.mr.domain.Commodity;
import com.mr.domain.Moneys;
import com.mr.domain.Orders;
import com.mr.service.OrdersService;

public class OrdersServiceImpl implements OrdersService{
	private MoneysDao moneysDao=MoneysFactory.getMoneysDao();
	private CommodityDao commodityDao=CommodityFactory.getCommodityDao();
	private OrdersDao ordersDao=OrdersFactory.getOrdersDao();
	@Override
	public int placeOrder(int id, int number, int card_id, String password,int userid) {
		// TODO Auto-generated method stub
		//result 0表示账号或密码错误,1表示钱不够，2表示成功
		int result=0;
		double price=0;
		//先查询总价
		Commodity commodity=commodityDao.selectById(id);
		price=commodity.getPrice()*number;
		//先查询银行卡
		Moneys moneys=moneysDao.selectByIdAndPwd(card_id, password);
		if(moneys==null){
			result=0;
		}else if(moneys.getNumber()<price){
			result=1;
		}else{
			//扣钱
			moneys.setNumber(moneys.getNumber()-(int)price);
			moneysDao.updateMoneys(moneys);
			ordersDao.insertOrders(commodity.getName(),commodity.getPicture(),
					number, userid);
			commodity.setNumber(commodity.getNumber()-number);
			commodityDao.updateCommodity(commodity);
			result=2;
		}
		return result;
	}
	@Override
	public List<Orders> selectOrdersByUserId(int userid) {
		// TODO Auto-generated method stub
		List<Orders> list=ordersDao.selectByUser(userid);
		return list;
	}

}
