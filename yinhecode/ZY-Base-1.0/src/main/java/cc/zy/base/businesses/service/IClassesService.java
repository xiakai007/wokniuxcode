package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.Classes;

import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.entity.TeacherChangeLog;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.TreeNode;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * 班级表 Service接口
 *
 * @author Jiangjinlin
 * @date 2021-01-25 19:29:08
 */
public interface IClassesService extends IService<Classes> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param classes classes
     * @return IPage<Classes>
     */
    IPage<Classes> findClassess(QueryRequest request, Classes classes);

    /**
     * @description: 查询满足查询条件的所有结果
     * @param: classes 班级对象，用来传递查询条件
     * @return: 查询到的班级集合
     * @author: LiPeng
     * @date: 2021/2/28
     */
    List<Classes> findClassess(Classes classes);

    /**
     * 新增班级
     *
     * @param classes 班级对象
     * @return boolean
     * @author houweikang
     * @date 2021/2/1
     */
    Boolean createClass(Classes classes);

    /**
     * 修改
     *
     * @param classes classes
     */
    void updateClasses(Classes classes);

    /**
     * 删除
     *
     * @param classIds
     * @author houweikang
     * @date 2021/2/1
     */
    void deleteClass(ArrayList<Integer> classIds);

    /**
     * 通过ID查找班级信息
     *
     * @param id id
     * @return 班级信息
     */
    Classes findById(Integer id);

    /**
     * 更换班主任
     *
     * @param teacherChangeLog 更换班主任日志表对象
     * @author houweikang
     * @date 2021/2/1
     */
    void updateTeacher(TeacherChangeLog teacherChangeLog);

    /**
     * @description: 查：根据班级id查询班级
     * @param: classesId 班级id
     * @return: Classes 班级对象
     * @author: LiPeng
     * @date: 2021/2/8
     */
    Classes findClassesById(@Param("classesId") Integer classesId);

    /**
     * @description: 根据班级id查询班主任更换记录
     * @param: request 分页对象；classesId 班级id
     * @return: IPage 包含分页参数，以及历史班主任日志集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    IPage<TeacherChangeLog> findTeacherChangeLogByClassesId(QueryRequest request, Integer classesId);

    /**
     * 构建用户部门树带所带人数
     *
     * @return
     */
    List<TreeNode> createUserDeptTree();

    /**
     * @Description: 班级树形下拉菜单
     * @return: 树节点集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    List<TreeNode> findClassesTree();

    /**
     * 更换学生专业
     *
     * @param student 学生对象
     * @author houweikang
     * @date 2021/2/1
     */
    void updateStuMajor(Student student);

    /**
     * @description: 查：按条件查询学生，用于分班
     * @param: request 分页对象，内含分页参数、排序参数；student query对象，传递查询条件
     * @return: 包含分页参数，以及查询到的数据集合
     * @author: LiPeng
     * @date: 2021/2/5
     */
    IPage<Student> findStudentForClassGrouping(QueryRequest request, Student student);

    /**
     * @description: 给学生分班
     * @param: ids 学生id集合；classId 班级id
     * @author: LiPeng
     * @date: 2021/2/5
     */
    void updateClassId(ArrayList<Integer> ids, Integer classId);

    /**
     * @description: 按条件查询学生，然后给查询到的所有学生分班
     * @param: student 查询对象，传递查询条件；classId 班级id
     * @author: LiPeng
     * @date: 2021/2/5
     */
    void updateClassIdAll(Student student, Integer classId);
}