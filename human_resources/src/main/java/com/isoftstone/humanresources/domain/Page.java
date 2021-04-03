package com.isoftstone.humanresources.domain;

import java.util.List;

public class Page {
    private int pageSize = 10;  //每页显示条数
    private int totalCount;//数据总数
    private int pageNo;//当前页码
    private int start;//记录开始数
    private int totalPages;  //页码总数
    private List dates;//分页记录集

    public Page() {
    }

    public Page(int totalCount, int pageNo, int pageSize, List dates) {//数据总数,当前页码,每页显示条数，分页记录集
        this.totalCount = totalCount;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.dates = dates;
        if (this.totalCount % this.pageSize != 0) {
            this.totalPages = this.totalCount / this.pageSize;
        } else {
            this.totalPages = this.totalCount / this.pageSize + 1;
        }
    }

    public boolean hasFirst() {  //有首页
        return getPageNo() > 1;  //当前页面不是首页就有首页
    }

    public boolean hasLast() {  //有尾页
        return getPageNo() < getTotalPages();                //当前页面小于最大页码数
    }

    public boolean hasNext() {  //有下一页
        return getPageNo() < getTotalPages();                //当前不是尾页，且总页数大于2
    }

    public boolean hasPrevious() {  //有上一页
        return getPageNo() > 1;                //当前不是尾页，且总页数大于2
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

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotalPages() {         //获取总页数
        totalPages = totalCount / pageSize;
        if (totalCount % pageSize != 0) {
            totalPages++;
        }
        return totalPages;
    }

    public List getDates() {
        return dates;
    }

    public void setDates(List dates) {
        this.dates = dates;
    }

}
