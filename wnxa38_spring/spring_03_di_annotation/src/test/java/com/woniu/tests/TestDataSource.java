package com.woniu.tests;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.logging.Logger;
@Log4j2
public class TestDataSource {
    //private Logger logger=Logger.getLogger(TestDataSource.class);
    @Test
    public void testDatasource(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource dataSource = (DruidDataSource) context.getBean("dataSource");
        //System.out.println("初始连接池数量："+dataSource.getInitialSize());
        log.info("初始连接池数量："+dataSource.getInitialSize());
    }
}
