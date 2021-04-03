package com.woniu.tests;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Address;
import com.woniu.mappers.AddressMapper;
import com.woniu.utils.MyUtil;

public class TestAddressMapper {
	private Logger logger=Logger.getLogger(TestAddressMapper.class);
	@Test
	public void testSelectAllAddress() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		AddressMapper addressMapper=sqlSession.getMapper(AddressMapper.class);
		List<Address> addresses =addressMapper.selectAllAddr();
		for (Address address : addresses) {
			logger.info(address.getId()+"\t"+address.getUser().getAccount()+"\t"+address.getCity());
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}
