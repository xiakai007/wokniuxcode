package com.woniu.tests;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Cart;
import com.woniu.mappers.CartMapper;
import com.woniu.utils.MyUtil;

public class TestCartMapper {
	private Logger logger=Logger.getLogger(TestCartMapper.class);
	@Test
	public void testSelectAllCart() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		CartMapper cartMapper=sqlSession.getMapper(CartMapper.class);
		List<Cart> carts=cartMapper.selectAllCart();
		for (Cart cart : carts) {
			logger.info(cart.getId()+"\t"+cart.getUser().getAccount()+"\t"+cart.getGoods().getName()+"\t"+cart.getPrice());
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}
