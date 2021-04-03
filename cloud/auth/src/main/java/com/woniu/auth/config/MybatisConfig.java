package com.woniu.auth.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.woniu.auth.mbg.mapper")
public class MybatisConfig {
}
