package com.woniu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 最完美的懒汉单例模式
 */
public class Test09 {
    private volatile static Test09 test09;
    private Test09(){}
    public static Test09 getInstance(){
        ExecutorService executorService = Executors.newScheduledThreadPool(3);
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        if (test09 == null) {
            synchronized(Test09.class){
                if (test09 == null) {
                    test09=new Test09();
                }
            }
        }
        return test09;
    }
}
