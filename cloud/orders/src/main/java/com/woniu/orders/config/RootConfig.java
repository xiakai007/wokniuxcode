package com.woniu.orders.config;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class RootConfig {
    @Bean
    public FilterRegistrationBean sentinelFilterRegistration(){
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CommonFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY,"false");
        registrationBean.setName("sentinelFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
