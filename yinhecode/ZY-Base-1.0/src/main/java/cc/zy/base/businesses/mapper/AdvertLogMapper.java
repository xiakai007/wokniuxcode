package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.AdvertLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 广告日志表 Mapper
 *
 * @author zhaojw
 * @date 2021-01-28
 */
public interface AdvertLogMapper extends BaseMapper<AdvertLog> {

    /**
     * 查询广告日志信息，带分页
     * @param page 分页
     * @param advertLog 广告日志实体类对象
     * @param <T> 泛型
     * @return 带分页的集合
     */
    <T> IPage<AdvertLog> findAdvertLogNew(@Param("page") Page<T> page, @Param("advertLog") AdvertLog advertLog);

    /**
     * 查询广告日志数量
     * @param advertLog 广告日志实体类对象
     * @return
     */
    Long countAdvertLog(AdvertLog advertLog);

    /**
     * 新建广告日志
     * @param userId 点击广告的用户id
     * @param advertId 点击的广告id
     */
    void insertAdvertLogData(@Param("userId") Integer userId, @Param("advertId") Integer advertId);

    /**
     * 根据openid查stuid
     * @Param openId 点击广告用户的openId
     */
    Integer findStuIdByOpenId(@Param("openId") String openId);

    /**
     * 记录用户退出广告的事件
     * @param userId 退出广告的userId
     * @param advertId 退出的广告id
     */
    void updateExitTime(@Param("userId") Integer userId, @Param("advertId") Integer advertId);

    /**
     * 导出广告日志信息
     */
    List<AdvertLog> exportAdvLog(@Param("advertLog") AdvertLog advertLog);

}
