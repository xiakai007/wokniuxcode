package com.woniuxy.jdbctest;

import com.woniuxy.daos.EmpTypeDao;
import com.woniuxy.entities.EmpType;

public class JDBCTest5_getEmpTypeById {
	public static void main(String[] args) {
		EmpTypeDao etd = new EmpTypeDao();
		EmpType empt = etd.getEmpTypeById(2);
		System.out.println(empt);
	}

}
