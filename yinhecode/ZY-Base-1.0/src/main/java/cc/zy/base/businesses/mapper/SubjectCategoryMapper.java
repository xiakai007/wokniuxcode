package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.SubjectCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学科类别表 Mapper
 *
 * @author guozhikun
 * @date 2021-01-26 16:18:45
 */
public interface SubjectCategoryMapper extends BaseMapper<SubjectCategory> {
    List<SubjectCategory> getSubjectCategorys(Integer levelId);

	 /**
     *
     * 学科类别详情信息
     * @param page 分页对象
     * @param subjectCategory 用户对象，用于传递查询条件
     * @param <T>
     * @return
     */
    <T> IPage<SubjectCategory> findSubjectCategoryDetailPage(Page<T> page, @Param("subjectCategory") SubjectCategory subjectCategory);

    /**
     * 全部专业类别
     * @return
     */
    List<SubjectCategory> findSubjectCategory();
    /**
     * 总记录数
     * @param subjectCategory
     * @return
     */
    long countSubjectCategoryDetail(@Param("subjectCategory") SubjectCategory subjectCategory);

    /**
     * 通过ID查找专业类别
     *
     * @param
     * @return
     */
    SubjectCategory findById(Integer subjectCategoryId);

    /**
     * 添加层次和类别关系信息
     * @param levelId
     * @param subtypeId
     */
    void insertLevelAndSubtype(@Param("levelId") Integer levelId,@Param("subtypeId") Integer subtypeId);

    /**
     * 获取subtypeId
     * @param fullName
     * @return
     */
    Integer getSubTypeIdByName(@Param("fullName")String fullName);
}
