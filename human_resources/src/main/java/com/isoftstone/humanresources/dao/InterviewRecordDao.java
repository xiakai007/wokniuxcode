package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.recruit.InterviewRecordModel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [面试记录表dao]</p>
 * Created on 2019年11月04日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2019年
 */
public interface InterviewRecordDao{
	
	/**
	* 分页查询固定参数
	*/
	List<InterviewRecordModel> queryPageInterviewRecord(@Param("page") Page page, @Param("entity") InterviewRecordModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<InterviewRecordModel> queryListInterviewRecord(@Param("entity") InterviewRecordModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountInterviewRecord(@Param("entity") InterviewRecordModel entity);
	
	/**
	* 查询单个实体
	*/
	InterviewRecordModel queryInterviewRecordById(@Param("id") Long id, @Param("queryFields") List queryFields);
	
	/**
	* 新增
	*/
	int addInterviewRecord(InterviewRecordModel entity);
	
	/**
	* 修改
	*/
	int updateInterviewRecord(InterviewRecordModel entity);
	
	/**
	* 批量删除
	*/
	int removeInterviewRecordByIds(List code);
	
	/**
	* 删除
	*/
	int removeInterviewRecordById(@Param("id") Long id);

	/**
	 * 根据候选人ID查询面试信息
	 */
	List<InterviewRecordModel> queryByCandidateID(@Param("candidateID") String candidateID);

	/**
	 * 根据员工ID查询面试信息
	 */
	List<InterviewRecordModel> queryByEmployeeID(@Param("employeeID") String employeeID);

}
