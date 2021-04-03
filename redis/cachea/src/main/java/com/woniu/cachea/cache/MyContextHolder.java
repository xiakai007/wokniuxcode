package com.woniu.cachea.cache;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MyContextHolder implements ApplicationContextAware{
    private static ApplicationContext ctx;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx=applicationContext;
        System.out.println("ctx=======>:"+ctx);

    }
    public static Object getBean(String name){
        return ctx.getBean(name);
    }
    public static <T>T getBean(Class<T> clazz){
        return ctx.getBean(clazz);
    }
}
