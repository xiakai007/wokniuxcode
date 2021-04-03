package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.StandardFee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *  Mapper
 *
 * @author Jiangjinlin
 * @date 2021-01-26 09:54:23
 */
public interface StandardFeeMapper extends BaseMapper<StandardFee> {

//    public List<Map<String,Object>> fingStandardFeeAll();

//
      <T> IPage<StandardFee> findStandardFeeDetailPage(Page<T> page, @Param("standardFee") StandardFee standardFee);


        long countStandardFeeDetail(@Param("standardFee") StandardFee standardFee);


            /**
     * 查找套内缴费详细信息
     *
     * @param standardFee 院校对象，用于传递查询条件
     * @return List<StandardFee>
     */
    List<StandardFee> findStandardFeeDetail(@Param("standardFee") StandardFee standardFee);


        /**
     * 通过ID查找用户
     *
     * @param id id
     * @return 院校
     */
    StandardFee findById(Integer standardFeeId);

           /**
     * 添加套内缴费
     *
     * @param standardFee standardFee
     * @return 套内缴费
     */
    int addStandardFee(StandardFee standardFee);


     /**
     * 获取所有批次信息
     *
     * @param
     */
     List<Map<String,String>> batchAll(Integer id);
     /**
     * 获取所有院校信息
     *
     * @param
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
     * 获取所有专业信息
     *
     * @param
     */
    List<Map<String,String>> cultivateAll();
 /**
     * 获取所有学习形式信息
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
       int verify(Integer id);
       /**  verify
     *
     *
     * @param
     */
       int delstandardByBatchId(Integer id);
       /**
     *copy
     *
     * @param
     */
       int copy(@Param("oldid")Integer oldid,@Param("newid")Integer newid);


       int verifys(@Param("batchId") Integer batchId,@Param("collegeId")Integer collegeId,@Param("studyLevelId")Integer studyLevelId,@Param("subjectCategoryId")Integer subjectCategoryId,@Param("majorId")Integer majorId,@Param("cultivate") Integer cultivate );
}
