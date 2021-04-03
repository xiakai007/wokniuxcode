package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.entity.Task;
import cc.zy.base.businesses.entity.UserTask;
import cc.zy.base.businesses.mapper.TaskMapper;
import cc.zy.base.businesses.service.ITaskService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.SortUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 *  Service实现
 *
 * @author zzz
 * @date 2021-01-28 17:29:15
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {

    private final TaskMapper taskMapper;

    @Override
    public IPage<Task> findTasks(QueryRequest request, Task task) {
        LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Task> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Task> findTasks(Task task) {
	    LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createTask(Task task) {
        this.save(task);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTask(Task task) {
        this.saveOrUpdate(task);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTask(Task task) {
        LambdaQueryWrapper<Task> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    public int findTotalTaskByUserId(Integer userId) {
        return taskMapper.findTotalTaskByStuId(userId);
    }

    @Override
    public IPage<UserTask> findUserTasks(QueryRequest request, UserTask userTask) {
        Page<UserTask> userTaskPage = new Page<>(request.getPageNum(), request.getPageSize());
        userTaskPage.setSearchCount(false);// 查询总记录数，默认是查询
        userTaskPage.setTotal(baseMapper.countTotalTaskByStuId(userTask));
        SortUtil.handlePageSort(request, userTaskPage, "stuId", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findTotalTaskByUserId(userTaskPage, userTask);
    }

    @Override
    public List<Task> findExamInfoTaskByStuId(Integer stuId) {
        return taskMapper.findExamInfoTaskByStuId(stuId);
    }

    @Override
    public List<Map<String, String>> findTaskTypeNumByStuId(Integer stuId) {
        return taskMapper.findTaskTypeNumByStuId(stuId);
    }
}
