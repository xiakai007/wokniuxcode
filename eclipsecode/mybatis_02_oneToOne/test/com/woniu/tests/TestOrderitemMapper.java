package com.woniu.tests;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Orderitem;
import com.woniu.mappers.OrderitemMapper;
import com.woniu.utils.MyUtil;

public class TestOrderitemMapper {
	private Logger logger=Logger.getLogger(TestOrderitemMapper.class);
	@Test
	public void testSelectAllOrderitem() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		OrderitemMapper orderitemMapper=sqlSession.getMapper(OrderitemMapper.class);
		List<Orderitem> orderitems=orderitemMapper.selectAllOrderitem();
		for (Orderitem orderitem : orderitems) {
			logger.info(orderitem.getId()+"\t"+orderitem.getOrders().getOrderno()+"\t"+orderitem.getGoods().getName()+"\t"+orderitem.getNums());
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}
