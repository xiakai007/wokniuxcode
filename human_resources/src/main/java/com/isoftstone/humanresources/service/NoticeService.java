package com.isoftstone.humanresources.service;

import java.util.List;

import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.gather.NoticeModel;

/**
 * Description: [消息通知表服务]
 * Created on 2020年06月08日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface NoticeService {

	/**
	 * <p>Discription:[消息通知表数据分页查询]</p>
	 * Created on 2020年06月08日
	 * @param page 消息通知表数据分页条件
	 * @param noticeModel 消息通知表数据查询条件
	 * @param queryFields 消息通知表数据查询字段集合
	 * @return List<NoticeModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<NoticeModel> queryPageNotice(Page page, NoticeModel noticeModel, String queryFields);
	 
	 /**
	 * <p>Discription:[消息通知表数据不分页查询]</p>
	 * Created on 2020年06月08日
	 * @param noticeModel 消息通知表数据查询条件
	 * @param queryFields 消息通知表数据查询字段集合
	 * @return List<NoticeModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<NoticeModel> queryListNotice(NoticeModel noticeModel, String queryFields);
	
	/**
	 * <p>Discription:[消息通知表数据查询总条数]</p>
	 * Created on 2020年06月08日
	 * @param noticeModel 消息通知表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountNotice(NoticeModel noticeModel);
	
	/**
	 * <p>Discription:[根据id查询消息通知表数据]</p>
	 * Created on 2020年06月08日
	 * @param id 消息通知表数据id
	 * @return NoticeModel 单条数据	 
	 * @author:wangchun
	 */
	public NoticeModel queryNoticeById(Long id);

	/**
	 * <p>Discription:[消息通知表数据新增]</p>
	 * Created on 2020年06月08日
	 * @param noticeModel 消息通知表数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public int save(NoticeModel noticeModel);
	
	/**
	 * <p>Discription:[消息通知表数据编辑]</p>
	 * Created on 2020年06月08日
	 * @param noticeModel 消息通知表数据
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int edit(NoticeModel noticeModel);
	
	/**
	 * <p>Discription:[消息通知表数据删除]</p>
	 * Created on 2020年06月08日
	 * @param id 消息通知表数据id
	 * @return 成功条数 	
	 * @author:wangchun
	 */
	public int removeNoticeById(Integer id);
	
	/**
	 * <p>Discription:[消息通知表数据批量删除]</p>
	 * Created on 2020年06月08日
	 * @param ids 消息通知表数据id的集合
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int removeNoticeByIds(String ids);
	
}
