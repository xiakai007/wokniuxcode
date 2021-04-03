package com.isoftstone.humanresources.domain.portraitprojectmanager;

import java.io.Serializable;

/**
 * 项目经理画像技能图返回实体
 * @author bwning
 *
 */
public class ProjectManagerVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private double processAndResults;					//项目过程和结果
	private double personManage;						//人员管理
	private double security;							//安全
	private double satisfaction;						//满意度
	private double qualityScore;						//质量得分
	private ScoreProjectSkillFP scoreFP;				//fp得分详情
	
	public ScoreProjectSkillFP getScoreFP() {
		return scoreFP;
	}
	public void setScoreFP(ScoreProjectSkillFP scoreFP) {
		this.scoreFP = scoreFP;
	}
	public double getProcessAndResults() {
		return processAndResults;
	}
	public void setProcessAndResults(double processAndResults) {
		this.processAndResults = processAndResults;
	}
	public double getPersonManage() {
		return personManage;
	}
	public void setPersonManage(double personManage) {
		this.personManage = personManage;
	}
	public double getSecurity() {
		return security;
	}
	public void setSecurity(double security) {
		this.security = security;
	}
	public double getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(double satisfaction) {
		this.satisfaction = satisfaction;
	}
	public double getQualityScore() {
		return qualityScore;
	}
	public void setQualityScore(double qualityScore) {
		this.qualityScore = qualityScore;
	}
}
