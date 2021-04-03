package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.Watch;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 *  Mapper
 *
 * @author Jiangjinlin
 * @date 2021-01-25 15:11:02
 */
public interface WatchMapper extends BaseMapper<Watch> {
    int updateByVideoIdAndStuid(Watch watch);
}
