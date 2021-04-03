package com.isoftstone.humanresources.controller;

import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.*;
import com.isoftstone.humanresources.service.OrderService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/hr_manager/order")
@Api(value = "工单API")
public class OrderController {
    private final static Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;

    /**
     * 分页查询工单列表
     *
     * @param queryOrderParam
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_order_list", method = RequestMethod.POST)
    public ResponseEntity<PageInfo<Order>> queryOrderList(@RequestBody QueryOrderParam queryOrderParam) {
        logger.info("- - -查询工单列表的请求参数 - - -{}", queryOrderParam);
        PageInfo<Order> orderList = null;
        try {
            if (null == queryOrderParam) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            orderList = orderService.queryOrderList(queryOrderParam);
            if (null == orderList) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - -查询工单列表异常- - -", e);
        }
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    /**
     * 查询工单状态下拉框
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_order_status", method = RequestMethod.GET)
    public ResponseEntity<List<SysConfigResponse>> queryOrderStatus() {
        logger.info("- - -查询工单状态下拉框controller - - -");
        List<SysConfigResponse> orderStatus = null;
        try {
            orderStatus = orderService.queryOrderStatus();
            if (CollectionUtils.isEmpty(orderStatus)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - -查询工单状态下拉框异常 - -", e);
        }
        return new ResponseEntity<>(orderStatus, HttpStatus.OK);

    }

    /**
     * 查询工单等级下拉框
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_order_level", method = RequestMethod.GET)
    public ResponseEntity<List<SysConfigResponse>> queryOrderLevel() {
        logger.info("- - -查询工单等级下拉框controller - - -");
        List<SysConfigResponse> levelStatus = null;
        try {
            levelStatus = orderService.queryLevelStatus();
            if (CollectionUtils.isEmpty(levelStatus)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - -查询工单等级下拉框异常 - -", e);
        }
        return new ResponseEntity<>(levelStatus, HttpStatus.OK);

    }

    /**
     * 查询工单等级下拉框
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_order_employee", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeInformation>> queryOrderEmployee() {
        logger.info("- - -查询工单可选人员下拉框controller - - -");
        List<EmployeeInformation> employeeInformations = null;
        try {
            employeeInformations = orderService.queryEmpList();
            if (CollectionUtils.isEmpty(employeeInformations)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - -查询工单工单可选人员下拉框异常 - -", e);
        }
        return new ResponseEntity<>(employeeInformations, HttpStatus.OK);

    }

    /**
     * 更新工单信息
     * @param order
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/update_order", method = RequestMethod.POST)
    public ResponseEntity<Result> updateOrder(@RequestBody Order order){
        logger.info("- - -更新工单信息的controller接入参数 - - -{}",order);
        Result result=null;
        try {
            if (null == order){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = orderService.updateOrder(order);
            if (null == result){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - -更新工单信息异常 - -", e);
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    /**
     * 新增工单信息
     * @param order
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_order", method = RequestMethod.POST)
    public ResponseEntity<Result> addOrder(@RequestBody Order order){
        logger.info("- - -新增工单信息的controller接入参数 - - -{}",order);
        Result result=null;
        try {
            if (null == order){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = orderService.addOrder(order);
            if (null == result){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - -新增工单信息异常 - -", e);
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    /**
     * 查询我的工单信息条数
     * @param employeeID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_myorder_num", method = RequestMethod.GET)
    public ResponseEntity<Integer> queryMyOrderNum(Integer employeeID){
        logger.info("- - -查询我的工单信息条数controller接入参数 - - -{}",employeeID);
        Integer orderNum =null;
        try {
            if (null == employeeID){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            orderNum = orderService.queryMyOrderNum(employeeID);
            if (null == orderNum){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - -查询我的工单信息条数异常 - -", e);
        }
        return new ResponseEntity<>(orderNum,HttpStatus.OK);
    }
}




