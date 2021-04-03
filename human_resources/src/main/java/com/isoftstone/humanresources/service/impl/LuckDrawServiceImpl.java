package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;

import com.isoftstone.humanresources.dao.EmployeeDao;
import com.isoftstone.humanresources.domain.EmployeeInformation;
import com.isoftstone.humanresources.domain.LuckDrawModel;
import com.isoftstone.humanresources.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.dao.LuckDrawDao;
import com.isoftstone.humanresources.service.LuckDrawService;

/** 
 * Description: [抽奖信息表服务实现]
 * Created on 2019年12月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2019年
 */
@Service("luckDrawService")
public class LuckDrawServiceImpl implements LuckDrawService {
	
	/**
	 * <p>Discription:[抽奖信息表dao]</p>
	 */	
	@Resource
	private LuckDrawDao luckDrawDao;

	@Resource
	private EmployeeDao employeeDao;
	/**
	 * <p>Discription:[抽奖信息表数据不分页查询]</p>
	 * Created on 2019年12月13日
	 * @param luckDrawModel 抽奖信息表数据查询条件
	 * @param queryFields 抽奖信息表数据查询字段
	 * @return List<LuckDrawModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<LuckDrawModel> queryListLuckDraw(LuckDrawModel luckDrawModel,String queryFields){
		List<LuckDrawModel> listLuckDraw = new ArrayList<LuckDrawModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listLuckDraw = this.luckDrawDao.queryListLuckDraw(luckDrawModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listLuckDraw;
	}

	/**
	 * <p>Discription:[抽奖信息表数据查询总条数]</p>
	 * Created on 2019年12月13日
	 * @param luckDrawModel 抽奖信息表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountLuckDraw(LuckDrawModel luckDrawModel){
		
		Long count = (long)0;
		try{
			count = this.luckDrawDao.queryCountLuckDraw(luckDrawModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询抽奖信息表数据]</p>
	 * Created on 2019年12月13日
	 * @param id 抽奖信息表数据id
	 * @return LuckDrawModel 单条数据	 
	 * @author:wangchun
	 */
	public LuckDrawModel queryLuckDrawById(Integer id){
		
		LuckDrawModel model = new LuckDrawModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.luckDrawDao.queryLuckDrawById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[抽奖信息表数据新增]</p>
	 * Created on 2019年12月13日
	 * @param luckDrawModel 抽奖信息表数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(LuckDrawModel luckDrawModel){
		int count = 0;
		try{
			if(Objects.isNull(luckDrawModel)){
				return 0;
			}else{
				count = this.luckDrawDao.addLuckDraw(luckDrawModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	public Result addLuckDraw(LuckDrawModel luckDrawModel){

		//1. 查找是否已经添加，根据员工ID查找，如果存在则不添加
		Result result = new Result();
//		LuckDrawModel model = luckDrawDao.queryLuckDrawById(  luckDrawModel.getEmployeeid(),null);
//		if(null != model){
//			result.setSuccess(false);
//			result.setMessage("您已经添加，请勿重复添加！");
//			return result ;
//		}
		//2. 查找是否在我们员工表里
//		EmployeeInformation queryEmployee = employeeDao.queryEmployeeInfo(luckDrawModel.getEmployeeid());
//		if(null == queryEmployee){
//			result.setSuccess(false);
//			result.setMessage("您不是我们部门员工，请核对工号是否填写正确！");
//			return result ;
//		}
		if(null == luckDrawModel.getEmployeeid()){
			luckDrawModel.setStatus("0");
		}
		//3. 不存在则添加
		int saveNum = save(luckDrawModel);
		if(0 == saveNum){
			result.setSuccess(false);
			result.setMessage("未添加成功");
		}else{
			result.setSuccess(true);
			result.setMessage("添加成功");
		}

		return result ;


	}

	/**
	 * <p>Discription:[抽奖信息表数据编辑]</p>
	 * Created on 2019年12月13日
	 * @param luckDrawModel 抽奖信息表数据
	 * @return 成功条数
	 *								    
	 * @author:wangchun
	 */
	public int edit(LuckDrawModel luckDrawModel){
		Integer count = 0;
		try{
			if(Objects.isNull(luckDrawModel) || Objects.isNull(luckDrawModel.getEmployeeid())){
				return 0;
			}else{
				count = this.luckDrawDao.updateLuckDraw(luckDrawModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[抽奖信息表数据删除]</p>
	 * Created on 2019年12月13日
	 * @param id 抽奖信息表数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeLuckDrawById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.luckDrawDao.removeLuckDrawById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[抽奖信息表数据批量删除]</p>
	 * Created on 2019年12月13日
	 * @param ids 抽奖信息表数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeLuckDrawByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.luckDrawDao.removeLuckDrawByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	public int queryLuckDrawByName(String employeeName){
		Integer count = 0;
		try{
			if(Objects.isNull(employeeName)){
				return 0;
			}else{
				count = this.luckDrawDao.queryLuckDrawByName(employeeName);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
