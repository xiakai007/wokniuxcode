package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.Classes;
import cc.zy.base.businesses.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * 班级表 Mapper
 *
 * @author Jiangjinlin
 * @date 2021-01-25 19:29:08
 */
public interface ClassesMapper extends BaseMapper<Classes> {
    /**
     * 查：班级列表
     *
     * @param page    分页对象
     * @param classes 班级对象，用于传递查询条件
     * @return IPage
     */
    <T> IPage<Classes> findClassesDetailPage(Page<T> page, @Param("classes") Classes classes);

    /**
     * 查询班级列表不带分页
     *
     * @param classes 班级对象，用于传递查询条件
     * @return
     */
    List<Classes> findClassesByCls(@Param("classes") Classes classes);

    /**
     * @description: 根据条件查询到的结果总数
     * @param: classes query对象，用来传递查询条件
     * @return: 结果数目
     * @author: houweikang
     * @date: 2021/3/2
     */
    long countClassesDetail(@Param("classes") Classes classes);

    /**
     * 通过ID查找班级
     *
     * @param classesId id
     * @return 班级
     */
    Classes findById(Integer classesId);

    /**
     * @description: 查：根据班级id查询班级
     * @param: classesId 班级id
     * @return: Classes 班级对象
     * @author: LiPeng
     * @date: 2021/2/8
     */
    Classes selectClassesById(@Param("classesId") Integer classesId);

    /**
     * @description: 查：根据批次、院校、层次、专业查询班级id，缺一不可
     * @param: classes 班级对象，传递查询条件
     * @return: 返回值：班级id
     * @author: LiPeng
     * @date: 2021/2/1
     */
    Integer selectClassesByUniqueCode(@Param("classes") Classes classes);

    /**
     * @description: 查：查询全部班级，用于构造树形下拉菜单
     * @return: 班级信息集合
     * @author: LiPeng
     * @date: 2021/2/8
     */
    List<Classes> selectAllClasses();

    /**
     * @description: 查：按条件查询学生，用于分班
     * @param: page 分页对象，内含分页、排序参数；student query对象，传递查询条件
     * @return: 包含分页参数，以及查询到的数据集合
     * @author: LiPeng
     * @date: 2021/2/8
     */
    <T> IPage<Student> findStudentInfoForClassGrouping(Page<T> page, @Param("student") Student student);

    /**
     * @description: 查：按条件查询到的数据总数，用于分班
     * @param: student query对象，传递查询条件
     * @return: 查询到的数据总数
     * @author: LiPeng
     * @date: 2021/2/8
     */
    long countStudentInfoForClassGrouping(@Param("student") Student student);

    /**
     * @description: 改：给学生分班
     * @param: ids 学生id集合；classId 班级id
     * @return: 成功更新条数
     * @author: LiPeng
     * @date: 2021/2/8
     */
    Integer updateClassId(@Param("ids") ArrayList<Integer> ids, @Param("classId") Integer classId);

    /**
     * @description: 查：按条件查询学生表中的学生id
     * @param: student query对象，传递查询条件
     * @return: 学生id集合
     * @author: LiPeng
     * @date: 2021/2/8
     */
    ArrayList<Integer> findIdsByParams(@Param("student") Student student);
}