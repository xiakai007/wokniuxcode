package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.dao.NoticeDao;
import com.isoftstone.humanresources.domain.gather.NoticeModel;
import com.isoftstone.humanresources.service.NoticeService;

/** 
 * Description: [消息通知表服务实现]
 * Created on 2020年06月08日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	/**
	 * <p>Discription:[消息通知表dao]</p>
	 */	
	@Resource
	private NoticeDao noticeDao;
	
	/**
	 * <p>Discription:[消息通知表数据分页查询]</p>
	 * Created on 2020年06月08日
	 * @param page 消息通知表数据分页条件
	 * @param noticeModel 消息通知表数据查询条件
	 * @param queryFields 消息通知表数据查询字段
	 * @return List<NoticeModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<NoticeModel> queryPageNotice(Page page,NoticeModel noticeModel,
			String queryFields){
			
		List<NoticeModel> listNotice = new ArrayList<NoticeModel>();
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
				listNotice = this.noticeDao.queryPageNotice(page,noticeModel,lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listNotice;
	}

	/**
	 * <p>Discription:[消息通知表数据不分页查询]</p>
	 * Created on 2020年06月08日
	 * @param noticeModel 消息通知表数据查询条件
	 * @param queryFields 消息通知表数据查询字段
	 * @return List<NoticeModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<NoticeModel> queryListNotice(NoticeModel noticeModel,String queryFields){
		List<NoticeModel> listNotice = new ArrayList<NoticeModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listNotice = this.noticeDao.queryListNotice(noticeModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listNotice;
	}

	/**
	 * <p>Discription:[消息通知表数据查询总条数]</p>
	 * Created on 2020年06月08日
	 * @param noticeModel 消息通知表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountNotice(NoticeModel noticeModel){
		
		Long count = (long)0;
		try{
			count = this.noticeDao.queryCountNotice(noticeModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询消息通知表数据]</p>
	 * Created on 2020年06月08日
	 * @param id 消息通知表数据id
	 * @return NoticeModel 单条数据	 
	 * @author:wangchun
	 */
	public NoticeModel queryNoticeById(Long id){
		
		NoticeModel model = new NoticeModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.noticeDao.queryNoticeById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[消息通知表数据新增]</p>
	 * Created on 2020年06月08日
	 * @param noticeModel 消息通知表数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(NoticeModel noticeModel){
		int count = 0;
		try{
			if(Objects.isNull(noticeModel)){
				return 0;
			}else{
				count = this.noticeDao.addNotice(noticeModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[消息通知表数据编辑]</p>
	 * Created on 2020年06月08日
	 * @param noticeModel 消息通知表数据
	 * @return 成功条数 	
	 *								    
	 * @author:wangchun
	 */
	public int edit(NoticeModel noticeModel){
		Integer count = 0;
		try{
			if(Objects.isNull(noticeModel) || Objects.isNull(noticeModel.getId())){
				return 0;
			}else{
				count = this.noticeDao.updateNotice(noticeModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[消息通知表数据删除]</p>
	 * Created on 2020年06月08日
	 * @param id 消息通知表数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeNoticeById(Integer id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.noticeDao.removeNoticeById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[消息通知表数据批量删除]</p>
	 * Created on 2020年06月08日
	 * @param ids 消息通知表数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeNoticeByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.noticeDao.removeNoticeByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
