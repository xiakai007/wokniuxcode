package com.woniu.tests;

import com.woniu.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
    @Test
    public void testStaticFactory(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person=(Person)context.getBean("person");
        person.setName("tom");
        person.setGender("男");
        person.setAge(3);
        System.out.println("我的名字是"+person.getName()+",我是"+person.getGender()+",今年"+person.getAge()+"岁");
        System.out.println("*************************");
        Person person2 =(Person) context.getBean("person2");
        person.setName("jack");
        person.setGender("女");
        person.setAge(23);
        System.out.println("我的名字是"+person.getName()+",我是"+person.getGender()+",今年"+person.getAge()+"岁");
    }
}
