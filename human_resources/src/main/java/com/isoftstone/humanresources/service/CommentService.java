package com.isoftstone.humanresources.service;

import java.util.List;

import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.gather.CommentModel;

/**
 * Description: [评论表服务]
 * Created on 2020年05月26日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface CommentService {

	/**
	 * <p>Discription:[评论表数据分页查询]</p>
	 * Created on 2020年05月26日
	 * @param page 评论表数据分页条件
	 * @param commentModel 评论表数据查询条件
	 * @param queryFields 评论表数据查询字段集合
	 * @return List<CommentModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<CommentModel> queryPageComment(Page page, CommentModel commentModel, String queryFields);
	 
	 /**
	 * <p>Discription:[评论表数据不分页查询]</p>
	 * Created on 2020年05月26日
	 * @param commentModel 评论表数据查询条件
	 * @param queryFields 评论表数据查询字段集合
	 * @return List<CommentModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<CommentModel> queryListComment(CommentModel commentModel, String queryFields);
	
	/**
	 * <p>Discription:[评论表数据查询总条数]</p>
	 * Created on 2020年05月26日
	 * @param commentModel 评论表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountComment(CommentModel commentModel);
	
	/**
	 * <p>Discription:[根据id查询评论表数据]</p>
	 * Created on 2020年05月26日
	 * @param id 评论表数据id
	 * @return CommentModel 单条数据	 
	 * @author:wangchun
	 */
	public CommentModel queryCommentById(Long id);

	/**
	 * <p>Discription:[评论表数据新增]</p>
	 * Created on 2020年05月26日
	 * @param commentModel 评论表数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public int save(CommentModel commentModel);
	
	/**
	 * <p>Discription:[评论表数据编辑]</p>
	 * Created on 2020年05月26日
	 * @param commentModel 评论表数据
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int edit(CommentModel commentModel);
	
	/**
	 * <p>Discription:[评论表数据删除]</p>
	 * Created on 2020年05月26日
	 * @param id 评论表数据id
	 * @return 成功条数 	
	 * @author:wangchun
	 */
	public int removeCommentById(Long id);
	
	/**
	 * <p>Discription:[评论表数据批量删除]</p>
	 * Created on 2020年05月26日
	 * @param ids 评论表数据id的集合
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int removeCommentByIds(String ids);
	
}
