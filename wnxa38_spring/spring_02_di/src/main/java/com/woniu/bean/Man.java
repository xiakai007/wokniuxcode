package com.woniu.bean;

import lombok.Data;

@Data
public class Man {
    private String name;
    private Wife wife;
    public String introduce(){
        return "我的名字是"+name+",我的妻子是"+wife.getName();
    }
}
