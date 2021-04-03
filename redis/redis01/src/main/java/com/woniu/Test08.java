package com.woniu;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Test08 {
    public static void main(String[] args) throws Exception {
        AtomicStampedReference atomicStampedReference=new AtomicStampedReference(10,0);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1-"+atomicStampedReference.getReference());
                //获取当前版本戳
                int stamp = atomicStampedReference.getStamp();
                System.out.println("thread1-stamp:"+stamp);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean flag = atomicStampedReference.compareAndSet(10, 11, stamp, stamp + 1);
                System.out.println("thread1:"+flag);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //让出CPU的控制权并重新争夺
                Thread.yield();
                System.out.println("thread2-"+atomicStampedReference.getReference());
                atomicStampedReference.compareAndSet(10, 11, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
                System.out.println("thread2-"+atomicStampedReference.getReference()+",thread2-stamp:"+atomicStampedReference.getStamp());
                atomicStampedReference.compareAndSet(11, 10, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
                System.out.println("thread2-"+atomicStampedReference.getReference()+",thread2-stamp:"+atomicStampedReference.getStamp());
            }
        });
        thread1.start();
        thread2.start();
    }
}
