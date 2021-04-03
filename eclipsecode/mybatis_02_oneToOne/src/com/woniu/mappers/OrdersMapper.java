package com.woniu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Goods;
import com.woniu.bean.pojo.Orders;

public interface OrdersMapper {
	public List<Orders> selectALLOrders();
	public Goods selectOrdersById(@Param("ordersid")Integer ordersid);
}
