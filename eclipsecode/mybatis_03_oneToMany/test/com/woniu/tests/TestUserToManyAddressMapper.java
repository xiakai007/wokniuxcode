package com.woniu.tests;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Address;
import com.woniu.bean.pojo.User;
import com.woniu.mappers.UserMapper;
import com.woniu.utils.MyUtil;

public class TestUserToManyAddressMapper {
	private Logger logger=Logger.getLogger(TestUserToManyAddressMapper.class);
	@Test
	public void testUser() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		User user=userMapper.selectUserById(1);
		logger.info("一个用户对应多个地址");
		for(Address address:user.getAddrs()){
			logger.info(user.getAccount()+"\t"+user.getPassword()+"\t"+address.getCity());
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}
