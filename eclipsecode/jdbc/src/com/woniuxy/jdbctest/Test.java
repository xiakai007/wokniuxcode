package com.woniuxy.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class MyQuery{
	public static void query() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mystudent?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement pst=null;
		String sql="select * from users where user_name=? and user_pwd=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, "tom");
			pst.setString(2, "123456");
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
public class Test {
	public static void main(String[] args) {
		MyQuery.query();
	}

}
