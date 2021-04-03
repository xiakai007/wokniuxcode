package com.isoftstone.humanresources.domain.workTime;

import java.io.Serializable;

/**
 * <p>Description: [考勤机配置表model]</p>
 * Created on 2020年10月28日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class TerminalInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 终端ID
     */
	private String terminalId;
	/**
     * 在岸、离岸
     */
	private String shoreType;

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getShoreType() {
		return shoreType;
	}

	public void setShoreType(String shoreType) {
		this.shoreType = shoreType;
	}
}
