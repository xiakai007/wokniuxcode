package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.ReqInfo;
import cc.zy.base.businesses.mapper.ReqInfoMapper;
import cc.zy.base.businesses.service.IReqInfoService;
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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Service实现
 *
 * @author peihaodong
 * @date 2021-01-25 19:58:35
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ReqInfoServiceImpl extends ServiceImpl<ReqInfoMapper, ReqInfo> implements IReqInfoService {

    private final ReqInfoMapper reqInfoMapper;


    @Override
    public IPage<ReqInfo> selectReqInfosByCondition(QueryRequest request, Date startDate, Date endDate, Integer triggerType, Integer reqUserId,Integer status) {
        Page<ReqInfo> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countReqInfosByCondition(startDate, endDate, triggerType, reqUserId,status));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        return reqInfoMapper.selectReqInfosByCondition(page,startDate, endDate, triggerType, reqUserId,status);
    }

    @Override
    public IPage<ReqInfo> findReqInfos(QueryRequest request, ReqInfo reqInfo) {
        LambdaQueryWrapper<ReqInfo> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        queryWrapper.setEntity(reqInfo);
        Page<ReqInfo> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<ReqInfo> findReqInfos(ReqInfo reqInfo) {
	    LambdaQueryWrapper<ReqInfo> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
        queryWrapper.setEntity(reqInfo);
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createReqInfo(ReqInfo reqInfo) {
        this.save(reqInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateReqInfo(ReqInfo reqInfo) {
        this.saveOrUpdate(reqInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteReqInfo(ReqInfo reqInfo) {
        LambdaQueryWrapper<ReqInfo> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
}
