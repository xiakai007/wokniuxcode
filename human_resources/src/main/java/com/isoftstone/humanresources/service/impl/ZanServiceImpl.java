package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.dao.ZanDao;
import com.isoftstone.humanresources.domain.gather.ZanModel;
import com.isoftstone.humanresources.service.ZanService;

/** 
 * Description: [点赞表服务实现]
 * Created on 2020年05月26日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("zanService")
public class ZanServiceImpl implements ZanService {
	
	/**
	 * <p>Discription:[点赞表dao]</p>
	 */	
	@Resource
	private ZanDao zanDao;
	
	/**
	 * <p>Discription:[点赞表数据分页查询]</p>
	 * Created on 2020年05月26日
	 * @param page 点赞表数据分页条件
	 * @param zanModel 点赞表数据查询条件
	 * @param queryFields 点赞表数据查询字段
	 * @return List<ZanModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<ZanModel> queryPageZan(Page page,ZanModel zanModel,
			String queryFields){
			
		List<ZanModel> listZan = new ArrayList<ZanModel>();
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
				listZan = this.zanDao.queryPageZan(page,zanModel,lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listZan;
	}

	/**
	 * <p>Discription:[点赞表数据不分页查询]</p>
	 * Created on 2020年05月26日
	 * @param zanModel 点赞表数据查询条件
	 * @param queryFields 点赞表数据查询字段
	 * @return List<ZanModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<ZanModel> queryListZan(ZanModel zanModel,String queryFields){
		List<ZanModel> listZan = new ArrayList<ZanModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listZan = this.zanDao.queryListZan(zanModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listZan;
	}

	/**
	 * <p>Discription:[点赞表数据查询总条数]</p>
	 * Created on 2020年05月26日
	 * @param zanModel 点赞表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountZan(ZanModel zanModel){
		
		Long count = (long)0;
		try{
			count = this.zanDao.queryCountZan(zanModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询点赞表数据]</p>
	 * Created on 2020年05月26日
	 * @param id 点赞表数据id
	 * @return ZanModel 单条数据	 
	 * @author:wangchun
	 */
	public ZanModel queryZanById(Long id){
		
		ZanModel model = new ZanModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.zanDao.queryZanById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[点赞表数据新增]</p>
	 * Created on 2020年05月26日
	 * @param zanModel 点赞表数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(ZanModel zanModel){
		int count = 0;
		try{
			if(Objects.isNull(zanModel)){
				return 0;
			}else{
				count = this.zanDao.addZan(zanModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[点赞表数据编辑]</p>
	 * Created on 2020年05月26日
	 * @param zanModel 点赞表数据
	 * @return 成功条数 	
	 *								    
	 * @author:wangchun
	 */
	public int edit(ZanModel zanModel){
		Integer count = 0;
		try{
			if(Objects.isNull(zanModel) || Objects.isNull(zanModel.getId())){
				return 0;
			}else{
				count = this.zanDao.updateZan(zanModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[点赞表数据删除]</p>
	 * Created on 2020年05月26日
	 * @param id 点赞表数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeZanById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.zanDao.removeZanById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[点赞表数据批量删除]</p>
	 * Created on 2020年05月26日
	 * @param ids 点赞表数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeZanByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.zanDao.removeZanByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
