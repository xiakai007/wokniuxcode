package com.woniuxy.jdbctest;

import java.util.List;

import com.woniuxy.daos.GoodsDao;
import com.woniuxy.entities.Goods;

public class JDBCTest6_getAllGoods {
	public static void main(String[] args) {
		GoodsDao gdo = new GoodsDao();
		List<Goods> listGoods = gdo.getAllGoods();
		for (Goods good:listGoods) {
			System.out.println(good.getGoodsName()+"-"+good.getGoodsCostPrice());
		}
		List<Goods> listGoodsName = gdo.getGoodsName();
		for (Goods good:listGoodsName) {
			System.out.println(good.getGoodsName());
		}
		
	}

}
