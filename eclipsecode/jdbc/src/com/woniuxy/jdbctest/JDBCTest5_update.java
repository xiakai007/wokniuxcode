package com.woniuxy.jdbctest;

import com.woniuxy.daos.GoodsDao;
import com.woniuxy.entities.Goods;

public class JDBCTest5_update {
	public static void main(String[] args) {
		GoodsDao gdo = new GoodsDao();
		gdo.UpdateGoods(new Goods(28, "李宁男登山鞋", 399.9f, 450, 8));
	}

}
