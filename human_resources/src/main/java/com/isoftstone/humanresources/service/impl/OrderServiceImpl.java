package com.isoftstone.humanresources.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.dao.EmployeeDao;
import com.isoftstone.humanresources.dao.OrderDao;
import com.isoftstone.humanresources.dao.UserDao;
import com.isoftstone.humanresources.domain.*;
import com.isoftstone.humanresources.service.OrderService;
import com.isoftstone.humanresources.util.CommonConstant;
import com.isoftstone.humanresources.util.SendMailUtil;
import com.isoftstone.humanresources.util.SystemConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "OrderService")
public class OrderServiceImpl implements OrderService {
    private final static Logger logger = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private SystemConfig systemConfig;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<Order> queryOrderList(QueryOrderParam queryOrderParam) {
        logger.info("----------查询工单列表信息service接入参数------{}", queryOrderParam);
        PageInfo<Order> orderPageInfo = new PageInfo<>();

        try {
            Integer page = queryOrderParam.getPage();
            Integer pageSize = queryOrderParam.getPageSize();
            if (page != null && pageSize != null) {
                PageHelper.startPage(page, pageSize);                     //分页
                Integer creator = queryOrderParam.getCreator();
                Integer designator = queryOrderParam.getDesignator();
                List<Order> orderList = null;
                if (creator != null && designator != null) {
                    //调用dao接口查询与用户相关的所有工单列表
                    orderList = orderDao.queryAllOrderList(creator, designator);
                } else {
                    //调用dao接口查询工单列表
                    orderList = orderDao.queryOrderList(queryOrderParam);
                }
                if (orderList != null && orderList.size() > 0) {
                    orderPageInfo = new PageInfo<>(orderList);
                }

            }

        } catch (Exception e) {
            logger.error("- - - - 查询工单列表异常- -", e);
        }
        logger.info("----------查询用户信息service返回参数------{}", orderPageInfo);
        return orderPageInfo;
    }


    @Override
    public List<SysConfigResponse> queryOrderStatus() {
        logger.info("----------查询工单状态信息service------");
        List<SysConfigResponse> orderStatus = null;
        try {
            orderStatus = orderDao.queryOrderStatus();
        } catch (Exception e) {
            logger.error("- - - - 查询工单状态下拉框异常- -", e);
        }
        logger.info("----------查询工单状态信息service返回参数------{}", orderStatus);
        return orderStatus;
    }

    @Override
    public List<SysConfigResponse> queryLevelStatus() {
        logger.info("----------查询工单等级信息service------");
        List<SysConfigResponse> orderLevels = null;
        try {
            orderLevels = orderDao.queryLevelStatus();
        } catch (Exception e) {
            logger.error("- - - - 查询工单等级下拉框异常- -", e);
        }
        logger.info("----------查询工单等级信息service返回参数------{}", orderLevels);
        return orderLevels;
    }

    @Override
    public List<EmployeeInformation> queryEmpList() {
        logger.info("----------查询工单可选人员信息service------");
        List<EmployeeInformation> employeeInformations = null;
        try {
            employeeInformations = orderDao.queryEmpList();
        } catch (Exception e) {
            logger.error("- - - - 查询工单可选人员下拉框异常- -", e);
        }
        logger.info("----------查询工单可选人员信息service返回参数------{}", employeeInformations);
        return employeeInformations;
    }

