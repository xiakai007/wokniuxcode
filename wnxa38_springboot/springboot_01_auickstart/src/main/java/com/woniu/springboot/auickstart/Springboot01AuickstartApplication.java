package com.woniu.springboot.auickstart;

import com.woniu.springboot.auickstart.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
//@SpringBootApplication(scanBasePackages = {"myconfig","com"})//方式三
//@Import({myconfig.Config.class})//方式二
@SpringBootApplication
@ComponentScan(basePackages = {"myconfig","com"})//方式一
public class Springboot01AuickstartApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot01AuickstartApplication.class, args);
	}
	@Bean
	public User getUserBean(){
		return new User("user-艾a",32);
	}
}
