package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.AbsenteeCost;


import cc.zy.base.businesses.entity.CostExport;
import cc.zy.base.businesses.entity.CostExportExcel;
import cc.zy.base.businesses.entity.EntranceScore;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 *  Service接口
 *
 * @author zzz
 * @date 2021-02-03 16:29:47
 */
public interface IAbsenteeCostService extends IService<AbsenteeCost> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param absenteeCost absenteeCost
     * @return IPage<AbsenteeCost>
     */
    IPage<AbsenteeCost> findAbsenteeCosts(QueryRequest request, AbsenteeCost absenteeCost);

    /**
     * 查询（所有）
     *
     * @param absenteeCost absenteeCost
     * @return List<AbsenteeCost>
     */
    List<AbsenteeCost> findAbsenteeCosts(AbsenteeCost absenteeCost);

    /**
     * 新增
     *
     * @param absenteeCost absenteeCost
     */
    void createAbsenteeCost(AbsenteeCost absenteeCost);

    /**
     * 修改
     *
     * @param absenteeCost absenteeCost
     */
    void updateAbsenteeCost(AbsenteeCost absenteeCost);

    /**
     * 删除
     *
     * @param absenteeCost absenteeCost
     */
    void deleteAbsenteeCost(AbsenteeCost absenteeCost);

    /**
     * 获得需要导出的缴费信息
     * @author guozhaodi
     * @date 2021-02-03 17:07:47
     * @param costExport
     * @return List<CostExportExcel>
     */

    List<CostExportExcel> selectbyexample(CostExport costExport);

}
