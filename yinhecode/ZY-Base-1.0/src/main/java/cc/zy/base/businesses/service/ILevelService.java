package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.Level;


import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 层次表 Service接口
 *
 * @author LiPeng
 * @date 2021-01-27 18:42:21
 */
public interface ILevelService extends IService<Level> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param level level
     * @return IPage<Level>
     */
    IPage<Level> findLevels(QueryRequest request, Level level);

    /**
     * 查询（所有）
     *
     * @param level level
     * @return List<Level>
     */
    List<Level> findLevels();

    /**
     * 查询（所有）
     *
     * @param level level
     * @return List<Level>
     */
    List<Level> findLevels(Level level);

    /**
     * 新增
     *
     * @param level level
     */
    void createLevel(Level level);

    /**
     * 修改
     *
     * @param level level
     */
    void updateLevel(Level level);

    /**
     * 删除
     *
     * @param level level
     */
    void deleteLevel(Level level);
}
