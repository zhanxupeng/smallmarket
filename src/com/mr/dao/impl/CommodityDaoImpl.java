package com.mr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mr.conn.Dbutil;
import com.mr.dao.CommodityDao;
import com.mr.domain.Commodity;

public class CommodityDaoImpl implements CommodityDao{

	@Override
	public List<Commodity> selectByCategory(String category) {
		// TODO Auto-generated method stub
		Connection conn=Dbutil.getConnection();
		List<Commodity> list=new ArrayList<>();
		Commodity commodity=null;
		String sql="select * from commodity where category=?";
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, category);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				commodity=new Commodity();
				commodity.setId(rs.getInt("id"));
				commodity.setName(rs.getString("name"));
				commodity.setCategory(rs.getString("category"));
				commodity.setDetail(rs.getString("detail"));
				commodity.setPicture(rs.getString("picture"));
				commodity.setPrice(rs.getDouble("price"));
				commodity.setNumber(rs.getInt("number"));
				list.add(commodity);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Commodity selectById(int id) {
		// TODO Auto-generated method stub
		Connection conn=Dbutil.getConnection();
		Commodity commodity=null;
		String sql="select * from commodity where id=?";
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				commodity=new Commodity();
				commodity.setId(rs.getInt("id"));
				commodity.setName(rs.getString("name"));
				commodity.setCategory(rs.getString("category"));
				commodity.setDetail(rs.getString("detail"));
				commodity.setPicture(rs.getString("picture"));
				commodity.setPrice(rs.getDouble("price"));
				commodity.setNumber(rs.getInt("number"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commodity;
	}

	@Override
	public void updateCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		Connection conn=Dbutil.getConnection();
		String sql="update commodity set number=? where id=?";
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, commodity.getNumber());
			ptmt.setInt(2, commodity.getId());
			ptmt.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args){
		CommodityDao dao=new CommodityDaoImpl();
		dao.deleteCommodity(1);
		Commodity commodity=dao.selectById(1);
		if(commodity!=null){
			System.out.println(commodity.getNumber());
		}
//		List<Commodity> list=dao.selectByCategory("闪讯");
//		System.out.println(list.size());
	}

	@Override
	public void deleteCommodity(int id) {
		// TODO Auto-generated method stub
		Connection conn=Dbutil.getConnection();
		String sql="delete from commodity where id=?";
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ptmt.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
