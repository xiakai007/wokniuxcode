package com.isoftstone.humanresources.domain.portraitprojectmanager;

import java.io.Serializable;

public class ProjectMangerScoreRes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private double qualityScore; 						//质量得分
	private double qualityScoreAll;						//质量得分总分
	private double humanScore;							//人资得分
	private RecruitAndLeaveVO recruitAndLeaveVO;		//人资得分详情
	private double managementScore;						//管理得分
	private double impressionScore;						//印象得分
	private double baseScoring;							//基础得分
	private double humanScoreAll;						//人资得分总分
	private double managementScoreAll;					//管理得分总分
	private double impressionScoreAll;					//印象得分总分
	private double baseScoringAll;						//基础得分总分
	private double sumScore;							//总分
	private String scoreType;							//打分类型
	private ManageScoreVO manageScoreInfo;				//管理得分详情

	public ManageScoreVO getManageScoreInfo() {
		return manageScoreInfo;
	}
	public void setManageScoreInfo(ManageScoreVO manageScoreInfo) {
		this.manageScoreInfo = manageScoreInfo;
	}
	public RecruitAndLeaveVO getRecruitAndLeaveVO() {
		return recruitAndLeaveVO;
	}
	public void setRecruitAndLeaveVO(RecruitAndLeaveVO recruitAndLeaveVO) {
		this.recruitAndLeaveVO = recruitAndLeaveVO;
	}
	public double getQualityScoreAll() {
		return qualityScoreAll;
	}
	public void setQualityScoreAll(double qualityScoreAll) {
		this.qualityScoreAll = qualityScoreAll;
	}
	public double getHumanScoreAll() {
		return humanScoreAll;
	}
	public void setHumanScoreAll(double humanScoreAll) {
		this.humanScoreAll = humanScoreAll;
	}
	public double getManagementScoreAll() {
		return managementScoreAll;
	}
	public void setManagementScoreAll(double managementScoreAll) {
		this.managementScoreAll = managementScoreAll;
	}
	public double getImpressionScoreAll() {
		return impressionScoreAll;
	}
	public void setImpressionScoreAll(double impressionScoreAll) {
		this.impressionScoreAll = impressionScoreAll;
	}
	public double getBaseScoringAll() {
		return baseScoringAll;
	}
	public void setBaseScoringAll(double baseScoringAll) {
		this.baseScoringAll = baseScoringAll;
	}
	public String getScoreType() {
		return scoreType;
	}
	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}
	public double getQualityScore() {
		return qualityScore;
	}
	public void setQualityScore(double qualityScore) {
		this.qualityScore = qualityScore;
	}
	public double getHumanScore() {
		return humanScore;
	}
	public void setHumanScore(double humanScore) {
		this.humanScore = humanScore;
	}
	public double getManagementScore() {
		return managementScore;
	}
	public void setManagementScore(double managementScore) {
		this.managementScore = managementScore;
	}
	public double getImpressionScore() {
		return impressionScore;
	}
	public void setImpressionScore(double impressionScore) {
		this.impressionScore = impressionScore;
	}
	public double getBaseScoring() {
		return baseScoring;
	}
	public void setBaseScoring(double baseScoring) {
		this.baseScoring = baseScoring;
	}
	public double getSumScore() {
		return sumScore;
	}
	public void setSumScore(double sumScore) {
		this.sumScore = sumScore;
	}
}
