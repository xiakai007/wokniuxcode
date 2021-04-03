package com.woniu.seckill;

import java.util.concurrent.CountDownLatch;

public class Test3 {
    public volatile int i=0;
    public void add(){
        i=5;
    }
    public static void main(String[] args) {
        Test3 t = new Test3();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"-begin");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t.add();
                System.out.println(Thread.currentThread().getName()+"-end");
            }
        }).start();
        while (t.i==0){
            //System.out.println("999");
        }
        System.out.println("over");
    }
}
