package com.isoftstone.humanresources.domain.portraitprojectmanager;

import java.io.Serializable;

public class ScoreProjectSkillFP implements Serializable{

	private static final long serialVersionUID = 1L;
	private double proDeliveryQuScore;					//过程交付质量得分
	private double timeOfDelivery;						//交付及时性得分
	private double rateStageAccept;						//阶段性验收一次通过率
	private double personStScore;						//人员稳定度
	private double proPersonStScore;					//项目人员稳定度
	private double deliveryScheduleDev;					//交付进度偏差
	private double proDeliveryQuality;					//过程交付质量
	private double projectDeliveryQuality;				//项目验收质量
	private double qualityScore;						//质量得分
	private double quPointsCriticalEvents;				//质量关键时间得分
	public double getProDeliveryQuScore() {
		return proDeliveryQuScore;
	}
	public void setProDeliveryQuScore(double proDeliveryQuScore) {
		this.proDeliveryQuScore = proDeliveryQuScore;
	}
	public double getTimeOfDelivery() {
		return timeOfDelivery;
	}
	public void setTimeOfDelivery(double timeOfDelivery) {
		this.timeOfDelivery = timeOfDelivery;
	}
	public double getRateStageAccept() {
		return rateStageAccept;
	}
	public void setRateStageAccept(double rateStageAccept) {
		this.rateStageAccept = rateStageAccept;
	}
	public double getPersonStScore() {
		return personStScore;
	}
	public void setPersonStScore(double personStScore) {
		this.personStScore = personStScore;
	}
	public double getProPersonStScore() {
		return proPersonStScore;
	}
	public void setProPersonStScore(double proPersonStScore) {
		this.proPersonStScore = proPersonStScore;
	}
	public double getDeliveryScheduleDev() {
		return deliveryScheduleDev;
	}
	public void setDeliveryScheduleDev(double deliveryScheduleDev) {
		this.deliveryScheduleDev = deliveryScheduleDev;
	}
	public double getProDeliveryQuality() {
		return proDeliveryQuality;
	}
	public void setProDeliveryQuality(double proDeliveryQuality) {
		this.proDeliveryQuality = proDeliveryQuality;
	}
	public double getProjectDeliveryQuality() {
		return projectDeliveryQuality;
	}
	public void setProjectDeliveryQuality(double projectDeliveryQuality) {
		this.projectDeliveryQuality = projectDeliveryQuality;
	}
	public double getQualityScore() {
		return qualityScore;
	}
	public void setQualityScore(double qualityScore) {
		this.qualityScore = qualityScore;
	}
	public double getQuPointsCriticalEvents() {
		return quPointsCriticalEvents;
	}
	public void setQuPointsCriticalEvents(double quPointsCriticalEvents) {
		this.quPointsCriticalEvents = quPointsCriticalEvents;
	}
}
