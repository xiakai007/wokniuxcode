package com.woniuxy.jdbctest;

import com.woniuxy.daos.EmployeeDao;
import com.woniuxy.entities.Employee;

public class JDBCTest10_getEmplById {
	public static void main(String[] args) {
		EmployeeDao epd = new EmployeeDao();
		Employee empl = epd.getEmplById(2);
		System.out.println(empl);
	}

}
