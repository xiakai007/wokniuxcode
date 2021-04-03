package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.dao.CommentDao;
import com.isoftstone.humanresources.domain.gather.CommentModel;
import com.isoftstone.humanresources.service.CommentService;

/** 
 * Description: [评论表服务实现]
 * Created on 2020年05月26日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
	
	/**
	 * <p>Discription:[评论表dao]</p>
	 */	
	@Resource
	private CommentDao commentDao;
	
	/**
	 * <p>Discription:[评论表数据分页查询]</p>
	 * Created on 2020年05月26日
	 * @param page 评论表数据分页条件
	 * @param commentModel 评论表数据查询条件
	 * @param queryFields 评论表数据查询字段
	 * @return List<CommentModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<CommentModel> queryPageComment(Page page,CommentModel commentModel,
			String queryFields){
			
		List<CommentModel> listComment = new ArrayList<CommentModel>();
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
				listComment = this.commentDao.queryPageComment(page,commentModel,lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listComment;
	}

	/**
	 * <p>Discription:[评论表数据不分页查询]</p>
	 * Created on 2020年05月26日
	 * @param commentModel 评论表数据查询条件
	 * @param queryFields 评论表数据查询字段
	 * @return List<CommentModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<CommentModel> queryListComment(CommentModel commentModel,String queryFields){
		List<CommentModel> listComment = new ArrayList<CommentModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listComment = this.commentDao.queryListComment(commentModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listComment;
	}

	/**
	 * <p>Discription:[评论表数据查询总条数]</p>
	 * Created on 2020年05月26日
	 * @param commentModel 评论表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountComment(CommentModel commentModel){
		
		Long count = (long)0;
		try{
			count = this.commentDao.queryCountComment(commentModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询评论表数据]</p>
	 * Created on 2020年05月26日
	 * @param id 评论表数据id
	 * @return CommentModel 单条数据	 
	 * @author:wangchun
	 */
	public CommentModel queryCommentById(Long id){
		
		CommentModel model = new CommentModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.commentDao.queryCommentById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[评论表数据新增]</p>
	 * Created on 2020年05月26日
	 * @param commentModel 评论表数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(CommentModel commentModel){
		int count = 0;
		try{
			if(Objects.isNull(commentModel)){
				return 0;
			}else{
				count = this.commentDao.addComment(commentModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[评论表数据编辑]</p>
	 * Created on 2020年05月26日
	 * @param commentModel 评论表数据
	 * @return 成功条数 	
	 *								    
	 * @author:wangchun
	 */
	public int edit(CommentModel commentModel){
		Integer count = 0;
		try{
			if(Objects.isNull(commentModel) || Objects.isNull(commentModel.getId())){
				return 0;
			}else{
				count = this.commentDao.updateComment(commentModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[评论表数据删除]</p>
	 * Created on 2020年05月26日
	 * @param id 评论表数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeCommentById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.commentDao.removeCommentById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[评论表数据批量删除]</p>
	 * Created on 2020年05月26日
	 * @param ids 评论表数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeCommentByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.commentDao.removeCommentByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
