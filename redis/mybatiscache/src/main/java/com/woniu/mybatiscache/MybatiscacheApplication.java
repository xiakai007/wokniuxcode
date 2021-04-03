package com.woniu.mybatiscache;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.woniu.mybatiscache.mapper")
public class MybatiscacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatiscacheApplication.class, args);
	}

}
