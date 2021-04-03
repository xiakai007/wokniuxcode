package com.woniu.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.bean.pojo.Category;
import com.woniu.bean.pojo.Goods;
import com.woniu.mappers.GoodsMapper;
import com.woniu.utils.MyUtil;

public class TestDynamicSqlMapper {
	private Logger logger=Logger.getLogger(TestDynamicSqlMapper.class);
	@Test
	public void testSelectGoodsByMap() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Integer[] ids={1,2,3};
		Map<String,Integer[]> mapIds=new HashMap<>();
		mapIds.put("map", ids);
		List<Goods> goodses=goodsMapper.selectGoodsByMap(mapIds);
		for (Goods goods : goodses) {
			logger.info(goods.getId()+"\t"+goods.getName());
		}
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void testSelectGoodsByList() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		List<Integer> ids=new ArrayList<>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		List<Goods> goodses=goodsMapper.selectGoodsByList(ids);
		for (Goods goods : goodses) {
			logger.info(goods.getId()+"\t"+goods.getName());
		}
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void testSelectGoodsByIds() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Integer[] ids={1,2,3}; 
		List<Goods> goodses=goodsMapper.selectGoodsByIds(ids);
		for (Goods goods : goodses) {
			logger.info(goods.getId()+"\t"+goods.getName());
		}
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void testUpdateGoodsWithTrim() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Goods goods = new Goods();
		goods.setName("123qwe");
		goods.setAuthor("tomcat");
		Category category = new Category();
		category.setId(3);
		goods.setId(1);
		goods.setCategory(category);
		int num=goodsMapper.updateGoodsWithTrim(goods);
		//必须提交事务
		sqlSession.commit();
		logger.info("成功更新"+num+"条数据");
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void testSelectDSWithTrim() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Page<Goods> page=PageHelper.startPage(1, 5);
		Goods goodsParam = new Goods();
		goodsParam.setName("IT");
		goodsParam.setAuthor("");
		goodsParam.setPublisher("清华大学出版社");
		Category category = new Category();
		category.setId(1);
		goodsParam.setCategory(category);
		List<Goods> goodses=goodsMapper.selectGoodsByDSWithTrim(goodsParam);
		int num=page.getPages();
		logger.info("每页有"+goodses.size()+"条数据");
		logger.info("共有"+num+"页");
		for (Goods goods : goodses) {
			logger.info(goods.getPublisher()+"\t"+goods.getCategory().getName()+"\t"+goods.getAuthor()+"\t"+goods.getName());
		}
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void testDynamicSqlUpdateGoods() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Goods goodsParam = new Goods();
		Category category = new Category();
		category.setId(1);
		goodsParam.setCategory(category);
		goodsParam.setName("地地道道");
		goodsParam.setId(1);
		int num=goodsMapper.updateGoods(goodsParam);
		//必须提交事务
		sqlSession.commit();
		logger.info("更新了"+num+"条数据");
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void testDynamicSqlCategory() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Page<Goods> page=PageHelper.startPage(1, 10);//startPage(当前页, 每页条目数)
		Goods goodsParam = new Goods();
		goodsParam.setName("传");
		Category category=new Category();
		category.setId(3);
		goodsParam.setCategory(category);
		List<Goods> goodses=goodsMapper.selectGoodsByDSqlCategory(goodsParam);
		
		int pages=page.getPages();
		logger.info("每页有"+goodses.size()+"条数据");
		logger.info("共有"+pages+"页");
		for (Goods goods : goodses) {
			logger.info(goods.getPublisher()+"\t"+goods.getAuthor()+"\t"+goods.getCategory().getName()+"\t"+goods.getName());
		}
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void testDynamicSql() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Page<Goods> page=PageHelper.startPage(1, 5);
		List<Goods> goodses=goodsMapper.selectGoodsByDynamicSql("  IT ".trim(), "李", null);
		int pages=page.getPages();
		logger.info("共有"+pages+"页");
		for (Goods goods : goodses) {
			logger.info(goods.getId()+"\t"+goods.getPublisher()+"\t"+goods.getAuthor()+"\t"+goods.getName());
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}
