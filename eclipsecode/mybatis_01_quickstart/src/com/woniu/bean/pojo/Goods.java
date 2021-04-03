package com.woniu.bean.pojo;

import java.sql.Timestamp;

public class Goods {
	private Integer id;
	private String name;
	private String goodsno;
	private String author;
	private String publisher;
	private String pubtime;
	private Integer categoryid;
	private String description;
	private String image;
	private Integer stock;
	private Double marketprice;
	private Double salesprice;
	private Double score;
	private Integer remarknums;
	private Timestamp uptime;
	private Integer salenums;
	private String newest;
	private String hot;
	private String status;
	public Goods() {
		super();
	}
	
	public Goods(String name, String goodsno, String author, String publisher, String pubtime, Integer categoryid,
			String description, String image, Integer stock, Double marketprice, Double salesprice, Double score,
			Integer remarknums, Timestamp uptime, Integer salenums, String newest, String hot, String status) {
		super();
		this.name = name;
		this.goodsno = goodsno;
		this.author = author;
		this.publisher = publisher;
		this.pubtime = pubtime;
		this.categoryid = categoryid;
		this.description = description;
		this.image = image;
		this.stock = stock;
		this.marketprice = marketprice;
		this.salesprice = salesprice;
		this.score = score;
		this.remarknums = remarknums;
		this.uptime = uptime;
		this.salenums = salenums;
		this.newest = newest;
		this.hot = hot;
		this.status = status;
	}

	public Goods(Integer id, String name, String goodsno, String author, String publisher, String pubtime,
			Integer categoryid, String description, String image, Integer stock, Double marketprice, Double salesprice,
			Double score, Integer remarknums, Timestamp uptime, Integer salenums, String newest, String hot,
			String status) {
		super();
		this.id = id;
		this.name = name;
		this.goodsno = goodsno;
		this.author = author;
		this.publisher = publisher;
		this.pubtime = pubtime;
		this.categoryid = categoryid;
		this.description = description;
		this.image = image;
		this.stock = stock;
		this.marketprice = marketprice;
		this.salesprice = salesprice;
		this.score = score;
		this.remarknums = remarknums;
		this.uptime = uptime;
		this.salenums = salenums;
		this.newest = newest;
		this.hot = hot;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGoodsno() {
		return goodsno;
	}
	public void setGoodsno(String goodsno) {
		this.goodsno = goodsno;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Double getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(Double marketprice) {
		this.marketprice = marketprice;
	}
	public Double getSalesprice() {
		return salesprice;
	}
	public void setSalesprice(Double salesprice) {
		this.salesprice = salesprice;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Integer getRemarknums() {
		return remarknums;
	}
	public void setRemarknums(Integer remarknums) {
		this.remarknums = remarknums;
	}
	public Timestamp getUptime() {
		return uptime;
	}
	public void setUptime(Timestamp uptime) {
		this.uptime = uptime;
	}
	public Integer getSalenums() {
		return salenums;
	}
	public void setSalenums(Integer salenums) {
		this.salenums = salenums;
	}
	public String getNewest() {
		return newest;
	}
	public void setNewest(String newest) {
		this.newest = newest;
	}
	public String getHot() {
		return hot;
	}
	public void setHot(String hot) {
		this.hot = hot;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", goodsno=" + goodsno + ", author=" + author + ", publisher="
				+ publisher + ", pubtime=" + pubtime + ", categoryid=" + categoryid + ", description=" + description
				+ ", image=" + image + ", stock=" + stock + ", marketprice=" + marketprice + ", salesprice="
				+ salesprice + ", score=" + score + ", remarknums=" + remarknums + ", uptime=" + uptime + ", salenums="
				+ salenums + ", newest=" + newest + ", hot=" + hot + ", status=" + status + "]";
	}
    

}
