package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.Advert;

import cc.zy.base.businesses.entity.AdvertLoop;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.validation.Valid;
import java.util.List;

/**
 *  广告Service接口
 *
 * @author lijian
 * @date 2021/01/25
 */
public interface IAdvertService extends IService<Advert> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param advert advert
     * @return IPage<Advert>
     */
    IPage<Advert> findAdverts(QueryRequest request, Advert advert);

    /**
     * 查询（所有）
     *
     * @param advert advert
     * @return List<Advert>
     */
    List<Advert> findAdverts(Advert advert);

    /**
     * 通过ID查找广告详细信息
     *
     * @param id id
     * @return 广告信息
     */
    Advert findAdvertDetailById(Integer id);

    /**
     * 新增
     *
     * @param advert advert
     */
    void createAdvert(Advert advert);

    /**
     * 修改
     *
     * @param advert advert
     */
    void updateAdvert(Advert advert);

    /**
     * 删除
     *
     * @param Integer advert
     */
    void deleteAdvert(Integer advertId);
    /**
     * 广告轮播位置
     *
     */
    Integer findAdvertLoopId();

    /**
     *删除轮播广告
     * @param advertId
     */
    void delAdvrertToAdvertLoop(Integer advertId);

    /**
     * 添加广告到广告轮播表
     * @param advertId
     * @param loopId
     */
    void addAdvertToAdvertLoop(Integer advertId,Integer loopId);

    IPage<AdvertLoop> findAdvertLoops(QueryRequest request);

    long findUseLoopCount();

    /**
     * 修改轮播广告的位置
     * @param advertLoop
     */
    void updateAdvertLoopOrder( AdvertLoop advertLoop);

    /**
     * 修改广告状态
     * @param advertDetail
     */
    void updateAdvertStatus(Advert advertDetail);
}
