package com.woniu.smartremind.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.woniu.smartremind.mbg.mapper","com.woniu.smartremind.dao"})
public class MybatisConfig {
}
