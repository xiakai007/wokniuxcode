package com.woniuxy.jdbctest;

import java.util.List;

import com.woniuxy.daos.TestDateDao;
import com.woniuxy.entities.TestDate;

public class JDBCDateTest1 {
	public static void main(String[] args) {
		TestDateDao tdd = new TestDateDao();
		List<TestDate> listDate=tdd.getAllDate();
		for(TestDate date:listDate) {
			System.out.println(date);
		}
	}

}
