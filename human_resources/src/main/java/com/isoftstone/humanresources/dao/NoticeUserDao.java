package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.gather.NoticeUserModel;
import com.isoftstone.humanresources.domain.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [消息通知人dao]</p>
 * Created on 2020年06月08日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface NoticeUserDao{
	
	/**
	* 分页查询固定参数
	*/
	List<NoticeUserModel> queryPageNoticeUser(@Param("page") Page page, @Param("entity") NoticeUserModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<NoticeUserModel> queryListNoticeUser(@Param("entity") NoticeUserModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountNoticeUser(@Param("entity") NoticeUserModel entity);
	
	/**
	* 查询单个实体
	*/
	NoticeUserModel queryNoticeUserById(@Param("id") Long id, @Param("queryFields") List queryFields);
	
	/**
	* 新增
	*/
	int addNoticeUser(NoticeUserModel entity);
	
	/**
	* 修改
	*/
	int updateNoticeUser(NoticeUserModel entity);
	
	/**
	* 批量删除
	*/
	int removeNoticeUserByIds(List code);
	
	/**
	* 删除
	*/
	int removeNoticeUserById(@Param("id") Long id);

}
