package com.woniu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMapper {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    }
}
