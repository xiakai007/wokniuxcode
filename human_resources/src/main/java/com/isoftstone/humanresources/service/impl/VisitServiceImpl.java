package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;

import com.isoftstone.humanresources.dao.VisitLeavemsgDao;
import com.isoftstone.humanresources.domain.VisitLeavemsgModel;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.dao.VisitDao;
import com.isoftstone.humanresources.domain.VisitModel;
import com.isoftstone.humanresources.service.VisitService;
import org.springframework.util.CollectionUtils;

/** 
 * Description: [拜访记录表服务实现]
 * Created on 2020年03月03日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("visitService")
public class VisitServiceImpl implements VisitService {
	
	/**
	 * <p>Discription:[拜访记录表dao]</p>
	 */	
	@Resource
	private VisitDao visitDao;

	@Resource
	private VisitLeavemsgDao visitLeavemsgDao;
	
	/**
	 * <p>Discription:[拜访记录表数据分页查询]</p>
	 * Created on 2020年03月03日
	 * @param page 拜访记录表数据分页条件
	 * @param visitModel 拜访记录表数据查询条件
	 * @param queryFields 拜访记录表数据查询字段
	 * @return List<VisitModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<VisitModel> queryPageVisit(Page page,VisitModel visitModel,
			String queryFields){
			
		List<VisitModel> listVisit = new ArrayList<VisitModel>();
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
				listVisit = this.visitDao.queryPageVisit(page,visitModel,lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listVisit;
	}

	/**
	 * <p>Discription:[拜访记录表数据不分页查询]</p>
	 * Created on 2020年03月03日
	 * @param visitModel 拜访记录表数据查询条件
	 * @param queryFields 拜访记录表数据查询字段
	 * @return List<VisitModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<VisitModel> queryListVisit(VisitModel visitModel,String queryFields){
		List<VisitModel> listVisit = null;
		List<VisitModel> retVisit = null;
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			List<VisitLeavemsgModel> visitLeavemsgModelList = null;

			listVisit = this.visitDao.queryListVisit(visitModel,lis);
			if(!CollectionUtils.isEmpty(listVisit)){
				retVisit = new ArrayList<VisitModel>();
				for(VisitModel model : listVisit){
					visitLeavemsgModelList = visitLeavemsgDao.queryByVisitId(model.getVisitid());
					if(!CollectionUtils.isEmpty(visitLeavemsgModelList)){
						model.setVisitLeavemsgModelList(visitLeavemsgModelList);
						model.setLeavemsg(visitLeavemsgModelList.get(0));
					}
					retVisit.add(model);
				}
			}else{
				return retVisit;
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return retVisit;
	}

	/**
	 * <p>Discription:[拜访记录表数据查询总条数]</p>
	 * Created on 2020年03月03日
	 * @param visitModel 拜访记录表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountVisit(VisitModel visitModel){
		
		Long count = (long)0;
		try{
			count = this.visitDao.queryCountVisit(visitModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询拜访记录表数据]</p>
	 * Created on 2020年03月03日
	 * @param id 拜访记录表数据id
	 * @return VisitModel 单条数据	 
	 * @author:wangchun
	 */
	public VisitModel queryVisitById(Long id){
		
		VisitModel model = new VisitModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}
			model = this.visitDao.queryVisitById(id,null);
			if(null != model){
				// 添加遗留问题记录
				List<VisitLeavemsgModel> visitLeavemsgModelList = visitLeavemsgDao.queryByVisitId(id);
				if(!CollectionUtils.isEmpty(visitLeavemsgModelList)){
					model.setVisitLeavemsgModelList(visitLeavemsgModelList);
				}
			}

		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[拜访记录表数据新增]</p>
	 * Created on 2020年03月03日
	 * @param visitModel 拜访记录表数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(VisitModel visitModel){
		int count = 0;
		try{
			if(Objects.isNull(visitModel)){
				return 0;
			}else{
//				if(null == visitModel.getVisitid() || 1 >visitModel.getVisitid()  ){
//					long visitID = System.currentTimeMillis() ;
//					visitModel.setVisitid( visitID);
//					VisitLeavemsgModel model = visitModel.getLeavemsg() ;
//					model.setVisitid(visitID);
//					visitModel.setLeavemsg(model);
//				}
				count = this.visitDao.addVisit(visitModel);
				if(null != visitModel.getVisitid() && 0< visitModel.getVisitid()  ){
					VisitLeavemsgModel model = visitModel.getLeavemsg() ;
					model.setVisitid(visitModel.getVisitid());
					visitModel.setLeavemsg(model);
				}
				if(0<count && null!=visitModel.getLeavemsg()){
					visitLeavemsgDao.addVisitLeavemsg(visitModel.getLeavemsg());
				}
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[拜访记录表数据编辑]</p>
	 * Created on 2020年03月03日
	 * @param visitModel 拜访记录表数据
	 * @return 成功条数 	
	 *								    
	 * @author:wangchun
	 */
	public int edit(VisitModel visitModel){
		Integer count = 0;
		try{
			if(Objects.isNull(visitModel) || Objects.isNull(visitModel.getVisitid())){
				return 0;
			}else{
				count = this.visitDao.updateVisit(visitModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[拜访记录表数据删除]</p>
	 * Created on 2020年03月03日
	 * @param id 拜访记录表数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeVisitById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.visitDao.removeVisitById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[拜访记录表数据批量删除]</p>
	 * Created on 2020年03月03日
	 * @param ids 拜访记录表数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeVisitByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.visitDao.removeVisitByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
