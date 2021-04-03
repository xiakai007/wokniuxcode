package com.woniuxy.jdbctest;

import com.woniuxy.daos.EmployeeDao;

public class JDBCTest8_deleteEmplById {
	public static void main(String[] args) {
		EmployeeDao epd = new EmployeeDao();
		epd.deleteEmplById(7);
		
	}

}
