package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.ResolveException;
import cc.zy.base.businesses.mapper.ResolveExceptionMapper;
import cc.zy.base.businesses.service.IResolveExceptionService;
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

import java.sql.Timestamp;
import java.util.List;

/**
 *  Service实现
 *
 * @author LiXu
 * @date 2021/01/25
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ResolveExceptionServiceImpl extends ServiceImpl<ResolveExceptionMapper, ResolveException> implements IResolveExceptionService {

    private final ResolveExceptionMapper resolveExceptionMapper;

    @Override
    public IPage<ResolveException> findResolveExceptions(QueryRequest request, ResolveException resolveException) {
        LambdaQueryWrapper<ResolveException> queryWrapper = new LambdaQueryWrapper<>();

        // TODO 设置查询条件
        Page<ResolveException> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<ResolveException> findResolveExceptions(ResolveException resolveException) {
	    LambdaQueryWrapper<ResolveException> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createResolveException(ResolveException resolveException) {
        try {
            this.save(resolveException);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateResolveException(ResolveException resolveException) {
        this.saveOrUpdate(resolveException);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteResolveException(ResolveException resolveException) {
        LambdaQueryWrapper<ResolveException> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    public IPage<ResolveException> findByResolveException(QueryRequest request,Timestamp dtpStartDate, Timestamp dtpEndDate, Integer cboTriggerType, Integer reqUserId) {
        Page<ResolveException> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.findByResolveExceptionCount(dtpStartDate,dtpEndDate,cboTriggerType,reqUserId));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        IPage<ResolveException> byResolveException = resolveExceptionMapper.findByResolveException(page, dtpStartDate, dtpEndDate, cboTriggerType, reqUserId);
        for (ResolveException resolveException : byResolveException.getRecords()) {
            if ((resolveException.getUserName()==null||resolveException.getUserName()=="")&&resolveException.getReqUserId()==0){
                resolveException.setUserName("系统【定时器同步】");
            }else if ((resolveException.getUserName()==null||resolveException.getUserName()=="")&&resolveException.getReqUserId()== -1){
                resolveException.setUserName("系统【自动推送】");
            }
        }
        return byResolveException;
    }

    @Override
    public IPage<ResolveException> findByResolveExceptionDics(QueryRequest request) {
        Page<ResolveException> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.findByResolveExceptionDicsCount());
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        IPage<ResolveException> byResolveExceptions = resolveExceptionMapper.findByResolveExceptions(page);
//        for (ResolveException resolveException : byResolveExceptions.getRecords()) {
//            if ((resolveException.getUserName()==null||resolveException.getUserName()=="")&&resolveException.getReqUserId()==0){
//                resolveException.setUserName("定时器推送");
//            }else if ((resolveException.getUserName()==null||resolveException.getUserName()=="")&&resolveException.getReqUserId()== -1){
//                resolveException.setUserName("自动推送");
//            }
//        }

        return byResolveExceptions;
    }

    @Override
    public ResolveException findById(Integer id) {
        ResolveException resolveException = resolveExceptionMapper.findById(id);
        if ((resolveException.getUserName()==null||resolveException.getUserName()=="")&&resolveException.getReqUserId()==0){
            resolveException.setUserName("系统【定时器同步】");
        }else if ((resolveException.getUserName()==null||resolveException.getUserName()=="")&&resolveException.getReqUserId()== -1){
            resolveException.setUserName("系统【自动推送】");
        }
        return resolveException;
    }
}
