package com.woniu.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.woniu.service.impl.*.*(..))")
    public void pc(){}
    @Before("pc()")
    public void beforeMethod(){
        System.out.println("调用方法前：");
    }
    @AfterReturning("pc()")
    public void afterReturningMethod(){
        System.out.println("调用方法后：");
    }
}
