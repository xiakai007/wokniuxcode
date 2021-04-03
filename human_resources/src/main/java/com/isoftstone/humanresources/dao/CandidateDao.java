package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.recruit.CandidateModel;
import java.util.List;

import com.isoftstone.humanresources.domain.recruit.QueryCandidateRequest;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [候选人信息表dao]</p>
 * Created on 2019年11月04日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2019年
 */
public interface CandidateDao{

	/**
	 * 分页查询候选人列表
	 * @param queryCandidateRequest
	 * @return
	 * @throws Exception
	 */
	List<CandidateModel> queryCandidate(QueryCandidateRequest queryCandidateRequest) throws Exception;

	/**
	 * 新增候选人
	 * @param candidateModel
	 * @throws Exception
	 */
	void addCandidate(CandidateModel candidateModel) throws Exception;

	/**
	 * 更新候选人
	 * @param candidateModel
	 * @throws Exception
	 */
	void updateCandidate(CandidateModel candidateModel)throws Exception;


}
