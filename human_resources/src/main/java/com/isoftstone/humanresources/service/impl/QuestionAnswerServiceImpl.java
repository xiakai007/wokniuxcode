package com.isoftstone.humanresources.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.dao.QuestionAnswerDao;
import com.isoftstone.humanresources.dao.SystemConfigDao;
import com.isoftstone.humanresources.domain.QuestionAnswerInfomation;
import com.isoftstone.humanresources.domain.SystemConfigInformation;
import com.isoftstone.humanresources.domain.questionanswer.QuestionAnswerRequest;
import com.isoftstone.humanresources.service.QuestionAnswerService;
import com.isoftstone.humanresources.util.StringUtil;

@Service(value = "QuestionAnswerService")
public class QuestionAnswerServiceImpl implements QuestionAnswerService{

	@Autowired
	private QuestionAnswerDao questionAnswerDao;
	
	@Autowired
	private SystemConfigDao systemConfigDao;
	@Override
	public boolean addQuestionAnswer(QuestionAnswerInfomation questionAnswerInfomation) {
		boolean flag;
		StringBuilder stb = new StringBuilder();
		try {
			List<String> strList = questionAnswerInfomation.getImgList();
			if(!strList.isEmpty()){
				for (String str : strList) {
					stb.append(str+",,");
				}
			}
			questionAnswerInfomation.setImgURL(stb.toString());
			int result = questionAnswerDao.addQuestionAnswer(questionAnswerInfomation);
			if(result == 0)
			{
				flag = false;
				return flag;
			}
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean updateQuestionAnswer(QuestionAnswerInfomation questionAnswerInfomation) {
		boolean flag;
		StringBuilder stb = new StringBuilder();
		try {
			List<String> strList = questionAnswerInfomation.getImgList();
			if(!strList.isEmpty()){
				for (String str : strList) {
					stb.append(str+",,");
				}
			}
			questionAnswerInfomation.setImgURL(stb.toString());
			int result = questionAnswerDao.updateQuestionAnswer(questionAnswerInfomation);
			if(result == 0)
			{
				flag = false;
				return flag;
			}
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		
		return flag;
	}

	@Override
	public PageInfo<QuestionAnswerInfomation> queryListQuestion(QuestionAnswerRequest questionAnswerRequest){
    PageInfo<QuestionAnswerInfomation> questPageInfo = new PageInfo<>();
        Integer page = questionAnswerRequest.getPage();                     //当前页
        Integer pageSize = questionAnswerRequest.getPageSize();             //每页显示的条数
        if((!StringUtil.isEmpty(questionAnswerRequest.getStartTime())) && (!StringUtil.isEmpty(questionAnswerRequest.getEndTime()))){
        	questionAnswerRequest.setStartTime(questionAnswerRequest.getStartTime()+" 00:00:00");
        	questionAnswerRequest.setEndTime(questionAnswerRequest.getEndTime()+" 23:59:59");
        }
        if (page != null && pageSize != null) {
            PageHelper.startPage(page, pageSize);                     //分页
            //调用dao接口查询用户列表
            List<QuestionAnswerInfomation> queryList = questionAnswerDao.queryListQuestion(questionAnswerRequest);
            if (!queryList.isEmpty()) {
            	this.getListUrl(queryList,questionAnswerRequest);
            	questPageInfo = new PageInfo<>(queryList);
            }
        }
    return questPageInfo;
	}

	/**
	 * 图片地址拆分
	 * @param queryList
	 * @return
	 */
	private List<QuestionAnswerInfomation> getListUrl(List<QuestionAnswerInfomation> queryList,QuestionAnswerRequest questionAnswerRequest){
		List<String> strList = null;
		List<SystemConfigInformation> listSys = systemConfigDao.queryConfigByType("headPerson");
		List<String> listEmp = new ArrayList<>();
		for (SystemConfigInformation sys : listSys) {
			listEmp.add(sys.getConfigName());
		}
		for (QuestionAnswerInfomation question : queryList) {
			strList = new ArrayList<>();
			String [] str= question.getImgURL().split(",,");
			for(int i = 0; i < str.length;i++){
				strList.add(str[i]);
			}
			if(listEmp.contains(questionAnswerRequest.getJobNumber())){
				question.setISGroup(true);
			}else{
				question.setISGroup(false);
			}
			question.setImgList(strList);
		}
		return queryList;
	}
}
