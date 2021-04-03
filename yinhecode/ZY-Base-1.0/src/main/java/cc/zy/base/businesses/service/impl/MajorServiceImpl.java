package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.Major;
import cc.zy.base.businesses.mapper.MajorMapper;
import cc.zy.base.businesses.service.IMajorService;
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
import java.util.List;

/**
 * 专业表 Service实现
 *
 * @author guozhikun
 * @date 2021-01-26 19:41:01
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements IMajorService {

    private final MajorMapper majorMapper;

    @Override
    public IPage<Major> findMajors(QueryRequest request, Major major) {
        Page<College> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countMajorDetail(major));
        SortUtil.handlePageSort(request, page, "createTime", FebsConstant.ORDER_DESC, true);
        return this.baseMapper.findMajorDetailPage(page, major);
    }

    @Override
    public List<Major> findMajor() {
        return majorMapper.findMajor();
    }

    @Override
    public Major findById(Integer id) {
        return majorMapper.findById(id);
    }

    @Override
    public List<Major> findMajors(Major major) {
	    LambdaQueryWrapper<Major> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createMajor(Major major) {
        major.setCreateTime(new Date());
        this.save(major);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMajor(Major major) {
        this.saveOrUpdate(major);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteMajor(Major major) {
        LambdaQueryWrapper<Major> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

	 @Override
    public List<Major> findMajorForSelect(Integer batchId, Integer collegeId, Integer levelId) {
        return this.majorMapper.selectMajorByBatchForSelect(batchId, collegeId, levelId);
    }
}
