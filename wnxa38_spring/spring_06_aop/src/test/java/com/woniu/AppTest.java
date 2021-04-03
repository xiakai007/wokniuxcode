package com.woniu;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppTest 
{

    @Test
    public void testVipCard(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Card vipCard = (Card)context.getBean("vip");
        vipCard.saveMoney(200);
        System.out.println("*******************");
        Card normalCard = (Card)context.getBean("normal");
        normalCard.saveMoney(200);
    }
}
