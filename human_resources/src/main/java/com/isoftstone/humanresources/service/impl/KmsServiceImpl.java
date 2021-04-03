package com.isoftstone.humanresources.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.dao.CommentDao;
import com.isoftstone.humanresources.dao.ZanDao;
import com.isoftstone.humanresources.util.CommonConstant;
import com.isoftstone.humanresources.util.StringUtil;
import org.springframework.stereotype.Service;
import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.dao.KmsDao;
import com.isoftstone.humanresources.domain.gather.KmsModel;
import com.isoftstone.humanresources.service.KmsService;
import org.springframework.util.CollectionUtils;

/** 
 * Description: [知识管理表服务实现]
 * Created on 2020年05月29日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("kmsService")
public class KmsServiceImpl implements KmsService {
	
	/**
	 * <p>Discription:[知识管理表dao]</p>
	 */	
	@Resource
	private KmsDao kmsDao;
	@Resource
	private CommentDao commentDao;
	@Resource
	private ZanDao zanDao;
	
	/**
	 * <p>Discription:[知识管理表数据分页查询]</p>
	 * Created on 2020年05月29日
	 * @param page 知识管理表数据分页条件
	 * @param kmsModel 知识管理表数据查询条件
	 * @param queryFields 知识管理表数据查询字段
	 * @return List<KmsModel>分页数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<KmsModel> queryPageKms(Page page,KmsModel kmsModel,
			String queryFields){
			
		List<KmsModel> listKms = new ArrayList<KmsModel>();
		List<KmsModel> retKmsList = null ;
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
				listKms = this.kmsDao.queryPageKms(page,kmsModel,lis);

				if(!CollectionUtils.isEmpty(listKms)) {
					retKmsList = new ArrayList<KmsModel>();
					for (KmsModel model : listKms) {
						if(!StringUtil.isEmpty(model.getImgs()) && model.getImgs().length() > 5 ){
							List<String> imgList = Arrays.asList (model.getImgs().split(","));
							model.setImgList(imgList);
						}
						model.setCommentSize( commentDao.queryBycomposeIDSize( CommonConstant.EMPTY_STRING+model.getId(), CommonConstant.COMPOSE_TYPE_KS));
						model.setZanSize( zanDao.queryBycomposeIDSize(CommonConstant.EMPTY_STRING+model.getId(), CommonConstant.COMPOSE_TYPE_KS));
						retKmsList.add(model);
					}
				}
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listKms;
	}

	/**
	 * <p>Discription:[知识管理表数据不分页查询]</p>
	 * Created on 2020年05月29日
	 * @param kmsModel 知识管理表数据查询条件
	 * @param queryFields 知识管理表数据查询字段
	 * @return List<KmsModel>数据
	 *													       	 
	 * @author:wangchun
	 */
	public List<KmsModel> queryListKms(KmsModel kmsModel,String queryFields){
		List<KmsModel> listKms = new ArrayList<KmsModel>();
		List<KmsModel> retKmsList = null ;
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			if( null == kmsModel){
				kmsModel = new KmsModel();
			}
			kmsModel.setApproved("TRUE");
			listKms = this.kmsDao.queryListKms(kmsModel,lis);

			if(!CollectionUtils.isEmpty(listKms)) {
				retKmsList = new ArrayList<KmsModel>();
				for (KmsModel model : listKms) {
					if(!StringUtil.isEmpty(model.getImgs()) && model.getImgs().length() > 5 ){
						List<String> imgList = Arrays.asList (model.getImgs().split(","));
						model.setImgList(imgList);
					}
					model.setCommentModelList( commentDao.queryBycomposeID( CommonConstant.EMPTY_STRING+model.getId(), CommonConstant.COMPOSE_TYPE_KS));
					model.setZanModelList( zanDao.queryBycomposeID(CommonConstant.EMPTY_STRING+model.getId(), CommonConstant.COMPOSE_TYPE_KS));
					retKmsList.add(model);
				}
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return retKmsList;
	}

	public PageInfo<KmsModel> querykmsPage(Integer page, Integer pageSize){
		PageInfo<KmsModel> kmsModelPageInfo = new PageInfo<>();
		if (page != null && pageSize != null) {
			PageHelper.startPage(page, pageSize); //分页
			//调用dao接口查询KMS列表
			List<KmsModel> kmsModelList =  this.kmsDao.queryListKms(null,null);
			kmsModelPageInfo = new PageInfo<>(kmsModelList);
		}
		return kmsModelPageInfo;
	}

	/**
	 * <p>Discription:[知识管理表数据查询总条数]</p>
	 * Created on 2020年05月29日
	 * @param kmsModel 知识管理表数据查询条件
	 * @return 查询条数	 
	 * @author:wangchun
	 */
	public Long queryCountKms(KmsModel kmsModel){
		
		Long count = (long)0;
		try{
			count = this.kmsDao.queryCountKms(kmsModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询知识管理表数据]</p>
	 * Created on 2020年05月29日
	 * @param id 知识管理表数据id
	 * @return KmsModel 单条数据	 
	 * @author:wangchun
	 */
	public KmsModel queryKmsById(Long id){
		
		KmsModel model = new KmsModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.kmsDao.queryKmsById(id,null);

				if(null == model){
					return null;
				}
				if(!StringUtil.isEmpty(model.getImgs()) && model.getImgs().length() > 5 ){
					List<String> imgList = Arrays.asList (model.getImgs().split(","));
					model.setImgList(imgList);
				}
				// 查询所有的评论信息
				model.setCommentModelList( commentDao.queryBycomposeID( CommonConstant.EMPTY_STRING+id, CommonConstant.COMPOSE_TYPE_KS));
				// 查询所有的点赞信息
				model.setZanModelList( zanDao.queryBycomposeID(CommonConstant.EMPTY_STRING+id, CommonConstant.COMPOSE_TYPE_KS));


			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[知识管理表数据新增]</p>
	 * Created on 2020年05月29日
	 * @param kmsModel 知识管理表数据
	 * @return String 添加成功的id
	 
	 * @author:wangchun
	 */
	public int save(KmsModel kmsModel){
		int count = 0;
		try{
			if(!CollectionUtils.isEmpty(kmsModel.getImgList())){
				String tmpStr = "";
				for(int i = 0;i<kmsModel.getImgList().size() ;i++ ){
					String str = kmsModel.getImgList().get(i);
					if(i==0){
						tmpStr = str ;
						continue;
					}
					tmpStr = tmpStr + "," + str ;
				}
				kmsModel.setImgs(tmpStr);
			}
			count = this.kmsDao.addKms(kmsModel);

		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[知识管理表数据编辑]</p>
	 * Created on 2020年05月29日
	 * @param kmsModel 知识管理表数据
	 * @return 成功条数 	
	 *								    
	 * @author:wangchun
	 */
	public int edit(KmsModel kmsModel){
		Integer count = 0;
		try{
			if(Objects.isNull(kmsModel) || Objects.isNull(kmsModel.getId())){
				return 0;
			}else{
				count = this.kmsDao.updateKms(kmsModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[知识管理表数据删除]</p>
	 * Created on 2020年05月29日
	 * @param id 知识管理表数据id
	 * @return 成功条数 	
	 *								   
	 * @author:wangchun
	 */
	public int removeKmsById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.kmsDao.removeKmsById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[知识管理表数据批量删除]</p>
	 * Created on 2020年05月29日
	 * @param ids 知识管理表数据id的集合
	 * @return 成功条数
	 *								  	 
	 * @author:wangchun
	 */
	public int removeKmsByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.kmsDao.removeKmsByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
