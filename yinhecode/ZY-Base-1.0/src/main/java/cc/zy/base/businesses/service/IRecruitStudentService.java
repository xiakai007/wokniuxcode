package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.StuColumn;
import cc.zy.base.businesses.entity.StuLabel;
import cc.zy.base.businesses.entity.Student;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author Jiangjinlin
 * @date 2021-01-25 11:45:25
 */
public interface IRecruitStudentService extends IService<Student> {
    //查找学生批次
    IPage<Student> selectStudentBatchPage(Student student, QueryRequest request);

    /**
     * 通用组件选择用户信息
     *
     * @param request request
     * @param student 用户对象，用于传递查询条件
     * @return IPage
     */
    IPage<Student> selectStudentDetailList(Student student, QueryRequest request);

    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param student student
     * @return IPage<Student>
     */
    IPage<Student> findStudents(QueryRequest request, Student student);
    List<Student> selectStudentDetail(Student student);


    /**
     * 查询（所有）
     *
     * @param student student
     * @return List<Student>
     */
    List<Student> findStudents(Student student);

    /**
     * 新增
     *
     * @param student student
     */
    void createStudent(Student student);

    /**
     * 修改
     *
     * @param student student
     */
    void updateStudent(Student student);

    /**
     * 删除
     *
     * @param student student
     */
    void deleteStudent(Student student);

    /**
     * 查询（单个学生）
     *
     * @return IPage<Student>
     */
    Student findStudentById(Integer id);

    /**
     * 通过学生Id和类型驳回审核信息
     *
     * @return IPage<Student>
     */
    Boolean rejectTask(Integer id, Integer typeId, String remark);

    /**
     * 通过学生Id和类型通过审核信息
     *
     * @param student Student
     * @return IPage<Student>
     */
    Boolean passedTask(Integer id, Integer typeId, Student student);

    /**
     * 通过ID查找学生详细信息
     *
     * @param id id
     * @return 学生信息
     */
    Student findById(Integer id);

    /**
     * 通过ID查找学生提交的待审核信息
     *
     * @param id id
     * @return 学生信息
     */
    Map<String, Object> findTaskDetail(Integer id, Integer typeId);

    void deleteStudents(String[] collegeIds);

    void creatStuLable(StuLabel stuLabel);

    List<StuLabel> checkYourLabel(Long id);

    void setRecycleStatus(int id);

    void insertIntoRecycle(Student student);

    Student selectStuForRecycle(int id);


    void delLable(Integer id);

    /**
     * 信息审核通过
     *
     * @param taskId
     *@param student
     * @return
     */
    Boolean passExamTask(Integer taskId, Student student);

    /**
     * 信息审核不通过
     *
     * @param taskId
     *
     * @return
     */
    Boolean noPassExamTask(Integer taskId);


    /**
     * 考试地点审核通过
     * @param stuId
     * @param taskId
     * @param examLocationId
     * @return
     */
    Boolean passExamLocation(Integer taskId, Integer stuId, Integer examLocationId);


    /**
     * 考试地点审核不通过
     * @param remark
     * @param taskId
     * @return
     */
    Boolean noPassExamLocation(Integer taskId, String remark);




    Integer[] findStuIdBuClassId(String classId, Integer typeId);


  //查找学生的待办任务

    /**
     * 通过班级id查找该班学生有待办事务的id数组
     *
     * @return 学生信息
     */
    Map<String, Object> findTaskByStuidAndType(Integer stuId, Integer typeId);
    /**
     * 更新学生异动状态
     *
     * @param student
     * @return
     */
    void studentReentry(Student student);
    List<StuColumn> checkYourColumn(Long id);
    int updateStudentByEntity(Student student);

public void overdueSet(int id);
/**
     * @date: 2021/2/1
     *获得//学生考试费缴费情况
     * @author 刘润雨
     * @date 2021\2\2
     */
 Map<String,String>getStuExamPayInfo(Integer stuId, String paymenExplain);

/**
 *
 * 获得学生学费缴纳情况
 * @author 刘润雨
 * @date 2021\2\4
 */
Map<String,String>getStuStudyPayInfo(Integer stuId, String paymenExplain);

/**
 *
 * 获得学生学习年份
 * @author 刘润雨
 * @date 2021\2\4
 */
int findStudentStudyYear(Integer stuId);
 }
