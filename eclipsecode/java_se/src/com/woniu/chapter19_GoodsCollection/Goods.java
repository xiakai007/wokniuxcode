package com.woniu.chapter19_GoodsCollection;

public class Goods implements Comparable<Goods> {
	private String goodsId;
	private String goodsName;
	private double goodsPrice;
	public Goods() {
		super();
	}
	public Goods(String goodsId, String goodsName, double goodsPrice) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + "]";
	}
	@Override
	public int compareTo(Goods o) {
		return (int)(this.goodsPrice - o.goodsPrice);
	}
	

}
