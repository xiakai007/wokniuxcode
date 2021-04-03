package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.dao.VisitLeavemsgDao;
import com.isoftstone.humanresources.domain.VisitLeavemsgModel;
import com.isoftstone.humanresources.service.VisitLeavemsgService;

/** 
 * Description: [遗留问题记录表服务实现]
 * Created on 2020年03月03日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("visitLeavemsgService")
public class VisitLeavemsgServiceImpl implements VisitLeavemsgService {
	
	/**
	 * <p>Discription:[遗留问题记录表dao]</p>
	 */	
	@Resource
	private VisitLeavemsgDao visitLeavemsgDao;
	
	/**
	 * <p>Discription:[遗留问题记录表数据分页查询]</p>
	 * Created on 2020年03月03日
	 * @param page 遗留问题记录表数据分页条件
	 * @param visitLeavemsgModel 遗留问题记录表数据查询条件
	 * @param queryFields 遗留问题记录表数据查询字段
	 * @return List<VisitLeavemsgModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<VisitLeavemsgModel> queryPageVisitLeavemsg(Page page,VisitLeavemsgModel visitLeavemsgModel,
			String queryFields){
			
		List<VisitLeavemsgModel> listVisitLeavemsg = new ArrayList<VisitLeavemsgModel>();
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
				listVisitLeavemsg = this.visitLeavemsgDao.queryPageVisitLeavemsg(page,visitLeavemsgModel,lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listVisitLeavemsg;
	}

	/**
	 * <p>Discription:[遗留问题记录表数据不分页查询]</p>
	 * Created on 2020年03月03日
	 * @param visitLeavemsgModel 遗留问题记录表数据查询条件
	 * @param queryFields 遗留问题记录表数据查询字段
	 * @return List<VisitLeavemsgModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<VisitLeavemsgModel> queryListVisitLeavemsg(VisitLeavemsgModel visitLeavemsgModel,String queryFields){
		List<VisitLeavemsgModel> listVisitLeavemsg = new ArrayList<VisitLeavemsgModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listVisitLeavemsg = this.visitLeavemsgDao.queryListVisitLeavemsg(visitLeavemsgModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listVisitLeavemsg;
	}

	/**
	 * <p>Discription:[遗留问题记录表数据查询总条数]</p>
	 * Created on 2020年03月03日
	 * @param visitLeavemsgModel 遗留问题记录表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountVisitLeavemsg(VisitLeavemsgModel visitLeavemsgModel){
		
		Long count = (long)0;
		try{
			count = this.visitLeavemsgDao.queryCountVisitLeavemsg(visitLeavemsgModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询遗留问题记录表数据]</p>
	 * Created on 2020年03月03日
	 * @param id 遗留问题记录表数据id
	 * @return VisitLeavemsgModel 单条数据	 
	 * @author:wangchun
	 */
	public VisitLeavemsgModel queryVisitLeavemsgById(Long id){
		
		VisitLeavemsgModel model = new VisitLeavemsgModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.visitLeavemsgDao.queryVisitLeavemsgById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[遗留问题记录表数据新增]</p>
	 * Created on 2020年03月03日
	 * @param visitLeavemsgModel 遗留问题记录表数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(VisitLeavemsgModel visitLeavemsgModel){
		int count = 0;
		try{
			if(Objects.isNull(visitLeavemsgModel)){
				return 0;
			}else{
				count = this.visitLeavemsgDao.addVisitLeavemsg(visitLeavemsgModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[遗留问题记录表数据编辑]</p>
	 * Created on 2020年03月03日
	 * @param visitLeavemsgModel 遗留问题记录表数据
	 * @return 成功条数 	
	 *								    
	 * @author:wangchun
	 */
	public int edit(VisitLeavemsgModel visitLeavemsgModel){
		Integer count = 0;
		try{
			if(Objects.isNull(visitLeavemsgModel) || Objects.isNull(visitLeavemsgModel.getLeaveid())){
				return 0;
			}else{
				count = this.visitLeavemsgDao.updateVisitLeavemsg(visitLeavemsgModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[遗留问题记录表数据删除]</p>
	 * Created on 2020年03月03日
	 * @param id 遗留问题记录表数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeVisitLeavemsgById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.visitLeavemsgDao.removeVisitLeavemsgById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[遗留问题记录表数据批量删除]</p>
	 * Created on 2020年03月03日
	 * @param ids 遗留问题记录表数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeVisitLeavemsgByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.visitLeavemsgDao.removeVisitLeavemsgByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
