package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.DistinctReqResult;


import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author LiXu
 * @date 2021/01/25
 */
public interface IDistinctReqResultService extends IService<DistinctReqResult> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param distinctReqResult distinctReqResult
     * @return IPage<DistinctReqResult>
     */
    IPage<DistinctReqResult> findDistinctReqResults(QueryRequest request, DistinctReqResult distinctReqResult);

    /**
     * 查询（所有）
     *
     * @param distinctReqResult distinctReqResult
     * @return List<DistinctReqResult>
     */
    List<DistinctReqResult> findDistinctReqResults(DistinctReqResult distinctReqResult);

    /**
     * 新增
     *
     * @param distinctReqResult distinctReqResult
     */
    void createDistinctReqResult(DistinctReqResult distinctReqResult);

    /**
     * 修改
     *
     * @param distinctReqResult distinctReqResult
     */
    void updateDistinctReqResult(DistinctReqResult distinctReqResult);

    /**
     * 删除
     *
     * @param distinctReqResult distinctReqResult
     */
    void deleteDistinctReqResult(DistinctReqResult distinctReqResult);

    /* 批量增加
     * @param distinctReqResultlist distinctReqResultlist
     */
    int addReqResultList(List<DistinctReqResult> distinctReqResultlist);

    /*
     *查询相同的数据//
     * @param distinctReqResult distinctReqResult
      * @return DistinctReqResult
     */
    DistinctReqResult findDistinctReqResultBySome(DistinctReqResult distinctReqResult);
}
