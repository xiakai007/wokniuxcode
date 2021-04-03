package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.CustomStandardFee;
import cc.zy.base.businesses.entity.StandardFee;
import cc.zy.base.businesses.mapper.CustomStandardFeeMapper;
import cc.zy.base.businesses.service.ICustomStandardFeeService;
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

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *  Service实现
 *
 * @author zzz
 * @date 2021-01-29 13:11:58
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomStandardFeeServiceImpl extends ServiceImpl<CustomStandardFeeMapper, CustomStandardFee> implements ICustomStandardFeeService {
       @Resource
    private final CustomStandardFeeMapper customStandardFeeMapper;





    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCustomStandardFees(String[] customStandardFeeIds) {
        List<String> list = Arrays.asList(customStandardFeeIds);
        // 删除用户
        this.removeByIds(list);
    }

    @Override
    public List<Map<String, String>> batchAll(Integer id) {
        return customStandardFeeMapper.batchAll(id);
    }

    @Override
    public List<Map<String, String>> collegeAll(Integer batchId) {
        return customStandardFeeMapper.collegeAll(batchId);
    }

    @Override
    public List<Map<String, String>> levelAll(Integer batchId, Integer collegeId) {
        return customStandardFeeMapper.levelAll(batchId,collegeId);
    }

    @Override
    public List<Map<String, String>> subjectCategoryAll(Integer batchId, Integer collegeId, Integer levelId) {
        return customStandardFeeMapper.subjectCategoryAll(batchId,collegeId,levelId);
    }

    @Override
    public List<Map<String, String>> majorAll(Integer batchId, Integer collegeId, Integer levelId, Integer subjectCategoryId) {
        return customStandardFeeMapper.majorAll(batchId,collegeId,levelId,subjectCategoryId);
    }
 @Override
    public List<Map<String, String>> cultivateAll() {
        return customStandardFeeMapper.cultivateAll();
    }












    @Override
    public IPage<CustomStandardFee> findCustomStandardFees(QueryRequest request, CustomStandardFee customStandardFee) {
        System.out.println("进入service：batchid："+customStandardFee.getBatchId());
       LambdaQueryWrapper<CustomStandardFee> queryWrapper = new LambdaQueryWrapper<>();
        Page<CustomStandardFee> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countCustomStandardFeeDetail(customStandardFee));
        SortUtil.handlePageSort(request, page, "T.ID", FebsConstant.ORDER_DESC, false);
        System.out.println( "结果："+this.baseMapper.findCustomStandardFeeDetailPage(page,customStandardFee));
        return this.baseMapper.findCustomStandardFeeDetailPage(page,customStandardFee);
    }
//    @Override
//    public IPage<StandardFee> findStandardFees(QueryRequest request, StandardFee standardFee) {
//        LambdaQueryWrapper<StandardFee> queryWrapper = new LambdaQueryWrapper<>();
//        // TODO 设置查询条件
//        Page<StandardFee> page = new Page<>(request.getPageNum(), request.getPageSize());
//        return this.page(page, queryWrapper);
//
//
////          Page<StandardFee> page = new Page<>(request.getPageNum(), request.getPageSize());
////        page.setSearchCount(false);
////        page.setTotal(baseMapper.countStandardFeeDetail(standardFee));
////        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
////        return this.baseMapper.findStandardFeeDetailPage(page,standardFee);
//    }

    @Override
    public List<CustomStandardFee> findCustomStandardFees(CustomStandardFee customStandardFee) {
	    LambdaQueryWrapper<CustomStandardFee> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

//    @Override
//    public List<Map<String, Object>> fingStandardFeeAll() {
//
//        return this.standardFeeMapper.fingStandardFeeAll();
//    }

        @Override
    public CustomStandardFee findById(Integer id) {
        return this.baseMapper.findById(id);
    }

    @Override
    public int addCustomStandardFee(CustomStandardFee customStandardFee) {
        return customStandardFeeMapper.addCustomStandardFee(customStandardFee);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createCustomStandardFee(CustomStandardFee customStandardFee) {
        this.save(customStandardFee);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCustomStandardFee(CustomStandardFee customStandardFee) {
        this.saveOrUpdate(customStandardFee);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCustomStandardFee(CustomStandardFee customStandardFee) {
        LambdaQueryWrapper<CustomStandardFee> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
}
