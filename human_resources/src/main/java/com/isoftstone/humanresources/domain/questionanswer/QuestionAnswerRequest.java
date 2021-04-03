package com.isoftstone.humanresources.domain.questionanswer;

import java.io.Serializable;

/**
 * 问题列表查询请求实体
 * @author bwning
 *
 */
public class QuestionAnswerRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;						//问题单ID
    private String jobNumber;				//工号
    private String question;				//问题描述
    private String detail;					//详细说明
    private String progress;				//当前进展
    private String headPerson;				//责任人
    private String startTime;				//开始时间
    private String endTime;					//结束时间
    private Integer page;             		//当前页
    private Integer pageSize;         		//每页显示条数
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	

}