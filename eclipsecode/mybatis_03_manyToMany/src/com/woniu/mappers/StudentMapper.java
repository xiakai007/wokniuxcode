package com.woniu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Student;

public interface StudentMapper {
	/**
	 * 一名老师对应多个学生：在关联表中通过老师tid获取对应的所有学生对象集合
	 * @param tid
	 * @return
	 */
	public List<Student> selectStudentByTid(@Param("tid")Integer tid);
	/**
	 * 一名学生对应多个老师：通过学生编号sno获取学生对象
	 * @param sno
	 * @return
	 */
	public Student selectStudentBySno(@Param("sno")String sno);
}
