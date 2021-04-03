package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.Seal;
import cc.zy.base.businesses.mapper.SealMapper;
import cc.zy.base.businesses.service.ISealService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.SortUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 *  印章业务层实现
 *
 * @author Jiangjinlin
 * @date 2021-01-27 09:56:39
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SealServiceImpl extends ServiceImpl<SealMapper, Seal> implements ISealService {

    private final SealMapper sealMapper;

    /**
     * 查询所有学校和印章的信息
     *
     * @param   request QueryRequest
     * @param   College college
     * @return IPage<College>
     * @author guozhaodi
     * @date 2021-01-27 09:56:39
     */
    @Override
    public IPage<College> findSeals(QueryRequest request, College college) {
        LambdaQueryWrapper<College> queryWrapper = new LambdaQueryWrapper<>();
        Page<College> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countSealDetail(college));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findSealDetailPage(page, college);
    }

    /**
     * 根据院校id更改院校图片信息
     *
     * @param Seal seal
     * 无返回
     * @author guozhaodi
     * @date 2021-01-27 09:56:39
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSeal(Seal seal) {
        this.saveOrUpdate(seal);
    }

    /**
     * 根据院校id查询当前院校和印章信息（用于修改前页面信息展示）
     *
     * @param id
     * @return
     * @author guozhaodi
     * @date 2021-01-27 09:56:39
     */
    @Override
    public College findSealById(Integer id) {
        return this.baseMapper.findById(id);
    }

}
