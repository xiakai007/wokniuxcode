package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.Cost;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author hu
 * @date 2021-01-25 11:42:38
 */
public interface ICostService extends IService<Cost> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param cost cost
     * @return IPage<Cost>
     */
    IPage<Cost> findCosts(QueryRequest request, Cost cost);

    /**
     * 查询（所有）
     *
     * @param cost cost
     * @return List<Cost>
     */
    List<Cost> findCosts(Cost cost);

    /**
     * 新增
     *
     * @param cost cost
     */
    void createCost(Cost cost);

    /**
     * 修改
     *
     * @param cost cost
     */
    void updateCost(Cost cost);

    /**
     * 删除
     *
     * @param cost cost
     */
    void deleteCost(Cost cost);
}
