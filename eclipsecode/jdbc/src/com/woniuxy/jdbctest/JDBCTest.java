package com.woniuxy.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) {
		//加载驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动已加载完成");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//得到连接
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/goods_dqlquery?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai", "root","123456");
			Statement sta = conn.createStatement();
			sta.executeUpdate("insert into goodstypes(typeName)values('玩具')");
			System.out.println("插入数据成功");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
