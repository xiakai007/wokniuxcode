package com.woniu.mappers;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.User;

public interface UserMapper {
	/**
	 * 通过id获取用户对象
	 * @param id
	 * @return
	 */
	public User selectUserById(@Param("id")Integer id);

}
