package com.woniu.mybatisinterceptor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HottableConfig {
    @Value("${hottable}")
    public List hottables;
    public List getHottables(){
        return hottables;
    }
}
