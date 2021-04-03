package com.woniu.chapter19_GoodsCollection;

import java.util.Comparator;

public class MyComparator implements Comparator<Goods> {

	@Override
	public int compare(Goods o1, Goods o2) {
		return (int)(o1.getGoodsPrice()-o2.getGoodsPrice());
	}

}
