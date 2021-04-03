package com.woniuxy.jdbctest;

import com.woniuxy.daos.GoodsDao;
import com.woniuxy.entities.Goods;

public class JDBCTest7_getGoodById {
	public static void main(String[] args) {
		GoodsDao gdo = new GoodsDao();
		Goods good1 = gdo.getGoodById(28);
		Goods good2 = gdo.getGoodById(12);
		System.out.println(good1);
		System.out.println(good2);
	}

}
