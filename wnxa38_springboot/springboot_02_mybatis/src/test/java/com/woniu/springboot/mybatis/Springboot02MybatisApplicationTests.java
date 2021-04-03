package com.woniu.springboot.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.woniu.mapper.UserMapper;
import com.woniu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class Springboot02MybatisApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private DruidDataSource druidDataSource;
	@Test
	void contextLoads() {
		List<User> userList = userMapper.selectUserByProperty(null);
		for(User user:userList){
			System.out.println(user.getRealname()+"\t"+user.getDept().getDname());
		}
	}
	@Test
	void test2() {
		try {
			DruidPooledConnection connection = druidDataSource.getConnection();
			System.out.println("connection:"+connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
