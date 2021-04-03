package com.woniu.orders.service.impl;

import com.woniu.orders.mbg.mapper.OrdersMapper;
import com.woniu.orders.mbg.model.Orders;
import com.woniu.orders.service.MyService;
import com.woniu.orders.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService{
    @Autowired
    private OrdersMapper ordersMapper;
    @Transactional
    @Override
    public boolean addOrders(Orders orders) {
        return ordersMapper.insert(orders)==0?false:true;
    }
    @Transactional(readOnly = true,propagation = Propagation.NEVER)
    @Override
    public List<Orders> findAllOrders() {
        return ordersMapper.selectByExample(null);
    }
}
