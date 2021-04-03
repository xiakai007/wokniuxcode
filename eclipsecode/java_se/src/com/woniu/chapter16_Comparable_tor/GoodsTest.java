package com.woniu.chapter16_Comparable_tor;

import java.util.Arrays;

public class GoodsTest {
	public static void main(String[] args) {
		Goods []goods = new Goods[5];
		goods[0] = new Goods("r红楼梦",23);
		goods[1] = new Goods("b水浒传",23);
		goods[2] = new Goods("h西游记",23);
		goods[3] = new Goods("d三国演义",23);
		goods[4] = new Goods("n营造天书",23);
		System.out.println(goods.toString());
		System.out.println(Arrays.toString(goods));
		Arrays.sort(goods);
		System.out.println(Arrays.toString(goods));
		
	}

}
