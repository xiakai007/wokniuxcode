package com.woniu.product.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.woniu.product.mbg.mapper")
public class MybatisConfig {
}
