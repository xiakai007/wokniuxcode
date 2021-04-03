package com.isoftstone.humanresources.domain.portraitprojectmanager;

import java.io.Serializable;

public class ScoreProjectSkillTM implements Serializable{

	private static final long serialVersionUID = 1L;

	private double taskCompRateTime;				//任务及时完成率
	private double missionPassRate;					//任务一次通过率
	private double ridingQuality;					//运行质量
	private double timelyArrivalRatePer;			//人员及时到位率
	private double personStScore;					//人员稳定度
	private double personInterviewRate;				//人员面试通过率
	private double informationSecurity;				//信息安全
	private double networkSecurity;					//网络安全
	private double viaBrainstuck;					//满意度
	private double deliveryScheduleDev;				//交付进度偏差
	private double proDeliveryQuality;				//过程交付质量
	private double projectDeliveryQuality;			//项目验收质量
	private double qualityScore;					//质量得分
	private double quPointsCriticalEvents;			//质量关键事件扣分
	public double getTaskCompRateTime() {
		return taskCompRateTime;
	}
	public void setTaskCompRateTime(double taskCompRateTime) {
		this.taskCompRateTime = taskCompRateTime;
	}
	public double getMissionPassRate() {
		return missionPassRate;
	}
	public void setMissionPassRate(double missionPassRate) {
		this.missionPassRate = missionPassRate;
	}
	public double getRidingQuality() {
		return ridingQuality;
	}
	public void setRidingQuality(double ridingQuality) {
		this.ridingQuality = ridingQuality;
	}
	public double getTimelyArrivalRatePer() {
		return timelyArrivalRatePer;
	}
	public void setTimelyArrivalRatePer(double timelyArrivalRatePer) {
		this.timelyArrivalRatePer = timelyArrivalRatePer;
	}
	public double getPersonStScore() {
		return personStScore;
	}
	public void setPersonStScore(double personStScore) {
		this.personStScore = personStScore;
	}
	public double getPersonInterviewRate() {
		return personInterviewRate;
	}
	public void setPersonInterviewRate(double personInterviewRate) {
		this.personInterviewRate = personInterviewRate;
	}
	public double getInformationSecurity() {
		return informationSecurity;
	}
	public void setInformationSecurity(double informationSecurity) {
		this.informationSecurity = informationSecurity;
	}
	public double getNetworkSecurity() {
		return networkSecurity;
	}
	public void setNetworkSecurity(double networkSecurity) {
		this.networkSecurity = networkSecurity;
	}
	public double getViaBrainstuck() {
		return viaBrainstuck;
	}
	public void setViaBrainstuck(double viaBrainstuck) {
		this.viaBrainstuck = viaBrainstuck;
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
