package com.woniu.chapter19_GoodsCollection;

public class MyComparable {
	public static void sort(GoodsList goodsList) {
		Goods[] goods = goodsList.toArray();
		for(int i=0;i<goodsList.getSize()-1;i++) {
			for(int j=0;j<goodsList.getSize()-1-i;j++) {
				if(goods[j].compareTo(goods[j+1])>0) {
					Goods temp=goods[j];
					goods[j]=goods[j+1];
					goods[j]=temp;
				}
			}
		}
	}

}
