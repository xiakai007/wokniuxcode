package com.woniu.chapter19_GoodsCollection;

public class GoodsList {
	private int size;
	private Goods[] goods;
	public GoodsList() {
		goods = new Goods[30];
	}
	public void addGood(Goods good) {
		goods[size++]=good;
	}
	public Goods getGood(int i) {
		return goods[i];
	}
	public int getSize() {
		return size;
	}
	public Goods[] toArray() {
		return goods;
	}

}
