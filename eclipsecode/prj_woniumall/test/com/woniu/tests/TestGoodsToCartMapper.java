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

public class TestGoodsToCartMapper {
	private Logger logger=Logger.getLogger(TestGoodsToCartMapper.class);
	@Test
	public void test() {
		SqlSession sqlSession=MyBatisUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		List<Goods> goodsList=goodsMapper.selectAllGoods();
		for (Goods goods : goodsList) {
			logger.info("goods.getPublisher():"+goods.getPublisher());
			logger.info("goods.getCart():"+goods.getCart());
		}
		MyBatisUtil.closeSqlSession(sqlSession);
	}

}
