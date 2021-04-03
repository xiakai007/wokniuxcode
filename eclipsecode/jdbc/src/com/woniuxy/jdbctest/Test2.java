package com.woniuxy.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class MyQueryPra{
	public static void query() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from users where user_name='刘备' and user_pwd='123abc'";
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+ "customers?characterEncoding=utf8&useSSL=false&"
					+ "serverTimezone=Asia/Shanghai", "root", "123456");
			
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()) {
				System.out.println("用户名正确");
			}else {
				System.out.println("用户名错误");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
public class Test2 {
	public static void main(String[] args) {
		MyQueryPra.query();
	}

}
