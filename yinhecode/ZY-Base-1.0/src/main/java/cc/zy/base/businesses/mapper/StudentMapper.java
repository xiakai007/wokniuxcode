package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.StuColumn;
import cc.zy.base.businesses.entity.StuLabel;
import cc.zy.base.businesses.entity.Student;
import cc.zy.base.monitor.entity.SystemLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;

/**
 * Mapper
 *
 * @author Jiangjinlin
 * @date 2021-01-25 11:45:25
 */
public interface StudentMapper extends BaseMapper<Student> {

    <T> IPage<Student> findStudentDetailPage(Page<T> page, @Param("student") Student student);

    /**
     * @Description: 为了显示学生分页信息
     * @author zhizhao Zhang
     * @date 2021-02-03 11:52:14
     * @param student 传递学生student对象
     * @return Ipage
     */
    long countStudentDetail(@Param("student") Student student);

    /**
     * @Description: 查找学生--详细信息--为了在servieImpl实现中使用
     * @author zhizhao Zhang
     * @date 2021-02-03 11:52:14
     * @param student 传递学生student对象
     * @return Ipage
     */
    <T> IPage<Student> selectStudentDetailPage(Page<T> page, @Param("student") Student student);

    /**
     * @Description: 通用组件选择学生信息
     * @author zhizhao Zhang
     * @date 2021-02-03 11:52:14
     * @param student 用于传递查询条件，并不用分页
     * @return
     */
    List<Student> selectStudentDetail(@Param("student") Student student);

    /**
     * @Description: 通用组件选择学生信息[查询学生批次]
     * @author zhizhao Zhang
     * @date 2021-02-03 11:52:14
     * @param student 用于查询批次，带着分页
     * @return
     */
    <T> IPage<Student> selectStudentBatchPage(Page<T> page, @Param("student") Student student);


    void testInsert(Student student);

    void creatStuLabel(StuLabel stuLabel);

    List<StuLabel> checkYourLabel(@Param("id") Long id);

    void setRecycleStatus(@Param("studentIds") String[] studentIds);

    void insertIntoRecycle(List<Student> students);

    List<Student> selectStuForRecycle(@Param("studentIds") String[] studentIds);

    int deleIndetityById(Integer id);

    /**
     * 修改待办事务表中状态，驳回审核信息
     *
     * @return int
     */
    int updateTaskStatusByStuId(@Param("id") Integer id, @Param("typeId") Integer typeId, @Param("remark") String remark);

    /**
     * 查找学生上传的待审核信息
     * @author hutengjiao
     * @date 2021-02-04
     * @param id,typeId
     * @return
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
     * 通过OpenId查找学生
     *
     * @param id id
     * @return 学生
     */
    Student findStudentByOpenId(String openId);

    /**
     * 通过微信信息和OpenId查找学生
     *
     * @return 学生
     */
    Student findStudentByWxInfoAndOpenId(@Param("batchName")String batchName, @Param("identity")String identity, @Param("tel")String tel, @Param("studyTypeName")String studyTypeName, @Param("openId")String openId);

    /**
     * 通过微信信息查找学生
     *
     * @return 学生
     */
    Student findStudentByWxInfo(@Param("batchName")String batchName, @Param("identity")String identity, @Param("tel")String tel, @Param("studyTypeName")String studyTypeName);


    /**
     * 查找全部院校，用作查询
     *
     * @author hutengjiao
     * @date 2021\2\1
     */
    List<College> findCollegeList();

    /**
     * 审核信息通过，修改待办任务表状态
     * @param id
     * @param typeId
     * @return int
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
     * 通过学生id查找该苏俄生所在班级中所有学生id
     * @param classId
     * @param typeId
     * @return Integer[]
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
//
//    /**
//     * 获得应缴金额
//     *
//     * @author 刘润雨
//     * @date 2021\2\2
//     */
//    Map<String, Object> getShouldPay(@Param("stuId") Integer stuId, @Param("paymenExplain") String paymenExplain);
//
//    /**
//     * 获得考试费实际缴金额
//     *
//     * @author 刘润雨
//     * @date 2021\2\2
//     */
//    Map<String, Object> getTruePay(@Param("stuId") Integer stuId, @Param("id") Integer id);
//
//    /**
//     * 获得缴费活动
//     *
//     * @author 刘润雨
//     * @date 2021\2\2
//     */
//    Map<String, Object> getPayDiscount(@Param("id") Integer id, @Param("payDate") String payDate);

    Map<String,Object> getEntryFee(@Param("id") Integer id);


    long countStuLog(@Param("systemLog") SystemLog systemLog);

    <T> IPage<SystemLog> findStuLog(Page<T> page, @Param("systemLog") SystemLog systemLog);
}
