package com.woniu.seckill;

import java.util.concurrent.CountDownLatch;

public class Test2 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                    System.out.println("***********");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        countDownLatch.countDown();
        countDownLatch.countDown();
        countDownLatch.countDown();
    }
}
