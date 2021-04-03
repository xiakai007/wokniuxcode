package com.isoftstone.humanresources.domain.portraitprojectmanager;

import java.io.Serializable;

/**
 * 招聘和离职返回详情
 * @author bwning
 *
 */
public class RecruitAndLeaveVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int leaveCount;								//离职人数
	private int sumPersonCount;							//总人数
	private double leaveScore;							//离职得分
	private int recruitCount;							//招聘人数
	private int sumNeedPerson;							//总需要人数
	private double recruitScore;						//招聘得分
	public int getLeaveCount() {
		return leaveCount;
	}
	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}
	public int getSumPersonCount() {
		return sumPersonCount;
	}
	public void setSumPersonCount(int sumPersonCount) {
		this.sumPersonCount = sumPersonCount;
	}
	public double getLeaveScore() {
		return leaveScore;
	}
	public void setLeaveScore(double leaveScore) {
		this.leaveScore = leaveScore;
	}
	public int getRecruitCount() {
		return recruitCount;
	}
	public void setRecruitCount(int recruitCount) {
		this.recruitCount = recruitCount;
	}
	public int getSumNeedPerson() {
		return sumNeedPerson;
	}
	public void setSumNeedPerson(int sumNeedPerson) {
		this.sumNeedPerson = sumNeedPerson;
	}
	public double getRecruitScore() {
		return recruitScore;
	}
	public void setRecruitScore(double recruitScore) {
		this.recruitScore = recruitScore;
	}
}
