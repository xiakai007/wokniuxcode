package com.woniu.tests;

import com.woniu.bean.Teacher;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TestTeacher {
    @Test
    public void testCollection(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Teacher teacher1=(Teacher) context.getBean("teacher1");
        teacher1.introduce();
    }
    @Test
    public void testProperties(){
        Properties properties = new Properties();
        properties.setProperty("ip","192.123.456.3");
        properties.setProperty("port","8070");
        try {
            //properties.store(new FileOutputStream("D:\\ideaprojects\\wnxa38_spring\\spring_02_di\\src\\main\\resources\\myhost.properties"),"config file");
            properties.storeToXML(new FileOutputStream("D:\\ideaprojects\\wnxa38_spring\\spring_02_di\\src\\main\\resources\\myhost.xml"),"config file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testProperties2(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("D:\\ideaprojects\\wnxa38_spring\\spring_02_di\\src\\main\\resources\\myhost.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String ip = properties.getProperty("ip");
        String port = properties.getProperty("port");
        System.out.println("ip:"+ip);
        System.out.println("port:"+port);
    }
    @Test
    public void testProperties3(){
        Properties properties = new Properties();
        try {
            properties.loadFromXML(new FileInputStream("D:\\ideaprojects\\wnxa38_spring\\spring_02_di\\src\\main\\resources\\myhost.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String ip = properties.getProperty("ip");
        String port = properties.getProperty("port");
        System.out.println("ip:"+ip);
        System.out.println("port:"+port);
    }
}
