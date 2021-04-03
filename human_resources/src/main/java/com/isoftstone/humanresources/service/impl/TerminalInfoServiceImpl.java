package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.dao.TerminalInfoDao;
import com.isoftstone.humanresources.domain.workTime.TerminalInfoModel;
import com.isoftstone.humanresources.service.TerminalInfoService;

/** 
 * Description: [考勤机配置表服务实现]
 * Created on 2020年10月28日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("terminalInfoService")
public class TerminalInfoServiceImpl implements TerminalInfoService {
	
	/**
	 * <p>Discription:[考勤机配置表dao]</p>
	 */	
	@Resource
	private TerminalInfoDao terminalInfoDao;
	
	/**
	 * <p>Discription:[考勤机配置表数据分页查询]</p>
	 * Created on 2020年10月28日
	 * @param page 考勤机配置表数据分页条件
	 * @param terminalInfoModel 考勤机配置表数据查询条件
	 * @param queryFields 考勤机配置表数据查询字段
	 * @return List<TerminalInfoModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<TerminalInfoModel> queryPageTerminalInfo(Page page,TerminalInfoModel terminalInfoModel,
			String queryFields){
			
		List<TerminalInfoModel> listTerminalInfo = new ArrayList<TerminalInfoModel>();
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
				listTerminalInfo = this.terminalInfoDao.queryPageTerminalInfo(page,terminalInfoModel,lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listTerminalInfo;
	}

	/**
	 * <p>Discription:[考勤机配置表数据不分页查询]</p>
	 * Created on 2020年10月28日
	 * @param terminalInfoModel 考勤机配置表数据查询条件
	 * @param queryFields 考勤机配置表数据查询字段
	 * @return List<TerminalInfoModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<TerminalInfoModel> queryListTerminalInfo(TerminalInfoModel terminalInfoModel,String queryFields){
		List<TerminalInfoModel> listTerminalInfo = new ArrayList<TerminalInfoModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listTerminalInfo = this.terminalInfoDao.queryListTerminalInfo(terminalInfoModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listTerminalInfo;
	}

	/**
	 * <p>Discription:[考勤机配置表数据查询总条数]</p>
	 * Created on 2020年10月28日
	 * @param terminalInfoModel 考勤机配置表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountTerminalInfo(TerminalInfoModel terminalInfoModel){
		
		Long count = (long)0;
		try{
			count = this.terminalInfoDao.queryCountTerminalInfo(terminalInfoModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询考勤机配置表数据]</p>
	 * Created on 2020年10月28日
	 * @param id 考勤机配置表数据id
	 * @return TerminalInfoModel 单条数据	 
	 * @author:wangchun
	 */
	public TerminalInfoModel queryTerminalInfoById(Long id){
		
		TerminalInfoModel model = new TerminalInfoModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.terminalInfoDao.queryTerminalInfoById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[考勤机配置表数据新增]</p>
	 * Created on 2020年10月28日
	 * @param terminalInfoModel 考勤机配置表数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(TerminalInfoModel terminalInfoModel){
		int count = 0;
		try{
			if(Objects.isNull(terminalInfoModel)){
				return 0;
			}else{
				count = this.terminalInfoDao.addTerminalInfo(terminalInfoModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[考勤机配置表数据编辑]</p>
	 * Created on 2020年10月28日
	 * @param terminalInfoModel 考勤机配置表数据
	 * @return 成功条数 	
	 *								    
	 * @author:wangchun
	 */
	public int edit(TerminalInfoModel terminalInfoModel){
		Integer count = 0;
		try{
			if(Objects.isNull(terminalInfoModel) || Objects.isNull(terminalInfoModel.getId())){
				return 0;
			}else{
				count = this.terminalInfoDao.updateTerminalInfo(terminalInfoModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[考勤机配置表数据删除]</p>
	 * Created on 2020年10月28日
	 * @param id 考勤机配置表数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeTerminalInfoById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.terminalInfoDao.removeTerminalInfoById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[考勤机配置表数据批量删除]</p>
	 * Created on 2020年10月28日
	 * @param ids 考勤机配置表数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeTerminalInfoByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.terminalInfoDao.removeTerminalInfoByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
