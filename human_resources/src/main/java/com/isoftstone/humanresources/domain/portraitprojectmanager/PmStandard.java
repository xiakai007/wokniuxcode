package com.isoftstone.humanresources.domain.portraitprojectmanager;

import java.io.Serializable;

public class PmStandard implements Serializable{

	private static final long serialVersionUID = 1L;

	private double parStandard;							//项目过程和结果标准
	private double pmaStandard;							//人员管理标准
	private double secStandard;							//安全标准
	private double satStandard;							//满意度标准
	private double qsStandard;							//质量得分标准
	public double getParStandard() {
		return parStandard;
	}
	public void setParStandard(double parStandard) {
		this.parStandard = parStandard;
	}
	public double getPmaStandard() {
		return pmaStandard;
	}
	public void setPmaStandard(double pmaStandard) {
		this.pmaStandard = pmaStandard;
	}
	public double getSecStandard() {
		return secStandard;
	}
	public void setSecStandard(double secStandard) {
		this.secStandard = secStandard;
	}
	public double getSatStandard() {
		return satStandard;
	}
	public void setSatStandard(double satStandard) {
		this.satStandard = satStandard;
	}
	public double getQsStandard() {
		return qsStandard;
	}
	public void setQsStandard(double qsStandard) {
		this.qsStandard = qsStandard;
	}
}
