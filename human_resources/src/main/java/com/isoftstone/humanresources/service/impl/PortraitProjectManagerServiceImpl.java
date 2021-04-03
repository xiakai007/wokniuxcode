package com.isoftstone.humanresources.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoftstone.humanresources.dao.EmployeeDao;
import com.isoftstone.humanresources.dao.PortraitProjectManagerDao;
import com.isoftstone.humanresources.domain.EmployeeBasicRecordInformation;
import com.isoftstone.humanresources.domain.EmployeeInformation;
import com.isoftstone.humanresources.domain.GradingRulesInformation;
import com.isoftstone.humanresources.domain.ImpressionRecordInformation;
import com.isoftstone.humanresources.domain.portraitprojectmanager.ImpressionRecordRes;
import com.isoftstone.humanresources.domain.portraitprojectmanager.PmScoreRes;
import com.isoftstone.humanresources.domain.portraitprojectmanager.ProjectManagerVO;
import com.isoftstone.humanresources.domain.portraitprojectmanager.ProjectMangerScoreRes;
import com.isoftstone.humanresources.domain.portraitprojectmanager.RecruitAndLeaveVO;
import com.isoftstone.humanresources.domain.portraitprojectmanager.ScoreProjectSkillFP;
import com.isoftstone.humanresources.domain.portraitprojectmanager.ScoreProjectSkillTM;
import com.isoftstone.humanresources.domain.portraitprojectmanager.ScoreWayVO;
import com.isoftstone.humanresources.service.PortraitProjectManagerService;
import com.isoftstone.humanresources.util.CommonConstant;

/**
 * 项目经理画像service实现
 * @author bwning
 *
 */
@Service(value = "PortraitProjectManagerService")
public class PortraitProjectManagerServiceImpl implements PortraitProjectManagerService{

	private final Logger logger = LoggerFactory.getLogger(GradingRulesServiceImpl.class);

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private PortraitProjectManagerDao portraitProjectManagerDao;
	@Override
	public Map<String, Object> addImpressionRecord(ImpressionRecordInformation impressionRecord) {
		boolean flag = false;
        Map<String, Object> map = new HashMap<>();
		try {
			int result = portraitProjectManagerDao.addImpressionRecord(impressionRecord);
			if(result == 0){
				map.put(CommonConstant.RETURN_STATUS, flag);
				map.put(CommonConstant.RETURN_MESSAGE, "新增失败");
				return map;
			}
			flag = true;
			map.put(CommonConstant.RETURN_STATUS, flag);
			map.put(CommonConstant.RETURN_MESSAGE, "新增成功");
		} catch (Exception e) {
			logger.error(e.toString());
			flag = false;
			map.put(CommonConstant.RETURN_STATUS, flag);
			map.put(CommonConstant.RETURN_MESSAGE, e.toString());
		}
		return map;
	}
	
	@Override
	public List<ImpressionRecordRes> queryImpression(String employeeID) {
		return portraitProjectManagerDao.queryImpression(employeeID);
	}

	@Override
	public Map<String, Object> addBasicRecord(EmployeeBasicRecordInformation employeeBasicRecordInfo) {
		boolean flag = false;
        Map<String, Object> map = new HashMap<>();
		try {
			int result = portraitProjectManagerDao.addBasicRecord(employeeBasicRecordInfo);
			if(result == 0){
				map.put(CommonConstant.RETURN_STATUS, flag);
				map.put(CommonConstant.RETURN_MESSAGE, "新增失败");
				return map;
			}
			flag = true;
			map.put(CommonConstant.RETURN_STATUS, flag);
			map.put(CommonConstant.RETURN_MESSAGE, "新增成功");
		} catch (Exception e) {
			logger.error(e.toString());
			flag = false;
			map.put(CommonConstant.RETURN_STATUS, flag);
			map.put(CommonConstant.RETURN_MESSAGE, e.toString());
		}
		return map;
	}

