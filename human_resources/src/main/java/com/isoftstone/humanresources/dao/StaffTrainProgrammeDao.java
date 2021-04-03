package com.isoftstone.humanresources.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.isoftstone.humanresources.domain.EmployeeTrainProgramInformation;
import com.isoftstone.humanresources.domain.organization.QueryEmpForProjectVO;

public interface StaffTrainProgrammeDao {

	/**
	 * 新增培训计划
	 * @param etpInfo
	 * @return
	 */
	int addTrainProgram(@Param("etpInfo") EmployeeTrainProgramInformation etpInfo);
	
	/**
	 * 通过id查询计划详情
	 * @param id
	 * @return
	 */
	List<EmployeeTrainProgramInformation> queryPlanById(@Param("id") String id,@Param("projectTeam") String projectTeam,@Param("des") String des);
	
	/**
	 * 修改培训计划
	 * @param etpInfo
	 * @return
	 */
	int updateTrainProgram(@Param("etpInfo") EmployeeTrainProgramInformation etpInfo);
	
	/**
	 * 查询leader下员工
	 * @param leader
	 * @return
	 */
	List<QueryEmpForProjectVO> queryEmpProject(@Param("leader") String leader);
}
