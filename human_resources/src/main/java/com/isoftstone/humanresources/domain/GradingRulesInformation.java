package com.isoftstone.humanresources.domain;

import java.io.Serializable;

public class GradingRulesInformation implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String scoreType;							//打分类型
	private String scoreName;							//打分类型名称
	private String scoreProportion;						//打分项占比
	private String createTime;							//创建时间
	private String updateTime;							//修改时间
	private String BU;
	private String buName;
	private String BD;
	private String bdName;
	private String bak;									//备注
	private long createemployeeID;						//创建人工号
	private String createName;
	private long updateEmployeeID;						//修改人工号
	private String updateName;
	
	public String getBuName() {
		return buName;
	}
	public void setBuName(String buName) {
		this.buName = buName;
	}
	public String getBdName() {
		return bdName;
	}
	public void setBdName(String bdName) {
		this.bdName = bdName;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getUpdateName() {
		return updateName;
	}
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	public long getCreateemployeeID() {
		return createemployeeID;
	}
	public void setCreateemployeeID(long createemployeeID) {
		this.createemployeeID = createemployeeID;
	}
	public long getUpdateEmployeeID() {
		return updateEmployeeID;
	}
	public void setUpdateEmployeeID(long updateEmployeeID) {
		this.updateEmployeeID = updateEmployeeID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScoreType() {
		return scoreType;
	}
	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}
	public String getScoreName() {
		return scoreName;
	}
	public void setScoreName(String scoreName) {
		this.scoreName = scoreName;
	}
	public String getScoreProportion() {
		return scoreProportion;
	}
	public void setScoreProportion(String scoreProportion) {
		this.scoreProportion = scoreProportion;
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
	public String getBU() {
		return BU;
	}
	public void setBU(String bU) {
		BU = bU;
	}
	public String getBD() {
		return BD;
	}
	public void setBD(String bD) {
		BD = bD;
	}
	public String getBak() {
		return bak;
	}
	public void setBak(String bak) {
		this.bak = bak;
	}
}
