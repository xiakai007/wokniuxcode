package com.woniu.entities;

import java.util.List;

public class PageBean<T> {
	private Integer currentPage;//当前页
	private Integer pageSize;//每页的行数
	private Integer totalCount;//总行数
	private Integer pages;//总页数
	private List<T> pageData;//页面数据
	public PageBean() {
		super();
	}
	public PageBean(Integer currentPage, Integer pageSize, Integer totalCount, Integer pages, List<T> pageData) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.pages = pages;
		this.pageData = pageData;
	}
	public PageBean(Integer currentPage, Integer pageSize) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	/**
	 * 必须在获得总行数totalCount值和每页的行数pageSize值后才能调用
	 * @return
	 */
	public Integer getPages() {
		pages=totalCount%pageSize==0?(totalCount/pageSize):(totalCount/pageSize+1);
		return pages;
	}
	
}
