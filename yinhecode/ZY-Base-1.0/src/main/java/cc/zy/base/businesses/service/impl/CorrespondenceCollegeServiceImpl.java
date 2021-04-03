package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.CorrespondenceCollege;
import cc.zy.base.businesses.mapper.CorrespondenceCollegeMapper;
import cc.zy.base.businesses.service.ICorrespondenceCollegeService;
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
 * 函授站表 Service实现
 *
 * @author Jiangjinlin
 * @date 2021-01-25 19:37:31
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CorrespondenceCollegeServiceImpl extends ServiceImpl<CorrespondenceCollegeMapper, CorrespondenceCollege> implements ICorrespondenceCollegeService {

    private final CorrespondenceCollegeMapper correspondenceCollegeMapper;

    @Override
    public IPage<CorrespondenceCollege> findCorrespondenceColleges(QueryRequest request, String province,String city, String name) {
        Page<CorrespondenceCollege> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(correspondenceCollegeMapper.countCorrespondenceCollege(province,city,name));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findCorrespondenceCollege(page,province,city,name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createCorrespondenceCollege(CorrespondenceCollege correspondenceCollege) {
        correspondenceCollegeMapper.insertCorrespondenceCollege(correspondenceCollege);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateCorrespondenceCollege(CorrespondenceCollege correspondenceCollege) {
        return correspondenceCollegeMapper.updateCorrespondenceCollege(correspondenceCollege);
    }

    @Override
    public CorrespondenceCollege findCorrespondenceCollegeById(Integer id) {
        return correspondenceCollegeMapper.findCorrespondenceCollegeById(id);
    }

    @Override
    public Boolean isRepetitive(String fullName, String simpleName) {
        Boolean flag = true;
        List<Integer> repetitive = correspondenceCollegeMapper.isRepetitive(fullName,simpleName);
        if(repetitive != null && repetitive.size() > 0){
            flag = false;
        }
        return flag;
    }


}
