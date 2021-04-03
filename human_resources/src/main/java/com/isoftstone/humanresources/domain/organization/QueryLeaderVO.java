package com.isoftstone.humanresources.domain.organization;

import java.io.Serializable;

/**
 * 查询负责人信息
 * @author bwning
 *
 */
public class QueryLeaderVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer leader;				//负责人软通工号
	private String leaderName;			//负责人姓名
	public Integer getLeader() {
		return leader;
	}
	public void setLeader(Integer leader) {
		this.leader = leader;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	
	
}
