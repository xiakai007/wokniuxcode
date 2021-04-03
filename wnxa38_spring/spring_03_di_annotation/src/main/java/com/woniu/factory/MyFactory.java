package com.woniu.factory;

import com.woniu.pojo.Person;

public class MyFactory {
    public static Person getStaticIntance(){
        return new Person();
    }
}
