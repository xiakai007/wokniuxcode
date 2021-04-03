package com.isoftstone.humanresources.service;

import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.*;

import java.util.List;

public interface OrderService {

    /**
     * 分页查询工单列表
     * @param queryOrderParam
     * @return
     * @throws Exception
     */
    PageInfo<Order> queryOrderList(QueryOrderParam queryOrderParam) throws Exception;



    /**
     * 查询工单状态下拉框
     * @return
     * @throws Exception
     */
    List<SysConfigResponse> queryOrderStatus( ) throws Exception;

    /**
     * 查询工单等级下拉框
     * @return
     * @throws Exception
     */
    List<SysConfigResponse> queryLevelStatus( ) throws Exception;


    /**
     * 查询工单可选人员下拉单
     * @return
     * @throws Exception
     */
    List<EmployeeInformation> queryEmpList() throws Exception;

    /**
     * 更新工单信息
     * @param order
     * @return
     * @throws Exception
     */
    Result updateOrder(Order order) throws Exception;

    /**
     * 新增工单信息
     * @param order
     * @return
     * @throws Exception
     */
    Result addOrder(Order order) throws Exception;




    /**
     * 查询与我相关订单条数
     * @param employeeID
     * @return
     * @throws Exception
     */
    Integer queryMyOrderNum(Integer employeeID) throws Exception;

}
