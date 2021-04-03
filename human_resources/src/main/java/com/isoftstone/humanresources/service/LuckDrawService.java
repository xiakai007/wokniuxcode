package com.isoftstone.humanresources.service;

import java.util.List;

import com.isoftstone.humanresources.domain.LuckDrawModel;
import com.isoftstone.humanresources.domain.Result;

/**
 * Description: [抽奖信息表服务]
 * Created on 2019年12月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2019年
 */
public interface LuckDrawService {

	 /**
	 * <p>Discription:[抽奖信息表数据不分页查询]</p>
	 * Created on 2019年12月13日
	 * @param luckDrawModel 抽奖信息表数据查询条件
	 * @param queryFields 抽奖信息表数据查询字段集合
	 * @return List<LuckDrawModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	 public	List<LuckDrawModel> queryListLuckDraw(LuckDrawModel luckDrawModel, String queryFields);
	
	/**
	 * <p>Discription:[抽奖信息表数据查询总条数]</p>
	 * Created on 2019年12月13日
	 * @param luckDrawModel 抽奖信息表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountLuckDraw(LuckDrawModel luckDrawModel);
	
	/**
	 * <p>Discription:[根据id查询抽奖信息表数据]</p>
	 * Created on 2019年12月13日
	 * @param id 抽奖信息表数据id
	 * @return LuckDrawModel 单条数据	 
	 * @author:wangchun
	 */
	public LuckDrawModel queryLuckDrawById(Integer id);

	/**
	 * <p>Discription:[抽奖信息表数据新增]</p>
	 * Created on 2019年12月13日
	 * @param luckDrawModel 抽奖信息表数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public int save(LuckDrawModel luckDrawModel);

	public Result addLuckDraw(LuckDrawModel luckDrawModel);
	
	/**
	 * <p>Discription:[抽奖信息表数据编辑]</p>
	 * Created on 2019年12月13日
	 * @param luckDrawModel 抽奖信息表数据
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int edit(LuckDrawModel luckDrawModel);
	
	/**
	 * <p>Discription:[抽奖信息表数据删除]</p>
	 * Created on 2019年12月13日
	 * @param id 抽奖信息表数据id
	 * @return 成功条数 	
	 * @author:wangchun
	 */
	public int removeLuckDrawById(Long id);
	
	/**
	 * <p>Discription:[抽奖信息表数据批量删除]</p>
	 * Created on 2019年12月13日
	 * @param ids 抽奖信息表数据id的集合
	 * @return 成功条数 
	 * @author:wangchun
	 */
	public int removeLuckDrawByIds(String ids);

	public int queryLuckDrawByName(String employeeName);
	
}
