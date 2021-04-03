package com.woniu;

import static org.junit.Assert.assertTrue;

import com.woniu.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppTest 
{

    @Test
    public void testTransferAccounts()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService=(AccountService)context.getBean("accountServiceImpl");
        accountService.transferAccounts("123456","123457",100f);
    }
}
