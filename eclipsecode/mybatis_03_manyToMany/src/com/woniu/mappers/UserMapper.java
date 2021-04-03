package com.woniu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.User;

public interface UserMapper {
	public User selectUserById(@Param("id")Integer id);
	public List<User> selectUserByGoodsid(@Param("goodsid")Integer goodsid);
}
