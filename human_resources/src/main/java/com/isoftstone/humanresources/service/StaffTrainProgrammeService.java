package com.isoftstone.humanresources.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.isoftstone.humanresources.domain.EmployeeTrainProgramInformation;
import com.isoftstone.humanresources.domain.organization.QueryEmpForProjectVO;

public interface StaffTrainProgrammeService {

	/**
	 * 新增培训计划
	 * @param etpInfo
	 * @return
	 */
	public  Map<String, Object> addTrainProgram(EmployeeTrainProgramInformation etpInfo);
	
	/**
	 * 查询计划详情
	 * @param id
	 * @return
	 */
	public List<EmployeeTrainProgramInformation> queryPlanById(String id,String projectTeam);
	
	/**
	 * 修改培训计划
	 * @param etpInfo
	 * @return
	 */
	public  Map<String, Object> updateTrainProgram(EmployeeTrainProgramInformation etpInfo);
	
	/**
	 * 查询leader下的员工
	 * @param leader
	 * @return
	 */
	public List<QueryEmpForProjectVO> queryEmpProject(String leader);
}
