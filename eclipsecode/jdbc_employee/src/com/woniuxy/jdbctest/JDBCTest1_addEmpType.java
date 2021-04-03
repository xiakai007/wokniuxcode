package com.woniuxy.jdbctest;

import com.woniuxy.daos.EmpTypeDao;
import com.woniuxy.entities.EmpType;

public class JDBCTest1_addEmpType {
	public static void main(String[] args) {
		EmpTypeDao etd = new EmpTypeDao();
		etd.addEmpType(new EmpType(null,"D001","外包人员"));
		
	}

}
