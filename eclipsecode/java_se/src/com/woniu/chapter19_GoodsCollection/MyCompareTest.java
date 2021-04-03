package com.woniu.chapter19_GoodsCollection;

public class MyCompareTest {
	public static void main(String[] args) {
		GoodsList goodsList = new GoodsList();
		goodsList.addGood(new Goods("001","商品1",29.5));
		goodsList.addGood(new Goods("002","商品2",26.5));
		goodsList.addGood(new Goods("003","商品3",3.5));
		goodsList.addGood(new Goods("004","商品4",7.5));
		goodsList.addGood(new Goods("005","商品5",5.5));
		for(int i=0;i<goodsList.getSize();i++) {
			System.out.println(goodsList.getGood(i));
		}
		System.out.println("--------------------");
		MyComparable.sort(goodsList);
		for(int i=0;i<goodsList.getSize();i++) {
			System.out.println(goodsList.getGood(i));
		}
	}

}
