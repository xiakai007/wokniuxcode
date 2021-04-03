package com.woniu.tests;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Category;
import com.woniu.mappers.CategoryMapper;
import com.woniu.utils.MyUtil;

public class TestFirstCacheMapper {
	private Logger logger=Logger.getLogger(TestFirstCacheMapper.class);
	@Test
	public void testFistCacheInvalid4(){
		SqlSession sqlSession=MyUtil.getSqlSession();
		CategoryMapper categoryMapper=sqlSession.getMapper(CategoryMapper.class);
		Category category=categoryMapper.selectCategoryById(1);
		logger.info(category.getId()+"\t"+category.getName());
		
		Category category3 = new Category();
		category3.setId(5);
		category3.setNavable("N");
		categoryMapper.updateCategory(category3);
		
		Category category2=categoryMapper.selectCategoryById(1);
		logger.info(category2.getId()+"\t"+category2.getName());
	}
	@Test
	public void testCache(){
		SqlSession sqlSession1=MyUtil.getSqlSession();
		CategoryMapper categoryMapper1=sqlSession1.getMapper(CategoryMapper.class);
		Category category1=categoryMapper1.selectCategoryById(1);
		logger.info("--------------sqlSession1-------------");
		logger.info(category1.getId()+"\t"+category1.getName());
		//关闭sqlSession1
		MyUtil.closeSqlSession(sqlSession1);
		//开启sqlSession2
		SqlSession sqlSession2=MyUtil.getSqlSession();
		CategoryMapper categoryMapper2=sqlSession2.getMapper(CategoryMapper.class);
		Category category2=categoryMapper2.selectCategoryById(1);
		logger.info("--------------sqlSession2-------------");
		logger.info(category2.getId()+"\t"+category2.getName());
		MyUtil.closeSqlSession(sqlSession2);
		
		SqlSession sqlSession3=MyUtil.getSqlSession();
		CategoryMapper categoryMapper3=sqlSession3.getMapper(CategoryMapper.class);
		Category category3=categoryMapper3.selectCategoryById(1);
		logger.info("--------------sqlSession2-------------");
		logger.info(category3.getId()+"\t"+category3.getName());
		MyUtil.closeSqlSession(sqlSession3);
		
		SqlSession sqlSession4=MyUtil.getSqlSession();
		CategoryMapper categoryMapper4=sqlSession4.getMapper(CategoryMapper.class);
		Category category4=categoryMapper4.selectCategoryById(1);
		logger.info("--------------sqlSession2-------------");
		logger.info(category4.getId()+"\t"+category4.getName());
		MyUtil.closeSqlSession(sqlSession4);
	}
	@Test
	public void testFistCacheInvalid2(){
		SqlSession sqlSession=MyUtil.getSqlSession();
		CategoryMapper categoryMapper=sqlSession.getMapper(CategoryMapper.class);
		Category category=categoryMapper.selectCategoryById(1);
		logger.info("--------------1-------------");
		logger.info(category.getId()+"\t"+category.getName());
		logger.info("--------------未刷新sqlSession-------------");
		Category category2=categoryMapper.selectCategoryById(1);
		logger.info(category2.getId()+"\t"+category2.getName());
		sqlSession.clearCache();
		logger.info("--------------刷新了sqlSession-------------");
		Category category3=categoryMapper.selectCategoryById(1);
		logger.info(category3.getId()+"\t"+category3.getName());
	}
	@Test
	public void testFistCacheInvalid1(){
		SqlSession sqlSession=MyUtil.getSqlSession();
		CategoryMapper categoryMapper=sqlSession.getMapper(CategoryMapper.class);
		Category category=categoryMapper.selectCategoryById(1);
		logger.info("--------------1-------------");
		logger.info(category.getId()+"\t"+category.getName());
		logger.info("--------------2-------------");
		Category category2=categoryMapper.selectCategoryById(1);
		logger.info(category2.getId()+"\t"+category2.getName());
		logger.info("--------------3-------------");
		Category category3=categoryMapper.selectCategoryById(3);
		logger.info(category3.getId()+"\t"+category3.getName());
		MyUtil.closeSqlSession(sqlSession);
	}
}
