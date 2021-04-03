package com.woniu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Orders;

public interface OrdersMapper {
	
	public List<Orders> selectOrdersByUserid(@Param("userid")Integer userid);

}
