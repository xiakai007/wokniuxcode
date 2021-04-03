package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.Level;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author Jiangjinlin
 * @date 2021-01-26 10:43:23
 */
public interface LevelMapper extends BaseMapper<Level> {

    List<Level> getLevelList();

    /**
     * @Description: 级联：根据院校id查询层次
     * @Param: collegeId 院校id
     * @return: 层次集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    List<Level> selectLevelForSelect(@Param("collegeId") Integer collegeId);
}