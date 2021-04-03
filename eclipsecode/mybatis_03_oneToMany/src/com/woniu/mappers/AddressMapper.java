package com.woniu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Address;

public interface AddressMapper {
	/**
	 * 一个用户对应多个地址：通过userid获取用户对应的地址集合
	 * @param userid
	 * @return
	 */
	public List<Address> selectAddrByUserId(@Param("userid")Integer userid);

}
