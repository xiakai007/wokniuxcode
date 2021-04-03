package com.woniu.mybatisinterceptor.cache;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * MyContextHolder类必须在MyCache类之前加载
 */
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
