package com.isoftstone.humanresources.service;

import java.util.List;

import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.VisitModel;

/**
 * Description: [拜访记录表服务]
 * Created on 2020年03月03日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface VisitService {

	/**
	 * <p>Discription:[拜访记录表数据分页查询]</p>
	 * Created on 2020年03月03日
	 * @param page 拜访记录表数据分页条件
	 * @param visitModel 拜访记录表数据查询条件
	 * @param queryFields 拜访记录表数据查询字段集合
	 * @return List<VisitModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<VisitModel> queryPageVisit(Page page, VisitModel visitModel, String queryFields);
	 
	 /**
	 * <p>Discription:[拜访记录表数据不分页查询]</p>
	 * Created on 2020年03月03日
	 * @param visitModel 拜访记录表数据查询条件
	 * @param queryFields 拜访记录表数据查询字段集合
	 * @return List<VisitModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<VisitModel> queryListVisit(VisitModel visitModel, String queryFields);
	
	/**
	 * <p>Discription:[拜访记录表数据查询总条数]</p>
	 * Created on 2020年03月03日
	 * @param visitModel 拜访记录表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountVisit(VisitModel visitModel);
	
	/**
	 * <p>Discription:[根据id查询拜访记录表数据]</p>
	 * Created on 2020年03月03日
	 * @param id 拜访记录表数据id
	 * @return VisitModel 单条数据	 
	 * @author:wangchun
	 */
	public VisitModel queryVisitById(Long id);

	/**
	 * <p>Discription:[拜访记录表数据新增]</p>
	 * Created on 2020年03月03日
	 * @param visitModel 拜访记录表数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public int save(VisitModel visitModel);
	
	/**
	 * <p>Discription:[拜访记录表数据编辑]</p>
	 * Created on 2020年03月03日
	 * @param visitModel 拜访记录表数据
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int edit(VisitModel visitModel);
	
	/**
	 * <p>Discription:[拜访记录表数据删除]</p>
	 * Created on 2020年03月03日
	 * @param id 拜访记录表数据id
	 * @return 成功条数 	
	 * @author:wangchun
	 */
	public int removeVisitById(Long id);
	
	/**
	 * <p>Discription:[拜访记录表数据批量删除]</p>
	 * Created on 2020年03月03日
	 * @param ids 拜访记录表数据id的集合
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int removeVisitByIds(String ids);
	
}
