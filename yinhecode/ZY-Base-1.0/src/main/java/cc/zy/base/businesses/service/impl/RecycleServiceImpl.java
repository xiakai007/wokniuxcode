package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.Recycle;
import cc.zy.base.businesses.entity.StuLabel;
import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.mapper.RecycleMapper;
import cc.zy.base.businesses.mapper.StudentMapper;
import cc.zy.base.businesses.service.IRecycleService;
import cc.zy.base.businesses.service.IStudentService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.SortUtil;
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

/**
 * @author JiangWeiguang
 * @date 2021\1\23 0023 10:51
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RecycleServiceImpl extends ServiceImpl<RecycleMapper, Recycle> implements IRecycleService {

    @Resource
    private RecycleMapper recycleMapper;

    @Override
    public IPage<Recycle> findRecycle(QueryRequest request, Recycle recycle) {
        Page<Recycle> recyclePage = new Page<>(request.getPageNum(), request.getPageSize());
        recyclePage.setSearchCount(false);// 查询总记录数，默认是查询
        recyclePage.setTotal(baseMapper.countRecycleDetail(recycle));
        SortUtil.handlePageSort(request, recyclePage, "ID", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findRecycleDetailPage(recyclePage, recycle);
    }

    @Override
    public Recycle findById(Integer id) {
        return recycleMapper.findRecycleById(id);
    }
}
