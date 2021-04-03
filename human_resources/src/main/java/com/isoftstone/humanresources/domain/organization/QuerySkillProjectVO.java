package com.isoftstone.humanresources.domain.organization;

import java.io.Serializable;
import java.util.List;

import com.isoftstone.humanresources.domain.EmployeeInformation;

/**
 * 技能分组信息
 * @author bwning
 *
 */
public class QuerySkillProjectVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String organizationId;				//组织ID
	private String organizationName;			//组织名称
	private String skill;						//技能
	private String organizationGroupId;			//cu分组ID
	private Integer skillCount;					//技能分组人员数
	private String organizationType;			//组织类型
	private List<EmployeeInformation> empList;	//员工集合
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getOrganizationGroupId() {
		return organizationGroupId;
	}
	public void setOrganizationGroupId(String organizationGroupId) {
		this.organizationGroupId = organizationGroupId;
	}
	public Integer getSkillCount() {
		return skillCount;
	}
	public void setSkillCount(Integer skillCount) {
		this.skillCount = skillCount;
	}
	public List<EmployeeInformation> getEmpList() {
		return empList;
	}
	public void setEmpList(List<EmployeeInformation> empList) {
		this.empList = empList;
	}
	public String getOrganizationType() {
		return organizationType;
	}
	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

}
