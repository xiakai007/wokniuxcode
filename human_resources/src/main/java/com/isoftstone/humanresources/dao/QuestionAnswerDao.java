package com.isoftstone.humanresources.dao;

import java.util.List;

import com.isoftstone.humanresources.domain.QuestionAnswerInfomation;
import com.isoftstone.humanresources.domain.questionanswer.QuestionAnswerRequest;

/**
 * 问题反馈dao
 * @author bwning
 *
 */
public interface QuestionAnswerDao {
	
	/**
	 * 问题反馈新增
	 * @param QuestionAnswerInfomation
	 * @return
	 */
	int addQuestionAnswer(QuestionAnswerInfomation questionAnswerInfomation);

	/**
	 * 问题反馈修改
	 * @param QuestionAnswerInfomation
	 * @return
	 */
	int updateQuestionAnswer(QuestionAnswerInfomation questionAnswerInfomation);
	
	/**
	 * 查询问题集合
	 * @return
	 */
	List<QuestionAnswerInfomation> queryListQuestion(QuestionAnswerRequest questionAnswerRequest);
}
