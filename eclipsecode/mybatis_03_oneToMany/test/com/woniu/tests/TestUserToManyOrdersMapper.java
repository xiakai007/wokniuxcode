package com.woniu.tests;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Orders;
import com.woniu.bean.pojo.User;
import com.woniu.mappers.UserMapper;
import com.woniu.utils.MyUtil;

public class TestUserToManyOrdersMapper {
	private Logger logger=Logger.getLogger(TestUserToManyOrdersMapper.class);
	@Test
	public void testManyOrdersMapper() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		User user=userMapper.selectUserById(1);
		logger.info("一个用户对应多个订单");
		for(Orders orders:user.getOrders()){
			logger.info(orders.getOrderno()+"\t"+user.getAccount());
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}
