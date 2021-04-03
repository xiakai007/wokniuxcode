package com.woniuxy.jdbctest;

import com.woniuxy.daos.GoodsDao;

public class JDBCTest4_delete {
	public static void main(String[] args) {
		GoodsDao gdo = new GoodsDao();
		gdo.deleteGoodsById(27);
	}

}
