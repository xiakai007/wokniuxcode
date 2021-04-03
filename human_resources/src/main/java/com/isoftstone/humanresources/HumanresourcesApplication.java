package com.isoftstone.humanresources;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.isoftstone.humanresources")
@MapperScan("com.isoftstone.humanresources.dao")
public class HumanresourcesApplication {

    public static void main(String[] args) {
        SpringApplication.run(HumanresourcesApplication.class, args);
    }

}
