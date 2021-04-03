package com.isoftstone.humanresources.domain.screen;

import java.io.Serializable;
import java.util.List;

public class EntryLeaveEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    //统计时间，月、周
    private String date;
    //入职个数
    private int num;
    //入离职top信息
    private List<EntryLeaveTopEntity>  topList ;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<EntryLeaveTopEntity> getTopList() {
        return topList;
    }

    public void setTopList(List<EntryLeaveTopEntity> topList) {
        this.topList = topList;
    }
}
