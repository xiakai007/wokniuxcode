package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.gather.CommentModel;
import com.isoftstone.humanresources.domain.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [评论表dao]</p>
 * Created on 2020年05月26日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface CommentDao{
	
	/**
	* 分页查询固定参数
	*/
	List<CommentModel> queryPageComment(@Param("page") Page page, @Param("entity") CommentModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<CommentModel> queryListComment(@Param("entity") CommentModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountComment(@Param("entity") CommentModel entity);
	
	/**
	* 查询单个实体
	*/
	CommentModel queryCommentById(@Param("id") Long id, @Param("queryFields") List queryFields);
	
	/**
	* 新增
	*/
	int addComment(CommentModel entity);
	
	/**
	* 修改
	*/
	int updateComment(CommentModel entity);
	
	/**
	* 批量删除
	*/
	int removeCommentByIds(List code);
	
	/**
	* 删除
	*/
	int removeCommentById(@Param("id") Long id);


	List<CommentModel> queryBycomposeID(@Param("composeID") String composeID,@Param("composeType") String composeType);

	int queryBycomposeIDSize(@Param("composeID") String composeID,@Param("composeType") String composeType);

}
