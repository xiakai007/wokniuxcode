package com.woniu.bean.pojo;

import java.util.List;

/**
 * 分页组件
 * @author xiakai
 *
 * @param <T>
 */
public class PageBean<T> {
	/**
	 * 当前页
	 */
	private int currentPage=1;
	/**
	 * 每页的条目数
	 */
	private int pageSize;
	/**
	 * 总条目数
	 */
	private int totalCount;
	/**
	 * 总页数
	 */
	private int pages;
	/**
	 * 存放页面数据的集合
	 */
	private List<T> data;
	/**
	 * 页码开始的序号
	 */
	private int start;
	/**
	 * 页码结束的序号
	 */
	private int end;
	/**
	 * 是否有“前一页”标签
	 */
	private boolean previous;
	 /**
	  * 是否有“下一页”标签
	  */
	private boolean next;
	/**
	 * 分页的长度
	 */
	private int shownum=10;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		if(currentPage>this.pages){
			this.currentPage=this.pages;
		}else{
			this.currentPage = currentPage;
		}
		
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPages() {
		pages=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1);
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getStart() {
		if(this.currentPage<=this.shownum/2+1){
			this.start=1;
		}else{
			this.start=this.currentPage-this.shownum/2;
		}
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		if(this.pages<=this.shownum){
			this.end=pages;
		}else{
			if(this.currentPage>this.shownum/2+1){
				this.end=this.currentPage+(this.shownum/2-1);
			}else{
				this.end=this.shownum;
			}
			if(this.end>this.pages){
				this.end=this.pages;
			}
		}
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public boolean isPrevious() {
		if(this.currentPage<=1){
			return false;
		}
		return true;
	}
	public void setPrevious(boolean previous) {
		this.previous = previous;
	}
	public boolean isNext() {
		if(this.currentPage>=this.pages){
			return false;
		}
		return true;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getShownum() {
		return shownum;
	}
	public void setShownum(int shownum) {
		this.shownum = shownum;
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", pages=" + pages + ", data=" + data + ", start=" + start + ", end=" + end + ", previous=" + previous
				+ ", next=" + next + ", shownum=" + shownum + "]";
	}
	
}
