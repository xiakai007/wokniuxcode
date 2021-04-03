package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.DistinctReqResult;
import cc.zy.base.businesses.mapper.DistinctReqResultMapper;
import cc.zy.base.businesses.service.IDistinctReqResultService;
import cc.zy.base.common.entity.QueryRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 *  Service实现
 *
 * @author LiXu
 * @date 2021/01/25
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DistinctReqResultServiceImpl extends ServiceImpl<DistinctReqResultMapper, DistinctReqResult> implements IDistinctReqResultService {

    private final DistinctReqResultMapper distinctReqResultMapper;

    @Override
    public IPage<DistinctReqResult> findDistinctReqResults(QueryRequest request, DistinctReqResult distinctReqResult) {
        LambdaQueryWrapper<DistinctReqResult> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<DistinctReqResult> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<DistinctReqResult> findDistinctReqResults(DistinctReqResult distinctReqResult) {
        LambdaQueryWrapper<DistinctReqResult> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createDistinctReqResult(DistinctReqResult distinctReqResult) {
        this.save(distinctReqResult);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateDistinctReqResult(DistinctReqResult distinctReqResult) {
        this.saveOrUpdate(distinctReqResult);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDistinctReqResult(DistinctReqResult distinctReqResult) {
        LambdaQueryWrapper<DistinctReqResult> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    //
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addReqResultList(List<DistinctReqResult> distinctReqResultlist) {
        int i = this.baseMapper.addDistinctReqResultlist(distinctReqResultlist);
        return i;
    }

    @Override
    public DistinctReqResult findDistinctReqResultBySome(DistinctReqResult distinctReqResult) {
        return this.baseMapper.findDistinctReqResultBySome(distinctReqResult);
    }

}