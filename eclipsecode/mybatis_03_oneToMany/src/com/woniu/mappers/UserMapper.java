package com.woniu.mappers;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.User;

public interface UserMapper {
	/**
	 * ͨ��id��ȡ�û�����
	 * @param id
	 * @return
	 */
	public User selectUserById(@Param("id")Integer id);

}
