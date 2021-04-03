package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.ReqInfo;

import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 *  Service接口
 *
 * @author peihaodong
 * @date 2021/01/25
 */
public interface IReqInfoService extends IService<ReqInfo> {

    /**
     * 查询请求信息（分页；条件：开始时间、结束时间、触发类型、请求人。）
     *
     * @param request QueryRequest
     * @param startDate Date
     * @param endDate Date
     * @param triggerType Integer
     * @param reqUserId Integer
     * @return List<ReqInfo>
     */
    IPage<ReqInfo> selectReqInfosByCondition(QueryRequest request,Date startDate,Date endDate, Integer triggerType, Integer reqUserId,Integer status);

    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param reqInfo reqInfo
     * @return IPage<ReqInfo>
     */
    IPage<ReqInfo> findReqInfos(QueryRequest request, ReqInfo reqInfo);

    /**
     * 查询（所有）
     *
     * @param reqInfo reqInfo
     * @return List<ReqInfo>
     */
    List<ReqInfo> findReqInfos(ReqInfo reqInfo);

    /**
     * 新增
     *
     * @param reqInfo reqInfo
     */
    void createReqInfo(ReqInfo reqInfo);

    /**
     * 修改
     *
     * @param reqInfo reqInfo
     */
    void updateReqInfo(ReqInfo reqInfo);

    /**
     * 删除
     *
     * @param reqInfo reqInfo
     */
    void deleteReqInfo(ReqInfo reqInfo);
}
