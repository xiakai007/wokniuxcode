package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.Watch;
import cc.zy.base.businesses.mapper.WatchMapper;
import cc.zy.base.businesses.service.IWatchService;
import cc.zy.base.common.entity.QueryRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Date;
import java.util.List;

/**
 *  Service实现
 *
 * @author Jiangjinlin
 * @date 2021-01-25 15:11:02
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class WatchServiceImpl extends ServiceImpl<WatchMapper, Watch> implements IWatchService {

    private final WatchMapper watchMapper;

    @Override
    public IPage<Watch> findWatchs(QueryRequest request, Watch watch) {
        LambdaQueryWrapper<Watch> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Watch> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Watch> findWatchs(Watch watch) {
	    LambdaQueryWrapper<Watch> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createWatch(Watch watch) {
        this.save(watch);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateWatch(Watch watch) {
        this.saveOrUpdate(watch);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteWatch(Watch watch) {
        LambdaQueryWrapper<Watch> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(Watch watch) {
        long l = System.currentTimeMillis();
        watch.setStartTime(new Date(l));
        this.insert(watch);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateWatchEndTime(Watch watch) {
        long l = System.currentTimeMillis();
        watch.setEndTime(new Date(l));
        watchMapper.updateByVideoIdAndStuid(watch);
    }
}
