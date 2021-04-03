package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.DistinctReqResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Mapper
 *
 * @author peihaodong
 * @date 2021-01-25 20:16:04
 */
public interface DistinctReqResultMapper extends BaseMapper<DistinctReqResult> {

    /*
     *  批量增加解析的数据//
     *  @param distinctReqResultlist  用于传递查询条件
     *  @return int//
     */
    public int addDistinctReqResultlist(@Param("distinctReqResultlist") List<DistinctReqResult> distinctReqResultlist);


    /*
     *  查找重复的
     *  * @param distinctReqResultList 院校对象，用于传递查询条件
     *  * @return DistinctReqResult
     */
    public DistinctReqResult findDistinctReqResultBySome(DistinctReqResult distinctReqResult);
//    @Param("distinctReqResult")@Param("distinctReqResult")
}
