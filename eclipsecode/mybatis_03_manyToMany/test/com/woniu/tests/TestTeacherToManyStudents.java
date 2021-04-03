package com.woniu.tests;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Student;
import com.woniu.bean.pojo.Teacher;
import com.woniu.mappers.TeacherMapper;
import com.woniu.utils.MyUtil;
/**
 * һ����ʦ��Ӧ����ѧ��
 */
public class TestTeacherToManyStudents {
	private Logger logger=Logger.getLogger(TestTeacherToManyStudents.class);
	/**
	 * ���ԣ�һ����ʦ��Ӧ����ѧ��
	 */
	@Test
	public void testManyStudents() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
		Teacher teacher=teacherMapper.selectTeacherByTno("wx003");
		logger.info("һ����ʦ��Ӧ���ѧ��");
		for(Student student:teacher.getStudents()){
			logger.info(student.getSno()+"\t"+student.getName()+
					"\t"+teacher.getTno()+"\t"+teacher.getName());
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}
