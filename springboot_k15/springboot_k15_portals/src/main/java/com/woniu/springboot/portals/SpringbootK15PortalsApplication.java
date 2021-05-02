package com.woniu.springboot.portals;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.woniu.springboot.portals.mapper")
public class SpringbootK15PortalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootK15PortalsApplication.class, args);
	}

}
