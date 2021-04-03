package com.woniu.tests;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Goods;
import com.woniu.bean.pojo.User;
import com.woniu.mappers.UserMapper;
import com.woniu.utils.MyUtil;

public class TestUserToManyGoods {
	private Logger logger=Logger.getLogger(TestUserToManyGoods.class);
	@Test
	public void testManyGoods() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		User user=userMapper.selectUserById(1);
		logger.info("一个用户对应多个商品");
		for(Goods goods:user.getGoodses()){
			logger.info(goods.getName()+"\t"+user.getAccount());
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}
