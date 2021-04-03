package com.isoftstone.humanresources.service;

import java.util.List;

import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.workTime.TerminalInfoModel;

/**
 * Description: [考勤机配置表服务]
 * Created on 2020年10月28日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface TerminalInfoService {

	/**
	 * <p>Discription:[考勤机配置表数据分页查询]</p>
	 * Created on 2020年10月28日
	 * @param page 考勤机配置表数据分页条件
	 * @param terminalInfoModel 考勤机配置表数据查询条件
	 * @param queryFields 考勤机配置表数据查询字段集合
	 * @return List<TerminalInfoModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<TerminalInfoModel> queryPageTerminalInfo(Page page, TerminalInfoModel terminalInfoModel, String queryFields);
	 
	 /**
	 * <p>Discription:[考勤机配置表数据不分页查询]</p>
	 * Created on 2020年10月28日
	 * @param terminalInfoModel 考勤机配置表数据查询条件
	 * @param queryFields 考勤机配置表数据查询字段集合
	 * @return List<TerminalInfoModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<TerminalInfoModel> queryListTerminalInfo(TerminalInfoModel terminalInfoModel, String queryFields);
	
	/**
	 * <p>Discription:[考勤机配置表数据查询总条数]</p>
	 * Created on 2020年10月28日
	 * @param terminalInfoModel 考勤机配置表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountTerminalInfo(TerminalInfoModel terminalInfoModel);
	
	/**
	 * <p>Discription:[根据id查询考勤机配置表数据]</p>
	 * Created on 2020年10月28日
	 * @param id 考勤机配置表数据id
	 * @return TerminalInfoModel 单条数据	 
	 * @author:wangchun
	 */
	public TerminalInfoModel queryTerminalInfoById(Long id);

	/**
	 * <p>Discription:[考勤机配置表数据新增]</p>
	 * Created on 2020年10月28日
	 * @param terminalInfoModel 考勤机配置表数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public int save(TerminalInfoModel terminalInfoModel);
	
	/**
	 * <p>Discription:[考勤机配置表数据编辑]</p>
	 * Created on 2020年10月28日
	 * @param terminalInfoModel 考勤机配置表数据
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int edit(TerminalInfoModel terminalInfoModel);
	
	/**
	 * <p>Discription:[考勤机配置表数据删除]</p>
	 * Created on 2020年10月28日
	 * @param id 考勤机配置表数据id
	 * @return 成功条数 	
	 * @author:wangchun
	 */
	public int removeTerminalInfoById(Long id);
	
	/**
	 * <p>Discription:[考勤机配置表数据批量删除]</p>
	 * Created on 2020年10月28日
	 * @param ids 考勤机配置表数据id的集合
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int removeTerminalInfoByIds(String ids);
	
}
