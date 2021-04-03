package com.isoftstone.humanresources.service;

import java.util.List;

import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.Suggest;

/**
 * Description: [意见建议表服务]
 * Created on 2020年05月25日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface SuggestService {

	/**
	 * <p>Discription:[意见建议表数据分页查询]</p>
	 * Created on 2020年05月25日
	 * @param page 意见建议表数据分页条件
	 * @param suggestModel 意见建议表数据查询条件
	 * @param queryFields 意见建议表数据查询字段集合
	 * @return List<SuggestModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<Suggest> queryPageSuggest(Page page, Suggest suggestModel, String queryFields);
	 
	 /**
	 * <p>Discription:[意见建议表数据不分页查询]</p>
	 * Created on 2020年05月25日
	 * @param suggestModel 意见建议表数据查询条件
	 * @param queryFields 意见建议表数据查询字段集合
	 * @return List<Suggest>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<Suggest> queryListSuggest(Suggest suggestModel, String queryFields);
	
	/**
	 * <p>Discription:[意见建议表数据查询总条数]</p>
	 * Created on 2020年05月25日
	 * @param suggestModel 意见建议表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountSuggest(Suggest suggestModel);
	
	/**
	 * <p>Discription:[根据id查询意见建议表数据]</p>
	 * Created on 2020年05月25日
	 * @param id 意见建议表数据id
	 * @return SuggestModel 单条数据	 
	 * @author:wangchun
	 */
	public Suggest querySuggestById(Long id);

	/**
	 * <p>Discription:[意见建议表数据新增]</p>
	 * Created on 2020年05月25日
	 * @param suggestModel 意见建议表数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public int save(Suggest suggestModel);
	
	/**
	 * <p>Discription:[意见建议表数据编辑]</p>
	 * Created on 2020年05月25日
	 * @param suggestModel 意见建议表数据
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int edit(Suggest suggestModel);
	
	/**
	 * <p>Discription:[意见建议表数据删除]</p>
	 * Created on 2020年05月25日
	 * @param id 意见建议表数据id
	 * @return 成功条数 	
	 * @author:wangchun
	 */
	public int removeSuggestById(Long id);
	
	/**
	 * <p>Discription:[意见建议表数据批量删除]</p>
	 * Created on 2020年05月25日
	 * @param ids 意见建议表数据id的集合
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int removeSuggestByIds(String ids);
	
}
