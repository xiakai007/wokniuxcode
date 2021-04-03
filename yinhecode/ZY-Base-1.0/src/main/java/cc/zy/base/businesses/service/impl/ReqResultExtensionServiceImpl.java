package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.ReqResultExtension;
import cc.zy.base.businesses.mapper.ReqResultExtensionMapper;
import cc.zy.base.businesses.service.IReqResultExtensionService;
import cc.zy.base.common.entity.QueryRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Service实现
 *
 * @author LiXu
 * @date 2021/01/25
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ReqResultExtensionServiceImpl extends ServiceImpl<ReqResultExtensionMapper, ReqResultExtension> implements IReqResultExtensionService {

    private final ReqResultExtensionMapper reqResultExtensionMapper;

    @Override
    public List<ReqResultExtension> findReqResultExtensions(ReqResultExtension reqResultExtension) {
        LambdaQueryWrapper<ReqResultExtension> queryWrapper = new LambdaQueryWrapper<>();
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public ReqResultExtension findById(Integer id) {
        return reqResultExtensionMapper.findById(id);
    }

    /**
     * @description: 查：按条件查询学生，用于分组
     * @param: request 分页对象，内含分页参数、排序参数；reqResultExtension query对象，传递查询条件
     * @return: 包含分页参数，以及查询到的数据集合
     * @author: LiPeng
     * @date: 2021/2/8
     */
    @Override
    public IPage<ReqResultExtension> findStudentInfoForGrouping(
            QueryRequest request, ReqResultExtension reqResultExtension) {
        Page<ReqResultExtension> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(this.reqResultExtensionMapper.countStudentInfoForGrouping(reqResultExtension));
        return this.reqResultExtensionMapper.findStudentInfoForGrouping(page, reqResultExtension);
    }

    /**
     * @description: 给学生分组
     * @param: ids 学生id集合；groupId 学生组的id
     * @author: LiPeng
     * @date: 2021/2/8
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateGroupId(ArrayList<Integer> ids, Integer groupId) {
        this.reqResultExtensionMapper.updateGroupId(ids, groupId);
    }

    /**
     * @description: 按条件查询学生，然后给查询到的所有学生分组
     * @param: reqResultExtension 查询对象，传递查询条件；groupId 学生组id
     * @author: LiPeng
     * @date: 2021/2/8
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateGroupIdAll(ReqResultExtension reqResultExtension, Integer groupId) {
        ArrayList<Integer> stuIds = this.reqResultExtensionMapper.findIdsByParams(reqResultExtension);
        this.reqResultExtensionMapper.updateGroupId(stuIds, groupId);
    }

    /**
     * @description: 查：按条件查询学生，根据用户Id查找该Id下管理的学生组学生信息
     * @param: request 分页对象，内含分页参数、排序参数；reqResultExtension query对象，传递查询条件;userId 用户Id
     * @return: 包含分页参数，以及查询到的数据集合
     * @author: hutengjiao
     * @date: 2021/3/2
     */
    @Override
    public IPage<ReqResultExtension> findStudentForGroupingByUId(QueryRequest request,
                                                                 ReqResultExtension reqResultExtension,
                                                                 Integer userId) {
        Page<ReqResultExtension> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(this.reqResultExtensionMapper.countStudentInfoForGroupingByUId(reqResultExtension,userId));
        return this.reqResultExtensionMapper.findStudentInfoForGroupingByUId(page, reqResultExtension,userId);
    }

    /**
     * @description: 查：根据id查找学生信息
     * @param: id 公海学生id
     * @author: hutengjiao
     * @date: 2021/3/3
     */
    @Override
    public ReqResultExtension findReqStudentByStuId(Integer id) {
        ReqResultExtension reqResultExtension = this.reqResultExtensionMapper.findStudentInfoForPoolByStuId(id);
        return reqResultExtension;
    }
}