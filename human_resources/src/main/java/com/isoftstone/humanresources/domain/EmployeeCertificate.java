package com.isoftstone.humanresources.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工证书
 */
public class EmployeeCertificate implements Serializable {
    private static final long serialVersionUID = 501846860637177431L;
    private Integer id;                 //主键
    private String certificateType;    //证书类型
    private String certificateName;    //证书名称
    private Integer employeeID;       //员工编号
    private String image;// 图片
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createDate;        //创建日期
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date updateDate;       //更新日期
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date expirationDate;   //过期日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