	@Override
	public Map<String, Object> updateBasicRecord(EmployeeBasicRecordInformation employeeBasicRecordInfo) {
		boolean flag = false;
        Map<String, Object> map = new HashMap<>();
		try {
			int result = portraitProjectManagerDao.updateBasicRecord(employeeBasicRecordInfo);
			if(result == 0){
				map.put(CommonConstant.RETURN_STATUS, flag);
				map.put(CommonConstant.RETURN_MESSAGE, "修改失败");
				return map;
			}
			flag = true;
			map.put(CommonConstant.RETURN_STATUS, flag);
			map.put(CommonConstant.RETURN_MESSAGE, "修改成功");
		} catch (Exception e) {
			logger.error(e.toString());
			flag = false;
			map.put(CommonConstant.RETURN_STATUS, flag);
			map.put(CommonConstant.RETURN_MESSAGE, e.toString());
		}
		return map;
	}

	@Override
	public List<EmployeeBasicRecordInformation> queryBasicById(String id, String employeeId) {
		return portraitProjectManagerDao.queryBasicById(id, employeeId);
	}

	@Override
	public List<PmScoreRes> queryProjectManagerScore(long employeeId) {
		DecimalFormat  a1 = new DecimalFormat("###.00");
		//查询FP项目得分
		ProjectManagerVO pmFP = portraitProjectManagerDao.queryProjectManagerScoreFP(employeeId);
		//查询TM项目得分详情
		ScoreProjectSkillTM scoreTM = portraitProjectManagerDao.queryProjectManagerScoreTMInfo(employeeId);
		//查询fp项目得分详情
		ScoreProjectSkillFP scoreFP = portraitProjectManagerDao.queryProjectManagerScoreFPInfo(employeeId);
		//查询TM项目得分
		ProjectManagerVO pmTM = portraitProjectManagerDao.queryProjectManagerScoreTM(employeeId);
		List<PmScoreRes> mapList = new ArrayList<>();
		PmScoreRes map = null;
		if(null == pmFP){
			if(null == pmTM){
				//封装参数
				map = new PmScoreRes();
				map.setName(CommonConstant.SECURITY);
				map.setValue(0);
				mapList.add(map);
				map = new PmScoreRes();
				map.setName(CommonConstant.PROCESS_AND_RESULTS);
				map.setValue(0);
				mapList.add(map);
				map = new PmScoreRes();
				map.setName(CommonConstant.PERSON_MANAGE);
				map.setValue(0);
				mapList.add(map);
				map = new PmScoreRes();
				map.setName(CommonConstant.SATIS_FACTION);
				map.setValue(0);
				mapList.add(map);
				map = new PmScoreRes();
				map.setName(CommonConstant.QUALITY_SCORE);
				map.setValue(0);
				mapList.add(map);
				return mapList; 
			}
			map = new PmScoreRes();
			map.setName(CommonConstant.SECURITY);
			map.setValue(pmTM.getSecurity());
			map.setPmFpList(this.getProSkillInfo(scoreFP,scoreTM,CommonConstant.SECURITY));
			mapList.add(map);
			map = new PmScoreRes();
			map.setName(CommonConstant.PROCESS_AND_RESULTS);
			map.setValue(pmTM.getProcessAndResults());
			map.setPmFpList(this.getProSkillInfo(scoreFP,scoreTM,CommonConstant.PROCESS_AND_RESULTS));
			mapList.add(map);
			map = new PmScoreRes();
			map.setName(CommonConstant.PERSON_MANAGE);
			map.setValue(pmTM.getPersonManage());
			map.setPmFpList(this.getProSkillInfo(scoreFP,scoreTM,CommonConstant.PERSON_MANAGE));
			mapList.add(map);
			map = new PmScoreRes();
			map.setName(CommonConstant.SATIS_FACTION);
			map.setValue(pmTM.getSatisfaction());
			map.setPmFpList(this.getProSkillInfo(scoreFP,scoreTM,CommonConstant.SATIS_FACTION));
			mapList.add(map);
			map = new PmScoreRes();
			map.setName(CommonConstant.QUALITY_SCORE);
			map.setValue(pmTM.getQualityScore());
			map.setPmFpList(this.getProSkillInfo(scoreFP,scoreTM,CommonConstant.QUALITY_SCORE));
			mapList.add(map);
			return mapList;
		}
		if(null == pmTM){
			map = new PmScoreRes();
			map.setName(CommonConstant.SECURITY);
			map.setValue(pmFP.getSecurity());
			map.setPmFpList(this.getProSkillInfo(scoreFP,null,CommonConstant.SECURITY));
			mapList.add(map);
			map = new PmScoreRes();
			map.setName(CommonConstant.PROCESS_AND_RESULTS);
			map.setValue(pmFP.getProcessAndResults());
			map.setPmFpList(this.getProSkillInfo(scoreFP,null,CommonConstant.PROCESS_AND_RESULTS));
			mapList.add(map);
			map = new PmScoreRes();
			map.setName(CommonConstant.PERSON_MANAGE);
			map.setValue(pmFP.getPersonManage());
			map.setPmFpList(this.getProSkillInfo(scoreFP,null,CommonConstant.PERSON_MANAGE));
			mapList.add(map);
			map = new PmScoreRes();
			map.setName(CommonConstant.SATIS_FACTION);
			map.setValue(pmFP.getSatisfaction());
			map.setPmFpList(this.getProSkillInfo(scoreFP,null,CommonConstant.SATIS_FACTION));
			mapList.add(map);
			map = new PmScoreRes();
			map.setName(CommonConstant.QUALITY_SCORE);
			map.setValue(pmFP.getQualityScore());
			map.setPmFpList(this.getProSkillInfo(scoreFP,null,CommonConstant.QUALITY_SCORE));
			mapList.add(map);
			return mapList;
		}
		map = new PmScoreRes();
		map.setName(CommonConstant.SECURITY);
		map.setValue(pmTM.getSecurity());
		map.setPmFpList(this.getProSkillInfo(scoreFP,scoreTM,CommonConstant.SECURITY));
		mapList.add(map);
		map = new PmScoreRes();
		map.setName(CommonConstant.PROCESS_AND_RESULTS);
		BigDecimal proResults = new BigDecimal(Double.toString(pmFP.getProcessAndResults()));
		BigDecimal proResults1 = new BigDecimal(Double.toString(pmTM.getProcessAndResults()));
		map.setValue(Double.parseDouble(a1.format(((proResults.add(proResults1).doubleValue())/2))));
		map.setPmFpList(this.getProSkillInfo(scoreFP,scoreTM,CommonConstant.PROCESS_AND_RESULTS));
		mapList.add(map);
		map = new PmScoreRes();
		map.setName(CommonConstant.PERSON_MANAGE);
		BigDecimal personManage = new BigDecimal(Double.toString(pmFP.getPersonManage()));
		BigDecimal personManage1 = new BigDecimal(Double.toString(pmTM.getPersonManage()));
		map.setValue(Double.parseDouble(a1.format(((personManage.add(personManage1).doubleValue())/2))));
		map.setPmFpList(this.getProSkillInfo(scoreFP,scoreTM,CommonConstant.PERSON_MANAGE));
		mapList.add(map);
		map = new PmScoreRes();
		map.setName(CommonConstant.SATIS_FACTION);
		map.setValue(pmTM.getSatisfaction());
		map.setPmFpList(this.getProSkillInfo(scoreFP,scoreTM,CommonConstant.SATIS_FACTION));
		mapList.add(map);
		map = new PmScoreRes();
		map.setName(CommonConstant.QUALITY_SCORE);
		BigDecimal qualityScore = new BigDecimal(Double.toString(pmFP.getQualityScore()));
		BigDecimal qualityScore1 = new BigDecimal(Double.toString(pmTM.getQualityScore()));
		map.setValue(Double.parseDouble(a1.format(((qualityScore.add(qualityScore1).doubleValue())/2))));
		map.setPmFpList(this.getProSkillInfo(scoreFP,scoreTM,CommonConstant.QUALITY_SCORE));
		mapList.add(map);
		return mapList;
	}

