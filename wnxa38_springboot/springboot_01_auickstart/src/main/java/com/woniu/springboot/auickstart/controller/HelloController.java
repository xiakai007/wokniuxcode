package com.woniu.springboot.auickstart.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    @Value("${org.giles.name}")
    private String name;
    @Value("${org.giles.age}")
    private Integer age;
    @GetMapping(value="/hello")
    public Map<String,Object> hello(){
        Map<String,Object> map=new HashMap<>();
        map.put("name",name);
        map.put("age",age);
        return map;
    }
}
