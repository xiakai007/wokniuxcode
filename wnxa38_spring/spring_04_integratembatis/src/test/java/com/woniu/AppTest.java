package com.woniu;

import static org.junit.Assert.assertTrue;

import com.alibaba.druid.pool.DruidDataSource;
import com.woniu.mapper.DeptMapper;
import com.woniu.pojo.Dept;
import com.woniu.service.DeptService;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AppTest 
{
    @Test
    public void testDatasource(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //DruidDataSource dataSource = (DruidDataSource) context.getBean("dataSource");
       //System.out.println("初始连接池数量："+dataSource.getInitialSize());
        //log.info("初始连接池数量："+dataSource.getInitialSize());
        //DeptMapper deptMapper=(DeptMapper) context.getBean("deptMapper");
        //List<Dept> deptList = deptMapper.selectDeptAll();
        DeptService deptService = (DeptService) context.getBean("deptServiceImpl");
        List<Dept> deptList=deptService.findDeptAll();
        for(Dept dept:deptList){
            System.out.println(dept.getId()+"\t"+dept.getDname());
        }
    }
}
