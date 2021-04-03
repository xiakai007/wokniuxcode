package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.College;
import cc.zy.base.common.paymentUtils.entity.RefundDetail;
import cc.zy.base.common.paymentUtils.entity.RefundStatu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 *  财务模块Mapper
 * @author 李文龙
 * @date 2021-02-03 05:48:13
 */
public interface IPaymentMapper {
    /**
     * @Description 将根据退款单号查询联拓富退款状态查询接口返回的json转换的实体类插入数据库
     * @param refundStatu 退款状态json转换的实体类
     * @return Integer 插入返回的影响行数
     */
    Integer insertRefundStatu(RefundStatu refundStatu);


    /**
     * @Description 申请联拓富退费接口返回的json转换的实体类插入数据库
     * @param refundDetail 申请退款返回的json转换的实体类
     * @return Integer 插入返回的影响行数
     */
    Integer insertReturnRefundDetail(RefundDetail refundDetail);


    /**
     * @Description 根据t_absentee_refund在籍退费表主键，在完成退费后，添加退费订单号
     * @param Id _absentee_refund在籍退费表主键
     * @param refundNo 调用联拓富退费接口前生成的退费订单号
     * @param refundTime 联拓富完成退费的具体时间
     * @param finanaceId 财务人ID，来自员工表
     * @param finanaceAgreeTime 财务审批退费同意的具体时间
     * @return Integer 根据id更新退款订单号返回的影响行数
     */
    Integer updateRefundNoById(@Param("id") Integer Id,
                               @Param("refundNo") String refundNo,
                               @Param("refundTime") Timestamp refundTime,
                               @Param("financeId") Long finanaceId,
                               @Param("finanaceAgreeTime") Timestamp finanaceAgreeTime,
                               @Param("agreeStatu") Integer agreeStatu,
                               @Param("refundOkStatu") Integer refundOkStatu);


    /**
     * @Description 根据t_absentee_refund表主键id查询出COST_ID,然后在t_absentee_cost表查询对应的订单号OUT_TRADE_NO和实缴金额COST_MONEY
     * @param   id 在籍退费表t_absentee_refund主键
     * @return map 键值对形式返回在籍缴费表t_absentee_cost的订单号OUT_TRADE_NO和实缴金额COST_MONEY
     */
    Map<String,Object> searchOutTradeNoAndCostMoney(@Param("id") Integer id);


    /**
     * @Description 查询字典表同意退费申请状态列
     * @param
     * @return Integer SID
     */
    Integer searchAgreeStatu();


    /**
     * @Description 查询字典表已退费状态列
     * @param
     * @return Integer SID
     */
    Integer searchRefundOkStatu();

    /**
     * @Description 查询字典表未退费状态列
     * @param
     * @return Integer SID
     */
    Integer searchRefundNotStatu();

    /**
     * @Description 查询所有等待财务审批的退费申请列表
     * @param
     * @return Map 退费申请表id，学生姓名，退费金额，申请时间
     */
    List<Map<String,Object>> selectRefundListForFinance(@Param("teacherAgreeStatu") Integer teacherAgreeStatu,
                                                  @Param("refundNotStatu") Integer refundNotStatu);


}
