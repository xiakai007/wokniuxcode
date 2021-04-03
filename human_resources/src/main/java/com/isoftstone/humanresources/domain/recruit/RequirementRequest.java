package com.isoftstone.humanresources.domain.recruit;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: [招聘管理系统需求信息表model]</p>
 * Created on 2020年03月09日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class RequirementRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 区域
	 */
	private List<String> area;
	/**
	 * 成本中心
	 */
	private List<String> costCenter;
	/**
	 * 业务线
	 */
	private String businessLine;
	/**
	 * PUD
	 */
	private List<String> pdu;
	/**
	 * 项目经理
	 */
	private List<String> projectManager;
	/**
	 * 技能
	 */
	private List<String> skill;

	/**
	 * 紧急度，0:一般，1:中，2:高，3:紧急
	 */
	private List<Integer> urgent;
	/**
	 * 状态 0:开启, 1:关闭, 2:取消
	 */
	private Integer rStatus;

	public List<String> getArea() {
		return area;
	}

	public void setArea(List<String> area) {
		this.area = area;
	}

	public List<String> getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(List<String> costCenter) {
		this.costCenter = costCenter;
	}

	public String getBusinessLine() {
		return businessLine;
	}

	public void setBusinessLine(String businessLine) {
		this.businessLine = businessLine;
	}

	public List<String> getPdu() {
		return pdu;
	}

	public void setPdu(List<String> pdu) {
		this.pdu = pdu;
	}

	public List<String> getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(List<String> projectManager) {
		this.projectManager = projectManager;
	}

	public List<String> getSkill() {
		return skill;
	}

	public void setSkill(List<String> skill) {
		this.skill = skill;
	}

	public List<Integer> getUrgent() {
		return urgent;
	}

	public void setUrgent(List<Integer> urgent) {
		this.urgent = urgent;
	}

	public Integer getrStatus() {
		return rStatus;
	}

	public void setrStatus(Integer rStatus) {
		this.rStatus = rStatus;
	}
}
