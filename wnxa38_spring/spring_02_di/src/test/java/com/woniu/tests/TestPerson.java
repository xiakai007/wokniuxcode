package com.woniu.tests;

import com.woniu.bean.Man;
import com.woniu.bean.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson {
    @Test
    public void testSimple1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Person person=(Person)context.getBean("person1");
        String introduce = person.introduce();
        System.out.println(introduce);
        Person person2 = (Person) context.getBean("person2");
        String introduce2 = person2.introduce();
        System.out.println(introduce2);
    }
    @Test
    public void testObject(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Man man=(Man)context.getBean("m1");
        String introduce = man.introduce();
        System.out.println(introduce);
    }

}
