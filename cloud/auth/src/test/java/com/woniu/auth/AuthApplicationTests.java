package com.woniu.auth;


import com.woniu.auth.mbg.mapper.UserinfoMapper;
import com.woniu.auth.mbg.model.Userinfo;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class AuthApplicationTests {
	@Autowired
	private UserinfoMapper userinfoMapper;

	@Test
	public void contextLoads() {
	}

//	@Test
//	public void test1(){
//		Userinfo userinfoLogin = userinfoMapper.selectUserinfoLogin("admin","123456");
//		System.out.println(userinfoLogin);
//	}

}
