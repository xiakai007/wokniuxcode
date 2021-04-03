package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;

import com.isoftstone.humanresources.dao.CommentDao;
import com.isoftstone.humanresources.dao.ZanDao;
import com.isoftstone.humanresources.util.CommonConstant;
import com.isoftstone.humanresources.util.StringUtil;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.dao.DepartmentNewsDao;
import com.isoftstone.humanresources.domain.gather.DepartmentNewsModel;
import com.isoftstone.humanresources.service.DepartmentNewsService;
import org.springframework.util.CollectionUtils;

/** 
 * Description: [部门新鲜事服务实现]
 * Created on 2020年05月29日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("departmentNewsService")
public class DepartmentNewsServiceImpl implements DepartmentNewsService {
	
	/**
	 * <p>Discription:[部门新鲜事dao]</p>
	 */	
	@Resource
	private DepartmentNewsDao departmentNewsDao;

	@Resource
	private CommentDao commentDao;
	@Resource
	private ZanDao zanDao;
	
	/**
	 * <p>Discription:[部门新鲜事数据分页查询]</p>
	 * Created on 2020年05月29日
	 * @param page 部门新鲜事数据分页条件
	 * @param departmentNewsModel 部门新鲜事数据查询条件
	 * @param queryFields 部门新鲜事数据查询字段
	 * @return List<DepartmentNewsModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<DepartmentNewsModel> queryPageDepartmentNews(Page page,DepartmentNewsModel departmentNewsModel,
			String queryFields){
			
		List<DepartmentNewsModel> listDepartmentNews = new ArrayList<DepartmentNewsModel>();
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
				listDepartmentNews = this.departmentNewsDao.queryPageDepartmentNews(page,departmentNewsModel,lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listDepartmentNews;
	}

	/**
	 * <p>Discription:[部门新鲜事数据不分页查询]</p>
	 * Created on 2020年05月29日
	 * @param departmentNewsModel 部门新鲜事数据查询条件
	 * @param queryFields 部门新鲜事数据查询字段
	 * @return List<DepartmentNewsModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<DepartmentNewsModel> queryListDepartmentNews(DepartmentNewsModel departmentNewsModel,String queryFields){
		List<DepartmentNewsModel> listDepartmentNews = new ArrayList<DepartmentNewsModel>();
		List<DepartmentNewsModel> retList = null;
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listDepartmentNews = this.departmentNewsDao.queryListDepartmentNews(departmentNewsModel,lis);

			if(!CollectionUtils.isEmpty(listDepartmentNews)) {
				retList = new ArrayList<DepartmentNewsModel>();
				for (DepartmentNewsModel model : listDepartmentNews) {
					if(!StringUtil.isEmpty(model.getImgs()) && model.getImgs().length() > 5 ){
						List<String> imgList = Arrays.asList (model.getImgs().split(","));
						model.setImgList(imgList);
					}
					retList.add(model);
				}
			}

		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return retList;
	}

	/**
	 * <p>Discription:[部门新鲜事数据查询总条数]</p>
	 * Created on 2020年05月29日
	 * @param departmentNewsModel 部门新鲜事数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountDepartmentNews(DepartmentNewsModel departmentNewsModel){
		
		Long count = (long)0;
		try{
			count = this.departmentNewsDao.queryCountDepartmentNews(departmentNewsModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询部门新鲜事数据]</p>
	 * Created on 2020年05月29日
	 * @param id 部门新鲜事数据id
	 * @return DepartmentNewsModel 单条数据	 
	 * @author:wangchun
	 */
	public DepartmentNewsModel queryDepartmentNewsById(Long id){
		
		DepartmentNewsModel model = new DepartmentNewsModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.departmentNewsDao.queryDepartmentNewsById(id,null);
				if(null == model){
					return null;
				}
				if(!StringUtil.isEmpty(model.getImgs()) && model.getImgs().length() > 5 ){
					List<String> imgList = Arrays.asList (model.getImgs().split(","));
					model.setImgList(imgList);
				}
				// 查询所有的评论信息
				model.setCommentModelList( commentDao.queryBycomposeID( CommonConstant.EMPTY_STRING+id, CommonConstant.COMPOSE_TYPE_NEWS));
				// 查询所有的点赞信息
				model.setZanModelList( zanDao.queryBycomposeID(CommonConstant.EMPTY_STRING+id, CommonConstant.COMPOSE_TYPE_NEWS));
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[部门新鲜事数据新增]</p>
	 * Created on 2020年05月29日
	 * @param departmentNewsModel 部门新鲜事数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(DepartmentNewsModel departmentNewsModel){
		int count = 0;
		try{
			if(!CollectionUtils.isEmpty(departmentNewsModel.getImgList())){
				String tmpStr = "";
				for(int i = 0;i<departmentNewsModel.getImgList().size() ;i++ ){
					String str = departmentNewsModel.getImgList().get(i);
					if(i==0){
						tmpStr = str ;
						continue;
					}
					tmpStr = tmpStr + "," + str ;
				}
				departmentNewsModel.setImgs(tmpStr);
			}
			count = this.departmentNewsDao.addDepartmentNews(departmentNewsModel);

		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[部门新鲜事数据编辑]</p>
	 * Created on 2020年05月29日
	 * @param departmentNewsModel 部门新鲜事数据
	 * @return 成功条数 	
	 *								    
	 * @author:wangchun
	 */
	public int edit(DepartmentNewsModel departmentNewsModel){
		Integer count = 0;
		try{
			if(!CollectionUtils.isEmpty(departmentNewsModel.getImgList())){
				String tmpStr = "";
				for(int i = 0;i<departmentNewsModel.getImgList().size() ;i++ ){
					String str = departmentNewsModel.getImgList().get(i);
					if(i==0){
						tmpStr = str ;
						continue;
					}
					tmpStr = tmpStr + "," + str ;
				}
				departmentNewsModel.setImgs(tmpStr);
			}
			count = this.departmentNewsDao.updateDepartmentNews(departmentNewsModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[部门新鲜事数据删除]</p>
	 * Created on 2020年05月29日
	 * @param id 部门新鲜事数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeDepartmentNewsById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.departmentNewsDao.removeDepartmentNewsById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[部门新鲜事数据批量删除]</p>
	 * Created on 2020年05月29日
	 * @param ids 部门新鲜事数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeDepartmentNewsByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.departmentNewsDao.removeDepartmentNewsByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
