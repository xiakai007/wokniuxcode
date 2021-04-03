package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.Level;
import cc.zy.base.businesses.mapper.LevelMapper;
import cc.zy.base.businesses.service.ILevelService;
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
 * @author Jiangjinlin
 * @date 2021-01-26 10:43:23
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LevelServiceImpl extends ServiceImpl<LevelMapper, Level> implements ILevelService {

    private final LevelMapper levelMapper;

    @Override
    public IPage<Level> findLevels(QueryRequest request, Level level) {
        LambdaQueryWrapper<Level> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Level> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Level> findLevels() {
		return this.baseMapper.getLevelList();
    }

    @Override
    public List<Level> findLevels(Level level) {
        LambdaQueryWrapper<Level> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createLevel(Level level) {
        this.save(level);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateLevel(Level level) {
        this.saveOrUpdate(level);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteLevel(Level level) {
        LambdaQueryWrapper<Level> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}


}
