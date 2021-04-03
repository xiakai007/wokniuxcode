package com.isoftstone.humanresources.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.GroupActivities;

/**
 * Description: [活动风采表服务]
 * Created on 2020年05月25日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface GroupActivitiesService {

	/**
	 * <p>Discription:[活动风采表数据分页查询]</p>
	 * Created on 2020年05月25日
	 * @param page 活动风采表数据分页条件
	 * @param groupActivities 活动风采表数据查询条件
	 * @param queryFields 活动风采表数据查询字段集合
	 * @return List<GroupActivitiesModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<GroupActivities> queryPageGroupActivities(Page page, GroupActivities groupActivities, String queryFields);
	 
	 /**
	 * <p>Discription:[活动风采表数据不分页查询]</p>
	 * Created on 2020年05月25日
	 * @param GroupActivities 活动风采表数据查询条件
	 * @param queryFields 活动风采表数据查询字段集合
	 * @return List<GroupActivities>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<GroupActivities> queryListGroupActivities(GroupActivities GroupActivities, String queryFields);

	 public PageInfo<GroupActivities> queryGroupActivitiesPage(Integer page,Integer pageSize);

	 public	GroupActivities querySingleGroupActivities(Integer id);
	
	/**
	 * <p>Discription:[活动风采表数据查询总条数]</p>
	 * Created on 2020年05月25日
	 * @param groupActivitiesModel 活动风采表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountGroupActivities(GroupActivities groupActivitiesModel);
	
	/**
	 * <p>Discription:[根据id查询活动风采表数据]</p>
	 * Created on 2020年05月25日
	 * @param id 活动风采表数据id
	 * @return GroupActivities 单条数据
	 * @author:wangchun
	 */
	public GroupActivities queryGroupActivitiesById(Long id);

	/**
	 * <p>Discription:[活动风采表数据新增]</p>
	 * Created on 2020年05月25日
	 * @param groupActivitiesModel 活动风采表数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public int save(GroupActivities groupActivitiesModel);
	
	/**
	 * <p>Discription:[活动风采表数据编辑]</p>
	 * Created on 2020年05月25日
	 * @param groupActivitiesModel 活动风采表数据
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int edit(GroupActivities groupActivitiesModel);
	
	/**
	 * <p>Discription:[活动风采表数据删除]</p>
	 * Created on 2020年05月25日
	 * @param id 活动风采表数据id
	 * @return 成功条数 	
	 * @author:wangchun
	 */
	public int removeGroupActivitiesById(int id);
	
	/**
	 * <p>Discription:[活动风采表数据批量删除]</p>
	 * Created on 2020年05月25日
	 * @param ids 活动风采表数据id的集合
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int removeGroupActivitiesByIds(String ids);
	
}