	@Override
	public ProjectMangerScoreRes queryPrjectManagerScore(long employeeId) {
		DecimalFormat  a1 = new DecimalFormat("###.00");
		ProjectMangerScoreRes projectMangerScore = new ProjectMangerScoreRes();
		ScoreWayVO scoreWayVO = new ScoreWayVO();
		//查询员工基本信息
		EmployeeInformation emp = employeeDao.queryEmployeeInfo(employeeId);
		
		//查询BU交付质量规则
		GradingRulesInformation gradInfo = 
				portraitProjectManagerDao.queryRuleScoreInfo(emp.getBU(), "BU", "pro_delivery");
		if(null == gradInfo){
			//查询bd规则
			gradInfo = 
					portraitProjectManagerDao.queryRuleScoreInfo(emp.getBU(), "BD", "pro_delivery");
			if(null == gradInfo){
				return projectMangerScore;
			}
			scoreWayVO.setScoreProportion(Double.parseDouble(gradInfo.getScoreProportion().replace("%", ""))/100);
			scoreWayVO.setEmployeeId(employeeId);
			//获取质量得分满分
			projectMangerScore.setQualityScoreAll(Double.parseDouble(gradInfo.getScoreProportion().replace("%", ""))/100*40);
			//获取质量得分
			projectMangerScore.setQualityScore(portraitProjectManagerDao.queryQualityScore(scoreWayVO));
			//获取BU人资打分规则
			gradInfo = 
					portraitProjectManagerDao.queryRuleScoreInfo(emp.getBU(), "BD", "human_resources");
			scoreWayVO.setScoreProportion(Double.parseDouble(gradInfo.getScoreProportion().replace("%", ""))/100);
			//获取人资得分满分
			projectMangerScore.setHumanScoreAll(Double.parseDouble(gradInfo.getScoreProportion().replace("%", ""))/100*40);
			//获取人资得分详情
			RecruitAndLeaveVO recruitAndLeave= portraitProjectManagerDao.queryHumanScoreInfo(scoreWayVO);
			//计算人资得分
			projectMangerScore.setRecruitAndLeaveVO(recruitAndLeave);
			
			BigDecimal leaveScore = new BigDecimal(Double.toString(recruitAndLeave.getLeaveScore()));
			
			BigDecimal recruitScore = new BigDecimal(Double.toString(recruitAndLeave.getRecruitScore()));
			//获取人资得分
			projectMangerScore.setHumanScore(Double.parseDouble(a1.format(leaveScore.add(recruitScore).doubleValue())));
			//获取BU印象打分规则
					gradInfo = 
							portraitProjectManagerDao.queryRuleScoreInfo(emp.getBU(), "BD", "impression");
					scoreWayVO.setScoreProportion(Double.parseDouble(gradInfo.getScoreProportion().replace("%", ""))/100);
			//获取印象的分总分		
			projectMangerScore.setImpressionScoreAll(Double.parseDouble(gradInfo.getScoreProportion().replace("%", ""))/100*40);
			//获取印象得分
			projectMangerScore.setImpressionScore(portraitProjectManagerDao.queryImpressionScore(scoreWayVO));
			//获取BU管理打分规则
			gradInfo = 
					portraitProjectManagerDao.queryRuleScoreInfo(emp.getBU(), "BD", "management");
			scoreWayVO.setScoreProportion(Double.parseDouble(gradInfo.getScoreProportion().replace("%", ""))/100);
			projectMangerScore.setManagementScoreAll(Double.parseDouble(gradInfo.getScoreProportion().replace("%", ""))/100*40);
			//获取管理得分
			projectMangerScore.setManagementScore(portraitProjectManagerDao.queryManagementScore(scoreWayVO));
			projectMangerScore.setBaseScoring(60);
			projectMangerScore.setBaseScoringAll(60);
			projectMangerScore.setScoreType("BD");
			projectMangerScore.setSumScore(projectMangerScore.getQualityScore()+projectMangerScore.getBaseScoring()
			+projectMangerScore.getHumanScore()+projectMangerScore.getImpressionScore()+projectMangerScore.getManagementScore());
			return projectMangerScore;
		}
		scoreWayVO.setScoreProportion(Double.parseDouble(gradInfo.getScoreProportion().replace("%", ""))/100);
		scoreWayVO.setEmployeeId(employeeId);
		//获取质量得分满分
		projectMangerScore.setQualityScoreAll(Double.parseDouble(gradInfo.getScoreProportion().replace("%", ""))/100*40);
		//获取质量得分
		projectMangerScore.setQualityScore(portraitProjectManagerDao.queryQualityScore(scoreWayVO));
		//获取BU人资打分规则
		gradInfo = 
				portraitProjectManagerDao.queryRuleScoreInfo(emp.getBU(), "BU", "human_resources");
		scoreWayVO.setScoreProportion(Double.parseDouble(gradInfo.getScoreProportion().replace("%", ""))/100);
		//获取人资得分满分
		projectMangerScore.setHumanScoreAll(Double.parseDouble(gradInfo.getScoreProportion().replace("%", ""))/100*40);
		//获取人资得分详情
		RecruitAndLeaveVO recruitAndLeave= portraitProjectManagerDao.queryHumanScoreInfo(scoreWayVO);
		//计算人资得分
		projectMangerScore.setRecruitAndLeaveVO(recruitAndLeave);
		
		BigDecimal leaveScore = new BigDecimal(Double.toString(recruitAndLeave.getLeaveScore()));
		
		BigDecimal recruitScore = new BigDecimal(Double.toString(recruitAndLeave.getRecruitScore()));
		//获取人资得分
		projectMangerScore.setHumanScore(Double.parseDouble(a1.format(leaveScore.add(recruitScore).doubleValue())));
		//获取BU印象打分规则
		gradInfo = 
				portraitProjectManagerDao.queryRuleScoreInfo(emp.getBU(), "BU", "impression");
		scoreWayVO.setScoreProportion(Double.parseDouble(gradInfo.getScoreProportion().replace("%", ""))/100);
		//获取印象的分总分		
		projectMangerScore.setImpressionScoreAll(Double.parseDouble(gradInfo.getScoreProportion().replace("%", ""))/100*40);
		//获取印象得分
		projectMangerScore.setImpressionScore(portraitProjectManagerDao.queryImpressionScore(scoreWayVO));
		//获取BU管理打分规则
		gradInfo = 
				portraitProjectManagerDao.queryRuleScoreInfo(emp.getBU(), "BU", "management");
		scoreWayVO.setScoreProportion(Double.parseDouble(gradInfo.getScoreProportion().replace("%", ""))/100);
		//获取管理得分总分
		projectMangerScore.setManagementScoreAll(Double.parseDouble(gradInfo.getScoreProportion().replace("%", ""))/100*40);
		//获取管理得分详情
		projectMangerScore.setManageScoreInfo(portraitProjectManagerDao.queryManagementScoreInfo(scoreWayVO));
		projectMangerScore.setManagementScore(portraitProjectManagerDao.queryManagementScore(scoreWayVO));
		projectMangerScore.setBaseScoring(60);
		projectMangerScore.setBaseScoringAll(60);
		projectMangerScore.setScoreType("BU");
		//将double类型进行转换
		BigDecimal qualityScore = new BigDecimal(Double.toString(projectMangerScore.getQualityScore()));
		BigDecimal baseScoring = new BigDecimal(Double.toString(projectMangerScore.getBaseScoring()));
		BigDecimal humanScore = new BigDecimal(Double.toString(projectMangerScore.getHumanScore()));
		BigDecimal impressionScore = new BigDecimal(Double.toString(projectMangerScore.getImpressionScore()));
		BigDecimal managementScore = new BigDecimal(Double.toString(projectMangerScore.getManagementScore()));
		//计算得到总分
		projectMangerScore.setSumScore(qualityScore.add(baseScoring).add(humanScore).add(impressionScore).add(managementScore).doubleValue());
		return projectMangerScore;
	}
	
