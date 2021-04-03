package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.ResolveException;


import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.sql.Timestamp;
import java.util.List;

/**
 *  Service接口
 *
 * @author LiXu
 * @date 2021/01/25
 */
public interface IResolveExceptionService extends IService<ResolveException> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param resolveException resolveException
     * @return IPage<ResolveException>
     */
    IPage<ResolveException> findResolveExceptions(QueryRequest request, ResolveException resolveException);

    /**
     * 查询（所有）
     *
     * @param resolveException resolveException
     * @return List<ResolveException>
     */
    List<ResolveException> findResolveExceptions(ResolveException resolveException);

    /**
     * 新增
     *
     * @param resolveException resolveException
     */
    void createResolveException(ResolveException resolveException);

    /**
     * 修改
     *
     * @param resolveException resolveException
     */
    void updateResolveException(ResolveException resolveException);

    /**
     * 删除
     *
     * @param resolveException resolveException
     */
    void deleteResolveException(ResolveException resolveException);

    /*
     *  按条件查询
     *  @param startTime  @param endTime  @param cboTriggerType @param reqUserId
     *  @return List<ResolveException>
     */
    IPage<ResolveException> findByResolveException(QueryRequest request, Timestamp dtpStartDate, Timestamp dtpEndDate, Integer cboTriggerType, Integer reqUserId);


    /*
   *  全部查询
   *
   *  @return List<ResolveException>
   */
    IPage<ResolveException>  findByResolveExceptionDics(QueryRequest request);


    ResolveException findById(Integer id);
}
