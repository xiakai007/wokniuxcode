package com.woniu.orders.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @SentinelResource("myservice")
    public String getTest(){
        System.out.println("into getTest()");
        return "this is a test";
    }
}
