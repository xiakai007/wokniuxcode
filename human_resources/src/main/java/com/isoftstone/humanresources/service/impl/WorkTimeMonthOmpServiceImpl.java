package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.dao.WorkTimeMonthOmpDao;
import com.isoftstone.humanresources.domain.workTime.WorkTimeMonthOmpModel;
import com.isoftstone.humanresources.service.WorkTimeMonthOmpService;

/** 
 * Description: [员工OMP月考勤记录服务实现]
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("workTimeMonthOmpService")
public class WorkTimeMonthOmpServiceImpl implements WorkTimeMonthOmpService {
	
	/**
	 * <p>Discription:[员工OMP月考勤记录dao]</p>
	 */	
	@Resource
	private WorkTimeMonthOmpDao workTimeMonthOmpDao;
	
	/**
	 * <p>Discription:[员工OMP月考勤记录数据分页查询]</p>
	 * Created on 2020年10月13日
	 * @param page 员工OMP月考勤记录数据分页条件
	 * @param workTimeMonthOmpModel 员工OMP月考勤记录数据查询条件
	 * @param queryFields 员工OMP月考勤记录数据查询字段
	 * @return List<WorkTimeMonthOmpModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<WorkTimeMonthOmpModel> queryPageWorkTimeMonthOmp(Page page,WorkTimeMonthOmpModel workTimeMonthOmpModel,
			String queryFields){
			
		List<WorkTimeMonthOmpModel> listWorkTimeMonthOmp = new ArrayList<WorkTimeMonthOmpModel>();
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
				listWorkTimeMonthOmp = this.workTimeMonthOmpDao.queryPageWorkTimeMonthOmp(page,workTimeMonthOmpModel,lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listWorkTimeMonthOmp;
	}

	/**
	 * <p>Discription:[员工OMP月考勤记录数据不分页查询]</p>
	 * Created on 2020年10月13日
	 * @param workTimeMonthOmpModel 员工OMP月考勤记录数据查询条件
	 * @param queryFields 员工OMP月考勤记录数据查询字段
	 * @return List<WorkTimeMonthOmpModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<WorkTimeMonthOmpModel> queryListWorkTimeMonthOmp(WorkTimeMonthOmpModel workTimeMonthOmpModel,String queryFields){
		List<WorkTimeMonthOmpModel> listWorkTimeMonthOmp = new ArrayList<WorkTimeMonthOmpModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listWorkTimeMonthOmp = this.workTimeMonthOmpDao.queryListWorkTimeMonthOmp(workTimeMonthOmpModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listWorkTimeMonthOmp;
	}

	/**
	 * <p>Discription:[员工OMP月考勤记录数据查询总条数]</p>
	 * Created on 2020年10月13日
	 * @param workTimeMonthOmpModel 员工OMP月考勤记录数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountWorkTimeMonthOmp(WorkTimeMonthOmpModel workTimeMonthOmpModel){
		
		Long count = (long)0;
		try{
			count = this.workTimeMonthOmpDao.queryCountWorkTimeMonthOmp(workTimeMonthOmpModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询员工OMP月考勤记录数据]</p>
	 * Created on 2020年10月13日
	 * @param id 员工OMP月考勤记录数据id
	 * @return WorkTimeMonthOmpModel 单条数据	 
	 * @author:wangchun
	 */
	public WorkTimeMonthOmpModel queryWorkTimeMonthOmpById(Long id){
		
		WorkTimeMonthOmpModel model = new WorkTimeMonthOmpModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.workTimeMonthOmpDao.queryWorkTimeMonthOmpById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[员工OMP月考勤记录数据新增]</p>
	 * Created on 2020年10月13日
	 * @param workTimeMonthOmpModel 员工OMP月考勤记录数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(WorkTimeMonthOmpModel workTimeMonthOmpModel){
		int count = 0;
		try{
			if(Objects.isNull(workTimeMonthOmpModel)){
				return 0;
			}else{
				count = this.workTimeMonthOmpDao.addWorkTimeMonthOmp(workTimeMonthOmpModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[员工OMP月考勤记录数据编辑]</p>
	 * Created on 2020年10月13日
	 * @param workTimeMonthOmpModel 员工OMP月考勤记录数据
	 * @return 成功条数 	
	 *								    
	 * @author:wangchun
	 */
	public int edit(WorkTimeMonthOmpModel workTimeMonthOmpModel){
		Integer count = 0;
		try{
			if(Objects.isNull(workTimeMonthOmpModel) || Objects.isNull(workTimeMonthOmpModel.getEmployeeid())){
				return 0;
			}else{
				count = this.workTimeMonthOmpDao.updateWorkTimeMonthOmp(workTimeMonthOmpModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[员工OMP月考勤记录数据删除]</p>
	 * Created on 2020年10月13日
	 * @param id 员工OMP月考勤记录数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeWorkTimeMonthOmpById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.workTimeMonthOmpDao.removeWorkTimeMonthOmpById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[员工OMP月考勤记录数据批量删除]</p>
	 * Created on 2020年10月13日
	 * @param ids 员工OMP月考勤记录数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeWorkTimeMonthOmpByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.workTimeMonthOmpDao.removeWorkTimeMonthOmpByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
