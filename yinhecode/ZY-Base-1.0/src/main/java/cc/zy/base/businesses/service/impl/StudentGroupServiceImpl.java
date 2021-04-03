package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.StudentGroup;
import cc.zy.base.businesses.mapper.StudentGroupMapper;
import cc.zy.base.businesses.service.IStudentGroupService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.FebsUtil;
import cc.zy.base.common.utils.SortUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 学生组表	 Service实现
 *
 * @author LiPeng
 * @date 2021-01-26 16:24:15
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentGroupServiceImpl extends ServiceImpl<StudentGroupMapper, StudentGroup> implements IStudentGroupService {

    private final StudentGroupMapper studentGroupMapper;

    @Override
    public IPage<StudentGroup> findStudentGroups(QueryRequest request, StudentGroup studentGroup) {
        Page<College> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countStudentGroupDetail(studentGroup));
        SortUtil.handlePageSort(request, page, "createTime", FebsConstant.ORDER_DESC, true);
        return this.baseMapper.findStudentGroupDetailPage(page, studentGroup);
    }

    /**
     * @description: 查询满足查询条件的所有结果
     * @param: studentGroup 学生组对象，用来传递查询条件
     * @return: 查询到的学生组集合
     * @author: LiPeng
     * @date: 2021/2/28
     */
    @Override
    public List<StudentGroup> findStudentGroups(StudentGroup studentGroup) {
        List<StudentGroup> studentGroupListNotPage = this.studentGroupMapper.findStudentGroupListNotPage(studentGroup);
        return studentGroupListNotPage;
    }

    /**
     * @Description: 查询所有学生组，倒序
     * @return: 学生组集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    @Override
    public List<StudentGroup> findStudentGroups() {
        QueryWrapper<StudentGroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("CREATE_TIME");
        return this.studentGroupMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createStudentGroup(StudentGroup studentGroup) {
        this.save(studentGroup);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteStudentGroup(String[] groupIds) {
        List<String> list = Arrays.asList(groupIds);
        this.removeByIds(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createGroup(StudentGroup studentGroup) {
        studentGroup.setCreateUserId(FebsUtil.getCurrentUser().getUserId());
        studentGroup.setCreateTime(new Date());
        this.save(studentGroup);
    }
}