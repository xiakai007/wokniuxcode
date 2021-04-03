package com.woniu.mappers;

import java.util.List;

import com.woniu.bean.pojo.User;

public interface UserMapper {
	public int addUser(User user);
	public List<User> selectAll();
}
