package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.DistinctReqResult;
import cc.zy.base.businesses.entity.ReqInfo;
import cc.zy.base.businesses.entity.ReqResult;


import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Service接口
 *
 * @author LiXu
 * @date 2021/01/25
 */
public interface IReqResultService extends IService<ReqResult> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param reqResult reqResult
     * @return IPage<ReqResult>
     */
    IPage<ReqResult> findReqResults(QueryRequest request, ReqResult reqResult);

    /**
     * 查询（所有）
     *
     * @param reqResult reqResult
     * @return List<ReqResult>
     */
    List<ReqResult> findReqResults(ReqResult reqResult);

    /**
     * 新增
     *
     * @param reqResult reqResult
     */
    void createReqResult(ReqResult reqResult);

    /**
     * 修改
     *
     * @param reqResult reqResult
     */
    void updateReqResult(ReqResult reqResult);

    /**
     * 删除
     *
     * @param reqResult reqResult
     */
    void deleteReqResult(ReqResult reqResult);

    /**
     * 批量增加
     *
     * @param reqResultList reqResultList
     */
    void addReqResultList(List<ReqResult> reqResultList);

    /**
     * 增加解析的数据并返回ID
     *
     * @param reqResult 用于传递查询条件
     * @return int
     *
     */

    public int addReqResultGetId(@Param("reqResult") ReqResult reqResult);

    /**
     * 增加ReqResult和ResultExtension
     * 保持二者事务一致
     *
     */
    ReqResult addReqResultAndReqResultExtension(ReqResult reqResult, ReqInfo reqInfo);
}
