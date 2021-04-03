package com.isoftstone.humanresources.service;

import java.util.List;

import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.workTime.WorkTimeMonthIpsaModel;

/**
 * Description: [员工IPSA月考勤记录服务]
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface WorkTimeMonthIpsaService {

	/**
	 * <p>Discription:[员工IPSA月考勤记录数据分页查询]</p>
	 * Created on 2020年10月13日
	 * @param page 员工IPSA月考勤记录数据分页条件
	 * @param workTimeMonthIpsaModel 员工IPSA月考勤记录数据查询条件
	 * @param queryFields 员工IPSA月考勤记录数据查询字段集合
	 * @return List<WorkTimeMonthIpsaModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<WorkTimeMonthIpsaModel> queryPageWorkTimeMonthIpsa(Page page, WorkTimeMonthIpsaModel workTimeMonthIpsaModel, String queryFields);
	 
	 /**
	 * <p>Discription:[员工IPSA月考勤记录数据不分页查询]</p>
	 * Created on 2020年10月13日
	 * @param workTimeMonthIpsaModel 员工IPSA月考勤记录数据查询条件
	 * @param queryFields 员工IPSA月考勤记录数据查询字段集合
	 * @return List<WorkTimeMonthIpsaModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<WorkTimeMonthIpsaModel> queryListWorkTimeMonthIpsa(WorkTimeMonthIpsaModel workTimeMonthIpsaModel, String queryFields);
	
	/**
	 * <p>Discription:[员工IPSA月考勤记录数据查询总条数]</p>
	 * Created on 2020年10月13日
	 * @param workTimeMonthIpsaModel 员工IPSA月考勤记录数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountWorkTimeMonthIpsa(WorkTimeMonthIpsaModel workTimeMonthIpsaModel);
	
	/**
	 * <p>Discription:[根据id查询员工IPSA月考勤记录数据]</p>
	 * Created on 2020年10月13日
	 * @param id 员工IPSA月考勤记录数据id
	 * @return WorkTimeMonthIpsaModel 单条数据	 
	 * @author:wangchun
	 */
	public WorkTimeMonthIpsaModel queryWorkTimeMonthIpsaById(Long id);

	/**
	 * <p>Discription:[员工IPSA月考勤记录数据新增]</p>
	 * Created on 2020年10月13日
	 * @param workTimeMonthIpsaModel 员工IPSA月考勤记录数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public int save(WorkTimeMonthIpsaModel workTimeMonthIpsaModel);
	
	/**
	 * <p>Discription:[员工IPSA月考勤记录数据编辑]</p>
	 * Created on 2020年10月13日
	 * @param workTimeMonthIpsaModel 员工IPSA月考勤记录数据
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int edit(WorkTimeMonthIpsaModel workTimeMonthIpsaModel);
	
	/**
	 * <p>Discription:[员工IPSA月考勤记录数据删除]</p>
	 * Created on 2020年10月13日
	 * @param id 员工IPSA月考勤记录数据id
	 * @return 成功条数 	
	 * @author:wangchun
	 */
	public int removeWorkTimeMonthIpsaById(Long id);
	
	/**
	 * <p>Discription:[员工IPSA月考勤记录数据批量删除]</p>
	 * Created on 2020年10月13日
	 * @param ids 员工IPSA月考勤记录数据id的集合
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int removeWorkTimeMonthIpsaByIds(String ids);
	
}
