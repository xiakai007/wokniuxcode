package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.SubjectCategory;


import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 学科类别表 Service接口
 *
 * @author guozhikun
 * @date 2021-01-26 16:18:45
 */
public interface ISubjectCategoryService extends IService<SubjectCategory> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param subjectCategory subjectCategory
     * @return IPage<SubjectCategory>
     */
    IPage<SubjectCategory> findSubjectCategorys(QueryRequest request, SubjectCategory subjectCategory);

    /**
     * 查询（所有）
     *
     * @param subjectCategory subjectCategory
     * @return List<SubjectCategory>
     */
    List<SubjectCategory> findSubjectCategorys(SubjectCategory subjectCategory);

    /**
     * 新增
     *
     * @param subjectCategory subjectCategory
     */
    String createSubjectCategory(SubjectCategory subjectCategory,Integer levelId);

    /**
     * 修改
     *
     * @param subjectCategory subjectCategory
     */
    void updateSubjectCategory(SubjectCategory subjectCategory);

    /**
     * 删除
     *
     * @param subjectCategory subjectCategory
     */
    void deleteSubjectCategory(SubjectCategory subjectCategory);

    /**
     * 通过层次id获取类别信息
     * @param levelId
     * @return
     */
    List<SubjectCategory> getSubjectCategorys(Integer levelId);

    /**
     * id查找类别
     * @param id
     * @return
     */
    SubjectCategory findById(Integer id);

    /**
     * 全部学科类别数据
     * @return
     */
    List<SubjectCategory> findSubjectCategory();
}
