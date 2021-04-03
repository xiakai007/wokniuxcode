package com.isoftstone.humanresources.domain.portraitprojectmanager;

import java.io.Serializable;

public class ScoreWayVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private long employeeId;						//项目经理工号
	private String scoreType;						//打分类型
	private double scoreProportion;					//打分项占比
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getScoreType() {
		return scoreType;
	}
	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}
	public double getScoreProportion() {
		return scoreProportion;
	}
	public void setScoreProportion(double scoreProportion) {
		this.scoreProportion = scoreProportion;
	}
}
