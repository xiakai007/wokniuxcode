package com.woniu.mybatisinterceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/say")
    public String say(){
        return "HelloWorld";
    }
}
