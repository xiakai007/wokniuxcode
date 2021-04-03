package com.isoftstone.humanresources.service;

import java.util.List;

import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.VisitLeavemsgModel;

/**
 * Description: [遗留问题记录表服务]
 * Created on 2020年03月03日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface VisitLeavemsgService {

	/**
	 * <p>Discription:[遗留问题记录表数据分页查询]</p>
	 * Created on 2020年03月03日
	 * @param page 遗留问题记录表数据分页条件
	 * @param visitLeavemsgModel 遗留问题记录表数据查询条件
	 * @param queryFields 遗留问题记录表数据查询字段集合
	 * @return List<VisitLeavemsgModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<VisitLeavemsgModel> queryPageVisitLeavemsg(Page page, VisitLeavemsgModel visitLeavemsgModel, String queryFields);
	 
	 /**
	 * <p>Discription:[遗留问题记录表数据不分页查询]</p>
	 * Created on 2020年03月03日
	 * @param visitLeavemsgModel 遗留问题记录表数据查询条件
	 * @param queryFields 遗留问题记录表数据查询字段集合
	 * @return List<VisitLeavemsgModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<VisitLeavemsgModel> queryListVisitLeavemsg(VisitLeavemsgModel visitLeavemsgModel, String queryFields);
	
	/**
	 * <p>Discription:[遗留问题记录表数据查询总条数]</p>
	 * Created on 2020年03月03日
	 * @param visitLeavemsgModel 遗留问题记录表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountVisitLeavemsg(VisitLeavemsgModel visitLeavemsgModel);
	
	/**
	 * <p>Discription:[根据id查询遗留问题记录表数据]</p>
	 * Created on 2020年03月03日
	 * @param id 遗留问题记录表数据id
	 * @return VisitLeavemsgModel 单条数据	 
	 * @author:wangchun
	 */
	public VisitLeavemsgModel queryVisitLeavemsgById(Long id);

	/**
	 * <p>Discription:[遗留问题记录表数据新增]</p>
	 * Created on 2020年03月03日
	 * @param visitLeavemsgModel 遗留问题记录表数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public int save(VisitLeavemsgModel visitLeavemsgModel);
	
	/**
	 * <p>Discription:[遗留问题记录表数据编辑]</p>
	 * Created on 2020年03月03日
	 * @param visitLeavemsgModel 遗留问题记录表数据
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int edit(VisitLeavemsgModel visitLeavemsgModel);
	
	/**
	 * <p>Discription:[遗留问题记录表数据删除]</p>
	 * Created on 2020年03月03日
	 * @param id 遗留问题记录表数据id
	 * @return 成功条数 	
	 * @author:wangchun
	 */
	public int removeVisitLeavemsgById(Long id);
	
	/**
	 * <p>Discription:[遗留问题记录表数据批量删除]</p>
	 * Created on 2020年03月03日
	 * @param ids 遗留问题记录表数据id的集合
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int removeVisitLeavemsgByIds(String ids);
	
}
