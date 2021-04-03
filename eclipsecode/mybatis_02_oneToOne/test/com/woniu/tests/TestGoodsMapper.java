package com.woniu.tests;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Goods;
import com.woniu.mappers.GoodsMapper;
import com.woniu.utils.MyUtil;

public class TestGoodsMapper {
	private Logger logger=Logger.getLogger(TestGoodsMapper.class);
	@Test
	public void testSelectGoodsAll() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		List<Goods> goodss=goodsMapper.selectGoodsAll();
		for (Goods goods : goodss) {
			logger.info(goods.getId()+"\t"+goods.getName()+"\t"+goods.getCategory().getName());
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}
