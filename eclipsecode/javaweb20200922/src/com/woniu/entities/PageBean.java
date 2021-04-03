package com.woniu.entities;

import java.util.List;

public class PageBean<T> {
	private Integer currentPage;//��ǰҳ
	private Integer pageSize;//ÿҳ������
	private Integer totalCount;//������
	private Integer pages;//��ҳ��
	private List<T> data;//ҳ������
	public PageBean() {
		super();
	}
	public PageBean(Integer currentPage, Integer pageSize, Integer totalCount, Integer pages, List<T> data) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.pages = pages;
		this.data = data;
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
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	/**
	 * �����ڻ��������totalCountֵ��ÿҳ������pageSizeֵ����ܵ���
	 * @return
	 */
	public Integer getPages() {
		pages=totalCount%pageSize==0?(totalCount/pageSize):(totalCount/pageSize+1);
		return pages;
	}
	
}
