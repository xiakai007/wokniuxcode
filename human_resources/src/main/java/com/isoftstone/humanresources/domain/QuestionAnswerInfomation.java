package com.isoftstone.humanresources.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 问题展示详情信息
 * @author bwning
 *
 */
public class QuestionAnswerInfomation implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;						//问题单ID
    private String jobNumber;				//工号
    private String jobName;					//员工姓名
    private String question;				//问题描述
    private String detail;					//详细说明
    private String progress;				//当前进展
    private String headPerson;				//责任人
    private String createTime;				//创建时间
    private String updateTime;				//修改时间
    private String bak;						//备注
    private String imgURL;					//图片地址
    private List<String> imgList;			//图片地址集合
    private String updateNumber;			//修改人
    private String updatename;				//修改人姓名
    private String progressName;			//状态
    private String headName;				//负责人名字
    private boolean isGroup;				//是否是组内人员					
    
	public boolean getIsGroup() {
		return isGroup;
	}
	public void setISGroup(boolean isGroup) {
		this.isGroup = isGroup;
	}
	public String getHeadName() {
		return headName;
	}
	public void setHeadName(String headName) {
		this.headName = headName;
	}
	public String getProgressName() {
		return progressName;
	}
	public void setProgressName(String progressName) {
		this.progressName = progressName;
	}
	public String getUpdatename() {
		return updatename;
	}
	public void setUpdatename(String updatename) {
		this.updatename = updatename;
	}
	public String getUpdateNumber() {
		return updateNumber;
	}
	public void setUpdateNumber(String updateNumber) {
		this.updateNumber = updateNumber;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public List<String> getImgList() {
		return imgList;
	}
	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getHeadPerson() {
		return headPerson;
	}
	public void setHeadPerson(String headPerson) {
		this.headPerson = headPerson;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getBak() {
		return bak;
	}
	public void setBak(String bak) {
		this.bak = bak;
	}
    

}
