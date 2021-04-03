package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.dao.SuggestDao;
import com.isoftstone.humanresources.domain.Suggest;
import com.isoftstone.humanresources.service.SuggestService;
import org.springframework.util.CollectionUtils;

/** 
 * Description: [意见建议表服务实现]
 * Created on 2020年05月25日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("suggestService")
public class SuggestServiceImpl implements SuggestService {
	
	/**
	 * <p>Discription:[意见建议表dao]</p>
	 */	
	@Resource
	private SuggestDao suggestDao;
	
	/**
	 * <p>Discription:[意见建议表数据分页查询]</p>
	 * Created on 2020年05月25日
	 * @param page 意见建议表数据分页条件
	 * @param suggestModel 意见建议表数据查询条件
	 * @param queryFields 意见建议表数据查询字段
	 * @return List<SuggestModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<Suggest> queryPageSuggest(Page page,Suggest suggestModel,
			String queryFields){
			
		List<Suggest> listSuggest = new ArrayList<Suggest>();
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
				listSuggest = this.suggestDao.queryPageSuggest(page,suggestModel,lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listSuggest;
	}

	/**
	 * <p>Discription:[意见建议表数据不分页查询]</p>
	 * Created on 2020年05月25日
	 * @param suggestModel 意见建议表数据查询条件
	 * @param queryFields 意见建议表数据查询字段
	 * @return List<SuggestModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<Suggest> queryListSuggest(Suggest suggestModel,String queryFields){
		List<Suggest> listSuggest = new ArrayList<Suggest>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listSuggest = this.suggestDao.queryListSuggest(suggestModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listSuggest;
	}

	/**
	 * <p>Discription:[意见建议表数据查询总条数]</p>
	 * Created on 2020年05月25日
	 * @param suggestModel 意见建议表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountSuggest(Suggest suggestModel){
		
		Long count = (long)0;
		try{
			count = this.suggestDao.queryCountSuggest(suggestModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询意见建议表数据]</p>
	 * Created on 2020年05月25日
	 * @param id 意见建议表数据id
	 * @return SuggestModel 单条数据	 
	 * @author:wangchun
	 */
	public Suggest querySuggestById(Long id){
		
		Suggest model = new Suggest();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.suggestDao.querySuggestById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[意见建议表数据新增]</p>
	 * Created on 2020年05月25日
	 * @param suggestModel 意见建议表数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(Suggest suggestModel){
		int count = 0;
		try{
			if(!CollectionUtils.isEmpty(suggestModel.getImgList())){
				String tmpStr = "";
				for(int i = 0;i<suggestModel.getImgList().size() ;i++ ){
					String str = suggestModel.getImgList().get(i);
					if(i==0){
						tmpStr = str ;
						continue;
					}
					tmpStr = tmpStr + "," + str ;
				}
				suggestModel.setImgs(tmpStr);
			}
			count = this.suggestDao.addSuggest(suggestModel);

		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[意见建议表数据编辑]</p>
	 * Created on 2020年05月25日
	 * @param suggestModel 意见建议表数据
	 * @return 成功条数 	
	 *								    
	 * @author:wangchun
	 */
	public int edit(Suggest suggestModel){
		Integer count = 0;
		try{
			if(Objects.isNull(suggestModel) || Objects.isNull(suggestModel.getId())){
				return 0;
			}else{
				count = this.suggestDao.updateSuggest(suggestModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[意见建议表数据删除]</p>
	 * Created on 2020年05月25日
	 * @param id 意见建议表数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeSuggestById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.suggestDao.removeSuggestById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[意见建议表数据批量删除]</p>
	 * Created on 2020年05月25日
	 * @param ids 意见建议表数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeSuggestByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.suggestDao.removeSuggestByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
