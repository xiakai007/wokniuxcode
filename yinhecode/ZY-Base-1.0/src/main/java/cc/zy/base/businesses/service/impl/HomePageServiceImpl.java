package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.HomePage;
import cc.zy.base.businesses.mapper.HomePageMapper;
import cc.zy.base.businesses.service.IHomePageService;
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
 * 首页栏位表 Service实现
 *
 * @author Jiangjinlin
 * @date 2021-01-27 10:29:21
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class HomePageServiceImpl extends ServiceImpl<HomePageMapper, HomePage> implements IHomePageService {

    private final HomePageMapper homePageMapper;

    @Override
    public IPage<HomePage> findHomePages(QueryRequest request, HomePage homePage) {
        LambdaQueryWrapper<HomePage> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<HomePage> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<HomePage> findHomePages(HomePage homePage) {
	    LambdaQueryWrapper<HomePage> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createHomePage(HomePage homePage) {
        this.save(homePage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateHomePage(HomePage homePage) {
        this.saveOrUpdate(homePage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteHomePage(HomePage homePage) {
        LambdaQueryWrapper<HomePage> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    public List<HomePage> findAllHomePage() {
        return homePageMapper.findAllHomePage();
    }

    @Override
    public HomePage findHomeById(Integer id) {
        return homePageMapper.findById(id);
    }
}
