package com.woniu.springboot.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@MapperScan(basePackages = "com.woniu.springboot.admin.mapper")
@SpringBootApplication
@EnableSwagger2
public class SpringbootK15AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootK15AdminApplication.class, args);
	}

}
