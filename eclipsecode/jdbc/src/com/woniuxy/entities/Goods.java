package com.woniuxy.entities;

import java.io.Serializable;

public class Goods implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer goodsId;
	private String goodsName;
	private Float goodsCostPrice;
	private Integer goodsCount;
	private Integer goodsType;
	public Goods() {
		super();
	}
	public Goods(Integer goodsId, String goodsName, Float goodsCostPrice, Integer goodsCount, Integer goodsType) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsCostPrice = goodsCostPrice;
		this.goodsCount = goodsCount;
		this.goodsType = goodsType;
	}
	public Goods(String goodsName) {
		super();
		this.goodsName = goodsName;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Float getGoodsCostPrice() {
		return goodsCostPrice;
	}
	public void setGoodsCostPrice(Float goodsCostPrice) {
		this.goodsCostPrice = goodsCostPrice;
	}
	public Integer getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}
	public Integer getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsCostPrice=" + goodsCostPrice
				+ ", goodsCount=" + goodsCount + ", goodsType=" + goodsType + "]";
	}
	

}
