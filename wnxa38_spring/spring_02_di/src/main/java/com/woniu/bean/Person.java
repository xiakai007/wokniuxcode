package com.woniu.bean;

import lombok.Data;

@Data
public class Person {
    private String name;
    public String introduce(){
        return "我的名字是"+name;
    }
}