    @Override
    public Result updateOrder(Order order) {
        logger.info("----------更新工单可选人员信息service接入参数------{}", order);
        /*更新分两类：1、 更新指派人和抄送人 2、更新状态和解决方案*/
        try {
            String status = order.getStatus();
            order.setUpdateDate(new Date());
            //如果状态已解决，回显指派者和抄送者，更新状态和解决方案
            if (status.equals(CommonConstant.MESSAGE_STRING_STATUS)){
                //回显数据
                Integer id = order.getId();
                Order orderInfo = orderDao.queryById(id);
                order.setDesignator(orderInfo.getDesignator());
                order.setCopier(orderInfo.getCopier());
                order.setCreator(orderInfo.getCreator());
            }else {
                //如果状态未解决，更新抄送者和指派者
                int[] copy = order.getCopy();
                if (copy != null && copy.length>0) {
                    String strCopy = ArrayTransformString(copy);
                    order.setCopier(strCopy);
                }
            }
            orderDao.updateOrder(order);
            //判断状态是否解决，若未解决，发邮件给指派人，反之，发邮件给创建者，告诉创建者工单处理完成。
            if (status.equals(CommonConstant.STRING_STATUS)) {
                Integer designator = order.getDesignator();
                sendMessage(designator, status);
            } else {
                Integer creator = order.getCreator();
                sendMessage(creator, status);
            }
            return new Result(true, "更新工单信息成功");
        } catch (Exception e) {
            logger.error("- - - - 更新工单信息异常- -", e);
            return new Result(false, "更新工单信息失败");
        }

    }

    @Override
    public Result addOrder(Order order) {
        logger.info("----------新增工单可选人员信息service接入参数------{}", order);
        try {
            int[] copy = order.getCopy();
            if(copy!=null && copy.length>0) {
                String strCopy = ArrayTransformString(copy);
                order.setCopier(strCopy);          //设置抄送人
            }
            order.setCreatDate(new Date());    //创建日期
            order.setStatus(CommonConstant.STRING_STATUS);    //状态
            Integer creator = order.getCreator();        //获取创建人
            Integer designator = order.getDesignator(); //获取指派者
            String status = order.getStatus();
            //调用dao接口新增工单信息
            orderDao.addOrder(order);
            //发送抄送邮件，信息入库
            sendMessage(designator,status);
            return new Result(true, "新增工单成功");
        } catch (Exception e) {
            return new Result(false, "新增工单失败");
        }

    }

    //发送邮件，信息入库
    private void sendMessage(Integer employeeID, String status) throws Exception {

        EmployeeInformation employee = employeeDao.queryEmployeeInfo(employeeID);
        String email = employee.getEmail();
        String employeeName = employee.getEmployeeName();
        String from = systemConfig.getFrom();
        String configPassword = systemConfig.getPassword();
        String smtp = systemConfig.getSmtp();
        String configUsername = systemConfig.getUsername();
        String title = "用户工单邮件-来自【MAG华为综合业务事业本部】";
        String content =employeeName+ "您好！"+"您有一条工单信息需要处理，具体信息可登录职能人力资源管理系统查询:"+CommonConstant.TASK_ADDRESS;
        String contentResult = employeeName+ "您好！"+"您有一条工单信息已经处理完成，具体信息可登录职能人力资源管理系统查询:"+CommonConstant.TASK_ADDRESS;
        boolean result = false;
        //根据状态判断，
        if (status.equals(CommonConstant.STRING_STATUS)) {
            result = SendMailUtil.send(smtp, from, email, title, content, configUsername, configPassword);

        } else {
            result = SendMailUtil.send(smtp, from, email, title, contentResult, configUsername, configPassword);
        }
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



    //采用字符串拼接形式转换，";"分号隔开
    private String ArrayTransformString(int[] SafetyMeasure) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < SafetyMeasure.length; i++) {
            sb.append(SafetyMeasure[i] + ",");
        }

        String substring = sb.substring(0, sb.length() - 1);
        return substring;

    }

    @Override
    public Integer queryMyOrderNum(Integer employeeID) {
        logger.info("----------查询我的工单任务条数service接入参数------{}", employeeID);
        Integer orderNum = null;
        try {
            orderNum = orderDao.queryMyOrderNum(employeeID);
        } catch (Exception e) {
            logger.error("- - -查询我的工单任务条数异常 - - -", e);
        }
        return orderNum;
    }
}