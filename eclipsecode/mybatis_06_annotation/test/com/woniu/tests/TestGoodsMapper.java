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
	public void TestUpdateGoods(){
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Goods goodsUpd = new Goods(1,"aaaa","ssss","dddd");
		goodsMapper.updateGoods(goodsUpd);
		sqlSession.commit();
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void TestSelectGoodsByDSqlGoods(){
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Goods goodsQuery = new Goods(" È","¿Ó","ÃÏΩÚ");
		List<Goods> goodses=goodsMapper.selectGoodsByDSqlGoods(goodsQuery);
		for (Goods goods : goodses) {
			logger.info(goods.getId()+"\t"+goods.getName());
		}
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void TestSelectGoodsByGoodsno(){
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Goods goods=goodsMapper.selectGoodsByGoodsno("6523715169109");
		logger.info(goods.getName()+"\t"+goods.getCategory().getName());
		sqlSession.commit();
		MyUtil.closeSqlSession(sqlSession);
	}
	
}
