package com.woniuxy.jdbctest;

import com.woniuxy.daos.EmployeeDao;
import com.woniuxy.entities.Employee;

public class JDBCTest6_addEmployee {
	public static void main(String[] args) {
		EmployeeDao epd = new EmployeeDao();
		epd.addEmployee(new Employee(null, "张飞", 32, "休假", 8));
		
	}

}
