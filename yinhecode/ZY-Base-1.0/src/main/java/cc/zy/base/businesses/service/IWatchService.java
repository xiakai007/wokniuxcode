package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.Watch;


import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author Jiangjinlin
 * @date 2021-01-25 15:11:02
 */
public interface IWatchService extends IService<Watch> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param watch watch
     * @return IPage<Watch>
     */
    IPage<Watch> findWatchs(QueryRequest request, Watch watch);

    /**
     * 查询（所有）
     *
     * @param watch watch
     * @return List<Watch>
     */
    List<Watch> findWatchs(Watch watch);

    /**
     * 新增
     *
     * @param watch watch
     */
    void createWatch(Watch watch);

    /**
     * 修改
     *
     * @param watch watch
     */
    void updateWatch(Watch watch);

    /**
     * 删除
     *
     * @param watch watch
     */
    void deleteWatch(Watch watch);

    /**
     * 插入观看记录开始时间
     */
    void insert (Watch watch);
    void updateWatchEndTime(Watch watch);
}
