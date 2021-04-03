package com.isoftstone.humanresources.domain.organization;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isoftstone.humanresources.util.BisicTreeVo;

@JsonIgnoreProperties(ignoreUnknown=true)
public class OrganizationTreeVO extends BisicTreeVo<OrganizationTreeVO> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String organizationName;
    
    private String isBU;
    
    //是否可点击
    private boolean isAccording;

    private String organizationType;
    
	public boolean getIsAccording() {
		return isAccording;
	}

	public String getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public void setIsAccording(boolean isAccording) {
		this.isAccording = isAccording;
	}

	public String getIsBU() {
		return isBU;
	}

	public void setIsBU(String isBU) {
		this.isBU = isBU;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}


}
