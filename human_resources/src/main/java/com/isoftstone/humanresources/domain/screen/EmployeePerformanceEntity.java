package com.isoftstone.humanresources.domain.screen;

import java.io.Serializable;

public class EmployeePerformanceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String employeeID;
    private String employeeName;
    private String start_date;
    private String end_date;
    private String type;
    private String score;
    private String level;
    private String maternity_leave;
    private String is_gt_45;
    private String is_manage_agreed;
    private String remark;
    private String quarter;
    private String year;

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMaternity_leave() {
        return maternity_leave;
    }

    public void setMaternity_leave(String maternity_leave) {
        this.maternity_leave = maternity_leave;
    }

    public String getIs_gt_45() {
        return is_gt_45;
    }

    public void setIs_gt_45(String is_gt_45) {
        this.is_gt_45 = is_gt_45;
    }

    public String getIs_manage_agreed() {
        return is_manage_agreed;
    }

    public void setIs_manage_agreed(String is_manage_agreed) {
        this.is_manage_agreed = is_manage_agreed;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
