package com.woniu.cachea;

import com.woniu.cachea.entity.Stu;
import com.woniu.cachea.mapper.StuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class CacheaApplicationTests {
	@Autowired
	private StuMapper stuMapper;
	@Test
	void contextLoads() {
	}
	@Test
	void test1(){
		List<Stu> stus = stuMapper.selectByExample(null);
		for (Stu stu : stus) {
			System.out.println(stu.getName());
		}
	}
	@Test
	void test2(){
		List<Stu> stus = stuMapper.selectByExample(null);
		for (Stu stu : stus) {
			System.out.println(stu.getName());
		}
	}
	@Test
	void test3(){
		List<Stu> stus = stuMapper.selectByExample(null);
		for (Stu stu : stus) {
			System.out.println(stu.getName());
		}
	}
	@Test
	void test4(){
		Stu stu = stuMapper.selectByPrimaryKey(7);
		System.out.println(stu.getName());
	}

}
