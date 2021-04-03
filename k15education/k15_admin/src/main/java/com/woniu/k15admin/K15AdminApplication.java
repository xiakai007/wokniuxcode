package com.woniu.k15admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@MapperScan(basePackages = "com.woniu.k15admin.mapper")
@SpringBootApplication
@EnableSwagger2
public class K15AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(K15AdminApplication.class, args);
	}

}
