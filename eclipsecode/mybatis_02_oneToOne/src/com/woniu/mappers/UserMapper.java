package com.woniu.mappers;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.User;

public interface UserMapper {
	public User selectUserById(@Param("userid")Integer userid);

}
