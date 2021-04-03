package com.woniuxy.jdbctest;

import java.util.List;

import com.woniuxy.daos.EmployeeDao;
import com.woniuxy.entities.Employee;

public class JDBCTest9_getAllEmployees {
	public static void main(String[] args) {
		EmployeeDao epd = new EmployeeDao();
		List<Employee> listEmpls = epd.getAllEmployees();
		for(Employee empl:listEmpls) {
			System.out.println(empl);
		}
	}

}
