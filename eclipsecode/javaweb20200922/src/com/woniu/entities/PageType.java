package com.woniu.entities;

import java.util.List;

public class PageType<T> {
	private Integer currentPage;
	private Integer pageSize;
	private Integer totalCount;
	private Integer pages;
	private List<T> pagaData;
	public PageType() {
		super();
	}
	public PageType(Integer currentPage, Integer pageSize, Integer totalCount, Integer pages, List<T> pagaData) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.pages = pages;
		this.pagaData = pagaData;
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
	public List<T> getPagaData() {
		return pagaData;
	}
	public void setPagaData(List<T> pagaData) {
		this.pagaData = pagaData;
	}
	/**
	 * 必须在总行数totalCount和每页行数pageSize确定后才能调用
	 * @return pages 总页数
	 */
    public Integer getPages() {
    	pages=totalCount%pageSize==0?(totalCount/pageSize):(totalCount/pageSize+1);
		return pages;
	}
}
