package com.isoftstone.humanresources.domain.portraitprojectmanager;

import java.io.Serializable;
import java.util.List;

public class PmScoreRes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private double value;

	private List<PmScoreRes> pmFpList;
	

	public List<PmScoreRes> getPmFpList() {
		return pmFpList;
	}

	public void setPmFpList(List<PmScoreRes> pmFpList) {
		this.pmFpList = pmFpList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	

}
