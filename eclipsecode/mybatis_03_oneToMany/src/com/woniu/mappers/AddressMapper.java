package com.woniu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Address;

public interface AddressMapper {
	/**
	 * һ���û���Ӧ�����ַ��ͨ��userid��ȡ�û���Ӧ�ĵ�ַ����
	 * @param userid
	 * @return
	 */
	public List<Address> selectAddrByUserId(@Param("userid")Integer userid);

}
