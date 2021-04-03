package com.woniu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Address;
import com.woniu.bean.pojo.User;

public interface AddressMapper {
	public List<Address> selectAllAddressByUserid(@Param("userid")Integer userid);
}
