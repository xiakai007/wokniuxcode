package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.CustomStandardFee;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 *  Service接口
 *
 * @author guankai
 * @date 2021-02_01 18:23
 */
public interface ICustomStandardFeeService extends IService<CustomStandardFee> {
   /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param customStandardFee customStandardFee
     * @return IPage<StandardFee>
     */
    IPage<CustomStandardFee> findCustomStandardFees(QueryRequest request, CustomStandardFee customStandardFee);

    /**
     * 查询（所有）
     *
     * @param customStandardFee customStandardFee
     * @return List<StandardFee>
     */
    List<CustomStandardFee> findCustomStandardFees(CustomStandardFee customStandardFee);

//      /**
//     * 查询（所有）
//     *
//
//     * @return List<CustomStandardFee>
//     */
//    List<Map<String,Object>> fingCustomStandardFeeAll();


    /**
     * 新增
     *
     * @param customStandardFee customStandardFee
     */
    void createCustomStandardFee(CustomStandardFee customStandardFee);

    /**
     * 修改
     *
     * @param customStandardFee customStandardFee
     */
    void updateCustomStandardFee(CustomStandardFee customStandardFee);

    /**
     * 删除
     *
     * @param customStandardFee customStandardFee
     */
    void deleteCustomStandardFee(CustomStandardFee customStandardFee);

        /**
     * 通过ID查找自定义套内缴费详细信息
     *
     * @param id id
     * @return 自定义套内缴费信息
     */
    CustomStandardFee findById(Integer id);

          /**
     * 通过ID查找套内缴费详细信息
     *
     * @param customStandardFee customStandardFee
     * @return 自定义套内缴费信息
     */
    int addCustomStandardFee(CustomStandardFee customStandardFee);

        /**
     * 删除自定义套内缴费信息
     *
     * @param customStandaedFeeIds 院校 id数组
     */
    void deleteCustomStandardFees(String[] customStandaedFeeIds);


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
