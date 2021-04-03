package com.woniu.tests;

import com.woniu.bean.Hello;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
public class TestHello {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Object obj = context.getBean("hello");
        if(obj instanceof Hello){
            Hello hello=(Hello)obj;
            String word=hello.sayHello("Spring");
            System.out.println(word);
        }
    }
    @Test
    public void Test2(){
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("D:\\application.xml"));
        Object obj = factory.getBean("hello");
        if(obj instanceof Hello){
            Hello hello=(Hello)obj;
            String word=hello.sayHello("Tom");
            System.out.println(word);
        }
    }
    @Test
    public void Test3(){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Object obj = context.getBean("hello");
        context.registerShutdownHook();
        if(obj instanceof Hello){
            Hello hello=(Hello)obj;
            String word=hello.sayHello("Jim");
            System.out.println(word);
        }
    }
}
