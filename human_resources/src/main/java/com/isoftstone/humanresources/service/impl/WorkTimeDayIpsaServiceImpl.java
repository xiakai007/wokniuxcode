package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.dao.WorkTimeDayIpsaDao;
import com.isoftstone.humanresources.domain.workTime.WorkTimeDayIpsaModel;
import com.isoftstone.humanresources.service.WorkTimeDayIpsaService;

/** 
 * Description: [员工IPSA日考勤记录服务实现]
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("workTimeDayIpsaService")
public class WorkTimeDayIpsaServiceImpl implements WorkTimeDayIpsaService {
	
	/**
	 * <p>Discription:[员工IPSA日考勤记录dao]</p>
	 */	
	@Resource
	private WorkTimeDayIpsaDao workTimeDayIpsaDao;
	
	/**
	 * <p>Discription:[员工IPSA日考勤记录数据分页查询]</p>
	 * Created on 2020年10月13日
	 * @param page 员工IPSA日考勤记录数据分页条件
	 * @param workTimeDayIpsaModel 员工IPSA日考勤记录数据查询条件
	 * @param queryFields 员工IPSA日考勤记录数据查询字段
	 * @return List<WorkTimeDayIpsaModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<WorkTimeDayIpsaModel> queryPageWorkTimeDayIpsa(Page page,WorkTimeDayIpsaModel workTimeDayIpsaModel,
			String queryFields){
			
		List<WorkTimeDayIpsaModel> listWorkTimeDayIpsa = new ArrayList<WorkTimeDayIpsaModel>();
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
				listWorkTimeDayIpsa = this.workTimeDayIpsaDao.queryPageWorkTimeDayIpsa(page,workTimeDayIpsaModel,lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listWorkTimeDayIpsa;
	}

	/**
	 * <p>Discription:[员工IPSA日考勤记录数据不分页查询]</p>
	 * Created on 2020年10月13日
	 * @param workTimeDayIpsaModel 员工IPSA日考勤记录数据查询条件
	 * @param queryFields 员工IPSA日考勤记录数据查询字段
	 * @return List<WorkTimeDayIpsaModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<WorkTimeDayIpsaModel> queryListWorkTimeDayIpsa(WorkTimeDayIpsaModel workTimeDayIpsaModel,String queryFields){
		List<WorkTimeDayIpsaModel> listWorkTimeDayIpsa = new ArrayList<WorkTimeDayIpsaModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listWorkTimeDayIpsa = this.workTimeDayIpsaDao.queryListWorkTimeDayIpsa(workTimeDayIpsaModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listWorkTimeDayIpsa;
	}

	/**
	 * <p>Discription:[员工IPSA日考勤记录数据查询总条数]</p>
	 * Created on 2020年10月13日
	 * @param workTimeDayIpsaModel 员工IPSA日考勤记录数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountWorkTimeDayIpsa(WorkTimeDayIpsaModel workTimeDayIpsaModel){
		
		Long count = (long)0;
		try{
			count = this.workTimeDayIpsaDao.queryCountWorkTimeDayIpsa(workTimeDayIpsaModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询员工IPSA日考勤记录数据]</p>
	 * Created on 2020年10月13日
	 * @param id 员工IPSA日考勤记录数据id
	 * @return WorkTimeDayIpsaModel 单条数据	 
	 * @author:wangchun
	 */
	public WorkTimeDayIpsaModel queryWorkTimeDayIpsaById(Long id){
		
		WorkTimeDayIpsaModel model = new WorkTimeDayIpsaModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.workTimeDayIpsaDao.queryWorkTimeDayIpsaById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[员工IPSA日考勤记录数据新增]</p>
	 * Created on 2020年10月13日
	 * @param workTimeDayIpsaModel 员工IPSA日考勤记录数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(WorkTimeDayIpsaModel workTimeDayIpsaModel){
		int count = 0;
		try{
			if(Objects.isNull(workTimeDayIpsaModel)){
				return 0;
			}else{
				count = this.workTimeDayIpsaDao.addWorkTimeDayIpsa(workTimeDayIpsaModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[员工IPSA日考勤记录数据编辑]</p>
	 * Created on 2020年10月13日
	 * @param workTimeDayIpsaModel 员工IPSA日考勤记录数据
	 * @return 成功条数 	
	 *								    
	 * @author:wangchun
	 */
	public int edit(WorkTimeDayIpsaModel workTimeDayIpsaModel){
		Integer count = 0;
		try{
			if(Objects.isNull(workTimeDayIpsaModel) || Objects.isNull(workTimeDayIpsaModel.getEmployeeid())){
				return 0;
			}else{
				count = this.workTimeDayIpsaDao.updateWorkTimeDayIpsa(workTimeDayIpsaModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[员工IPSA日考勤记录数据删除]</p>
	 * Created on 2020年10月13日
	 * @param id 员工IPSA日考勤记录数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeWorkTimeDayIpsaById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.workTimeDayIpsaDao.removeWorkTimeDayIpsaById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[员工IPSA日考勤记录数据批量删除]</p>
	 * Created on 2020年10月13日
	 * @param ids 员工IPSA日考勤记录数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeWorkTimeDayIpsaByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.workTimeDayIpsaDao.removeWorkTimeDayIpsaByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
