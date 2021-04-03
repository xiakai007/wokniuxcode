package com.woniu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.User;

public interface UserMapper {
	public User login(@Param("account")String account,@Param("password")String password);
	public int updateUser(User user);
	public int register(@Param("account")String account, @Param("password")String password);
	public User selectUserById(@Param("id")Integer id);
	public User selectUserByIdToCart(@Param("id")Integer id);
	/**
	 * 一个商品对应多个用户
	 * @param goodsid
	 * @return
	 */
	public List<User> selectUserByGoodsid(@Param("goodsid")Integer goodsid);
}
