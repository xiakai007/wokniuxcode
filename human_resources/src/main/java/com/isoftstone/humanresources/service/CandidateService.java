package com.isoftstone.humanresources.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.Result;
import com.isoftstone.humanresources.domain.recruit.CandidateModel;
import com.isoftstone.humanresources.domain.recruit.InterviewRecordModel;
import com.isoftstone.humanresources.domain.recruit.QueryCandidateRequest;

/**
 * Description: [候选人信息表服务]
 * Created on 2019年11月04日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2019年
 */
public interface CandidateService {

	/**
	 * 分页查询候选人列表
	 * @param queryCandidateRequest
	 * @return
	 * @throws Exception
	 */
	PageInfo<CandidateModel> queryCandidate(QueryCandidateRequest queryCandidateRequest) throws Exception;

	/**
	 * 新增候选人信息
	 * @param candidateModel
	 * @throws Exception
	 */
	Result addCandidate(CandidateModel candidateModel) throws Exception;

	/**
	 * 更新候选人信息
	 */
	Result updateCandidate(CandidateModel candidateModel) throws Exception;

	/**
	 * 根据候选人ID或员工ID查询面试记录信息
	 * @param userID
	 * @param userType
	 * @return
	 */
	List<InterviewRecordModel> queryListByID(String userID,String userType);

	/**
	 * 新增候选人信息
	 * @param interviewRecordModel
	 * @throws Exception
	 */
	Result addInterview(InterviewRecordModel interviewRecordModel) throws Exception;

}
