package com.woniuxy.jdbctest;

import com.woniuxy.daos.EmpTypeDao;
import com.woniuxy.entities.EmpType;

public class JDBCTest2_updateEmpType {
	public static void main(String[] args) {
		EmpTypeDao etd = new EmpTypeDao();
		etd.updateEmpType(new EmpType(6,"CH002","高级技工（工人）"));
	}

}
