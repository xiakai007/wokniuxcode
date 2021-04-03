package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.Major;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 专业表 Mapper
 *
 * @author guozhikun
 * @date 2021-01-26 19:41:01
 */
public interface MajorMapper extends BaseMapper<Major> {

    /**
     * 院校专业详情信息
     *
     * @param page  分页对象
     * @param major 用户对象，用于传递查询条件
     * @param <T>
     * @return
     */
    <T> IPage<Major> findMajorDetailPage(Page<T> page, @Param("major") Major major);

    long countMajorDetail(@Param("major") Major major);

    /**
     * 全部专业列表
     *
     * @return
     */
    List<Major> findMajor();

    /**
     * 通过ID查找专业类别
     *
     * @param majorId
     * @return
     */
    Major findById(Integer majorId);


    /**
     * @Description: 级联：根据院校id、层次id查询专业
     * @Param: collegeId 院校id；levelId 层次id
     * @return: 专业集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    List<Major> selectMajorForSelect(@Param("collegeId") Integer collegeId, @Param("levelId") Integer levelId);

    /**
     * @Description: 查：根据批次id、院校id、层次id获取专业信息
     * @Param: batchId 批次id；collegeId 院校id；levelId 层次id
     * @return: 专业集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    List<Major> selectMajorByBatchForSelect(@Param("batchId") Integer batchId, @Param("collegeId") Integer collegeId, @Param("levelId") Integer levelId);
}