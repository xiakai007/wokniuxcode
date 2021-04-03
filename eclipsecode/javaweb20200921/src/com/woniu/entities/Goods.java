package com.woniu.entities;

public class Goods {
	private Integer goods_id;
	private Integer type_id;
	private Integer supp_id;
	private String goods_code;
	private String goods_name;
	private Integer goods_sum;
	private Float goods_price;
	private String goods_photo;
	private String goods_desc;
	public Goods() {
		super();
	}
	public Goods(Integer goods_id, Integer type_id, Integer supp_id, String goods_code, String goods_name,
			Integer goods_sum, Float goods_price, String goods_photo, String goods_desc) {
		super();
		this.goods_id = goods_id;
		this.type_id = type_id;
		this.supp_id = supp_id;
		this.goods_code = goods_code;
		this.goods_name = goods_name;
		this.goods_sum = goods_sum;
		this.goods_price = goods_price;
		this.goods_photo = goods_photo;
		this.goods_desc = goods_desc;
	}
	
	public Goods(Integer type_id, Integer supp_id, String goods_code, String goods_name, Integer goods_sum,
			Float goods_price, String goods_photo, String goods_desc) {
		super();
		this.type_id = type_id;
		this.supp_id = supp_id;
		this.goods_code = goods_code;
		this.goods_name = goods_name;
		this.goods_sum = goods_sum;
		this.goods_price = goods_price;
		this.goods_photo = goods_photo;
		this.goods_desc = goods_desc;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public Integer getSupp_id() {
		return supp_id;
	}
	public void setSupp_id(Integer supp_id) {
		this.supp_id = supp_id;
	}
	public String getGoods_code() {
		return goods_code;
	}
	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public Integer getGoods_sum() {
		return goods_sum;
	}
	public void setGoods_sum(Integer goods_sum) {
		this.goods_sum = goods_sum;
	}
	public Float getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(Float goods_price) {
		this.goods_price = goods_price;
	}
	public String getGoods_photo() {
		return goods_photo;
	}
	public void setGoods_photo(String goods_photo) {
		this.goods_photo = goods_photo;
	}
	public String getGoods_desc() {
		return goods_desc;
	}
	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
	}
	@Override
	public String toString() {
		return "Goods [goods_id=" + goods_id + ", type_id=" + type_id + ", supp_id=" + supp_id + ", goods_code="
				+ goods_code + ", goods_name=" + goods_name + ", goods_sum=" + goods_sum + ", goods_price="
				+ goods_price + ", goods_photo=" + goods_photo + ", goods_desc=" + goods_desc + "]";
	}
	


}
