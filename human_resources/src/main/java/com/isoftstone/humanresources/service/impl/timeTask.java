package com.isoftstone.humanresources.service.impl;

import com.isoftstone.humanresources.dao.*;
import com.isoftstone.humanresources.domain.EmployeeBackups;
import com.isoftstone.humanresources.domain.EmployeeInformation;
import com.isoftstone.humanresources.domain.Order;
import com.isoftstone.humanresources.domain.SendMessageInfo;
import com.isoftstone.humanresources.service.EmployeePerformanceService;
import com.isoftstone.humanresources.util.CommonConstant;
import com.isoftstone.humanresources.util.SendMailUtil;
import com.isoftstone.humanresources.util.SystemConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class timeTask {
    private final static Logger logger = LoggerFactory.getLogger(timeTask.class);

    @Autowired
    private SystemLogDao systemLogDao;

    @Autowired
    private OrganizationDao organizationDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private SystemConfig systemConfig;
    @Autowired
    private UserDao userDao;
    /**
     * cron表达式，每月1号凌晨一点执行，删除系统日志
     */
    @Scheduled(cron = "0 0 1 1 * ?")
    public void task2() throws Exception {
        logger.info("- - -执行删除系统日志的定时任务开始 - - -");
        systemLogDao.deleteSysLog();
        logger.info("当前时间：{}\t\t任务：cron task，每月1号凌晨一点执行一次", System.currentTimeMillis());
    }


    /**
     *cron表达式，每天晚上11点执行，发邮件给完成人员备份的人员
     * @throws Exception
     */
    @Scheduled(cron = "0 0 23 * * ?")
    public  void  backTask()throws Exception{
        logger.info("- - -执行发送邮件确认人员备份的定时任务开始 - - -");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = format.format(new Date());
        //调用人员备份的接口查询完成备份人员的信息
        List<EmployeeBackups> backupsList = organizationDao.queryCompleteEmployeeBackups(strDate);
        ArrayList<Order> orderList = new ArrayList<>();
        if (backupsList!=null && backupsList.size()>0) {
            for (EmployeeBackups employeeBackups : backupsList) {
                Integer employeeID = employeeBackups.getEmployeeID();
                String pm = employeeBackups.getPm();
                String backupContent = employeeBackups.getBackupContent();
                Order order = new Order();
                order.setCreator(Integer.parseInt(pm));
                order.setCreatDate(new Date());
                order.setLevel(CommonConstant.STRING_ORDER_LEVEL);
                order.setContent(CommonConstant.STRING_ORDER_CONTENT+backupContent);
                order.setStatus(CommonConstant.STRING_STATUS);
                order.setDesignator(employeeID);
                orderList.add(order);

            }
            //调用工单的接口批量新增工单
            orderDao.addOrderList(orderList);
            //先新增工单成功，再发送邮件
            for (Order order : orderList) {
                Integer creator = order.getCreator();
                Integer designator = order.getDesignator();
                sendMessage(designator);
            }
        }
        logger.info("当前时间：{}\t\t任务：cron task，每天晚上11点执行一次", System.currentTimeMillis());
    }




    //发送邮件，信息入库
    private void sendMessage(Integer employeeID) throws Exception {

        EmployeeInformation employee = employeeDao.queryEmployeeInfo(employeeID);
        String email = employee.getEmail();
        String employeeName = employee.getEmployeeName();
        String from = systemConfig.getFrom();
        String configPassword = systemConfig.getPassword();
        String smtp = systemConfig.getSmtp();
        String configUsername = systemConfig.getUsername();
        String title = "用户工单邮件-来自【MAG华为综合业务事业本部】";
        String content = "您好！关于人员备份的工单信息需要您处理，具体信息可登录职能人力资源管理系统查询:"+CommonConstant.TASK_ADDRESS;
        boolean result = false;

            result = SendMailUtil.send(smtp, from, email, title, content, configUsername, configPassword);

        //邮件表存入数据
        if (result) {
            SendMessageInfo messageInfo = new SendMessageInfo();
            messageInfo.setTitle(title);
            messageInfo.setContent(content);
            messageInfo.setDealUser(employeeName);
            messageInfo.setToUser(employeeName);
            messageInfo.setToEmail(email);
            messageInfo.setStatus(Integer.parseInt(CommonConstant.MESSAGE_STATUS));
            messageInfo.setCreateTime(new Date());
            messageInfo.setSendTime(new Date());
            messageInfo.setMessageType(Integer.parseInt(CommonConstant.MESSAGE_TYPE));
            userDao.insertMessage(messageInfo);
        }
    }

}
