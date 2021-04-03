package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.OtherPayment;
import cc.zy.base.businesses.mapper.OtherPaymentMapper;
import cc.zy.base.businesses.service.IOtherPaymentService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.SortUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *  Service实现
 *
 * @author zzz
 * @date 2021-01-30 15:58:27
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OtherPaymentServiceImpl extends ServiceImpl<OtherPaymentMapper, OtherPayment> implements IOtherPaymentService {

    private final OtherPaymentMapper otherPaymentMapper;
      @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOtherPayments(String[] otherPaymentIds) {
        List<String> list = Arrays.asList(otherPaymentIds);
        // 删除用户
        this.removeByIds(list);
    }

    @Override
    public List<Map<String, String>> batchAll(Integer id) {
        return otherPaymentMapper.batchAll(id);
    }

    @Override
    public List<Map<String, String>> collegeAll(Integer batchId) {
        return otherPaymentMapper.collegeAll(batchId);
    }

    @Override
    public List<Map<String, String>> levelAll(Integer batchId, Integer collegeId) {
        return otherPaymentMapper.levelAll(batchId,collegeId);
    }

    @Override
    public List<Map<String, String>> subjectCategoryAll(Integer batchId, Integer collegeId, Integer levelId) {
        return otherPaymentMapper.subjectCategoryAll(batchId,collegeId,levelId);
    }

    @Override
    public List<Map<String, String>> majorAll(Integer batchId, Integer collegeId, Integer levelId, Integer subjectCategoryId) {
        return otherPaymentMapper.majorAll(batchId,collegeId,levelId,subjectCategoryId);
    }
 @Override
    public List<Map<String, String>> cultivateAll() {
        return otherPaymentMapper.cultivateAll();
    }












    @Override
    public IPage<OtherPayment> findOtherPayments(QueryRequest request, OtherPayment otherPayment) {
        System.out.println("进入service：batchid："+otherPayment.getBatchId());
       LambdaQueryWrapper<OtherPayment> queryWrapper = new LambdaQueryWrapper<>();
        Page<OtherPayment> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countOtherPaymentDetail(otherPayment));
        SortUtil.handlePageSort(request, page, "T.ID", FebsConstant.ORDER_DESC, false);
        System.out.println( "结果："+this.baseMapper.findOtherPaymentDetailPage(page,otherPayment));
        return this.baseMapper.findOtherPaymentDetailPage(page,otherPayment);
    }


    @Override
    public List<OtherPayment> findOtherPayments(OtherPayment otherPayment) {
	    LambdaQueryWrapper<OtherPayment> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }



        @Override
    public OtherPayment findById(Integer id) {
        return this.baseMapper.findById(id);
    }

    @Override
    public int addOtherPayment(OtherPayment otherPayment) {
        return otherPaymentMapper.addOtherPayment(otherPayment);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOtherPayment(OtherPayment otherPayment) {
        this.save(otherPayment);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOtherPayment(OtherPayment otherPayment) {
        this.saveOrUpdate(otherPayment);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOtherPayment(OtherPayment otherPayment) {
        LambdaQueryWrapper<OtherPayment> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}


}
