package com.woniu.autha.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.woniu.autha.mbg.mapper")
public class MybatisConfig {
}
