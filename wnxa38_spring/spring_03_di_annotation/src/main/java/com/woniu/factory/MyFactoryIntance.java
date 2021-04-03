package com.woniu.factory;

import com.woniu.pojo.Person;

public class MyFactoryIntance {
    public Person getIntance(){
        return new Person();
    }
}
