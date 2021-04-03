package com.woniu.tests;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Category;
import com.woniu.bean.pojo.Goods;
import com.woniu.mappers.CategoryMapper;
import com.woniu.utils.MyUtil;

public class TestCategoryMapper {
	private Logger logger=Logger.getLogger(TestCategoryMapper.class);
	@Test
	public void TestSelectCategoryByIdRef(){
		SqlSession sqlSession=MyUtil.getSqlSession();
		CategoryMapper categoryMapper=sqlSession.getMapper(CategoryMapper.class);
		Category category=categoryMapper.selectCategoryByIdRef(1);
		for(Goods goods:category.getGoodsList()){
			logger.info(category.getName()+"\t"+goods.getName());
		}
		sqlSession.commit();
		MyUtil.closeSqlSession(sqlSession);
	}
	
}
