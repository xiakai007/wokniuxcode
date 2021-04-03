package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 印象打分实体
 * @author bwning
 *
 */
public class ImpressionRecordInformation implements Serializable{

	private static final long serialVersionUID = 1L;

	private long employeeID;					//员工编号
	private String labelImpre;					//印象标签
	private double labelImpreScore;				//得分
	private long scoreEmployeeId;				//打分人工号
	private String createTime;					//创建时间
	private String bak;							//备注
	public long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}
	public String getLabelImpre() {
		return labelImpre;
	}
	public void setLabelImpre(String labelImpre) {
		this.labelImpre = labelImpre;
	}
	public double getLabelImpreScore() {
		return labelImpreScore;
	}
	public void setLabelImpreScore(double labelImpreScore) {
		this.labelImpreScore = labelImpreScore;
	}
	public long getScoreEmployeeId() {
		return scoreEmployeeId;
	}
	public void setScoreEmployeeId(long scoreEmployeeId) {
		this.scoreEmployeeId = scoreEmployeeId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getBak() {
		return bak;
	}
	public void setBak(String bak) {
		this.bak = bak;
	}
}