	/**
	 * 获取项目经理技能图详情
	 * @param scoreFP
	 * @param scoreTM
	 * @return
	 */
	private List<PmScoreRes> getProSkillInfo(ScoreProjectSkillFP scoreFP,ScoreProjectSkillTM scoreTM,String type){
		List<PmScoreRes> pmScoreList = new ArrayList<>();
		PmScoreRes pmScore = null;
		if(null == scoreFP && null == scoreTM){
			return pmScoreList;
		}
		if(null == scoreTM){
			//封装FP数据
			switch (type) {
			case CommonConstant.SECURITY:
				pmScore = new PmScoreRes();
				pmScore.setName(CommonConstant.SECURITY);
				pmScore.setValue(0);
				pmScoreList.add(pmScore);
				break;
			case CommonConstant.PROCESS_AND_RESULTS:
				this.processAndResultsFp(pmScoreList, scoreFP);
				break;
			case CommonConstant.PERSON_MANAGE:
				this.personManageFp(pmScoreList, scoreFP);
				break;
			case CommonConstant.SATIS_FACTION:
				pmScore = new PmScoreRes();
				pmScore.setName(CommonConstant.SATIS_FACTION);
				pmScore.setValue(0);
				pmScoreList.add(pmScore);
				break;
			case CommonConstant.QUALITY_SCORE:
				this.qualityScoreFp(pmScoreList, scoreFP);
				break;
				default:
				break;
			}
			return pmScoreList;
		}
		if(null == scoreFP){
			//封装TM数据
			switch (type) {
			case CommonConstant.SECURITY:
				this.securityTm(pmScoreList, scoreTM);
				break;
			case CommonConstant.PROCESS_AND_RESULTS:
				this.processAndResultsTm(pmScoreList, scoreTM);
				break;
			case CommonConstant.PERSON_MANAGE:
				this.personManageTm(pmScoreList, scoreTM);
				break;
			case CommonConstant.SATIS_FACTION:
				this.satisFactionTm(pmScoreList, scoreTM);
				break;
			case CommonConstant.QUALITY_SCORE:
				this.qualityScoreTm(pmScoreList, scoreTM);
				break;
				default:
				break;
			}
			return pmScoreList;
		}
		//封装TM和fp数据
		switch (type) {
		case CommonConstant.SECURITY:
			this.securityTm(pmScoreList, scoreTM);
			break;
		case CommonConstant.PROCESS_AND_RESULTS:
			this.processAndResultsTm(pmScoreList, scoreTM);
			this.processAndResultsFp(pmScoreList, scoreFP);
			break;
		case CommonConstant.PERSON_MANAGE:
			this.personManageTm(pmScoreList, scoreTM);
			this.personManageFp(pmScoreList, scoreFP);
			break;
		case CommonConstant.SATIS_FACTION:
			this.satisFactionTm(pmScoreList, scoreTM);
			break;
		case CommonConstant.QUALITY_SCORE:
			this.qualityScoreTm(pmScoreList, scoreTM);
			this.qualityScoreFp(pmScoreList, scoreFP);
			break;
			default:
			break;
		}
		return pmScoreList;
	}
	
