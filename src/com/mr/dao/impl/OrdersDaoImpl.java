package com.mr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mr.conn.Dbutil;
import com.mr.dao.OrdersDao;
import com.mr.domain.Orders;

public class OrdersDaoImpl implements OrdersDao{

	@Override
	public void insertOrders(String name, String picture, int number, int userid) {
		// TODO Auto-generated method stub
		Connection conn=Dbutil.getConnection();
		String sql="insert into orders(name,picture,number,userid)"
				+ " values(?,?,?,?)";
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, name);
			ptmt.setString(2, picture);
			ptmt.setInt(3, number);
			ptmt.setInt(4, userid);
			ptmt.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrders(int id) {
		// TODO Auto-generated method stub
		Connection conn=Dbutil.getConnection();
		String sql="delete from orders where id=?";
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ptmt.execute();
			ptmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Orders> selectByUser(int userid) {
		// TODO Auto-generated method stub
		List<Orders> list=new ArrayList<>();
		Orders orders=null;
		Connection conn=Dbutil.getConnection();
		String sql="select * from orders where userid=?";
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, userid);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				orders=new Orders();
				orders.setId(rs.getInt("id"));
				orders.setName(rs.getString("name"));
				orders.setPicture(rs.getString("picture"));
				orders.setUserid(rs.getInt("userid"));
				orders.setNumber(rs.getInt("number"));
				list.add(orders);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args){
		OrdersDao dao=new OrdersDaoImpl();
		//dao.insertOrders("50M闪讯","a.jpg",2,1);
		dao.deleteOrders(1);
		List<Orders> list=dao.selectByUser(1);
		for(Orders orders:list){
			System.out.println(orders.getName());
		}
	}

}
