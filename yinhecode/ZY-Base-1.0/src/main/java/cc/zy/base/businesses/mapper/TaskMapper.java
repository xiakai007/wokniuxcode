package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.entity.Task;
import cc.zy.base.businesses.entity.UserTask;
import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *  Mapper
 *
 * @author zzz
 * @date 2021-01-28 17:29:15
 */
public interface TaskMapper extends BaseMapper<Task> {

   int findTotalTaskByStuId(@Param("userId") Integer userId);

    <T> IPage<UserTask> findTotalTaskByUserId(Page<T> page, @Param("userTask") UserTask userTask);

    int countTotalTaskByStuId(@Param("userTask") UserTask userTask);

    List<Task> findExamInfoTaskByStuId(@Param("stuId")Integer stuId);

    @SqlParser(filter = true)
    List<Map<String,String>> findTaskTypeNumByStuId(@Param("stuId")Integer stuId);
}
