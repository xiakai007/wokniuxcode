package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.dao.WorkTimeMonthIpsaDao;
import com.isoftstone.humanresources.domain.workTime.WorkTimeMonthIpsaModel;
import com.isoftstone.humanresources.service.WorkTimeMonthIpsaService;

/** 
 * Description: [员工IPSA月考勤记录服务实现]
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("workTimeMonthIpsaService")
public class WorkTimeMonthIpsaServiceImpl implements WorkTimeMonthIpsaService {
	
	/**
	 * <p>Discription:[员工IPSA月考勤记录dao]</p>
	 */	
	@Resource
	private WorkTimeMonthIpsaDao workTimeMonthIpsaDao;
	
	/**
	 * <p>Discription:[员工IPSA月考勤记录数据分页查询]</p>
	 * Created on 2020年10月13日
	 * @param page 员工IPSA月考勤记录数据分页条件
	 * @param workTimeMonthIpsaModel 员工IPSA月考勤记录数据查询条件
	 * @param queryFields 员工IPSA月考勤记录数据查询字段
	 * @return List<WorkTimeMonthIpsaModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<WorkTimeMonthIpsaModel> queryPageWorkTimeMonthIpsa(Page page,WorkTimeMonthIpsaModel workTimeMonthIpsaModel,
			String queryFields){
			
		List<WorkTimeMonthIpsaModel> listWorkTimeMonthIpsa = new ArrayList<WorkTimeMonthIpsaModel>();
		try{
			//判断参数是否为空
			if(Objects.isNull(page)){
				return null;
			}else{
				List<String> lis = new ArrayList<String>();
				if(Objects.isNull(queryFields)){
					lis = null;
				}else{
					lis = Arrays.asList(queryFields.split(","));
				}
				listWorkTimeMonthIpsa = this.workTimeMonthIpsaDao.queryPageWorkTimeMonthIpsa(page,workTimeMonthIpsaModel,lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listWorkTimeMonthIpsa;
	}

	/**
	 * <p>Discription:[员工IPSA月考勤记录数据不分页查询]</p>
	 * Created on 2020年10月13日
	 * @param workTimeMonthIpsaModel 员工IPSA月考勤记录数据查询条件
	 * @param queryFields 员工IPSA月考勤记录数据查询字段
	 * @return List<WorkTimeMonthIpsaModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<WorkTimeMonthIpsaModel> queryListWorkTimeMonthIpsa(WorkTimeMonthIpsaModel workTimeMonthIpsaModel,String queryFields){
		List<WorkTimeMonthIpsaModel> listWorkTimeMonthIpsa = new ArrayList<WorkTimeMonthIpsaModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listWorkTimeMonthIpsa = this.workTimeMonthIpsaDao.queryListWorkTimeMonthIpsa(workTimeMonthIpsaModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listWorkTimeMonthIpsa;
	}

	/**
	 * <p>Discription:[员工IPSA月考勤记录数据查询总条数]</p>
	 * Created on 2020年10月13日
	 * @param workTimeMonthIpsaModel 员工IPSA月考勤记录数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountWorkTimeMonthIpsa(WorkTimeMonthIpsaModel workTimeMonthIpsaModel){
		
		Long count = (long)0;
		try{
			count = this.workTimeMonthIpsaDao.queryCountWorkTimeMonthIpsa(workTimeMonthIpsaModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询员工IPSA月考勤记录数据]</p>
	 * Created on 2020年10月13日
	 * @param id 员工IPSA月考勤记录数据id
	 * @return WorkTimeMonthIpsaModel 单条数据	 
	 * @author:wangchun
	 */
	public WorkTimeMonthIpsaModel queryWorkTimeMonthIpsaById(Long id){
		
		WorkTimeMonthIpsaModel model = new WorkTimeMonthIpsaModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.workTimeMonthIpsaDao.queryWorkTimeMonthIpsaById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[员工IPSA月考勤记录数据新增]</p>
	 * Created on 2020年10月13日
	 * @param workTimeMonthIpsaModel 员工IPSA月考勤记录数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(WorkTimeMonthIpsaModel workTimeMonthIpsaModel){
		int count = 0;
		try{
			if(Objects.isNull(workTimeMonthIpsaModel)){
				return 0;
			}else{
				count = this.workTimeMonthIpsaDao.addWorkTimeMonthIpsa(workTimeMonthIpsaModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[员工IPSA月考勤记录数据编辑]</p>
	 * Created on 2020年10月13日
	 * @param workTimeMonthIpsaModel 员工IPSA月考勤记录数据
	 * @return 成功条数 	
	 *								    
	 * @author:wangchun
	 */
	public int edit(WorkTimeMonthIpsaModel workTimeMonthIpsaModel){
		Integer count = 0;
		try{
			if(Objects.isNull(workTimeMonthIpsaModel) || Objects.isNull(workTimeMonthIpsaModel.getEmployeeid())){
				return 0;
			}else{
				count = this.workTimeMonthIpsaDao.updateWorkTimeMonthIpsa(workTimeMonthIpsaModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[员工IPSA月考勤记录数据删除]</p>
	 * Created on 2020年10月13日
	 * @param id 员工IPSA月考勤记录数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeWorkTimeMonthIpsaById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.workTimeMonthIpsaDao.removeWorkTimeMonthIpsaById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[员工IPSA月考勤记录数据批量删除]</p>
	 * Created on 2020年10月13日
	 * @param ids 员工IPSA月考勤记录数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeWorkTimeMonthIpsaByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.workTimeMonthIpsaDao.removeWorkTimeMonthIpsaByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
