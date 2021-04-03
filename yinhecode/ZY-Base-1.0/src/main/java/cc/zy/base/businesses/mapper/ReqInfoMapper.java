package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.ReqInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *  Mapper
 *
 * @author peihaodong
 * @date 2021/01/25
 */
public interface ReqInfoMapper extends BaseMapper<ReqInfo> {
    //根据条件分页查询请求信息列表
    <T>IPage<ReqInfo> selectReqInfosByCondition(Page page,
                                                @Param("startDate") Date startDate,
                                                @Param("endDate") Date endDate,
                                                @Param("triggerType") Integer triggerType,
                                                @Param("reqUserId") Integer reqUserId,
                                                @Param("status") Integer status);
    //根据条件查询请求信息列表条目数
    Long countReqInfosByCondition(@Param("startDate") Date startDate,
                                  @Param("endDate") Date endDate,
                                  @Param("triggerType") Integer triggerType,
                                  @Param("reqUserId") Integer reqUserId,
                                  @Param("status") Integer status);

}
