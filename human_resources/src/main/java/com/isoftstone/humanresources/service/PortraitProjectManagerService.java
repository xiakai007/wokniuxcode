package com.isoftstone.humanresources.service;

import java.util.List;
import java.util.Map;

import com.isoftstone.humanresources.domain.EmployeeBasicRecordInformation;
import com.isoftstone.humanresources.domain.ImpressionRecordInformation;
import com.isoftstone.humanresources.domain.portraitprojectmanager.ImpressionRecordRes;
import com.isoftstone.humanresources.domain.portraitprojectmanager.PmScoreRes;
import com.isoftstone.humanresources.domain.portraitprojectmanager.ProjectMangerScoreRes;

/**
 *项目经理画像service接口
 * @author bwning
 *
 */
public interface PortraitProjectManagerService {

	/**
	 * 新增印象
	 * @param impressionRecord
	 * @return
	 */
	public Map<String, Object> addImpressionRecord(ImpressionRecordInformation impressionRecord);
	
	/**
	 * 查询印象标签
	 * @param employeeID
	 * @return
	 */
	public List<ImpressionRecordRes> queryImpression(String employeeID);
	
	/**
	 * 新增基础加分项
	 * @param employeeBasicRecordInfo
	 * @return
	 */
	public Map<String, Object> addBasicRecord(EmployeeBasicRecordInformation employeeBasicRecordInfo);
	
	/**
	 * 修改基础加分项
	 * @param employeeBasicRecordInfo
	 * @return
	 */
	public Map<String, Object> updateBasicRecord(EmployeeBasicRecordInformation employeeBasicRecordInfo);
	
	/**
	 * 查询基础打分项详情
	 * @param id
	 * @return
	 */
	public List<EmployeeBasicRecordInformation> queryBasicById(String id,String employeeId);
	
	/**
	 * 查询项目经理技能图
	 * @param employeeId
	 * @return
	 */
	public List<PmScoreRes> queryProjectManagerScore(long employeeId);
	
	/**
	 * 查询项目经理打分
	 * @param employeeId
	 * @return
	 */
	public ProjectMangerScoreRes queryPrjectManagerScore(long employeeId);
	
	
}
