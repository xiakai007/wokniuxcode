package com.woniu.tests;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.woniu.bean.pojo.Goods;
import com.woniu.utils.MyUtil;

public class TestGoodsApi {
	@Test
	public void selectAllGoods() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		List<Goods> goodss=sqlSession.selectList("com.woniu.mappers.GoodsMapper.selectAllGoods");
		for(Goods goods:goodss){
			System.out.println(goods);
		}
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void selectGoods() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		Goods goods=sqlSession.selectOne("com.woniu.mappers.GoodsMapper.selectGoods", 4);
		System.out.println(goods);
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void updateGoods() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		Timestamp ts=new Timestamp(new Date().getTime());
		Goods goods=new Goods(4,"心理学原理","B00444","作44","出44","2019-12-14",4,"描述4","图4",104,24.99,
				14.99,4.5,14,ts,4,"q","w","e");
		sqlSession.update("com.woniu.mappers.GoodsMapper.updateGoods", goods);
		sqlSession.commit();
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void deleteGoods() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		sqlSession.delete("com.woniu.mappers.GoodsMapper.deleteGoods", 6);
		sqlSession.commit();
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void addGoods() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		Timestamp ts=new Timestamp(new Date().getTime());
		Goods goods=new Goods("书4","B004","作4","出4","2019-12-14",4,"描述4","图4",104,24.99,
				14.99,4.5,14,ts,4,"q","w","e");
		sqlSession.insert("com.woniu.mappers.GoodsMapper.addGoods", goods);
		sqlSession.commit();
		MyUtil.closeSqlSession(sqlSession);
	}

}
