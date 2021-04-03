package com.isoftstone.humanresources.service;

import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.QuestionAnswerInfomation;
import com.isoftstone.humanresources.domain.questionanswer.QuestionAnswerRequest;

/**
 * 问题反馈service接口
 * @author bwning
 *
 */
public interface QuestionAnswerService {

	/**
	 * 问题反馈新增
	 * @param QuestionAnswerInfomation
	 * @return
	 */
	boolean addQuestionAnswer(QuestionAnswerInfomation questionAnswerInfomation);

	/**
	 * 问题反馈修改
	 * @param QuestionAnswerInfomation
	 * @return
	 */
	boolean updateQuestionAnswer(QuestionAnswerInfomation questionAnswerInfomation);
	
	/**
	 * 分页查询问题单
	 * @param questionAnswerInfomation
	 * @return
	 * @throws Exception
	 */
	PageInfo<QuestionAnswerInfomation> queryListQuestion(QuestionAnswerRequest questionAnswerRequest);
}
