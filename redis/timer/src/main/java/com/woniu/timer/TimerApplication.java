package com.woniu.timer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TimerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimerApplication.class, args);
	}

}