	/**
	 * fp项目与过程数据
	 * @param pmScoreList
	 * @param scoreFP
	 * @return
	 */
	private void processAndResultsFp(List<PmScoreRes> pmScoreList,ScoreProjectSkillFP scoreFP){
		PmScoreRes pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.PRO_DELIVERY_QU_SCORE_FP);
		pmScore.setValue(scoreFP.getProDeliveryQuScore());
		pmScoreList.add(pmScore);
		pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.TIME_OF_DELIVERY_FP);
		pmScore.setValue(scoreFP.getTimeOfDelivery());
		pmScoreList.add(pmScore);
		pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.RATE_STAGE_ACCEPT_FP);
		pmScore.setValue(scoreFP.getRateStageAccept());
		pmScoreList.add(pmScore);
	}
	
	/**
	 * fp人资数据
	 * @param pmScoreList
	 * @param scoreFP
	 */
	private void personManageFp(List<PmScoreRes> pmScoreList,ScoreProjectSkillFP scoreFP){
		PmScoreRes pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.PERSON_ST_SCORE_FP);
		pmScore.setValue(scoreFP.getPersonStScore());
		pmScoreList.add(pmScore);
		pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.PRO_PERSON_ST_SCORE_FP);
		pmScore.setValue(scoreFP.getProPersonStScore());
		pmScoreList.add(pmScore);
	}
	
	/**
	 * fp交付质量
	 * @param pmScoreList
	 * @param scoreFP
	 */
	private void qualityScoreFp(List<PmScoreRes> pmScoreList,ScoreProjectSkillFP scoreFP){
		PmScoreRes pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.DELIVERY_SCHEDULE_DEV_FP);
		pmScore.setValue(scoreFP.getDeliveryScheduleDev());
		pmScoreList.add(pmScore);
		pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.PRO_DELIVERY_QUALITY_FP);
		pmScore.setValue(scoreFP.getProDeliveryQuality());
		pmScoreList.add(pmScore);
		pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.PROJECT_DELIVERY_QUALITY_FP);
		pmScore.setValue(scoreFP.getProjectDeliveryQuality());
		pmScoreList.add(pmScore);
		pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.QU_POINTS_CRITICAL_EVENTS_FP);
		pmScore.setValue(scoreFP.getQuPointsCriticalEvents());
		pmScoreList.add(pmScore);
		pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.QUALITY_SCORE_FP);
		pmScore.setValue(scoreFP.getQualityScore());
		pmScoreList.add(pmScore);
	}
	
	/**
	 * TM安全
	 * @param pmScoreList
	 * @param scoreTM
	 */
	private void securityTm(List<PmScoreRes> pmScoreList,ScoreProjectSkillTM scoreTM){
		PmScoreRes pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.INFORMATION_SECURITY_TM);
		pmScore.setValue(scoreTM.getInformationSecurity());
		pmScoreList.add(pmScore);
		pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.NETWORK_SECURITY_TM);
		pmScore.setValue(scoreTM.getNetworkSecurity());
		pmScoreList.add(pmScore);
	}
	
	/**
	 * TM人资和过程
	 * @param pmScoreList
	 * @param scoreTM
	 */
	private void processAndResultsTm(List<PmScoreRes> pmScoreList,ScoreProjectSkillTM scoreTM){
		PmScoreRes pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.TASK_COMP_RATE_TIME_TM);
		pmScore.setValue(scoreTM.getTaskCompRateTime());
		pmScoreList.add(pmScore);
		pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.MISSION_PASS_RATE_TM);
		pmScore.setValue(scoreTM.getMissionPassRate());
		pmScoreList.add(pmScore);
		pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.RIDING_QUALITY_TM);
		pmScore.setValue(scoreTM.getRidingQuality());
		pmScoreList.add(pmScore);
	}
	
	/**
	 * TM人资数据
	 * @param pmScoreList
	 * @param scoreTM
	 */
	private void personManageTm(List<PmScoreRes> pmScoreList,ScoreProjectSkillTM scoreTM){
		PmScoreRes pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.PERSON_ST_SCORE_TM);
		pmScore.setValue(scoreTM.getPersonStScore());
		pmScoreList.add(pmScore);
		pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.TIMELY_ARRIVAL_RATEPER_TM);
		pmScore.setValue(scoreTM.getTimelyArrivalRatePer());
		pmScoreList.add(pmScore);
		pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.PERSON_INTERVIEW_RATE_TM);
		pmScore.setValue(scoreTM.getPersonInterviewRate());
		pmScoreList.add(pmScore);
	}
	
	/**
	 * TM满意度
	 * @param pmScoreList
	 * @param scoreTM
	 */
	private void satisFactionTm(List<PmScoreRes> pmScoreList,ScoreProjectSkillTM scoreTM){
		PmScoreRes pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.VIA_BRAINSTUCK_TM);
		pmScore.setValue(scoreTM.getViaBrainstuck());
		pmScoreList.add(pmScore);
	}
	
	/**
	 * TM质量得分
	 * @param pmScoreList
	 * @param scoreTM
	 */
	private void qualityScoreTm(List<PmScoreRes> pmScoreList,ScoreProjectSkillTM scoreTM){
		PmScoreRes pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.DELIVERY_SCHEDULE_DEV_TM);
		pmScore.setValue(scoreTM.getDeliveryScheduleDev());
		pmScoreList.add(pmScore);
		pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.PRO_DELIVERY_QUALITY_TM);
		pmScore.setValue(scoreTM.getProDeliveryQuality());
		pmScoreList.add(pmScore);
		pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.PROJECT_DELIVERY_QUALITY_TM);
		pmScore.setValue(scoreTM.getProjectDeliveryQuality());
		pmScoreList.add(pmScore);
		pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.QU_POINTS_CRITICAL_EVENTS_TM);
		pmScore.setValue(scoreTM.getQuPointsCriticalEvents());
		pmScoreList.add(pmScore);
		pmScore = new PmScoreRes();
		pmScore.setName(CommonConstant.QUALITY_SCORE_TM);
		pmScore.setValue(scoreTM.getQualityScore());
		pmScoreList.add(pmScore);
	}
}
