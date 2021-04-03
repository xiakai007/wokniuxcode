package com.woniu.aspect;

public class LogAspect {
    public void beforeMethod(){
        System.out.println("调用方法前：");
    }
    public void afterReturningMethod(){
        System.out.println("调用方法后：");
    }
}
