package com.woniu.seckill;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static AtomicInteger count=new AtomicInteger(0);
    public static void main(String[] args) {
//        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
//        Set<Map.Entry<Thread, StackTraceElement[]>> entries = allStackTraces.entrySet();
//        for (Map.Entry<Thread, StackTraceElement[]> entry : entries) {
//            System.out.println(entry.getKey()+"\t"+entry.getValue());
//        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 800; j++) {
                        try {
                            countDownLatch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        count.getAndIncrement();
                    }
                }
            }).start();
        }
        countDownLatch.countDown();
        while (Thread.activeCount()!=2){
            Thread.yield();
        }
        System.out.println(count);
    }
}
