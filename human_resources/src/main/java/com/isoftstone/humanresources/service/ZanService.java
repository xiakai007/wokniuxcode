package com.isoftstone.humanresources.service;

import java.util.List;

import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.gather.ZanModel;

/**
 * Description: [点赞表服务]
 * Created on 2020年05月26日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface ZanService {

	/**
	 * <p>Discription:[点赞表数据分页查询]</p>
	 * Created on 2020年05月26日
	 * @param page 点赞表数据分页条件
	 * @param zanModel 点赞表数据查询条件
	 * @param queryFields 点赞表数据查询字段集合
	 * @return List<ZanModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<ZanModel> queryPageZan(Page page, ZanModel zanModel, String queryFields);
	 
	 /**
	 * <p>Discription:[点赞表数据不分页查询]</p>
	 * Created on 2020年05月26日
	 * @param zanModel 点赞表数据查询条件
	 * @param queryFields 点赞表数据查询字段集合
	 * @return List<ZanModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<ZanModel> queryListZan(ZanModel zanModel, String queryFields);
	
	/**
	 * <p>Discription:[点赞表数据查询总条数]</p>
	 * Created on 2020年05月26日
	 * @param zanModel 点赞表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountZan(ZanModel zanModel);
	
	/**
	 * <p>Discription:[根据id查询点赞表数据]</p>
	 * Created on 2020年05月26日
	 * @param id 点赞表数据id
	 * @return ZanModel 单条数据	 
	 * @author:wangchun
	 */
	public ZanModel queryZanById(Long id);

	/**
	 * <p>Discription:[点赞表数据新增]</p>
	 * Created on 2020年05月26日
	 * @param zanModel 点赞表数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public int save(ZanModel zanModel);
	
	/**
	 * <p>Discription:[点赞表数据编辑]</p>
	 * Created on 2020年05月26日
	 * @param zanModel 点赞表数据
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int edit(ZanModel zanModel);
	
	/**
	 * <p>Discription:[点赞表数据删除]</p>
	 * Created on 2020年05月26日
	 * @param id 点赞表数据id
	 * @return 成功条数 	
	 * @author:wangchun
	 */
	public int removeZanById(Long id);
	
	/**
	 * <p>Discription:[点赞表数据批量删除]</p>
	 * Created on 2020年05月26日
	 * @param ids 点赞表数据id的集合
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int removeZanByIds(String ids);
	
}
