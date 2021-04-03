package com.isoftstone.humanresources.service;

import java.util.List;

import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.gather.NoticeUserModel;

/**
 * Description: [消息通知人服务]
 * Created on 2020年06月08日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface NoticeUserService {

	/**
	 * <p>Discription:[消息通知人数据分页查询]</p>
	 * Created on 2020年06月08日
	 * @param page 消息通知人数据分页条件
	 * @param noticeUserModel 消息通知人数据查询条件
	 * @param queryFields 消息通知人数据查询字段集合
	 * @return List<NoticeUserModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<NoticeUserModel> queryPageNoticeUser(Page page, NoticeUserModel noticeUserModel, String queryFields);
	 
	 /**
	 * <p>Discription:[消息通知人数据不分页查询]</p>
	 * Created on 2020年06月08日
	 * @param noticeUserModel 消息通知人数据查询条件
	 * @param queryFields 消息通知人数据查询字段集合
	 * @return List<NoticeUserModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<NoticeUserModel> queryListNoticeUser(NoticeUserModel noticeUserModel, String queryFields);
	
	/**
	 * <p>Discription:[消息通知人数据查询总条数]</p>
	 * Created on 2020年06月08日
	 * @param noticeUserModel 消息通知人数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountNoticeUser(NoticeUserModel noticeUserModel);
	
	/**
	 * <p>Discription:[根据id查询消息通知人数据]</p>
	 * Created on 2020年06月08日
	 * @param id 消息通知人数据id
	 * @return NoticeUserModel 单条数据	 
	 * @author:wangchun
	 */
	public NoticeUserModel queryNoticeUserById(Long id);

	/**
	 * <p>Discription:[消息通知人数据新增]</p>
	 * Created on 2020年06月08日
	 * @param noticeUserModel 消息通知人数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public int save(NoticeUserModel noticeUserModel);
	
	/**
	 * <p>Discription:[消息通知人数据编辑]</p>
	 * Created on 2020年06月08日
	 * @param noticeUserModel 消息通知人数据
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int edit(NoticeUserModel noticeUserModel);
	
	/**
	 * <p>Discription:[消息通知人数据删除]</p>
	 * Created on 2020年06月08日
	 * @param id 消息通知人数据id
	 * @return 成功条数 	
	 * @author:wangchun
	 */
	public int removeNoticeUserById(Long id);
	
	/**
	 * <p>Discription:[消息通知人数据批量删除]</p>
	 * Created on 2020年06月08日
	 * @param ids 消息通知人数据id的集合
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int removeNoticeUserByIds(String ids);
	
}
