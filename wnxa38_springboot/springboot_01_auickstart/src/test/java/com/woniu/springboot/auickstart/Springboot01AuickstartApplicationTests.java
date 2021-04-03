package com.woniu.springboot.auickstart;

import com.woniu.springboot.auickstart.pojo.Person;
import com.woniu.springboot.auickstart.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Springboot01AuickstartApplicationTests {
	@Autowired
	//@Qualifier("beihai")
	@Qualifier("getPerson2")
	private Person person;
	@Autowired
	@Qualifier("getUser")
	private User user;
	@Test
	void test1() {
		System.out.println(person);
	}
	@Test
	void test2() {
		System.out.println(user);
	}

}
