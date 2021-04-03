package com.woniu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Student;

public interface StudentMapper {
	/**
	 * һ����ʦ��Ӧ���ѧ�����ڹ�������ͨ����ʦtid��ȡ��Ӧ������ѧ�����󼯺�
	 * @param tid
	 * @return
	 */
	public List<Student> selectStudentByTid(@Param("tid")Integer tid);
	/**
	 * һ��ѧ����Ӧ�����ʦ��ͨ��ѧ�����sno��ȡѧ������
	 * @param sno
	 * @return
	 */
	public Student selectStudentBySno(@Param("sno")String sno);
}
