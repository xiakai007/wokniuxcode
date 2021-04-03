package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.TeacherChangeLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * 班主任变更记录表 Mapper
 *
 * @author LiPeng
 * @date 2021/01/27 16:44:35
 */
public interface TeacherChangeLogMapper extends BaseMapper<TeacherChangeLog> {

    /**
     * @Description: 查：根据班级id查询班主任更换记录
     * @Param: page 分页对象；classId 班级id
     * @return: IPage 包含分页参数，以及历史班主任日志集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    <T> IPage<TeacherChangeLog> selectTeacherChangeLogByClassId(Page<T> page, @Param("classId") Integer classId);

    /**
     * @Description: 查：根据班级id查询班主任更换记录总数
     * @Param: classId 班级id
     * @return: 总记录数
     * @author: LiPeng
     * @date: 2021/2/1
     */
    long countTeacherChangeLog(@Param("classId") Integer classId);
}
