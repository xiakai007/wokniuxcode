package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.AdvertLog;

import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 广告日志
 *
 * @author 赵佳伟
 * @date 2021-01-28 09:46:04
 */
public interface IAdvertLogService extends IService<AdvertLog> {

    /**
     * 查询广告日志（分页）
     *
     * @param request   QueryRequest
     * @param advertLog advertLog
     * @return IPage<AdvertLog>
     */
    IPage<AdvertLog> findAdvertLogs(QueryRequest request, AdvertLog advertLog);

    /**
     * 查询广告日志（不分页）
     *
     * @param advertLog advertLog
     * @return List<AdvertLog>
     */
    List<AdvertLog> findAdvertLogs(AdvertLog advertLog);

    /**
     * 新增广告日志
     *
     * @param userId   用户id（学生表id）
     * @param advertId 观看广告的id
     */
    void insertAdvertLogData(Integer userId, Integer advertId);

    /**
     * 用户退出广告时，记录退出时间
     *
     * @param userId   用户id（学生表id）
     * @param advertId 观看广告的id
     */
    void updateAdvertLog(Integer userId, Integer advertId);


    /**
     * 根据openid查stuid
     *
     * @param openId
     * @return Integer
     */
    Integer findStuIdByOpenId(String openId);

    /**
     * 导出广告日志信息
     *
     * @param advertLog 广告日志对象
     * @return List集合
     */
    List<AdvertLog> exportAdvLog(AdvertLog advertLog);


}
