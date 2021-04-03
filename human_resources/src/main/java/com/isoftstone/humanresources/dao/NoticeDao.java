package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.gather.NoticeModel;
import com.isoftstone.humanresources.domain.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [消息通知表dao]</p>
 * Created on 2020年06月08日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface NoticeDao{
	
	/**
	* 分页查询固定参数
	*/
	List<NoticeModel> queryPageNotice(@Param("page") Page page, @Param("entity") NoticeModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<NoticeModel> queryListNotice(@Param("entity") NoticeModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountNotice(@Param("entity") NoticeModel entity);
	
	/**
	* 查询单个实体
	*/
	NoticeModel queryNoticeById(@Param("id") Long id, @Param("queryFields") List queryFields);
	
	/**
	* 新增
	*/
	int addNotice(NoticeModel entity);
	
	/**
	* 修改
	*/
	int updateNotice(NoticeModel entity);
	
	/**
	* 批量删除
	*/
	int removeNoticeByIds(List code);
	
	/**
	* 删除
	*/
	int removeNoticeById(@Param("id") Integer id);

}
