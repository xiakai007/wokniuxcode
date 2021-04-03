package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.OtherPayment;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 *  Service接口
 *
 * @author zzz
 * @date 2021-01-30 15:58:27
 */
public interface IOtherPaymentService extends IService<OtherPayment> {
   /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param OtherPayment OtherPayment
     * @return IPage<OtherPayment>
     */
    IPage<OtherPayment> findOtherPayments(QueryRequest request, OtherPayment OtherPayment);

    /**
     * 查询（所有）
     *
     * @param OtherPayment OtherPayment
     * @return List<OtherPayment>
     */
    List<OtherPayment> findOtherPayments(OtherPayment OtherPayment);

//      /**
//     * 查询（所有）
//     *
//
//     * @return List<OtherPayment>
//     */
//    List<Map<String,Object>> fingCustomStandardFeeAll();


    /**
     * 新增
     *
     * @param OtherPayment OtherPayment
     */
    void createOtherPayment(OtherPayment OtherPayment);

    /**
     * 修改
     *
     * @param OtherPayment OtherPayment
     */
    void updateOtherPayment(OtherPayment OtherPayment);

    /**
     * 删除
     *
     * @param OtherPayment OtherPayment
     */
    void deleteOtherPayment(OtherPayment OtherPayment);

        /**
     * 通过ID查找自定义套内缴费详细信息
     *
     * @param id id
     * @return 自定义套内缴费信息
     */
    OtherPayment findById(Integer id);

          /**
     * 通过ID查找套内缴费详细信息
     *
     * @param OtherPayment OtherPayment
     * @return 自定义套内缴费信息
     */
    int addOtherPayment(OtherPayment OtherPayment);

        /**
     * 删除自定义套内缴费信息
     *
     * @param customStandaedFeeIds 院校 id数组
     */
    void deleteOtherPayments(String[] customStandaedFeeIds);


     /**
     * 获取所有批次信息
     *
     * @param id 批次id
     */
List<Map<String,String>> batchAll(Integer id);
  /**
     * 获取所有院校信息
     *
     * @param batchId 院校 id
     */
List<Map<String,String>> collegeAll(Integer batchId);
  /**
     * 获取所有层次信息
     *
     * @param
     */
List<Map<String,String>> levelAll(Integer batchId,Integer collegeId);
  /**
     * 获取所有类别信息
     *
     * @param
     */
List<Map<String,String>> subjectCategoryAll( Integer batchId,
                                  Integer collegeId,
                                  Integer levelId);
  /**
     * 获取所有专业信息
     *
     * @param
     */
List<Map<String,String>> majorAll(Integer batchId,
                                   Integer collegeId,
                                  Integer levelId,
                                   Integer subjectCategoryId);
  /**
     * 获取所有学习形式信息
     *
     * @param
     */
List<Map<String,String>> cultivateAll();
}
