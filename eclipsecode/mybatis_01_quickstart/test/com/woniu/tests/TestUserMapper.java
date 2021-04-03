package com.woniu.tests;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.User;
import com.woniu.mappers.UserMapper;
import com.woniu.utils.MyUtil;

public class TestUserMapper {
	private Logger logger=Logger.getLogger(TestUserMapper.class);
	@Test
	public void testAddUser() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		Timestamp ts=new Timestamp(new Date().getTime());
		User user = new User("zxcv","123qwe","er32@qq.com","fgh",29,ts,"0");
		int count=userMapper.addUser(user);
		logger.debug(count);
		logger.debug(user.getUserId());
		sqlSession.commit();
		MyUtil.closeSqlSession(sqlSession);		
	}
	@Test
	public void testSelectAll() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		List<User> users=userMapper.selectAll();
		for (User user : users) {
			logger.info(user);
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}
