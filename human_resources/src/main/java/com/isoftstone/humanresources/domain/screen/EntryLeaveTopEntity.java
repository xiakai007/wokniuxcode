package com.isoftstone.humanresources.domain.screen;

import java.io.Serializable;

public class EntryLeaveTopEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    //入职时间
    private String entryDate;
    //离职时间
    private String leaveDate;
    private String organizationID;
    private String organizationName;
    //入职人数
    private Integer entryNum;
    //当前时间的离职人数
    private Integer leaveNum;
    //叠加的离职人数
    private Integer addLeaveNum;
    //在职总人数
    private Integer allNum;
    //入离职比率
    private String leaveOrEntryRate;
    //叠加离职比率
    private String addLeaveOrEntryRate;
    //数据类型，是上一波的数据
    private String numType;

    public String getAddLeaveOrEntryRate() {
        return addLeaveOrEntryRate;
    }

    public void setAddLeaveOrEntryRate(String addLeaveOrEntryRate) {
        this.addLeaveOrEntryRate = addLeaveOrEntryRate;
    }

    public String getNumType() {
        return numType;
    }

    public void setNumType(String numType) {
        this.numType = numType;
    }

    public String getLeaveOrEntryRate() {
        return leaveOrEntryRate;
    }

    public void setLeaveOrEntryRate(String leaveOrEntryRate) {
        this.leaveOrEntryRate = leaveOrEntryRate;
    }

    public String getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(String organizationID) {
        this.organizationID = organizationID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Integer getEntryNum() {
        return entryNum;
    }

    public void setEntryNum(Integer entryNum) {
        this.entryNum = entryNum;
    }

    public Integer getLeaveNum() {
        return leaveNum;
    }

    public void setLeaveNum(Integer leaveNum) {
        this.leaveNum = leaveNum;
    }

    public Integer getAddLeaveNum() {
        return addLeaveNum;
    }

    public void setAddLeaveNum(Integer addLeaveNum) {
        this.addLeaveNum = addLeaveNum;
    }

    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }
}
