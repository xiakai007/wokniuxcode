package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.StudentGroup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学生组表	 Mapper
 *
 * @author LiPeng
 * @date 2021-01-26 16:24:15
 */
public interface StudentGroupMapper extends BaseMapper<StudentGroup> {

    /**
     * 查找学生分组详细信息
     *
     * @param page         分页对象
     * @param studentGroup 学生分组对象，用于传递查询条件
     * @return IPage
     * @author: houweikang
     * @date: 2021/2/28
     */
    <T> IPage<StudentGroup> findStudentGroupDetailPage(Page<T> page, @Param("studentGroup") StudentGroup studentGroup);

    /**
     * @description: 查：查询满足查询条件的所有结果总数
     * @param: studentGroup 学生组对象，用来传递查询条件
     * @return: long 结果总数
     * @author: houweikang
     * @date: 2021/2/28
     */
    long countStudentGroupDetail(@Param("studentGroup") StudentGroup studentGroup);

    /**
     * @description: 查：查询满足查询条件的所有结果
     * @param: studentGroup 学生组对象，用来传递查询条件
     * @return: list 查询到的学生组集合
     * @author: LiPeng
     * @date: 2021/2/28
     */
    List<StudentGroup> findStudentGroupListNotPage(@Param("studentGroup") StudentGroup studentGroup);
}