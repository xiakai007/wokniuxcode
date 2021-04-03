package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.TransferApplication;
import cc.zy.base.businesses.entity.TransferApplicationVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Mapper
 *
 * @author liuheng
 * @date 2021/01/18
 */
public interface TransferApplicationMapper extends BaseMapper<TransferApplication> {

    /**
     * 查找用户详细信息
     *
     * @param page                分页对象
     * @param transferApplication 用户对象，用于传递查询条件
     * @return Ipage
     */
    <T> IPage<TransferApplicationVo> findTransferApplicationPage(Page<T> page, @Param("transferApplication") TransferApplication transferApplication);

    /**
     * 根据id查询异动信息详情
     *
     * @param id
     * @return
     */
    TransferApplicationVo findTransferDetailById(@Param("id") Integer id);

    /**
     * 统计对应条件下的异动信息条目数
     *
     * @param transferApplication
     * @return 条目数
     */
    long countTransferApplication(@Param("transferApplication") TransferApplication transferApplication);

    /**
     * 根据异动信息id查询复学后批次名称
     *
     * @param id
     * @return 批次名称
     */
    String findBackCollegeByTransferApplicationId(@Param("id") Integer id);

    /**
     * 根据异动信息id查询休学年限
     *
     * @param id
     * @return 休学年限
     */
    Integer findSuspensionCollegeByTransferApplicationId(@Param("id") Integer id);

    /**
     * 根据异动信息id查询更换至的学习形式名称
     *
     * @param id
     * @return 新的学习形式名称
     */
    String findStudyTypeChangeByTransferApplicationId(@Param("id") Integer id);

    /**
     * 根据异动信息id查询更换至的专业名称
     *
     * @param id
     * @return 新的专业名称
     */
    String findMajorChangeByTransferApplicationId(@Param("id") Integer id);

    /**
     * 根据异动信息id查询对应的申请材料附件
     *
     * @param id
     * @return 附件地址（url）的集合
     */
    List<String> findTransferAttachment(@Param("id") Integer id);

    /**
     * 添加异动申请记录
     *
     * @param transferApplicationVo
     */
    int addTransferApplication(@Param("transferApplicationVo") TransferApplicationVo transferApplicationVo);

    /**
     * 根据异动申请记录id添加申请材料附件url
     *
     * @param applicationId
     * @param url
     */
    void addTransferApplicationAttachment(@Param("applicationId") Integer applicationId, @Param("url") String url);

    /**
     * 根据异动申请记录id添加休学对应信息
     *
     * @param applicationId
     * @param yearLimit
     */
    void addSuspensionCollege(@Param("applicationId") Integer applicationId, @Param("yearLimit") Integer yearLimit);

    /**
     * 根据异动申请记录id添加复学对应信息
     *
     * @param applicationId
     * @param newBatchId
     */
    void addBackCollege(@Param("applicationId") Integer applicationId, @Param("newBatchId") Integer newBatchId);

    /**
     * 根据异动申请记录id添加转专业对应信息
     *
     * @param applicationId
     * @param newMajorId
     */
    void addMajorChange(@Param("applicationId") Integer applicationId, @Param("newMajorId") Integer newMajorId);

    /**
     * 根据异动申请记录id添加更换学习形式对应信息
     *
     * @param applicationId
     * @param newStudyTypeId
     */
    void addStudyTypeChange(@Param("applicationId") Integer applicationId, @Param("newStudyTypeId") Integer newStudyTypeId);

}
