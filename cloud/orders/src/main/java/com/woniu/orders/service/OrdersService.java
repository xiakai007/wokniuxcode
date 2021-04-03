package com.woniu.orders.service;

import com.woniu.orders.mbg.model.Orders;

import java.util.List;

public interface OrdersService {
    boolean addOrders(Orders orders);
    List<Orders> findAllOrders();
}
