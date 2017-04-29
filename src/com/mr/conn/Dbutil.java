package com.mr.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {
	public static Connection getConnection(){
		Connection connection=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/quan";
		String username="root";
		String password="998973";
		connection=DriverManager.getConnection(url,username,password);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
	}
	public static void main(String[] args){
		Connection conn=getConnection();
		if(conn!=null){
			System.out.println("数据库连接成功！");
		}
	}
}
