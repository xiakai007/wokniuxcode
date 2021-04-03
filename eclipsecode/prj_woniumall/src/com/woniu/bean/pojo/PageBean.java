package com.woniu.bean.pojo;

import java.util.List;

/**
 * ��ҳ���
 * @author xiakai
 *
 * @param <T>
 */
public class PageBean<T> {
	/**
	 * ��ǰҳ
	 */
	private int currentPage=1;
	/**
	 * ÿҳ����Ŀ��
	 */
	private int pageSize;
	/**
	 * ����Ŀ��
	 */
	private int totalCount;
	/**
	 * ��ҳ��
	 */
	private int pages;
	/**
	 * ���ҳ�����ݵļ���
	 */
	private List<T> data;
	/**
	 * ҳ�뿪ʼ�����
	 */
	private int start;
	/**
	 * ҳ����������
	 */
	private int end;
	/**
	 * �Ƿ��С�ǰһҳ����ǩ
	 */
	private boolean previous;
	 /**
	  * �Ƿ��С���һҳ����ǩ
	  */
	private boolean next;
	/**
	 * ��ҳ�ĳ���
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
