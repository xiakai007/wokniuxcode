package com.woniu.autha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class AuthaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthaApplication.class, args);
	}

}
