package com.isoftstone.humanresources.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;

/**
 * 工单
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 3347865322480553883L;
    private Integer id;          //主键
    private Integer creator;     //创建者
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date creatDate;      //创建日期
    private String level;        //等级
    private String content;     //内容
    private String status;      //状态
    private Integer designator; //指派者
    private Integer solver;     //解决者
    private String solution;     //解决方案
    private String copier;      //抄送者
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date updateDate;      //更新日期
    private String creatorName;  //创建者名称
    private String designatorName; //指派者名称
    private String solverName;     //解决者名称
    private int[] copy;         //抄送者


    public int[] getCopy() {
        return copy;
    }

    public void setCopy(int[] copy) {
        this.copy = copy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDesignator() {
        return designator;
    }

    public void setDesignator(Integer designator) {
        this.designator = designator;
    }

    public Integer getSolver() {
        return solver;
    }

    public void setSolver(Integer solver) {
        this.solver = solver;
    }

    public String getCopier() {
        return copier;
    }

    public void setCopier(String copier) {
        this.copier = copier;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getDesignatorName() {
        return designatorName;
    }

    public void setDesignatorName(String designatorName) {
        this.designatorName = designatorName;
    }

    public String getSolverName() {
        return solverName;
    }

    public void setSolverName(String solverName) {
        this.solverName = solverName;
    }
}
