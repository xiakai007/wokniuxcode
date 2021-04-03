package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.AdvertLog;
import cc.zy.base.businesses.mapper.AdvertLogMapper;
import cc.zy.base.businesses.service.IAdvertLogService;
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
 * 广告日志表 Service实现
 *
 * @author zhaojw
 * @date 2021-01-28 09:46:04
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdvertLogServiceImpl extends ServiceImpl<AdvertLogMapper, AdvertLog> implements IAdvertLogService {

    private final AdvertLogMapper advertLogMapper;

    @Override
    public IPage<AdvertLog> findAdvertLogs(QueryRequest request, AdvertLog advertLog) {
        if (advertLog != null && advertLog.getTitle() != null) {
            advertLog.setTitle(advertLog.getTitle().trim());
        }
        if (advertLog != null && advertLog.getStuName() != null) {
            advertLog.setStuName(advertLog.getStuName().trim());
        }
        Page<AdvertLog> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(advertLogMapper.countAdvertLog(advertLog));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        return advertLogMapper.findAdvertLogNew(page, advertLog);
    }

    @Override
    public List<AdvertLog> findAdvertLogs(AdvertLog advertLog) {
        if (advertLog != null && advertLog.getTitle() != null) {
            advertLog.setTitle(advertLog.getTitle().trim());
        }
        if (advertLog != null && advertLog.getStuName() != null) {
            advertLog.setStuName(advertLog.getStuName().trim());
        }
        LambdaQueryWrapper<AdvertLog> queryWrapper = new LambdaQueryWrapper<>();
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertAdvertLogData(Integer userId, Integer advertId) {
        advertLogMapper.insertAdvertLogData(userId, advertId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAdvertLog(Integer userId, Integer advertId) {
        this.advertLogMapper.updateExitTime(userId, advertId);
    }


    @Override
    public Integer findStuIdByOpenId(String openId) {
        return advertLogMapper.findStuIdByOpenId(openId);
    }

    @Override
    public List<AdvertLog> exportAdvLog(AdvertLog advertLog) {
        return advertLogMapper.exportAdvLog(advertLog);
    }

}
