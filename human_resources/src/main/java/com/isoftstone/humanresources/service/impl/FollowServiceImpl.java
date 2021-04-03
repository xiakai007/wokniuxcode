package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.dao.FollowDao;
import com.isoftstone.humanresources.domain.gather.FollowModel;
import com.isoftstone.humanresources.service.FollowService;

/** 
 * Description: [关注表服务实现]
 * Created on 2020年05月26日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("followService")
public class FollowServiceImpl implements FollowService {
	
	/**
	 * <p>Discription:[关注表dao]</p>
	 */	
	@Resource
	private FollowDao followDao;
	
	/**
	 * <p>Discription:[关注表数据分页查询]</p>
	 * Created on 2020年05月26日
	 * @param page 关注表数据分页条件
	 * @param followModel 关注表数据查询条件
	 * @param queryFields 关注表数据查询字段
	 * @return List<FollowModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<FollowModel> queryPageFollow(Page page,FollowModel followModel,
			String queryFields){
			
		List<FollowModel> listFollow = new ArrayList<FollowModel>();
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
				listFollow = this.followDao.queryPageFollow(page,followModel,lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listFollow;
	}

	/**
	 * <p>Discription:[关注表数据不分页查询]</p>
	 * Created on 2020年05月26日
	 * @param followModel 关注表数据查询条件
	 * @param queryFields 关注表数据查询字段
	 * @return List<FollowModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<FollowModel> queryListFollow(FollowModel followModel,String queryFields){
		List<FollowModel> listFollow = new ArrayList<FollowModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listFollow = this.followDao.queryListFollow(followModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listFollow;
	}

	/**
	 * <p>Discription:[关注表数据查询总条数]</p>
	 * Created on 2020年05月26日
	 * @param followModel 关注表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountFollow(FollowModel followModel){
		
		Long count = (long)0;
		try{
			count = this.followDao.queryCountFollow(followModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询关注表数据]</p>
	 * Created on 2020年05月26日
	 * @param id 关注表数据id
	 * @return FollowModel 单条数据	 
	 * @author:wangchun
	 */
	public FollowModel queryFollowById(Long id){
		
		FollowModel model = new FollowModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.followDao.queryFollowById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[关注表数据新增]</p>
	 * Created on 2020年05月26日
	 * @param followModel 关注表数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(FollowModel followModel){
		int count = 0;
		try{
			if(Objects.isNull(followModel)){
				return 0;
			}else{
				count = this.followDao.addFollow(followModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[关注表数据编辑]</p>
	 * Created on 2020年05月26日
	 * @param followModel 关注表数据
	 * @return 成功条数 	
	 *								    
	 * @author:wangchun
	 */
	public int edit(FollowModel followModel){
		Integer count = 0;
		try{
			if(Objects.isNull(followModel) || Objects.isNull(followModel.getId())){
				return 0;
			}else{
				count = this.followDao.updateFollow(followModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[关注表数据删除]</p>
	 * Created on 2020年05月26日
	 * @param id 关注表数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeFollowById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.followDao.removeFollowById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[关注表数据批量删除]</p>
	 * Created on 2020年05月26日
	 * @param ids 关注表数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeFollowByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.followDao.removeFollowByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
