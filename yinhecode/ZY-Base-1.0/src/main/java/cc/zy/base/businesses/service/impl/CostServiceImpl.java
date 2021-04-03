package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.Cost;
import cc.zy.base.businesses.mapper.CostMapper;
import cc.zy.base.businesses.service.ICostService;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  Service实现
 *
 * @author hu
 * @date 2021-01-25 11:42:38
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CostServiceImpl extends ServiceImpl<CostMapper, Cost> implements ICostService {

    private final CostMapper costMapper;

    @Override
    public IPage<Cost> findCosts(QueryRequest request, Cost cost) {
        LambdaQueryWrapper<Cost> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Cost> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Cost> findCosts(Cost cost) {
	    LambdaQueryWrapper<Cost> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createCost(Cost cost) {
        this.save(cost);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCost(Cost cost) {
        this.saveOrUpdate(cost);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCost(Cost cost) {
        LambdaQueryWrapper<Cost> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
}
