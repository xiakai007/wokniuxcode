package com.isoftstone.humanresources.domain.useremployee;

import com.isoftstone.humanresources.domain.SystemConfigInformation;

import java.io.Serializable;

public class SkillInVO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private long skillId;		//技能ID
    private long employeeID;	//员工ID
    private String	skill;		//技能
    private String skillName;	//技能名称
    private double proficiency;	//熟练程度
    private String createTime;	//创建时间
    private String updateTime;	//更新时间
    private String bak;			//备注
	private SystemConfigInformation sys;

	public SystemConfigInformation getSys() {
		return sys;
	}

	public void setSys(SystemConfigInformation sys) {
		this.sys = sys;
	}

	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public long getSkillId() {
		return skillId;
	}
	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}
	public long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public double getProficiency() {
		return proficiency;
	}
	public void setProficiency(double proficiency) {
		this.proficiency = proficiency;
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
