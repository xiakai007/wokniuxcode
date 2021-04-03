package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.entity.Task;
import cc.zy.base.businesses.entity.UserTask;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *  Service接口
 *
 * @author zzz
 * @date 2021-01-28 17:29:15
 */
public interface ITaskService extends IService<Task> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param task task
     * @return IPage<Task>
     */
    IPage<Task> findTasks(QueryRequest request, Task task);

    /**
     * 查询（所有）
     *
     * @param task task
     * @return List<Task>
     */
    List<Task> findTasks(Task task);

    /**
     * 新增
     *
     * @param task task
     */
    void createTask(Task task);

    /**
     * 修改
     *
     * @param task task
     */
    void updateTask(Task task);

    /**
     * 删除
     *
     * @param task task
     */
    void deleteTask(Task task);

    /**
     * 当前招生人员的总待办数量
     *
     * @param userId userId
     */
    int findTotalTaskByUserId(Integer userId);
//查询招生老师负责的待办任务，按学生分类
    IPage<UserTask> findUserTasks(QueryRequest request, UserTask UserTask);
//获得学生报考信息待办任务list
    List<Task> findExamInfoTaskByStuId(Integer stuId);
//获得学生各类型待办任务的数量
    List<Map<String,String>> findTaskTypeNumByStuId(@Param("stuId")Integer stuId);
}
