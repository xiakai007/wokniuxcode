package com.woniuxy.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.woniuxy.entities.Type;

public class JDBCTest2 {
	/*增加商品类型*/
	public void addType(Type t) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/goods_dqlquery?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai", "root","123456");
			Statement sta = conn.createStatement();
			String sql = "insert into goodstypes(typeName)values('"+t.getTypeName()+"')";
			System.out.println(sql);
			sta.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		JDBCTest2 jt = new JDBCTest2();
		Type t = new Type(null, "游戏机");
		jt.addType(t);
		System.out.println("goodsTypes插入数据成功");
	}

}
