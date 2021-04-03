package com.isoftstone.humanresources.service;

import java.util.List;

import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.workTime.WorkTimeMonthOmpModel;

/**
 * Description: [员工OMP月考勤记录服务]
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface WorkTimeMonthOmpService {

	/**
	 * <p>Discription:[员工OMP月考勤记录数据分页查询]</p>
	 * Created on 2020年10月13日
	 * @param page 员工OMP月考勤记录数据分页条件
	 * @param workTimeMonthOmpModel 员工OMP月考勤记录数据查询条件
	 * @param queryFields 员工OMP月考勤记录数据查询字段集合
	 * @return List<WorkTimeMonthOmpModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<WorkTimeMonthOmpModel> queryPageWorkTimeMonthOmp(Page page, WorkTimeMonthOmpModel workTimeMonthOmpModel, String queryFields);
	 
	 /**
	 * <p>Discription:[员工OMP月考勤记录数据不分页查询]</p>
	 * Created on 2020年10月13日
	 * @param workTimeMonthOmpModel 员工OMP月考勤记录数据查询条件
	 * @param queryFields 员工OMP月考勤记录数据查询字段集合
	 * @return List<WorkTimeMonthOmpModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<WorkTimeMonthOmpModel> queryListWorkTimeMonthOmp(WorkTimeMonthOmpModel workTimeMonthOmpModel, String queryFields);
	
	/**
	 * <p>Discription:[员工OMP月考勤记录数据查询总条数]</p>
	 * Created on 2020年10月13日
	 * @param workTimeMonthOmpModel 员工OMP月考勤记录数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountWorkTimeMonthOmp(WorkTimeMonthOmpModel workTimeMonthOmpModel);
	
	/**
	 * <p>Discription:[根据id查询员工OMP月考勤记录数据]</p>
	 * Created on 2020年10月13日
	 * @param id 员工OMP月考勤记录数据id
	 * @return WorkTimeMonthOmpModel 单条数据	 
	 * @author:wangchun
	 */
	public WorkTimeMonthOmpModel queryWorkTimeMonthOmpById(Long id);

	/**
	 * <p>Discription:[员工OMP月考勤记录数据新增]</p>
	 * Created on 2020年10月13日
	 * @param workTimeMonthOmpModel 员工OMP月考勤记录数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public int save(WorkTimeMonthOmpModel workTimeMonthOmpModel);
	
	/**
	 * <p>Discription:[员工OMP月考勤记录数据编辑]</p>
	 * Created on 2020年10月13日
	 * @param workTimeMonthOmpModel 员工OMP月考勤记录数据
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int edit(WorkTimeMonthOmpModel workTimeMonthOmpModel);
	
	/**
	 * <p>Discription:[员工OMP月考勤记录数据删除]</p>
	 * Created on 2020年10月13日
	 * @param id 员工OMP月考勤记录数据id
	 * @return 成功条数 	
	 * @author:wangchun
	 */
	public int removeWorkTimeMonthOmpById(Long id);
	
	/**
	 * <p>Discription:[员工OMP月考勤记录数据批量删除]</p>
	 * Created on 2020年10月13日
	 * @param ids 员工OMP月考勤记录数据id的集合
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int removeWorkTimeMonthOmpByIds(String ids);
	
}
