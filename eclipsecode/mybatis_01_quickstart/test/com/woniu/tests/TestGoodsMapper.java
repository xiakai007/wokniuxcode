package com.woniu.tests;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Goods;
import com.woniu.bean.vo.GoodsQuery;
import com.woniu.mappers.GoodsMapper;
import com.woniu.utils.MyUtil;

public class TestGoodsMapper {
	private Logger logger=Logger.getLogger(TestGoodsMapper.class);
	@Test
	public void TestSelectGoodsByNameAndPublisherWithMap() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Map<String,Object> mapQuery=new HashMap<>();
		mapQuery.put("nameKey", "��");
		mapQuery.put("publisherKey", "̨");
		List<Goods> goodss=goodsMapper.selectGoodsByNameAndPublisherWithMap(mapQuery);
		for (Goods goods : goodss) {
			System.out.println(goods);
		}
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void TestSelectGoodsByAuthorAndPublisher() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		//GoodsQuery��װ��ѯ����
		GoodsQuery goodsQuery=new GoodsQuery("��", "��");
		List<Goods> goodss=goodsMapper.selectGoodsByAuthorAndPublisher(goodsQuery);
		for (Goods goods : goodss) {
			System.out.println(goods);
		}
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void TestSelectGoodsByAuthorAndHot() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		List<Goods> goodss=goodsMapper.selectGoodsByAuthorAndHot("��", "��");
		for (Goods goods : goodss) {
			System.out.println(goods);
		}
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void TestSelectGoodsByAuthor() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		List<Goods> goodss=goodsMapper.selectGoodsByAuthor("��");
		for (Goods goods : goodss) {
			System.out.println(goods);
		}
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void TestSelectGoodsByNewest() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		/*Goods goods=goodsMapper.selectGoodsByNewest("��");
		System.out.println(goods);*/
		List<Goods> goodss=goodsMapper.selectGoodsByNewest("��");
		for (Goods goods : goodss) {
			System.out.println(goods);
		}
		List<Goods> goodsa=goodsMapper.selectGoodsByNewest("��");
		for (Goods goods : goodsa) {
			System.out.println(goods);
		}
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void TestSelectAllGoods() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		List<Goods> goodss=goodsMapper.selectAllGoods();
		for(Goods goods:goodss){
			logger.debug(goods.getId()+"\t"+goods.getName()+"\t"+goods.getGoodsno());
		}
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void TestSelectGoods() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Goods goods=goodsMapper.selectGoods(4);
		System.out.println(goods);
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void TestUpdateGoods() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Timestamp ts=new Timestamp(new Date().getTime());
		Goods goods=new Goods(3,"����","B003","�űߵ�","̨��������","2019-12-16",6,"����6","ͼ6",106,26.99,
				23.99,5.2,16,ts,6,"��","��","1");
		goodsMapper.updateGoods(goods);
		sqlSession.commit();
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void TestDeleteGoods() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		goodsMapper.deleteGoods(6);
		sqlSession.commit();
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void TestAddGoods() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Timestamp ts=new Timestamp(new Date().getTime());
		Goods goods=new Goods("��qqqq","B00u","��9","��9","2019-12-16",6,"����6","ͼ6",106,26.99,
				16.99,6.5,16,ts,6,"r","t","y");
		goodsMapper.addGoods(goods);
		sqlSession.commit();
		MyUtil.closeSqlSession(sqlSession);
	}

}
