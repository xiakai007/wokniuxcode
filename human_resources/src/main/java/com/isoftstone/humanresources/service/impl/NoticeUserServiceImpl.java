package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.dao.NoticeUserDao;
import com.isoftstone.humanresources.domain.gather.NoticeUserModel;
import com.isoftstone.humanresources.service.NoticeUserService;

/** 
 * Description: [消息通知人服务实现]
 * Created on 2020年06月08日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("noticeUserService")
public class NoticeUserServiceImpl implements NoticeUserService {
	
	/**
	 * <p>Discription:[消息通知人dao]</p>
	 */	
	@Resource
	private NoticeUserDao noticeUserDao;
	
	/**
	 * <p>Discription:[消息通知人数据分页查询]</p>
	 * Created on 2020年06月08日
	 * @param page 消息通知人数据分页条件
	 * @param noticeUserModel 消息通知人数据查询条件
	 * @param queryFields 消息通知人数据查询字段
	 * @return List<NoticeUserModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<NoticeUserModel> queryPageNoticeUser(Page page,NoticeUserModel noticeUserModel,
			String queryFields){
			
		List<NoticeUserModel> listNoticeUser = new ArrayList<NoticeUserModel>();
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
				listNoticeUser = this.noticeUserDao.queryPageNoticeUser(page,noticeUserModel,lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listNoticeUser;
	}

	/**
	 * <p>Discription:[消息通知人数据不分页查询]</p>
	 * Created on 2020年06月08日
	 * @param noticeUserModel 消息通知人数据查询条件
	 * @param queryFields 消息通知人数据查询字段
	 * @return List<NoticeUserModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<NoticeUserModel> queryListNoticeUser(NoticeUserModel noticeUserModel,String queryFields){
		List<NoticeUserModel> listNoticeUser = new ArrayList<NoticeUserModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listNoticeUser = this.noticeUserDao.queryListNoticeUser(noticeUserModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listNoticeUser;
	}

	/**
	 * <p>Discription:[消息通知人数据查询总条数]</p>
	 * Created on 2020年06月08日
	 * @param noticeUserModel 消息通知人数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountNoticeUser(NoticeUserModel noticeUserModel){
		
		Long count = (long)0;
		try{
			count = this.noticeUserDao.queryCountNoticeUser(noticeUserModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询消息通知人数据]</p>
	 * Created on 2020年06月08日
	 * @param id 消息通知人数据id
	 * @return NoticeUserModel 单条数据	 
	 * @author:wangchun
	 */
	public NoticeUserModel queryNoticeUserById(Long id){
		
		NoticeUserModel model = new NoticeUserModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.noticeUserDao.queryNoticeUserById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[消息通知人数据新增]</p>
	 * Created on 2020年06月08日
	 * @param noticeUserModel 消息通知人数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(NoticeUserModel noticeUserModel){
		int count = 0;
		try{
			if(Objects.isNull(noticeUserModel)){
				return 0;
			}else{
				count = this.noticeUserDao.addNoticeUser(noticeUserModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[消息通知人数据编辑]</p>
	 * Created on 2020年06月08日
	 * @param noticeUserModel 消息通知人数据
	 * @return 成功条数 	
	 *								    
	 * @author:wangchun
	 */
	public int edit(NoticeUserModel noticeUserModel){
		Integer count = 0;
		try{
			if(Objects.isNull(noticeUserModel) || Objects.isNull(noticeUserModel.getId())){
				return 0;
			}else{
				count = this.noticeUserDao.updateNoticeUser(noticeUserModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[消息通知人数据删除]</p>
	 * Created on 2020年06月08日
	 * @param id 消息通知人数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeNoticeUserById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.noticeUserDao.removeNoticeUserById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[消息通知人数据批量删除]</p>
	 * Created on 2020年06月08日
	 * @param ids 消息通知人数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeNoticeUserByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.noticeUserDao.removeNoticeUserByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
