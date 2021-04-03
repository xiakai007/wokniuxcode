package com.isoftstone.humanresources.domain.portraitprojectmanager;

import java.io.Serializable;

/**
 * 管理得分详情
 * @author bwning
 *
 */
public class ManageScoreVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private double isHealthPer;							//是否做了人员健康度计划得分
	private double isPersonBak;							//是否做了人员备份计划得分
	private double isPlanEmployee;						//是否做了员工培养计划
	public double getIsHealthPer() {
		return isHealthPer;
	}
	public void setIsHealthPer(double isHealthPer) {
		this.isHealthPer = isHealthPer;
	}
	public double getIsPersonBak() {
		return isPersonBak;
	}
	public void setIsPersonBak(double isPersonBak) {
		this.isPersonBak = isPersonBak;
	}
	public double getIsPlanEmployee() {
		return isPlanEmployee;
	}
	public void setIsPlanEmployee(double isPlanEmployee) {
		this.isPlanEmployee = isPlanEmployee;
	}
}
