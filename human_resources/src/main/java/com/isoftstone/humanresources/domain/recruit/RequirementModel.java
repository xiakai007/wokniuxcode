package com.isoftstone.humanresources.domain.recruit;

import java.io.Serializable;

/**
 * <p>Description: [招聘管理系统需求信息表model]</p>
 * Created on 2020年03月09日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class RequirementModel implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private Integer id;
	/**
	 * 区域
	 */
	private String area;
	/**
	 * 成本中心
	 */
	private String costCenter;
	/**
	 * 业务线
	 */
	private String businessLine;
	/**
	 * PUD
	 */
	private String pdu;
	/**
	 * 项目经理
	 */
	private String projectManager;
	/**
	 * 技能
	 */
	private String skill;
	/**
	 * 开始时间
	 */
	private Integer starttime;
	/**
	 * 结束时间
	 */
	private Integer endtime;
	/**
	 * 变更时间
	 */
	private Integer changetime;

	/**
	 * 开始时间
	 */
	private String starttimestr;
	/**
	 * 结束时间
	 */
	private String endtimestr;
	/**
	 * 变更时间
	 */
	private String changetimestr;
	/**
	 * 需求数
	 */
	private Integer requirementsNum;
	/**
	 * 紧急度，0:一般，1:中，2:高，3:紧急
	 */
	private Integer urgent;
	/**
	 * 状态 0:开启, 1:关闭, 2:取消
	 */
	private Integer rStatus;
	/**
	 * 项目类型
	 */
	private String projectType;
	/**
	 * 办公地点
	 */
	private String officeSpace;
	/**
	 * 面试流程
	 */
	private String interviewPrc;
	/**
	 * 技能要求
	 */
	private String skillReq;
	/**
	 * 级别范围
	 */
	private String levelScope;
	/**
	 * 项目类型: 0:无  1：继承  2:竞标
	 */
	private Integer pType;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 项目经理ID(tbl_user_info中的ID)
	 */
	private Integer pmid;
	/**
	 * 项目优先级 1：BD优先级  2:BU优先级
	 */
	private Integer prioritytype;

	private String showDetail ;
	/**
	 * 拒绝理由
	 */
	private String reject;
	/**
	 * 审批人
	 */
	private String approver;

	public String getReject() {
		return reject;
	}

	public void setReject(String reject) {
		this.reject = reject;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getShowDetail() {
		return showDetail;
	}

	public void setShowDetail(String showDetail) {
		this.showDetail = showDetail;
	}

	public String getStarttimestr() {
		return starttimestr;
	}

	public void setStarttimestr(String starttimestr) {
		this.starttimestr = starttimestr;
	}

	public String getEndtimestr() {
		return endtimestr;
	}

	public void setEndtimestr(String endtimestr) {
		this.endtimestr = endtimestr;
	}

	public String getChangetimestr() {
		return changetimestr;
	}

	public void setChangetimestr(String changetimestr) {
		this.changetimestr = changetimestr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getBusinessLine() {
		return businessLine;
	}

	public void setBusinessLine(String businessLine) {
		this.businessLine = businessLine;
	}

	public String getPdu() {
		return pdu;
	}

	public void setPdu(String pdu) {
		this.pdu = pdu;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Integer getStarttime() {
		return starttime;
	}

	public void setStarttime(Integer starttime) {
		this.starttime = starttime;
	}

	public Integer getEndtime() {
		return endtime;
	}

	public void setEndtime(Integer endtime) {
		this.endtime = endtime;
	}

	public Integer getChangetime() {
		return changetime;
	}

	public void setChangetime(Integer changetime) {
		this.changetime = changetime;
	}

	public Integer getRequirementsNum() {
		return requirementsNum;
	}

	public void setRequirementsNum(Integer requirementsNum) {
		this.requirementsNum = requirementsNum;
	}

	public Integer getUrgent() {
		return urgent;
	}

	public void setUrgent(Integer urgent) {
		this.urgent = urgent;
	}

	public Integer getrStatus() {
		return rStatus;
	}

	public void setrStatus(Integer rStatus) {
		this.rStatus = rStatus;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getOfficeSpace() {
		return officeSpace;
	}

	public void setOfficeSpace(String officeSpace) {
		this.officeSpace = officeSpace;
	}

	public String getInterviewPrc() {
		return interviewPrc;
	}

	public void setInterviewPrc(String interviewPrc) {
		this.interviewPrc = interviewPrc;
	}

	public String getSkillReq() {
		return skillReq;
	}

	public void setSkillReq(String skillReq) {
		this.skillReq = skillReq;
	}

	public String getLevelScope() {
		return levelScope;
	}

	public void setLevelScope(String levelScope) {
		this.levelScope = levelScope;
	}

	public Integer getpType() {
		return pType;
	}

	public void setpType(Integer pType) {
		this.pType = pType;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getPmid() {
		return pmid;
	}

	public void setPmid(Integer pmid) {
		this.pmid = pmid;
	}

	public Integer getPrioritytype() {
		return prioritytype;
	}

	public void setPrioritytype(Integer prioritytype) {
		this.prioritytype = prioritytype;
	}
}
