package com.woniu.mybatiscache;

import com.woniu.mybatiscache.entity.Student;
import com.woniu.mybatiscache.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class MybatiscacheApplicationTests {
	@Autowired
	private StudentMapper studentMapper;
	@Test
	void contextLoads() {
	}
	@Test
	void test1(){
		List<Student> students = studentMapper.selectAllStudent();
		System.out.println(students);
	}
	@Test
	void test2(){
		List<Student> students = studentMapper.selectAllStudent();
		System.out.println(students);
	}
	@Test
	void test3(){
		List<Student> students = studentMapper.selectAllStudent();
		System.out.println(students);
	}
}
