package com.woniu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Teacher;

public interface TeacherMapper {
	/**
	 * 一名老师对应多个学生：通过编号tno获取老师对象
	 * @param tno
	 * @return
	 */
	public Teacher selectTeacherByTno(@Param("tno")String tno);
	/**
	 * 一名学生对应多个老师：通过学生sid获取对应的所有老师集合
	 * @param sid
	 * @return
	 */
	public List<Teacher> selectTeacherBySid(@Param("sid")Integer sid);
}
