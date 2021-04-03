package com.isoftstone.humanresources.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工风险
 */
public class EmployeeRisk implements Serializable {
    private static final long serialVersionUID = -971352642657571219L;
    private Integer ID;                //主键
    private Integer employeeID;        //员工id
    private String riskName;            //风险名称
    private String desc;                //描述
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;            //创建时间
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date modifyTime;           //修改时间
    private String creator;           //创建人
    private String modifier;         //修改人

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

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
}
