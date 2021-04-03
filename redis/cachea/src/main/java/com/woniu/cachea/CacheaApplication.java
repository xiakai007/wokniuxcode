package com.woniu.cachea;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.woniu.cachea.mapper")
public class CacheaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheaApplication.class, args);
	}

}
