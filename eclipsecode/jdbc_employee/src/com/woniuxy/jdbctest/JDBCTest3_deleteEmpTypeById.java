package com.woniuxy.jdbctest;

import com.woniuxy.daos.EmpTypeDao;

public class JDBCTest3_deleteEmpTypeById {
	public static void main(String[] args) {
		EmpTypeDao etd = new EmpTypeDao();
		etd.deleteEmpTypeById(7);
		
	}

}
