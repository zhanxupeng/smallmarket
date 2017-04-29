package com.mr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mr.conn.Dbutil;
import com.mr.dao.MoneysDao;
import com.mr.domain.Moneys;

public class MoneysDaoImpl implements MoneysDao{

	@Override
	public Moneys selectByIdAndPwd(int id, String password) {
		// TODO Auto-generated method stub
		Moneys moneys=null;
		Connection conn=Dbutil.getConnection();
		String sql="select * from moneys where id=? and password=?";
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ptmt.setString(2, password);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				moneys=new Moneys();
				moneys.setId(rs.getInt("id"));
				moneys.setPassword(rs.getString("password"));
				moneys.setNumber(rs.getInt("number"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moneys;
	}

	@Override
	public void updateMoneys(Moneys moneys) {
		// TODO Auto-generated method stub
		Connection conn=Dbutil.getConnection();
		String sql="update moneys set number=? where id=?";
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, moneys.getNumber());
			ptmt.setInt(2, moneys.getId());
			ptmt.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		MoneysDao dao=new MoneysDaoImpl();
		Moneys moneys=dao.selectByIdAndPwd(1,"123456");
		moneys.setNumber(moneys.getNumber()-100);
		dao.updateMoneys(moneys);
		if(moneys!=null){
			System.out.println(moneys.getNumber());
		}
	}
}
