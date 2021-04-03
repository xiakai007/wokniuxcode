package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.ConfirmAddress;
import cc.zy.base.businesses.mapper.ConfirmAddressMapper;
import cc.zy.base.businesses.service.IConfirmAddressService;
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

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 现场确认地点 Service实现
 *
 * @author Jiangjinlin
 * @date 2021-01-25 18:18:46
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ConfirmAddressServiceImpl extends ServiceImpl<ConfirmAddressMapper, ConfirmAddress> implements IConfirmAddressService {

    @Resource
    private final ConfirmAddressMapper confirmAddressMapper;

    @Override
    //查询所有和分页
    public IPage<ConfirmAddress> findConfirmAddresss(QueryRequest request, ConfirmAddress confirmAddress) {
//        LambdaQueryWrapper<ConfirmAddress> queryWrapper = new LambdaQueryWrapper<>();
        Page<ConfirmAddress> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countAddressDetail(confirmAddress));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findAddressDetailPage(page, confirmAddress);
    }

    @Override
    public List<ConfirmAddress> findConfirmAddresss(ConfirmAddress confirmAddress) {
	    LambdaQueryWrapper<ConfirmAddress> queryWrapper = new LambdaQueryWrapper<>(confirmAddress);
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createConfirmAddress(ConfirmAddress confirmAddress) {
//        confirmAddress.setCreatetime(new Date());
        this.save(confirmAddress);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateConfirmAddress(ConfirmAddress confirmAddress) {
        this.saveOrUpdate(confirmAddress);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteConfirmAddress(ConfirmAddress confirmAddress) {
        LambdaQueryWrapper<ConfirmAddress> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    public ConfirmAddress findById(Integer id) {
        return this.baseMapper.findById(id);
    }

    //删除地址
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAddress(String[] addresIds) {
        List<String> list = Arrays.asList(addresIds);
        this.removeByIds(list);
    }
}
