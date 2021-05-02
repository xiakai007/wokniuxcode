package com.woniu.mymall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.woniu.mymall.mapper")
public class MymallApplication {

	public static void main(String[] args) {
		SpringApplication.run(MymallApplication.class, args);
	}

}
