package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.AbsenteeCost;
import cc.zy.base.businesses.entity.CostExport;
import cc.zy.base.businesses.entity.CostExportExcel;
import cc.zy.base.businesses.mapper.AbsenteeCostMapper;
import cc.zy.base.businesses.service.IAbsenteeCostService;
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
import java.util.List;


/**
 * Service实现
 *
 * @author zzz
 * @date 2021-02-03 16:29:47
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AbsenteeCostServiceImpl extends ServiceImpl<AbsenteeCostMapper, AbsenteeCost> implements IAbsenteeCostService {

    private final AbsenteeCostMapper absenteeCostMapper;

    @Override
    public IPage<AbsenteeCost> findAbsenteeCosts(QueryRequest request, AbsenteeCost absenteeCost) {
        LambdaQueryWrapper<AbsenteeCost> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<AbsenteeCost> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<AbsenteeCost> findAbsenteeCosts(AbsenteeCost absenteeCost) {
        LambdaQueryWrapper<AbsenteeCost> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createAbsenteeCost(AbsenteeCost absenteeCost) {
        this.save(absenteeCost);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAbsenteeCost(AbsenteeCost absenteeCost) {
        this.saveOrUpdate(absenteeCost);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAbsenteeCost(AbsenteeCost absenteeCost) {
        LambdaQueryWrapper<AbsenteeCost> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }
    /**
     * 获得需要导出的缴费信息
     *
     * @param costExport
     * @return
     * @author guozhaodi
     * @date 2021-02-03 17:07:47
     */
    @Override
    public List<CostExportExcel> selectbyexample(CostExport costExport) {

        List<CostExportExcel> costExportExcels = absenteeCostMapper.selectCostExportExcel(costExport);

        return costExportExcels;

    }
}
