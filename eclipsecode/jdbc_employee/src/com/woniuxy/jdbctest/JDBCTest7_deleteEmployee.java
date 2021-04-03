package com.woniuxy.jdbctest;

import com.woniuxy.daos.EmployeeDao;
import com.woniuxy.entities.Employee;

public class JDBCTest7_deleteEmployee {
	public static void main(String[] args) {
		EmployeeDao epd = new EmployeeDao();
		epd.updateEmployee(new Employee(6, "白起", 30, "出差", 3));
		
	}

}
