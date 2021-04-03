package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.*;
import com.isoftstone.humanresources.util.SystemConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    /**
     * 查询工单列表
     * @param queryOrderParam
     * @return
     * @throws Exception
     */
    List<Order> queryOrderList(QueryOrderParam queryOrderParam)throws Exception;

    /**
     * 查询用户所有工单列表
     * @param creator
     * @param
     * @return
     * @throws Exception
     */
    List<Order> queryAllOrderList(Integer creator,Integer designator)throws Exception;

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
     * @throws Exception
     */
    void updateOrder(Order order) throws Exception;

    /**
     * 新增工单信息
     * @param order
     * @return
     * @throws Exception
     */
    void addOrder(Order order) throws Exception;

    /**
     * 查询与我相关订单条数
     * @param employeeID
     * @return
     * @throws Exception
     */
    Integer queryMyOrderNum(Integer employeeID) throws Exception;

    /**
     * 根据id查询订单
     * @param id
     * @return
     * @throws Exception
     */
    Order queryById(Integer id)throws Exception;


    /**
     * 批量新增工单
     * @param list
     * @throws Exception
     */
    void addOrderList(@Param("list") List<Order> list) throws Exception;
}
