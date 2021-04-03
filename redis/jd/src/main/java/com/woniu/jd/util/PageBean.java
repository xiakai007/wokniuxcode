package com.woniu.jd.util;

import lombok.Data;


public class PageBean {
    private Integer from=0;
    private Integer size=50;
    private Integer count=0;
    private Integer now=1;
    private Integer pageSize=0;
    public Integer getFrom(){
        if(now==null){
            now=1;
        }
        return (now-1)*size;
    }
    public void setFrom(Integer from){
        this.from=from;
    }
    public Integer getPageSize(){
        return (count+size-1)/size;
    }
    public void setPageSize(Integer pageSize){
        this.pageSize=pageSize;
    }
    public Integer getSize(){
        return size;
    }
    public void setSize(Integer size){
        this.size=size;
    }
    public Integer getCount(){
        return count;
    }
    public void setCount(Integer count){
        this.count=count;
    }
}
