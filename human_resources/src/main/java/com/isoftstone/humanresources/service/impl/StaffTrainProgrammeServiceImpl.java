package com.isoftstone.humanresources.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoftstone.humanresources.dao.StaffTrainProgrammeDao;
import com.isoftstone.humanresources.domain.EmployeeTrainProgramInformation;
import com.isoftstone.humanresources.domain.organization.QueryEmpForProjectVO;
import com.isoftstone.humanresources.domain.portraitprojectmanager.PmScoreRes;
import com.isoftstone.humanresources.service.StaffTrainProgrammeService;
import com.isoftstone.humanresources.util.CommonConstant;
import com.isoftstone.humanresources.util.StringUtil;

@Service(value="StaffTrainProgrammeService")
public class StaffTrainProgrammeServiceImpl implements StaffTrainProgrammeService{

	@Autowired
	private StaffTrainProgrammeDao staffTrainProgrammeDao;
	@Override
	public Map<String, Object> addTrainProgram(EmployeeTrainProgramInformation etpInfo) {
		boolean flag = false;
        Map<String, Object> map = new HashMap<>();
		try {
			int result = staffTrainProgrammeDao.addTrainProgram(etpInfo);
			if(result == 0){
				map.put(CommonConstant.RETURN_STATUS, flag);
				map.put(CommonConstant.RETURN_MESSAGE, "新增失败");
				return map;
			}
			flag = true;
			map.put(CommonConstant.RETURN_STATUS, flag);
			map.put(CommonConstant.RETURN_MESSAGE, "新增成功");
		} catch (Exception e) {
			flag = false;
			map.put(CommonConstant.RETURN_STATUS, flag);
			map.put(CommonConstant.RETURN_MESSAGE, e.toString());
		}
		return map;
	}
	@Override
	public List<EmployeeTrainProgramInformation> queryPlanById(String id,String projectTeam) {
		String des = "";
		PmScoreRes train = null;
		if(StringUtil.isEmpty(id)){
			des = "ORDER BY updateTime DESC";
		}
		List<EmployeeTrainProgramInformation> trainList = 
				staffTrainProgrammeDao.queryPlanById(id,projectTeam,des);
		//封装前台返回数据
		for (EmployeeTrainProgramInformation etpInfo : trainList) {
			train = new PmScoreRes();
			train.setValue(etpInfo.getTrainCompleteness());
			train.setName(this.replace(String.valueOf(etpInfo.getTrainCompleteness()))+"%");
			etpInfo.setTrain(train);
		}
		return trainList;
	}
	@Override
	public Map<String, Object> updateTrainProgram(EmployeeTrainProgramInformation etpInfo) {
		boolean flag = false;
        Map<String, Object> map = new HashMap<>();
		try {
			int result = staffTrainProgrammeDao.updateTrainProgram(etpInfo);
			if(result == 0){
				map.put(CommonConstant.RETURN_STATUS, flag);
				map.put(CommonConstant.RETURN_MESSAGE, "修改失败");
				return map;
			}
			flag = true;
			map.put(CommonConstant.RETURN_STATUS, flag);
			map.put(CommonConstant.RETURN_MESSAGE, "修改成功");
		} catch (Exception e) {
			flag = false;
			map.put(CommonConstant.RETURN_STATUS, flag);
			map.put(CommonConstant.RETURN_MESSAGE, e.toString());
		}
		return map;
	}
	@Override
	public List<QueryEmpForProjectVO> queryEmpProject(String leader) {
		return staffTrainProgrammeDao.queryEmpProject(leader);
	}

	 /** 
     * 使用java正则表达式去掉多余的.与0 
     * @param s 
     * @return  string
     */  
    private String replace(String s){  
        if(null != s && s.indexOf(".") > 0){  
            s = s.replaceAll("0+?$", "");//去掉多余的0  
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉  
        }  
        return s;  
    }   
}
