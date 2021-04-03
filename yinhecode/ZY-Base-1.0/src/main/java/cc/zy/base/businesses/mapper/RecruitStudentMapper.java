package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.StuLabel;
import cc.zy.base.businesses.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper
 *
 * @author Jiangjinlin
 * @date 2021-01-25 11:45:25
 */
public interface RecruitStudentMapper extends BaseMapper<Student> {
    /**
     * 查找学生--详细信息--为了在servieImpl实现中使用
     *
     * @param page    分页对象
     * @param student 用户对象，用于传递查询条件
     * @return Ipage
     */
    <T> IPage<Student> findStudentDetailPage(Page<T> page, @Param("student") Student student);

    long countStudentDetail(@Param("student") Student student);

    /**
     * 通用组件选择用户信息
     *
     * @param student 用户对象，用于传递查询条件
     * @return List<Student>
     */
    <T> IPage<Student> selectStudentDetailPage(Page<T> page, @Param("student") Student student);

    /**
     * 通用组件选择学生信息
     *
     * @param student 用于传递查询条件，并不用分页
     * @return List<Student>
     */
    List<Student> selectStudentDetail(@Param("student") Student student);


    //查询学生批次
    <T> IPage<Student> selectStudentBatchPage(Page<T> page, @Param("student") Student student);

    //勾选全部结果
//    <T> IPage<Student> (Page<T> page, @Param("student") Student student);

    void testInsert(Student student);

    void creatStuLabel(StuLabel stuLabel);

    List<StuLabel> checkYourLabel(@Param("id") Long id);

    void setRecycleStatus(@Param("id") int id);

    void insertIntoRecycle(Student student);

    Student selectStuForRecycle(@Param("id") int id);

    int deleIndetityById(Integer id);

    /**
     * 修改待办事务表中状态，驳回审核信息
     *
     * @return
     */
    int updateTaskStatusByStuId(@Param("id") Integer id, @Param("typeId") Integer typeId, @Param("remark") String remark);

    /**
     * 查找学生上传的待审核信息
     *
     * @return IPage
     */
    Map<String, Object> findTaskDetailByStuId(@Param("id") Integer id, @Param("typeId") Integer typeId);

    /**
     * 通过ID查找学生
     *
     * @param id id
     * @return 学生
     */
    Student findById(Integer id);


    /**
     * 查找全部院校，用作查询
     *
     * @author hutengjiao
     * @date 2021\2\1
     */
    List<College> findCollegeList();

    /**
     * 审核信息通过，修改待办任务表状态
     */
    int updateStatusByTask(@Param("id") Integer id, @Param("typeId") Integer typeId);

    /**
     * 考试地点审核信息通过，通过ID修改待办任务表状态
     */
    int updateStatusById(@Param("taskId") Integer taskId);

    /**
     * 考试地点审核信息通过，修改学生考点
     */
    int updateStudentExamLocation(@Param("id") Integer id, @Param("examLocationId") Integer examLocationId);

    void delLable(@Param("id") Integer id);

    /**
     * 考试地点审核信息不通过，通过ID修改待办任务表状态
     */
    int updateStatusByIdNoPass(@Param("taskId") Integer taskId, @Param("remark") String remark);

    //查找学生的待办任务
    Map<String, Object> findTaskByStuidAndType(@Param("stuId") Integer stuId, @Param("typeId") Integer typeId);

    /**
     * 审核信息通过，修改待办任务表状态
     */
    /**
     * 审核信息通过，修改待办任务表状态
     */
    Integer[] selectStuidByClass(@Param("classId") String classId, @Param("typeId") Integer typeId);



    /**
     * 查：按条件查询学生，用于分班
     *
     * @param page    分页对象
     * @param student 学生对象，用于传递查询条件
     * @return Ipage
     */
    <T> IPage<Student> findStudentByParams(Page<T> page, @Param("student") Student student);

    long countStudentByParams(@Param("student") Student student);

    int updateStudentTransaction(@Param("student") Student student);

    /*复学相关 start*/

    /**
     * @Description: 复学时，将学生异动状态修改成正常，同时将其标记为放入回收站状态
     * @Param: studentId 学生id
     * @return: 成功更新数据条数
     * @author: LiPeng
     * @date: 2021/2/1
     */
    Integer updateStudentForBackCollege(@Param("studentId") Integer studentId);

    /**
     * @Description: 批量插入学生信息
     * @Param: studentList 学生集合
     * @return: 成功添加数据条数
     * @author: LiPeng
     * @date: 2021/2/1
     */
    Integer insertStudentBatch(@Param("studentList") List<Student> studentList);

    void overdueSet(int id);
    /*复学相关 end*/

    /**
     *获得应缴金额
     * @author 刘润雨
     * @date 2021\2\2
     */
    Map<String,Object>getShouldPay(@Param("stuId") Integer stuId, @Param("paymenExplain") String paymenExplain);

    /**
     *获得考试费实际缴金额
     * @author 刘润雨
     * @date 2021\2\2
     */
    Map<String,Object>getTruePay(@Param("stuId") Integer stuId, @Param("id") Integer id);

    /**
     *获得学费实际缴金额
     * @author 刘润雨
     * @date 2021\2\2
     */
    Map<String,Object>getStudyTruePay(@Param("stuId") Integer stuId, @Param("id") Integer id);

    /**
     *获得缴费活动
     * @author 刘润雨
     * @date 2021\2\2
     */
    Map<String,Object>getPayDiscount(@Param("id") Integer id, @Param("payDate") String payDate);

    /**
     *获得学生学习年份
     * @author 刘润雨
     * @date 2021\2\4
     */
    int findStudentStudyYear(@Param("stuId")Integer stuId);
}
