package com.woniuxy.jdbctest;

import com.woniuxy.daos.GoodsDao;
import com.woniuxy.entities.Goods;

public class JDBCTest3_add {
	public static void main(String[] args) {
		GoodsDao gdo = new GoodsDao();
		gdo.addGoods(new Goods(null,"SK-II神仙水",2500.5f,500,6));
		
	}

}
