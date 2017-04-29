package com.mr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mr.conn.Dbutil;
import com.mr.dao.UserDao;
import com.mr.domain.User;

public class UserDaoImpl implements UserDao{

	@Override
	public User selectByIdAndPwd(int id, String password) {
		// TODO Auto-generated method stub
		Connection conn=Dbutil.getConnection();
		User user=null;
		String sql="select * from myuser where id=? and password=?";
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ptmt.setString(2, password);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Connection conn=Dbutil.getConnection();
		String sql="update myuser set name=?,password=? where id=?";
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, user.getName());
			ptmt.setString(2, user.getPassword());
			ptmt.setInt(3, user.getId());
			ptmt.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		Connection conn=Dbutil.getConnection();
		String sql="insert into myuser (id,name,password) values("
				+"?,?,?)";
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, user.getId());
			ptmt.setString(2, user.getName());
			ptmt.setString(3, user.getPassword());
			ptmt.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		Connection conn=Dbutil.getConnection();
		String sql="delete from myuser where id=?";
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ptmt.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void main(String[] args){
		UserDaoImpl dao=new UserDaoImpl();
		User user=dao.selectById(1);
		if(user!=null){
			System.out.println(user.getName());
		}
//		User myuser =new User(2,"詹旭鹏","654321");
//		dao.insertUser(myuser);
//		User user=dao.selectByIdAndPwd(2, "654321");
//		if(user==null){
//			System.out.println("没有该用户，请重新输入");
//		}
	}

	@Override
	public User selectById(int id) {
		// TODO Auto-generated method stub
		Connection conn=Dbutil.getConnection();
		User user=null;
		String sql="select * from myuser where id=?";
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
}
