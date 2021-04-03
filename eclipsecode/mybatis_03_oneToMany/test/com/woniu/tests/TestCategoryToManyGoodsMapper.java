package com.woniu.tests;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Category;
import com.woniu.bean.pojo.Goods;
import com.woniu.mappers.CategoryMapper;
import com.woniu.mappers.CategoryMapper2;
import com.woniu.utils.MyUtil;

public class TestCategoryToManyGoodsMapper {
	private Logger logger=Logger.getLogger(TestCategoryToManyGoodsMapper.class);
	@Test
	public void testNesting() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		CategoryMapper2 categoryMapper2=sqlSession.getMapper(CategoryMapper2.class);
		Category category=categoryMapper2.selectCategoryById(1);
		logger.info(category.getId()+"\t"+category.getName());
		List<Goods> goodses=category.getGoodses();
		for (Goods goods : goodses) {
			logger.info("\t"+goods.getName()+"\t"+goods.getGoodsno());
		}
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void testSubstep() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		CategoryMapper categoryMapper=sqlSession.getMapper(CategoryMapper.class);
		Category category=categoryMapper.selectCategoryById(1);
		logger.info(category.getId()+"\t"+category.getName());
		List<Goods> goodses=category.getGoodses();
		for (Goods goods : goodses) {
			logger.info("\t"+goods.getName()+"\t"+goods.getGoodsno());
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}
