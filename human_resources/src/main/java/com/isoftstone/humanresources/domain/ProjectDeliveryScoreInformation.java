package com.isoftstone.humanresources.domain;

import java.io.Serializable;

public class ProjectDeliveryScoreInformation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String projectId;							//项目编号
	private String contractId;							//合同编号
	private String predictLeadTime;						//预计交付时间
	private String realityLeadTime;						//实际交付时间
	private double personStScore;						//人员稳定度得分
	private String personStScoreSake;					//人员稳定度得分理由
	private double timeOfDelivery;						//交付及时性得分
	private String timeOfDeliverySake;					//交付及时性得分理由
	private double proDeliveryQuScore;					//过程交付质量得分
	private String proDeliveryQusake;					//过程交付质量得分理由
	private double scoreProjectAccept;					//结项验收质量得分
	private String projectAcceptSake;					//结项验收质量得分理由
	private double pointsDeductedCriticalEvents;		//综合关键事件扣分
	private String criticalEventssake;					//关键事件扣分理由
	private double proPersonStScore;					//项目人员稳定度
	private String proPersonStScoresake;				//项目人员稳定度得分理由
	private double proScheduleVariance;					//项目进度偏差
	private String postponeDuty;						//延期责任方
	private double rateStageAccept;						//阶段验收一次通过率
	private double LOC;									//代码规模(KLOC）
	private double softAcceptDensity;					//软件验收缺陷密度（个/KLOC）
	private double pactSoftAcceptDensity;				//合同允许验收缺陷密度(个/KLOC)
	private long dataSize;								//资料规模（页）
	private long dataAcceptDensity;						//资料验收缺陷密度（个/页）
	private long caseSize;								//用例规模
	private long qualityAfterInternet;					//版本上网后质量事故（个）
	private long pactQualityAfterInternet;				//合同允许上网后质量事故（个）
	private double networkSecuritySatis;				//网络安全满足度
	private double deliveryScheduleDev;					//交付进度偏差（10）
	private double proDeliveryQuality;					//过程交付质量（15）
	private double projectDeliveryQuality;				//项目验收质量（20）
	private double qualityScore;						//质量得分（45）
	private int quPointsCriticalEvents;					//质量关键事件扣分
	private double sumScore;							//总分
	private String createTime;							//创建时间
	private String updateTime;							//修改时间
	private int isPostpone;								//是否有延期
	private String postponeCause;						//延期理由详述
	private double taskCompRateTime;					//任务及时完成率
	private double missionPassRate;						//任务一次通过率
	private double ridingQuality;						//运行质量
	private double timelyArrivalRatePer;				//人员及时到位率
	private double personInterviewRate;					//人员面试通过率
	private double informationSecurity;					//信息安全
	private double networkSecurity;						//网络安全
	private double viaBrainstuck;						//用户满意度
	private String BU;
	private String BD;
	private String CU;
	private String bak;									//备注
	private String accRepSignDate;						//验收报告签字日期
	private String startEvaluateMonth;					//开始评价月份
	private String endEvaluateMonth;					//结束评价月份
	private String accRepInputDate;						//验收报告录入日期
	private String compreAcConclusion;					//综合验收结论
	
	public String getAccRepSignDate() {
		return accRepSignDate;
	}
	public void setAccRepSignDate(String accRepSignDate) {
		this.accRepSignDate = accRepSignDate;
	}
	public String getStartEvaluateMonth() {
		return startEvaluateMonth;
	}
	public void setStartEvaluateMonth(String startEvaluateMonth) {
		this.startEvaluateMonth = startEvaluateMonth;
	}
	public String getEndEvaluateMonth() {
		return endEvaluateMonth;
	}
	public void setEndEvaluateMonth(String endEvaluateMonth) {
		this.endEvaluateMonth = endEvaluateMonth;
	}
	public String getAccRepInputDate() {
		return accRepInputDate;
	}
	public void setAccRepInputDate(String accRepInputDate) {
		this.accRepInputDate = accRepInputDate;
	}
	public String getCompreAcConclusion() {
		return compreAcConclusion;
	}
	public void setCompreAcConclusion(String compreAcConclusion) {
		this.compreAcConclusion = compreAcConclusion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getPredictLeadTime() {
		return predictLeadTime;
	}
	public void setPredictLeadTime(String predictLeadTime) {
		this.predictLeadTime = predictLeadTime;
	}
	public String getRealityLeadTime() {
		return realityLeadTime;
	}
	public void setRealityLeadTime(String realityLeadTime) {
		this.realityLeadTime = realityLeadTime;
	}
	public double getPersonStScore() {
		return personStScore;
	}
	public void setPersonStScore(double personStScore) {
		this.personStScore = personStScore;
	}
	public String getPersonStScoreSake() {
		return personStScoreSake;
	}
	public void setPersonStScoreSake(String personStScoreSake) {
		this.personStScoreSake = personStScoreSake;
	}
	public double getTimeOfDelivery() {
		return timeOfDelivery;
	}
	public void setTimeOfDelivery(double timeOfDelivery) {
		this.timeOfDelivery = timeOfDelivery;
	}
	public String getTimeOfDeliverySake() {
		return timeOfDeliverySake;
	}
	public void setTimeOfDeliverySake(String timeOfDeliverySake) {
		this.timeOfDeliverySake = timeOfDeliverySake;
	}
	public double getProDeliveryQuScore() {
		return proDeliveryQuScore;
	}
	public void setProDeliveryQuScore(double proDeliveryQuScore) {
		this.proDeliveryQuScore = proDeliveryQuScore;
	}
	public String getProDeliveryQusake() {
		return proDeliveryQusake;
	}
	public void setProDeliveryQusake(String proDeliveryQusake) {
		this.proDeliveryQusake = proDeliveryQusake;
	}
	public double getScoreProjectAccept() {
		return scoreProjectAccept;
	}
	public void setScoreProjectAccept(double scoreProjectAccept) {
		this.scoreProjectAccept = scoreProjectAccept;
	}
	public String getProjectAcceptSake() {
		return projectAcceptSake;
	}
	public void setProjectAcceptSake(String projectAcceptSake) {
		this.projectAcceptSake = projectAcceptSake;
	}
	public double getPointsDeductedCriticalEvents() {
		return pointsDeductedCriticalEvents;
	}
	public void setPointsDeductedCriticalEvents(double pointsDeductedCriticalEvents) {
		this.pointsDeductedCriticalEvents = pointsDeductedCriticalEvents;
	}
	public String getCriticalEventssake() {
		return criticalEventssake;
	}
	public void setCriticalEventssake(String criticalEventssake) {
		this.criticalEventssake = criticalEventssake;
	}
	public double getProPersonStScore() {
		return proPersonStScore;
	}
	public void setProPersonStScore(double proPersonStScore) {
		this.proPersonStScore = proPersonStScore;
	}
	public String getProPersonStScoresake() {
		return proPersonStScoresake;
	}
	public void setProPersonStScoresake(String proPersonStScoresake) {
		this.proPersonStScoresake = proPersonStScoresake;
	}
	public double getProScheduleVariance() {
		return proScheduleVariance;
	}
	public void setProScheduleVariance(double proScheduleVariance) {
		this.proScheduleVariance = proScheduleVariance;
	}
	public String getPostponeDuty() {
		return postponeDuty;
	}
	public void setPostponeDuty(String postponeDuty) {
		this.postponeDuty = postponeDuty;
	}
	public double getRateStageAccept() {
		return rateStageAccept;
	}
	public void setRateStageAccept(double rateStageAccept) {
		this.rateStageAccept = rateStageAccept;
	}
	public double getLOC() {
		return LOC;
	}
	public void setLOC(double lOC) {
		LOC = lOC;
	}
	public double getSoftAcceptDensity() {
		return softAcceptDensity;
	}
	public void setSoftAcceptDensity(double softAcceptDensity) {
		this.softAcceptDensity = softAcceptDensity;
	}
	public double getPactSoftAcceptDensity() {
		return pactSoftAcceptDensity;
	}
	public void setPactSoftAcceptDensity(double pactSoftAcceptDensity) {
		this.pactSoftAcceptDensity = pactSoftAcceptDensity;
	}
	public long getDataSize() {
		return dataSize;
	}
	public void setDataSize(long dataSize) {
		this.dataSize = dataSize;
	}
	public long getDataAcceptDensity() {
		return dataAcceptDensity;
	}
	public void setDataAcceptDensity(long dataAcceptDensity) {
		this.dataAcceptDensity = dataAcceptDensity;
	}
	public long getCaseSize() {
		return caseSize;
	}
	public void setCaseSize(long caseSize) {
		this.caseSize = caseSize;
	}
	public long getQualityAfterInternet() {
		return qualityAfterInternet;
	}
	public void setQualityAfterInternet(long qualityAfterInternet) {
		this.qualityAfterInternet = qualityAfterInternet;
	}
	public long getPactQualityAfterInternet() {
		return pactQualityAfterInternet;
	}
	public void setPactQualityAfterInternet(long pactQualityAfterInternet) {
		this.pactQualityAfterInternet = pactQualityAfterInternet;
	}
	public double getNetworkSecuritySatis() {
		return networkSecuritySatis;
	}
	public void setNetworkSecuritySatis(double networkSecuritySatis) {
		this.networkSecuritySatis = networkSecuritySatis;
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
	public int getQuPointsCriticalEvents() {
		return quPointsCriticalEvents;
	}
	public void setQuPointsCriticalEvents(int quPointsCriticalEvents) {
		this.quPointsCriticalEvents = quPointsCriticalEvents;
	}
	public double getSumScore() {
		return sumScore;
	}
	public void setSumScore(double sumScore) {
		this.sumScore = sumScore;
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
	public int getIsPostpone() {
		return isPostpone;
	}
	public void setIsPostpone(int isPostpone) {
		this.isPostpone = isPostpone;
	}
	public String getPostponeCause() {
		return postponeCause;
	}
	public void setPostponeCause(String postponeCause) {
		this.postponeCause = postponeCause;
	}
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
	public String getCU() {
		return CU;
	}
	public void setCU(String cU) {
		CU = cU;
	}
	public String getBak() {
		return bak;
	}
	public void setBak(String bak) {
		this.bak = bak;
	}
	
}
