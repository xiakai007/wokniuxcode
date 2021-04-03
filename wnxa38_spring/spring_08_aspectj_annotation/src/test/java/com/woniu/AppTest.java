package com.woniu;

import static org.junit.Assert.assertTrue;

import com.woniu.service.ProductService;
import com.woniu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppTest 
{
    @Test
    public void testAspectJXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)context.getBean("userServiceImpl");
        userService.addUser(null);
        System.out.println("*********1**********");
        userService.addUser(1,"asda");
        System.out.println("*********2**********");
        ProductService productService = (ProductService)context.getBean("productServiceImpl");
        productService.addProduct(1);
        System.out.println("*********3**********");
        productService.removeProduct(1);
    }
}
