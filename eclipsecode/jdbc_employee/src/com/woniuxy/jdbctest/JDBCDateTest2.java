package com.woniuxy.jdbctest;



import java.util.Date;

import com.woniuxy.daos.TestDateDao;
import com.woniuxy.entities.TestDate;

public class JDBCDateTest2 {
	public static void main(String[] args) {
		TestDateDao tdd = new TestDateDao();
		tdd.addTestDate(new TestDate(null,"上课时间",new Date()));
	}

}
