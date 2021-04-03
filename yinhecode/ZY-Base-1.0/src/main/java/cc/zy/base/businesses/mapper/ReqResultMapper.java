package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.ReqResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 *  Mapper
 *
 * @author Jiangjinlin
 * @date 2021-01-25 10:16:25
 */
public interface ReqResultMapper extends BaseMapper<ReqResult> {
    /**
     * 批量增加解析的数据
     *
     * @param reqResultList 用于传递查询条件
     * @return int
     *
     */

    public int addReqResultList(@Param("reqResultList") List<ReqResult> reqResultList);


    /**
     * 增加解析的数据并返回ID
     *
     * @param reqResult 用于传递查询条件
     * @return int
     *
     */

    public int addReqResultGetId(ReqResult reqResult);
}
