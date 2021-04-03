package com.woniu.chapter20_IO;

import java.io.Serializable;

public class Goods implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int goodsId;
	private String goodsName;
	private double goodsPrice;
	
	public Goods() {
		super();
	}
	
	public Goods(int goodsId, String goodsName, double goodsPrice) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
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
    
}
