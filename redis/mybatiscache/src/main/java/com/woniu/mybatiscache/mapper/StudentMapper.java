package com.woniu.mybatiscache.mapper;

import com.woniu.mybatiscache.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentMapper {
    public List<Student> selectAllStudent();
    public List<Student> selectStudent(Student student);
//    public Student selectStudentById(@Param("id") Integer id);
//    public int addStudent(Student student);
//    public int deleteStudentById();
//    public int updateStudent(Student student);
}
