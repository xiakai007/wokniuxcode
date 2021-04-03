package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Mapper
 *
 * @author wangpin
 * @date 2021-01-28 16:13:11
 */
public interface TermScoreMapper extends BaseMapper<TermScore> {
    /**
     * 查询列表
     * @author wangpin
     * @param termScore
     * @return
     */
    IPage<TermScore> getTermScoreList(@Param("page") Page<TermScore> page, @Param("termScore")TermScore termScore);

    Long countTermScoreDetail(@Param("termScore")TermScore termScore);

    /**
     * 通过学校id获取层次名称
     * @param collegeId
     * @return
     */
    List<Level> getLevelListByCollegeId(@Param("collegeId") Integer collegeId);

    /**
     * 通过学校和层次获取对应专业
     * @param collegeId
     * @param levelId
     * @return
     */
    List<Major> getMajorListByIds(@Param("collegeId")Integer collegeId,@Param("levelId")Integer levelId);

    /**
     * 通过学校和层次及专业获取对应课程
     * @param collegeId
     * @param levelId
     * @param majorId
     * @return
     */
    List<TeachProgram> getCourseNameByIds(@Param("collegeId")Integer collegeId,@Param("levelId")Integer levelId,@Param("majorId")Integer majorId,@Param("termId")Integer termId);

    /**
     * 根据层次id获取对应学期
     * @param levelId
     * @return
     */
    List<CollegeTerm> getTermsByLevelId(@Param("levelId")Integer levelId);

    /**
     * 根据批次名获取对应ID
     * @author wangpin
     * @param batchName
     * @return
     */
    Integer getBatchIdByBatchName(@Param("batchName")String batchName);

    /**
     * 根据学习形式获取学习形式ID
     * @param studyType
     * @return
     */
    Integer getStudyTypeIdByStudyType(@Param("studyType")String studyType);

    /**
     * 获取学期ID
     * @param termName
     * @return
     */
    Integer getTermIdByTermName(@Param("termName")String termName);

    /**
     * 获取学年ID
     * @param yearName
     * @return
     */
    Integer getYearIdByYearName(@Param("yearName")String yearName);
    /**
     * 获取学校、批次、专业、层次ID
     * @param batchId
     * @param studyTypeId
     * @param identity
     * @return
     */
    TermScore getTermIdsByPrimery(@Param("batchId")Integer batchId,@Param("studyTypeId")Integer studyTypeId,@Param("identity")String identity);

    /**
     * 获取课程ID和科目类型ID
     * @param termScore
     * @return
     */
    TeachProgram getCourseIdAndSubTypeIdByCourseName(@Param("termScore")TermScore termScore);

    /**
     * 插入学期数据
     * @param termScoreList
     */
    void addtermScoreList(@Param("termScoreList")List<TermScore> termScoreList);

    /**
     * 检查学期成绩信息唯一性
     * @param termScore
     * @return
     */
    Integer checkTermScoreUnique(@Param("termScore")TermScore termScore);
}
