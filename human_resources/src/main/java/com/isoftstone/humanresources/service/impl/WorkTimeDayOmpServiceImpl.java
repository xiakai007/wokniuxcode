package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.dao.WorkTimeDayOmpDao;
import com.isoftstone.humanresources.domain.workTime.WorkTimeDayOmpModel;
import com.isoftstone.humanresources.service.WorkTimeDayOmpService;

/** 
 * Description: [员工OMP日考勤记录服务实现]
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("workTimeDayOmpService")
public class WorkTimeDayOmpServiceImpl implements WorkTimeDayOmpService {
	
	/**
	 * <p>Discription:[员工OMP日考勤记录dao]</p>
	 */	
	@Resource
	private WorkTimeDayOmpDao workTimeDayOmpDao;
	
	/**
	 * <p>Discription:[员工OMP日考勤记录数据分页查询]</p>
	 * Created on 2020年10月13日
	 * @param page 员工OMP日考勤记录数据分页条件
	 * @param workTimeDayOmpModel 员工OMP日考勤记录数据查询条件
	 * @param queryFields 员工OMP日考勤记录数据查询字段
	 * @return List<WorkTimeDayOmpModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<WorkTimeDayOmpModel> queryPageWorkTimeDayOmp(Page page,WorkTimeDayOmpModel workTimeDayOmpModel,
			String queryFields){
			
		List<WorkTimeDayOmpModel> listWorkTimeDayOmp = new ArrayList<WorkTimeDayOmpModel>();
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
				listWorkTimeDayOmp = this.workTimeDayOmpDao.queryPageWorkTimeDayOmp(page,workTimeDayOmpModel,lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listWorkTimeDayOmp;
	}

	/**
	 * <p>Discription:[员工OMP日考勤记录数据不分页查询]</p>
	 * Created on 2020年10月13日
	 * @param workTimeDayOmpModel 员工OMP日考勤记录数据查询条件
	 * @param queryFields 员工OMP日考勤记录数据查询字段
	 * @return List<WorkTimeDayOmpModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<WorkTimeDayOmpModel> queryListWorkTimeDayOmp(WorkTimeDayOmpModel workTimeDayOmpModel,String queryFields){
		List<WorkTimeDayOmpModel> listWorkTimeDayOmp = new ArrayList<WorkTimeDayOmpModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listWorkTimeDayOmp = this.workTimeDayOmpDao.queryListWorkTimeDayOmp(workTimeDayOmpModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listWorkTimeDayOmp;
	}

	/**
	 * <p>Discription:[员工OMP日考勤记录数据查询总条数]</p>
	 * Created on 2020年10月13日
	 * @param workTimeDayOmpModel 员工OMP日考勤记录数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountWorkTimeDayOmp(WorkTimeDayOmpModel workTimeDayOmpModel){
		
		Long count = (long)0;
		try{
			count = this.workTimeDayOmpDao.queryCountWorkTimeDayOmp(workTimeDayOmpModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询员工OMP日考勤记录数据]</p>
	 * Created on 2020年10月13日
	 * @param id 员工OMP日考勤记录数据id
	 * @return WorkTimeDayOmpModel 单条数据	 
	 * @author:wangchun
	 */
	public WorkTimeDayOmpModel queryWorkTimeDayOmpById(Long id){
		
		WorkTimeDayOmpModel model = new WorkTimeDayOmpModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.workTimeDayOmpDao.queryWorkTimeDayOmpById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[员工OMP日考勤记录数据新增]</p>
	 * Created on 2020年10月13日
	 * @param workTimeDayOmpModel 员工OMP日考勤记录数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(WorkTimeDayOmpModel workTimeDayOmpModel){
		int count = 0;
		try{
			if(Objects.isNull(workTimeDayOmpModel)){
				return 0;
			}else{
				count = this.workTimeDayOmpDao.addWorkTimeDayOmp(workTimeDayOmpModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[员工OMP日考勤记录数据编辑]</p>
	 * Created on 2020年10月13日
	 * @param workTimeDayOmpModel 员工OMP日考勤记录数据
	 * @return 成功条数 	
	 *								    
	 * @author:wangchun
	 */
	public int edit(WorkTimeDayOmpModel workTimeDayOmpModel){
		Integer count = 0;
		try{
			if(Objects.isNull(workTimeDayOmpModel) || Objects.isNull(workTimeDayOmpModel.getEmployeeid())){
				return 0;
			}else{
				count = this.workTimeDayOmpDao.updateWorkTimeDayOmp(workTimeDayOmpModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[员工OMP日考勤记录数据删除]</p>
	 * Created on 2020年10月13日
	 * @param id 员工OMP日考勤记录数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeWorkTimeDayOmpById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.workTimeDayOmpDao.removeWorkTimeDayOmpById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[员工OMP日考勤记录数据批量删除]</p>
	 * Created on 2020年10月13日
	 * @param ids 员工OMP日考勤记录数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeWorkTimeDayOmpByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.workTimeDayOmpDao.removeWorkTimeDayOmpByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
