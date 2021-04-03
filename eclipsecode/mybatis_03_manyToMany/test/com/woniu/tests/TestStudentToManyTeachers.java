package com.woniu.tests;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Student;
import com.woniu.bean.pojo.Teacher;
import com.woniu.mappers.StudentMapper;
import com.woniu.mappers.TeacherMapper;
import com.woniu.utils.MyUtil;
/**
 * һ��ѧ����Ӧ������ʦ
 */
public class TestStudentToManyTeachers {
	private Logger logger=Logger.getLogger(TestStudentToManyTeachers.class);
	/**
	 * ���ԣ�һ��ѧ����Ӧ������ʦ
	 */
	@Test
	public void testManyTeachers() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		Student student=studentMapper.selectStudentBySno("x001");
		logger.info("һ��ѧ����Ӧ������ʦ");
		for(Teacher teacher:student.getTeachers()){
			logger.info(teacher.getTno()+"\t"+teacher.getName()+"\t"+student.getName());
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}
