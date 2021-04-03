package com.woniu;

import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class Test07 {
    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("1111");
//            }
//        },5000);
        System.out.println("****");
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("5秒后执行了");
//            }
//        },new Date(System.currentTimeMillis()+5000));
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(55551111);
            }
        },5000,1000);
    }
}
