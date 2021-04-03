package com.isoftstone.humanresources.service;

import java.util.List;

import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.workTime.WorkTimeDayOmpModel;

/**
 * Description: [员工OMP日考勤记录服务]
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface WorkTimeDayOmpService {

	/**
	 * <p>Discription:[员工OMP日考勤记录数据分页查询]</p>
	 * Created on 2020年10月13日
	 * @param page 员工OMP日考勤记录数据分页条件
	 * @param workTimeDayOmpModel 员工OMP日考勤记录数据查询条件
	 * @param queryFields 员工OMP日考勤记录数据查询字段集合
	 * @return List<WorkTimeDayOmpModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<WorkTimeDayOmpModel> queryPageWorkTimeDayOmp(Page page, WorkTimeDayOmpModel workTimeDayOmpModel, String queryFields);
	 
	 /**
	 * <p>Discription:[员工OMP日考勤记录数据不分页查询]</p>
	 * Created on 2020年10月13日
	 * @param workTimeDayOmpModel 员工OMP日考勤记录数据查询条件
	 * @param queryFields 员工OMP日考勤记录数据查询字段集合
	 * @return List<WorkTimeDayOmpModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<WorkTimeDayOmpModel> queryListWorkTimeDayOmp(WorkTimeDayOmpModel workTimeDayOmpModel, String queryFields);
	
	/**
	 * <p>Discription:[员工OMP日考勤记录数据查询总条数]</p>
	 * Created on 2020年10月13日
	 * @param workTimeDayOmpModel 员工OMP日考勤记录数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountWorkTimeDayOmp(WorkTimeDayOmpModel workTimeDayOmpModel);
	
	/**
	 * <p>Discription:[根据id查询员工OMP日考勤记录数据]</p>
	 * Created on 2020年10月13日
	 * @param id 员工OMP日考勤记录数据id
	 * @return WorkTimeDayOmpModel 单条数据	 
	 * @author:wangchun
	 */
	public WorkTimeDayOmpModel queryWorkTimeDayOmpById(Long id);

	/**
	 * <p>Discription:[员工OMP日考勤记录数据新增]</p>
	 * Created on 2020年10月13日
	 * @param workTimeDayOmpModel 员工OMP日考勤记录数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public int save(WorkTimeDayOmpModel workTimeDayOmpModel);
	
	/**
	 * <p>Discription:[员工OMP日考勤记录数据编辑]</p>
	 * Created on 2020年10月13日
	 * @param workTimeDayOmpModel 员工OMP日考勤记录数据
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int edit(WorkTimeDayOmpModel workTimeDayOmpModel);
	
	/**
	 * <p>Discription:[员工OMP日考勤记录数据删除]</p>
	 * Created on 2020年10月13日
	 * @param id 员工OMP日考勤记录数据id
	 * @return 成功条数 	
	 * @author:wangchun
	 */
	public int removeWorkTimeDayOmpById(Long id);
	
	/**
	 * <p>Discription:[员工OMP日考勤记录数据批量删除]</p>
	 * Created on 2020年10月13日
	 * @param ids 员工OMP日考勤记录数据id的集合
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int removeWorkTimeDayOmpByIds(String ids);
	
}
