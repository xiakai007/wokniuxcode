package com.woniu.bean.vo;

public class GoodsQuery {
	private String author;
	private String publisher;
	public GoodsQuery(String author, String publisher) {
		super();
		this.author = author;
		this.publisher = publisher;
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
	

}
