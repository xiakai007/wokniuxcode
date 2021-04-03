package com.woniu.springboot.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan(basePackages = "com.woniu.springboot.mp.mapper")
@SpringBootApplication
public class Springboot03MpApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot03MpApplication.class, args);
	}

}
