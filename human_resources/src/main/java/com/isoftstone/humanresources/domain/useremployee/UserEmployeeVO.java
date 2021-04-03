package com.isoftstone.humanresources.domain.useremployee;

import java.io.Serializable;
import java.util.List;

import com.isoftstone.humanresources.domain.EmployeeInformation;
import com.isoftstone.humanresources.domain.EmployeePerformanceInformation;
import com.isoftstone.humanresources.domain.EmployeeProjectInformation;
import com.isoftstone.humanresources.domain.EmployeeWorkTimeDayInformation;
import com.isoftstone.humanresources.domain.EmployeeWorkTimeMonthInfomation;

public class UserEmployeeVO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private long userID;											//用户ID
    private String username;										//用户名
    private String organizationName;								//工作部门
    private int age;												//年龄
    private double workLong;										//服务年限
    private List<SkillInVO> skilList;								//技能列表
    private List<EmployeeProjectInformation> projectList;			//项目经历
    private List<EmployeePerformanceInformation> performanceList;	//个人绩效
    private List<EmployeeWorkTimeDayInformation> workTimeList;		//个人工时
    private EmployeeInformation employeeInformation;				//员工信息
    private List<EmployeeWorkTimeMonthInfomation> mothList;			//员工月绩效 
	
	public List<EmployeeWorkTimeMonthInfomation> getMothList() {
		return mothList;
	}
	public void setMothList(List<EmployeeWorkTimeMonthInfomation> mothList) {
		this.mothList = mothList;
	}
	public EmployeeInformation getEmployeeInformation() {
		return employeeInformation;
	}
	public void setEmployeeInformation(EmployeeInformation employeeInformation) {
		this.employeeInformation = employeeInformation;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWorkLong() {
		return workLong;
	}
	public void setWorkLong(double workLong) {
		this.workLong = workLong;
	}
	public List<SkillInVO> getSkilList() {
		return skilList;
	}
	public void setSkilList(List<SkillInVO> skilList) {
		this.skilList = skilList;
	}
	public List<EmployeeProjectInformation> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<EmployeeProjectInformation> projectList) {
		this.projectList = projectList;
	}
	
	public List<EmployeePerformanceInformation> getPerformanceList() {
		return performanceList;
	}
	public void setPerformanceList(List<EmployeePerformanceInformation> performanceList) {
		this.performanceList = performanceList;
	}
	public List<EmployeeWorkTimeDayInformation> getWorkTimeList() {
		return workTimeList;
	}
	public void setWorkTimeList(List<EmployeeWorkTimeDayInformation> workTimeList) {
		this.workTimeList = workTimeList;
	}
    
}
