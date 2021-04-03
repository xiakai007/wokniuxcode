package com.woniuxy.jdbctest;

import java.util.List;

import com.woniuxy.daos.EmpTypeDao;
import com.woniuxy.entities.EmpType;

public class JDBCTest4_getAllEmpTypes {
	public static void main(String[] args) {
		EmpTypeDao etd = new EmpTypeDao();
		List<EmpType> listEmpts = etd.getAllEmpType();
		for(EmpType empt:listEmpts) {
			System.out.println(empt);
		}
	}

}
