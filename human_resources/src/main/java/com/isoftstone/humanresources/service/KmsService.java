package com.isoftstone.humanresources.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.gather.KmsModel;

/**
 * Description: [知识管理表服务]
 * Created on 2020年05月29日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface KmsService {

	/**
	 * <p>Discription:[知识管理表数据分页查询]</p>
	 * Created on 2020年05月29日
	 * @param page 知识管理表数据分页条件
	 * @param kmsModel 知识管理表数据查询条件
	 * @param queryFields 知识管理表数据查询字段集合
	 * @return List<KmsModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<KmsModel> queryPageKms(Page page, KmsModel kmsModel, String queryFields);
	 
	 /**
	 * <p>Discription:[知识管理表数据不分页查询]</p>
	 * Created on 2020年05月29日
	 * @param kmsModel 知识管理表数据查询条件
	 * @param queryFields 知识管理表数据查询字段集合
	 * @return List<KmsModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<KmsModel> queryListKms(KmsModel kmsModel, String queryFields);

     public PageInfo<KmsModel> querykmsPage(Integer page, Integer pageSize);


	/**
	 * <p>Discription:[知识管理表数据查询总条数]</p>
	 * Created on 2020年05月29日
	 * @param kmsModel 知识管理表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountKms(KmsModel kmsModel);
	
	/**
	 * <p>Discription:[根据id查询知识管理表数据]</p>
	 * Created on 2020年05月29日
	 * @param id 知识管理表数据id
	 * @return KmsModel 单条数据	 
	 * @author:wangchun
	 */
	public KmsModel queryKmsById(Long id);

	/**
	 * <p>Discription:[知识管理表数据新增]</p>
	 * Created on 2020年05月29日
	 * @param kmsModel 知识管理表数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public int save(KmsModel kmsModel);
	
	/**
	 * <p>Discription:[知识管理表数据编辑]</p>
	 * Created on 2020年05月29日
	 * @param kmsModel 知识管理表数据
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int edit(KmsModel kmsModel);
	
	/**
	 * <p>Discription:[知识管理表数据删除]</p>
	 * Created on 2020年05月29日
	 * @param id 知识管理表数据id
	 * @return 成功条数 	
	 * @author:wangchun
	 */
	public int removeKmsById(Long id);
	
	/**
	 * <p>Discription:[知识管理表数据批量删除]</p>
	 * Created on 2020年05月29日
	 * @param ids 知识管理表数据id的集合
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int removeKmsByIds(String ids);
	
}
