package com.isoftstone.humanresources.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.QuestionAnswerInfomation;
import com.isoftstone.humanresources.domain.questionanswer.QuestionAnswerRequest;
import com.isoftstone.humanresources.service.QuestionAnswerService;
import com.isoftstone.humanresources.util.CommonConstant;

import io.swagger.annotations.Api;

@Controller
@RequestMapping(value = "/hr_manager/questionanswer")
@Api(value = "问题反馈API")
public class QuestionAnswerController {

	@Autowired
	private QuestionAnswerService questionAnswerService;
	
	/**
	 * 问题反馈新增接口
	 * @param questionAnswerInfomation
	 * @return
	 */
	@CrossOrigin
	@PostMapping(path = "/add_question_answer")
	public ResponseEntity<Map<String, Object>> addQuestionAnswer(@RequestBody QuestionAnswerInfomation questionAnswerInfomation){
		Map<String, Object> map = new HashMap<>();
		try {
			boolean flag = questionAnswerService.addQuestionAnswer(questionAnswerInfomation);
			if(flag){
				map.put(CommonConstant.RETURN_STATUS, flag);
				map.put(CommonConstant.RETURN_MESSAGE, "问题反馈成功！感谢你的反馈！");
				return new ResponseEntity<>(map, HttpStatus.OK);
			}
			map.put(CommonConstant.RETURN_STATUS, flag);
			map.put(CommonConstant.RETURN_MESSAGE, "问题反馈失败！请重试！");
		} catch (Exception e) {
			map.put(CommonConstant.RETURN_STATUS, false);
			map.put(CommonConstant.RETURN_MESSAGE, e.getMessage());
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	/**
	 * 问题反馈修改接口
	 * @param questionAnswerInfomation
	 * @return
	 */
	@CrossOrigin
	@PostMapping(path = "/update_question_answer")
	public ResponseEntity<Map<String, Object>> updateQuestionAnswer(@RequestBody QuestionAnswerInfomation questionAnswerInfomation){
		Map<String, Object> map = new HashMap<>();
		boolean flag = false;
		try {
			flag = questionAnswerService.updateQuestionAnswer(questionAnswerInfomation);
			if(flag){
				map.put(CommonConstant.RETURN_STATUS, flag);
				map.put(CommonConstant.RETURN_MESSAGE, "修改成功");
				return new ResponseEntity<>(map, HttpStatus.OK);
			}
			map.put(CommonConstant.RETURN_STATUS, flag);
			map.put(CommonConstant.RETURN_MESSAGE, "修改失败");
		} catch (Exception e) {
			map.put(CommonConstant.RETURN_STATUS, false);
			map.put(CommonConstant.RETURN_MESSAGE, e.getMessage());
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	/**
	 * 问题反馈列表查询
	 * @param questionAnswerRequest
	 * @return
	 */
	@CrossOrigin
	@PostMapping(path = "/query_list_question")
	public ResponseEntity<PageInfo<QuestionAnswerInfomation>> queryListQuestion(@RequestBody QuestionAnswerRequest questionAnswerRequest){
		PageInfo<QuestionAnswerInfomation> questionPageInfo = null;
			questionPageInfo = questionAnswerService.queryListQuestion(questionAnswerRequest);
		return new ResponseEntity<>(questionPageInfo, HttpStatus.OK);
	}
}
