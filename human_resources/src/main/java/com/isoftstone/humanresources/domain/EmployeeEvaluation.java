package com.isoftstone.humanresources.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工评价
 */
public class EmployeeEvaluation implements Serializable {

    private static final long serialVersionUID = 4473453952470681841L;
    private Integer ID;           //主键
    private Integer employeeID;   //员工编号
    private String content;       //评价内容
    private String creator;       //创建人
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;     //创建时间
    private String modifier;    //修改人
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date modifyTime;  //修改时间

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
