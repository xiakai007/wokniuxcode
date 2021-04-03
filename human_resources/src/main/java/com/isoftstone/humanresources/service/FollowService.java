package com.isoftstone.humanresources.service;

import java.util.List;

import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.gather.FollowModel;

/**
 * Description: [关注表服务]
 * Created on 2020年05月26日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface FollowService {

	/**
	 * <p>Discription:[关注表数据分页查询]</p>
	 * Created on 2020年05月26日
	 * @param page 关注表数据分页条件
	 * @param followModel 关注表数据查询条件
	 * @param queryFields 关注表数据查询字段集合
	 * @return List<FollowModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<FollowModel> queryPageFollow(Page page, FollowModel followModel, String queryFields);
	 
	 /**
	 * <p>Discription:[关注表数据不分页查询]</p>
	 * Created on 2020年05月26日
	 * @param followModel 关注表数据查询条件
	 * @param queryFields 关注表数据查询字段集合
	 * @return List<FollowModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<FollowModel> queryListFollow(FollowModel followModel, String queryFields);
	
	/**
	 * <p>Discription:[关注表数据查询总条数]</p>
	 * Created on 2020年05月26日
	 * @param followModel 关注表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountFollow(FollowModel followModel);
	
	/**
	 * <p>Discription:[根据id查询关注表数据]</p>
	 * Created on 2020年05月26日
	 * @param id 关注表数据id
	 * @return FollowModel 单条数据	 
	 * @author:wangchun
	 */
	public FollowModel queryFollowById(Long id);

	/**
	 * <p>Discription:[关注表数据新增]</p>
	 * Created on 2020年05月26日
	 * @param followModel 关注表数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public int save(FollowModel followModel);
	
	/**
	 * <p>Discription:[关注表数据编辑]</p>
	 * Created on 2020年05月26日
	 * @param followModel 关注表数据
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int edit(FollowModel followModel);
	
	/**
	 * <p>Discription:[关注表数据删除]</p>
	 * Created on 2020年05月26日
	 * @param id 关注表数据id
	 * @return 成功条数 	
	 * @author:wangchun
	 */
	public int removeFollowById(Long id);
	
	/**
	 * <p>Discription:[关注表数据批量删除]</p>
	 * Created on 2020年05月26日
	 * @param ids 关注表数据id的集合
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int removeFollowByIds(String ids);
	
}
