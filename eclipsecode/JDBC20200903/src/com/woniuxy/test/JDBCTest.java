package com.woniuxy.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		
		try {
			//��������
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	    //�ô����ݿ�����
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/goods?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai", "root","123456");
			Statement stat=conn.createStatement();
			stat.executeUpdate("insert into goodstypes(typeName) values('�·�')");
			conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
