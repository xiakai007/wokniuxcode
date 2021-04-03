package com.woniuxy.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		
		try {
			//加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	    //得打数据库连接
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/goods?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai", "root","123456");
			Statement stat=conn.createStatement();
			stat.executeUpdate("insert into goodstypes(typeName) values('衣服')");
			conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
