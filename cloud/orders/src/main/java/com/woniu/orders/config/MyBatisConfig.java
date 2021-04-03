package com.woniu.orders.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.woniu.orders.mbg.mapper")
public class MyBatisConfig {
}
