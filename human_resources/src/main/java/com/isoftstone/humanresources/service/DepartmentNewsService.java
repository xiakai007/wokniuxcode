package com.isoftstone.humanresources.service;

import java.util.List;

import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.gather.DepartmentNewsModel;

/**
 * Description: [部门新鲜事服务]
 * Created on 2020年05月29日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface DepartmentNewsService {

	/**
	 * <p>Discription:[部门新鲜事数据分页查询]</p>
	 * Created on 2020年05月29日
	 * @param page 部门新鲜事数据分页条件
	 * @param departmentNewsModel 部门新鲜事数据查询条件
	 * @param queryFields 部门新鲜事数据查询字段集合
	 * @return List<DepartmentNewsModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<DepartmentNewsModel> queryPageDepartmentNews(Page page, DepartmentNewsModel departmentNewsModel, String queryFields);
	 
	 /**
	 * <p>Discription:[部门新鲜事数据不分页查询]</p>
	 * Created on 2020年05月29日
	 * @param departmentNewsModel 部门新鲜事数据查询条件
	 * @param queryFields 部门新鲜事数据查询字段集合
	 * @return List<DepartmentNewsModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<DepartmentNewsModel> queryListDepartmentNews(DepartmentNewsModel departmentNewsModel, String queryFields);
	
	/**
	 * <p>Discription:[部门新鲜事数据查询总条数]</p>
	 * Created on 2020年05月29日
	 * @param departmentNewsModel 部门新鲜事数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountDepartmentNews(DepartmentNewsModel departmentNewsModel);
	
	/**
	 * <p>Discription:[根据id查询部门新鲜事数据]</p>
	 * Created on 2020年05月29日
	 * @param id 部门新鲜事数据id
	 * @return DepartmentNewsModel 单条数据	 
	 * @author:wangchun
	 */
	public DepartmentNewsModel queryDepartmentNewsById(Long id);

	/**
	 * <p>Discription:[部门新鲜事数据新增]</p>
	 * Created on 2020年05月29日
	 * @param departmentNewsModel 部门新鲜事数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public int save(DepartmentNewsModel departmentNewsModel);
	
	/**
	 * <p>Discription:[部门新鲜事数据编辑]</p>
	 * Created on 2020年05月29日
	 * @param departmentNewsModel 部门新鲜事数据
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int edit(DepartmentNewsModel departmentNewsModel);
	
	/**
	 * <p>Discription:[部门新鲜事数据删除]</p>
	 * Created on 2020年05月29日
	 * @param id 部门新鲜事数据id
	 * @return 成功条数 	
	 * @author:wangchun
	 */
	public int removeDepartmentNewsById(Long id);
	
	/**
	 * <p>Discription:[部门新鲜事数据批量删除]</p>
	 * Created on 2020年05月29日
	 * @param ids 部门新鲜事数据id的集合
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int removeDepartmentNewsByIds(String ids);
	
}
