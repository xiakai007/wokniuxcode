package com.woniu;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class MoneyLog implements MethodBeforeAdvice,AfterReturningAdvice,ThrowsAdvice {
    @Override
    public void afterReturning(@Nullable Object o, Method method, Object[] objects, @Nullable Object o1) throws Throwable {
        if(method.getName().equals("saveMoney")){
            System.out.println("[日志]可以获取"+o+"元");
        }
    }

    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        if(method.getName().equals("saveMoney")){
            System.out.println("[日志]准备存钱"+objects[0]+"元");
        }
    }
    public void afterThrowing(Exception e){
        System.out.println("[日志]检查异常");
    }
    public void afterThrowing(RuntimeException e){
        System.out.println("[日志]运行时异常");
    }
}
