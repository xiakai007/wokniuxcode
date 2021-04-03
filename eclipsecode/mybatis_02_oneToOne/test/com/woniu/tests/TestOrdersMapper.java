package com.woniu.tests;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Orders;
import com.woniu.mappers.OrdersMapper;
import com.woniu.utils.MyUtil;

public class TestOrdersMapper {
	private Logger logger=Logger.getLogger(TestOrdersMapper.class);
	@Test
	public void testSelectAllOrders() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		OrdersMapper ordersMapper=sqlSession.getMapper(OrdersMapper.class);
		List<Orders> orderses=ordersMapper.selectALLOrders();
		for (Orders orders : orderses) {
			logger.info(orders.getOrderno()+"\t"+orders.getUser().getAccount()+"\t"+orders.getMoney());
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}
