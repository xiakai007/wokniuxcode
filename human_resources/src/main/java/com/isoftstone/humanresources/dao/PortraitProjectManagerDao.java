package com.isoftstone.humanresources.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.isoftstone.humanresources.domain.EmployeeBasicRecordInformation;
import com.isoftstone.humanresources.domain.GradingRulesInformation;
import com.isoftstone.humanresources.domain.ImpressionRecordInformation;
import com.isoftstone.humanresources.domain.portraitprojectmanager.ImpressionRecordRes;
import com.isoftstone.humanresources.domain.portraitprojectmanager.ManageScoreVO;
import com.isoftstone.humanresources.domain.portraitprojectmanager.ProjectManagerVO;
import com.isoftstone.humanresources.domain.portraitprojectmanager.RecruitAndLeaveVO;
import com.isoftstone.humanresources.domain.portraitprojectmanager.ScoreProjectSkillFP;
import com.isoftstone.humanresources.domain.portraitprojectmanager.ScoreProjectSkillTM;
import com.isoftstone.humanresources.domain.portraitprojectmanager.ScoreWayVO;

/**
 * 项目经理画像dao
 * @author bwning
 *
 */
public interface PortraitProjectManagerDao {
	
	/**
	 * 新增印象
	 * @param impressionRecord
	 * @return
	 */
	int addImpressionRecord(@Param("impressionRecord") ImpressionRecordInformation impressionRecord);
	
	/**
	 * 查询印象标签
	 * @param employeeID
	 * @return
	 */
	List<ImpressionRecordRes> queryImpression(@Param("employeeID") String employeeID);
	
	/**
	 * 新增基础分
	 * @param employeeBasicRecordInfo
	 * @return
	 */
	int addBasicRecord(@Param("employeeBasicRecordInfo") EmployeeBasicRecordInformation employeeBasicRecordInfo);

	/**
	 * 修改基础加分项
	 * @param employeeBasicRecordInfo
	 * @return
	 */
	int updateBasicRecord(@Param("employeeBasicRecordInfo") EmployeeBasicRecordInformation employeeBasicRecordInfo);
	
	/**
	 * 查询基础打分项详情
	 * @param id
	 * @param employeeId
	 * @return
	 */
	List<EmployeeBasicRecordInformation> queryBasicById(@Param("id")String id,@Param("employeeId")String employeeId);
	
	/**
	 * 查询项目经理fp项目得分
	 * @param employeeId
	 * @return
	 */
	ProjectManagerVO queryProjectManagerScoreFP(@Param("employeeId") long employeeId);
	
	/**
	 * 查询项目经理fp项目得分详情
	 * @param employeeId
	 * @return
	 */
	ScoreProjectSkillFP queryProjectManagerScoreFPInfo(@Param("employeeId") long employeeId);
	
	/**
	 * 查询项目经理TM项目得分
	 * @param employeeId
	 * @return
	 */
	ProjectManagerVO queryProjectManagerScoreTM(@Param("employeeId") long employeeId);
	
	/**
	 * 查询项目经理TM项目得分详情
	 * @param employeeId
	 * @return
	 */
	ScoreProjectSkillTM queryProjectManagerScoreTMInfo(@Param("employeeId") long employeeId);
	
	/**
	 * 获取质量得分
	 * @param scoreWayVO
	 * @return
	 */
	double queryQualityScore(ScoreWayVO scoreWayVO);
	
	/**
	 * 获取人资得分
	 * @param scoreWayVO
	 * @return
	 */
	double queryHumanScore(ScoreWayVO scoreWayVO);
	
	/**
	 * 获取离职得分
	 * @param scoreWayVO
	 * @return
	 */
	RecruitAndLeaveVO queryHumanScoreInfo(ScoreWayVO scoreWayVO);
	
	/**
	 * 获取印象得分
	 * @param scoreWayVO
	 * @return
	 */
	double queryImpressionScore(ScoreWayVO scoreWayVO);
	
	/**
	 * 获取管理得分
	 * @param scoreWayVO
	 * @return
	 */
	double queryManagementScore(ScoreWayVO scoreWayVO);
	
	/**
	 * 获取管理详情
	 * @param scoreWayVO
	 * @return
	 */
	ManageScoreVO queryManagementScoreInfo(ScoreWayVO scoreWayVO);
	
	/**
	 * 查询打分规则
	 * @param bdOrBu
	 * @param orgType
	 * @return
	 */
	GradingRulesInformation queryRuleScoreInfo(@Param("bdOrBu") String bdOrBu,@Param("orgType") String orgType,@Param("scoreType") String scoreType);
}
