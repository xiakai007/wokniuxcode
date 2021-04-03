package com.isoftstone.humanresources.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.annotation.Resource;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.dao.CandidateDao;
import com.isoftstone.humanresources.dao.InterviewRecordDao;
import com.isoftstone.humanresources.domain.Result;
import com.isoftstone.humanresources.domain.recruit.CandidateModel;
import com.isoftstone.humanresources.domain.recruit.InterviewRecordModel;
import com.isoftstone.humanresources.domain.recruit.QueryCandidateRequest;
import com.isoftstone.humanresources.service.CandidateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/** 
 * Description: [候选人信息表服务实现]
 * Created on 2019年11月04日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2019年
 */
@Service("candidateService")
public class CandidateServiceImpl implements CandidateService {
	private final static Logger logger = LoggerFactory.getLogger(CandidateService.class);
	/**
	 * <p>Discription:[候选人信息表dao]</p>
	 */	
	@Resource
	private CandidateDao candidateDao;

	@Resource
	private InterviewRecordDao interviewRecordDao;

	/**
	 * 分页查询候选人列表
	 * @param queryCandidateRequest
	 * @return
	 * @throws Exception
	 */
	public PageInfo<CandidateModel> queryCandidate(QueryCandidateRequest queryCandidateRequest) throws Exception{

		PageInfo<CandidateModel> candidateModelPageInfo = new PageInfo<>();
		try {
			Integer page = queryCandidateRequest.getPage();                     //当前页
			Integer pageSize = queryCandidateRequest.getPageSize();          //每页显示的条数
			if (null != page && pageSize != null) {
				PageHelper.startPage(page, pageSize);                       //分页
				//调用dao接口查询用户组分页信息
				List<CandidateModel> candidateModels = candidateDao.queryCandidate(queryCandidateRequest);
				if (candidateModels != null && candidateModels.size() > 0) {
					for(CandidateModel model:candidateModels){
						List<InterviewRecordModel>  interviewRecordModelList = interviewRecordDao.queryByCandidateID(model.getCandidateID()+ "");
						if(!CollectionUtils.isEmpty(interviewRecordModelList)){
							model.setInterviewRecordModelList(interviewRecordModelList);
						}
					}
					candidateModelPageInfo = new PageInfo<>(candidateModels);
				}
			}
		} catch (Exception e) {
			logger.error("-----查询候选人列表信息异常--------", e);
		}
		return candidateModelPageInfo;

	}

	/**
	 * 新增候选人信息
	 * @param candidateModel
	 * @throws Exception
	 */
	public Result addCandidate(CandidateModel candidateModel) throws Exception{
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String createTime = format.format(new Date());
			candidateModel.setCreateTime(createTime);
			//调用dao新增用户组
			candidateDao.addCandidate(candidateModel);
			return new Result(true,"新增候选人成功");
		} catch (Exception e) {
			logger.error("-----新增候选人异常--------", e);
		}
		return new Result(false,"新增候选人失败");
	}

	/**
	 * 更新候选人信息
	 */
	public Result updateCandidate(CandidateModel candidateModel)throws Exception{
		try {
			//调用dao更新用户组
			candidateDao.updateCandidate(candidateModel);
			return new Result(true,"更新候选人成功");
		} catch (Exception e) {
			logger.error("-----更新候选人异常--------", e);
		}
		return new Result(false,"更新候选人失败");
	}

	/**
	 * 查询候选人面试信息
	 */
	public List<InterviewRecordModel> queryListByID(String userID, String userType){
		List<InterviewRecordModel> interviewRecordModelList = null;
		//根据userType判断查询候选人信息还是员工信息
		try {
			interviewRecordModelList = interviewRecordDao.queryByCandidateID(userID);
		} catch (Exception e) {
			logger.error("-----查询候选人面试信息异常--------", e);
		}
		return interviewRecordModelList;
	}

	/**
	 * 新增候选人面试记录信息
	 * @param interviewRecordModel
	 * @throws Exception
	 */
	public Result addInterview(InterviewRecordModel interviewRecordModel) throws Exception{
		try {
			//调用dao新增面试记录
			interviewRecordDao.addInterviewRecord(interviewRecordModel);
			return new Result(true,"新增候选人面试记录成功");
		} catch (Exception e) {
			logger.error("-----新增候选人面试记录异常--------", e);
		}
		return new Result(false,"新增候选人面试记录失败");
	}
}
