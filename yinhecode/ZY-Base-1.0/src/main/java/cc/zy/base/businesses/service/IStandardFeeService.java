package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.StandardFee;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *  Service接口
 *
 * @author Jiangjinlin
 * @date 2021-01-26 09:54:23
 */
public interface IStandardFeeService extends IService<StandardFee> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param standardFee standardFee
     * @return IPage<StandardFee>
     */
    IPage<StandardFee> findStandardFees(QueryRequest request, StandardFee standardFee);

    /**
     * 查询（所有）
     *
     * @param standardFee standardFee
     * @return List<StandardFee>
     */
    List<StandardFee> findStandardFees(StandardFee standardFee);

//      /**
//     * 查询（所有）
//     *
//
//     * @return List<StandardFee>
//     */
//    List<Map<String,Object>> fingStandardFeeAll();


    /**
     * 新增
     *
     * @param standardFee standardFee
     */
    void createStandardFee(StandardFee standardFee);

    /**
     * 修改
     *
     * @param standardFee standardFee
     */
    void updateStandardFee(StandardFee standardFee);

    /**
     * 删除
     *
     * @param standardFee standardFee
     */
    void deleteStandardFee(StandardFee standardFee);

        /**
     * 通过ID查找套内缴费详细信息
     *
     * @param id id
     * @return 套内缴费信息
     */
    StandardFee findById(Integer id);

          /**
     * 通过ID查找套内缴费详细信息
     *
     * @param id id
     * @return 套内缴费信息
     */
    int addStandardFee(StandardFee standardFee);

        /**
     * 删除套内缴费信息
     *
     * @param standaedFeeIds 院校 id数组
     */
    void deleteStandardFees(String[] standaedFeeIds);


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
 /**
     * 获取所有已存在套内缴费批次信息
     *
     * @param
     */
List<Map<String,String>> oldBatchAll();
 /**
     * 获取所有新创建套内缴费批次信息
     *
     * @param
     */
List<Map<String,String>> newBatchAll();
 /**
     *count
     *
     * @param
     */
int count(StandardFee standardFee);
/**  verify
     *
     *
     * @param
     */
int verify(Integer id);
/**
     *copy
     *
     * @param
     */
int copy(@Param("oldid")Integer oldid, @Param("newid")Integer newid);


int verifys(Integer batchId,Integer collegeId,Integer studyLevelId,Integer subjectCategoryId,Integer majorId,Integer cultivate);
}
