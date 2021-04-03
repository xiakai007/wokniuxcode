package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.CustomStandardFee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *  Mapper
 *
 * @author zzz
 * @date 2021-01-29 13:11:58
 */
public interface CustomStandardFeeMapper extends BaseMapper<CustomStandardFee> {
    <T> IPage<CustomStandardFee> findCustomStandardFeeDetailPage(Page<T> page, @Param("customStandardFee") CustomStandardFee customStandardFee);


        long countCustomStandardFeeDetail(@Param("customStandardFee") CustomStandardFee customStandardFee);


            /**
     * 查找自定义套内缴费详细信息
     *
     * @param customStandardFee
     * @return List<CustomStandardFee>
     */
    List<CustomStandardFee> findCustomStandardFeeDetail(@Param("customStandardFee") CustomStandardFee customStandardFee);


        /**
     * 通过ID查找用户
     *
     * @param customStandardFeeId customStandardFeeId
     * @return 院校
     */
    CustomStandardFee findById(Integer customStandardFeeId);

           /**
     * 添加自定义套内缴费
     *
     * @param customStandardFee customStandardFee
     * @return 自定义套内缴费
     */
    int addCustomStandardFee(CustomStandardFee customStandardFee);


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
List<Map<String,String>> levelAll(@Param("batchId") Integer batchId,@Param("collegeId")Integer collegeId);
/**
     * 获取所有类别信息
     *
     * @param
     */
List<Map<String,String>> subjectCategoryAll(@Param("batchId") Integer batchId,
                                       @Param("collegeId")Integer collegeId,
                                       @Param("levelId")Integer levelId);
/**
     * 获取所有专业信息
     *
     * @param
     */
List<Map<String,String>> majorAll(@Param("batchId") Integer batchId,
                                       @Param("collegeId")Integer collegeId,
                                       @Param("levelId")Integer levelId,
                                        @Param("subjectCategoryId")Integer subjectCategoryId);
/**
     * 获取所有学习形式信息
     *
     * @param
     */
List<Map<String,String>> cultivateAll();



}
