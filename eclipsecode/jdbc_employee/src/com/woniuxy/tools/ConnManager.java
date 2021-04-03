package com.woniuxy.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnManager {
	private static String DRIVER_URL = "com.mysql.cj.jdbc.Driver";
	private static String CONNECTION_URL = "jdbc:mysql://localhost:3306/test20200904?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
    private static String USER_NAME = "root";
    private static String USER_PWD = "123456";
    
    public static Connection getConnection() {
    	try {
			Class.forName(DRIVER_URL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	try {
			Connection conn = DriverManager.getConnection(CONNECTION_URL,USER_NAME,USER_PWD);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    	
    }
	public static void closeSC(Statement sta,Connection conn) {
		try {
			if(sta!=null&&!sta.isClosed()) {
				sta.close();
			}
			if(conn!=null&&!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closeResultSet(ResultSet rs) {
		try {
			if(rs!=null&&!rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
