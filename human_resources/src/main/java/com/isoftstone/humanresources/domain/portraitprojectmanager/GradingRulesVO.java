package com.isoftstone.humanresources.domain.portraitprojectmanager;

import java.io.Serializable;
import java.util.List;

import com.isoftstone.humanresources.domain.GradingRulesInformation;

public class GradingRulesVO implements Serializable{

		private static final long serialVersionUID = 1L;
		private String bu;
		private String bd;
		private String bak;									//备注
		private List<GradingRulesInformation> ruleList;		//规则类型集合
		private long createemployeeID;						//创建人工号
		private long updateEmployeeID;						//修改人工号
		private String buName;
		private String bdName;
		private String createName;
		private String updateName;
		private String parentId;
		
		public String getParentId() {
			return parentId;
		}
		public void setParentId(String parentId) {
			this.parentId = parentId;
		}
		public String getBuName() {
			return buName;
		}
		public void setBuName(String buName) {
			this.buName = buName;
		}
		public String getBdName() {
			return bdName;
		}
		public void setBdName(String bdName) {
			this.bdName = bdName;
		}
		public String getCreateName() {
			return createName;
		}
		public void setCreateName(String createName) {
			this.createName = createName;
		}
		public String getUpdateName() {
			return updateName;
		}
		public void setUpdateName(String updateName) {
			this.updateName = updateName;
		}
		public long getCreateemployeeID() {
			return createemployeeID;
		}
		public void setCreateemployeeID(long createemployeeID) {
			this.createemployeeID = createemployeeID;
		}
		public long getUpdateEmployeeID() {
			return updateEmployeeID;
		}
		public void setUpdateEmployeeID(long updateEmployeeID) {
			this.updateEmployeeID = updateEmployeeID;
		}
		public String getBu() {
			return bu;
		}
		public void setBu(String bu) {
			this.bu = bu;
		}
		public String getBd() {
			return bd;
		}
		public void setBd(String bd) {
			this.bd = bd;
		}
		public String getBak() {
			return bak;
		}
		public void setBak(String bak) {
			this.bak = bak;
		}
		public List<GradingRulesInformation> getRuleList() {
			return ruleList;
		}
		public void setRuleList(List<GradingRulesInformation> ruleList) {
			this.ruleList = ruleList;
		}
}
