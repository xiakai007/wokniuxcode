package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.dao.CommentDao;
import com.isoftstone.humanresources.dao.ZanDao;
import com.isoftstone.humanresources.util.CommonConstant;
import com.isoftstone.humanresources.util.StringUtil;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.dao.GroupActivitiesDao;
import com.isoftstone.humanresources.domain.GroupActivities;
import com.isoftstone.humanresources.service.GroupActivitiesService;
import org.springframework.util.CollectionUtils;

/** 
 * Description: [活动风采表服务实现]
 * Created on 2020年05月25日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("groupActivitiesService")
public class GroupActivitiesServiceImpl implements GroupActivitiesService {
	
	/**
	 * <p>Discription:[活动风采表dao]</p>
	 */	
	@Resource
	private GroupActivitiesDao groupActivitiesDao;
    @Resource
    private CommentDao commentDao;
    @Resource
    private ZanDao zanDao;
	
	/**
	 * <p>Discription:[活动风采表数据分页查询]</p>
	 * Created on 2020年05月25日
	 * @param page 活动风采表数据分页条件
	 * @param groupActivitiesModel 活动风采表数据查询条件
	 * @param queryFields 活动风采表数据查询字段
	 * @return List<GroupActivitiesModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<GroupActivities> queryPageGroupActivities(Page page,GroupActivities groupActivitiesModel,
			String queryFields){
			
		List<GroupActivities> listGroupActivities = new ArrayList<GroupActivities>();
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
				listGroupActivities = this.groupActivitiesDao.queryPageGroupActivities(page,groupActivitiesModel,lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listGroupActivities;
	}

	/**
	 * <p>Discription:[活动风采表数据不分页查询]</p>
	 * Created on 2020年05月25日
	 * @param groupActivitiesModel 活动风采表数据查询条件
	 * @param queryFields 活动风采表数据查询字段
	 * @return List<GroupActivitiesModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<GroupActivities> queryListGroupActivities(GroupActivities groupActivitiesModel,String queryFields){
		List<GroupActivities> listGroupActivities = new ArrayList<GroupActivities>();
		List<GroupActivities> retActivities = null ;
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			if( null == groupActivitiesModel){
				groupActivitiesModel = new GroupActivities();
			}
			groupActivitiesModel.setApproved("TRUE");
			listGroupActivities = this.groupActivitiesDao.queryListGroupActivities(groupActivitiesModel,lis);
			if(!CollectionUtils.isEmpty(listGroupActivities)) {
				retActivities = new ArrayList<GroupActivities>();
				for (GroupActivities activities : listGroupActivities) {
					if(!StringUtil.isEmpty(activities.getImgs()) && activities.getImgs().length() > 5 ){
						List<String> imgList = Arrays.asList (activities.getImgs().split(","));
						activities.setImgList(imgList);
					}
					// 查询所有的评论信息
					activities.setCommentModelList( commentDao.queryBycomposeID( CommonConstant.EMPTY_STRING+activities.getId(), CommonConstant.COMPOSE_TYPE_GA));
					// 查询所有的点赞信息
					activities.setZanModelList( zanDao.queryBycomposeID(CommonConstant.EMPTY_STRING+activities.getId(), CommonConstant.COMPOSE_TYPE_GA));

					retActivities.add(activities);
				}
			}

		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return retActivities;
	}

	public PageInfo<GroupActivities> queryGroupActivitiesPage(Integer page, Integer pageSize){

		PageInfo<GroupActivities> groupActivitiesPageInfo = new PageInfo<>();
		if (page != null && pageSize != null) {
			PageHelper.startPage(page, pageSize);                     //分页
			//调用dao接口查询员工列表
			List<GroupActivities> groupActivities =  this.groupActivitiesDao.queryListGroupActivities(null,null);
			groupActivitiesPageInfo = new PageInfo<>(groupActivities);
		}
		return groupActivitiesPageInfo;
	}

    public GroupActivities querySingleGroupActivities(Integer id){

        GroupActivities groupActivities =  this.groupActivitiesDao.querySingleGroupActivities(id) ;

        if(null == groupActivities){
            return null;
        }

        if(!StringUtil.isEmpty(groupActivities.getImgs()) && groupActivities.getImgs().length() > 5 ){
            List<String> imgList = Arrays.asList (groupActivities.getImgs().split(","));
            groupActivities.setImgList(imgList);
        }
        // 查询所有的评论信息
        groupActivities.setCommentModelList( commentDao.queryBycomposeID( CommonConstant.EMPTY_STRING+id, CommonConstant.COMPOSE_TYPE_GA));
        // 查询所有的点赞信息
        groupActivities.setZanModelList( zanDao.queryBycomposeID(CommonConstant.EMPTY_STRING+id, CommonConstant.COMPOSE_TYPE_GA));

        return groupActivities;
    }

	/**
	 * <p>Discription:[活动风采表数据查询总条数]</p>
	 * Created on 2020年05月25日
	 * @param groupActivitiesModel 活动风采表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountGroupActivities(GroupActivities groupActivitiesModel){
		
		Long count = (long)0;
		try{
			count = this.groupActivitiesDao.queryCountGroupActivities(groupActivitiesModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询活动风采表数据]</p>
	 * Created on 2020年05月25日
	 * @param id 活动风采表数据id
	 * @return GroupActivitiesModel 单条数据	 
	 * @author:wangchun
	 */
	public GroupActivities queryGroupActivitiesById(Long id){
		
		GroupActivities model = new GroupActivities();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.groupActivitiesDao.queryGroupActivitiesById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[活动风采表数据新增]</p>
	 * Created on 2020年05月25日
	 * @param groupActivitiesModel 活动风采表数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(GroupActivities groupActivitiesModel){
		int count = 0;
		try{
			if(!CollectionUtils.isEmpty(groupActivitiesModel.getImgList())){
				String tmpStr = "";
				for(int i = 0;i<groupActivitiesModel.getImgList().size() ;i++ ){
					String str = groupActivitiesModel.getImgList().get(i);
					if(i==0){
						tmpStr = str ;
						continue;
					}
					tmpStr = tmpStr + "," + str ;
				}
				groupActivitiesModel.setImgs(tmpStr);
			}
			count = this.groupActivitiesDao.addGroupActivities(groupActivitiesModel);

		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[活动风采表数据编辑]</p>
	 * Created on 2020年05月25日
	 * @param groupActivitiesModel 活动风采表数据
	 * @return 成功条数 	
	 *								    
	 * @author:wangchun
	 */
	public int edit(GroupActivities groupActivitiesModel){
		Integer count = 0;
		try{
			if(Objects.isNull(groupActivitiesModel) || Objects.isNull(groupActivitiesModel.getId())){
				return 0;
			}else{
				if(!CollectionUtils.isEmpty(groupActivitiesModel.getImgList())){
					String tmpStr = "";
					for(int i = 0;i<groupActivitiesModel.getImgList().size() ;i++ ){
						String str = groupActivitiesModel.getImgList().get(i);
						if(i==0){
							tmpStr = str ;
							continue;
						}
						tmpStr = tmpStr + "," + str ;
					}
					groupActivitiesModel.setImgs(tmpStr);
				}
				count = this.groupActivitiesDao.updateGroupActivities(groupActivitiesModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[活动风采表数据删除]</p>
	 * Created on 2020年05月25日
	 * @param id 活动风采表数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeGroupActivitiesById(int id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.groupActivitiesDao.removeGroupActivitiesById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[活动风采表数据批量删除]</p>
	 * Created on 2020年05月25日
	 * @param ids 活动风采表数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeGroupActivitiesByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.groupActivitiesDao.removeGroupActivitiesByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
