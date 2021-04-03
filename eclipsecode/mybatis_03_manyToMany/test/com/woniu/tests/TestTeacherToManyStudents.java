package com.woniu.tests;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Student;
import com.woniu.bean.pojo.Teacher;
import com.woniu.mappers.TeacherMapper;
import com.woniu.utils.MyUtil;
/**
 * 一个老师对应多名学生
 */
public class TestTeacherToManyStudents {
	private Logger logger=Logger.getLogger(TestTeacherToManyStudents.class);
	/**
	 * 测试：一个老师对应多名学生
	 */
	@Test
	public void testManyStudents() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
		Teacher teacher=teacherMapper.selectTeacherByTno("wx003");
		logger.info("一个老师对应多个学生");
		for(Student student:teacher.getStudents()){
			logger.info(student.getSno()+"\t"+student.getName()+
					"\t"+teacher.getTno()+"\t"+teacher.getName());
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}
