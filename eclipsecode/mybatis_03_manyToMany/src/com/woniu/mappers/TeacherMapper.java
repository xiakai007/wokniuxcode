package com.woniu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Teacher;

public interface TeacherMapper {
	/**
	 * һ����ʦ��Ӧ���ѧ����ͨ�����tno��ȡ��ʦ����
	 * @param tno
	 * @return
	 */
	public Teacher selectTeacherByTno(@Param("tno")String tno);
	/**
	 * һ��ѧ����Ӧ�����ʦ��ͨ��ѧ��sid��ȡ��Ӧ��������ʦ����
	 * @param sid
	 * @return
	 */
	public List<Teacher> selectTeacherBySid(@Param("sid")Integer sid);
}
