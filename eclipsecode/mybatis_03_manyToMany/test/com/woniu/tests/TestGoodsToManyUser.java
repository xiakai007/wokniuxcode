package com.woniu.tests;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Goods;
import com.woniu.bean.pojo.User;
import com.woniu.mappers.GoodsMapper;
import com.woniu.utils.MyUtil;

public class TestGoodsToManyUser {
	private Logger logger=Logger.getLogger(TestGoodsToManyUser.class);
	@Test
	public void testManyUser() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Goods goods=goodsMapper.selectGoodsByid(1);
		logger.info("一个商品对应多个用户");
		for(User user:goods.getUsers()){
			logger.info(goods.getName()+"\t"+user.getAccount());
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}
