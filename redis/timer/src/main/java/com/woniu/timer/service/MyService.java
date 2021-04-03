package com.woniu.timer.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class MyService {
    @Scheduled(cron = "0/2 * * * * ? ")
    public void test(){
        System.out.println("2222222");
    }
}
