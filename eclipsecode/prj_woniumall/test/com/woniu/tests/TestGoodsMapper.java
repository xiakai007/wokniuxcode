package com.woniu.tests;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.bean.pojo.Goods;
import com.woniu.mappers.GoodsMapper;
import com.woniu.utils.MyBatisUtil;

public class TestGoodsMapper {
	private Logger logger=Logger.getLogger(TestGoodsMapper.class);
	@Test
	public void test() {
		SqlSession sqlSession=MyBatisUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Page<Goods> page=PageHelper.startPage(1, 12);
		List<Goods> goodses=goodsMapper.selectGoodsByNewest();
		logger.info(goodses.size()+"ÌõÊý¾Ý");
		logger.info(page.getPages()+"Ò³");
		for (Goods goods : goodses) {
			logger.info(goods.getName());
		}
		MyBatisUtil.closeSqlSession(sqlSession);
	}

}
