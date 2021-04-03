package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Year;
import java.util.List;

/**
 *  Mapper
 *
 * @author peizijian
 * @date 2021/01/25
 */
public interface TeachProgramMapper extends BaseMapper<TeachProgram> {
    /**
     *  @author huangjia
     * @date 2021/02/01
     * 找到对应的层次id的名称
     * @param collegeId
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    public List<TeachProgram> findLevelName(Integer collegeId);
    /**
     *  @author huangjia
     * @date 2021/02/01
     * 找到对应的层次id和学校id第一的专业名称
     * @param collegeId
     * @return
     */
    public List<TeachProgram> getMajorName(@Param("collegeId") Integer collegeId,@Param("levelId") Integer levelId);
    /**
     * @param page 分页对象
     * @param teachProgram 计划对象，用于传递查询条件
     * @author peizijian
     * @date 2021/01/25
     * @return Ipage
     */
    <T> IPage<TeachProgram> findTeachProgramDetailPage(@Param("page") Page<T> page, @Param("teachProgram") TeachProgram teachProgram);

    long countTeachProgramDetail(@Param("teachProgram") TeachProgram teachProgram);

    /**
     * 查找计划详细信息
     * @author peizijian
     * @date 2021/01/25
     * @param teachProgram 计划对象，用于传递查询条件
     * @return List<TeachProgram>
     */
    List<TeachProgram> findTeachProgramDetail(@Param("teachProgram") TeachProgram teachProgram);

    /**
     * 单批次停用
     * @author peizijian
     * @date 2021/01/25
     * @date 2021/01/25
     */
    void updateStatus(@Param("id") Integer id);

    /**
     * 通过ID查找批次
     * @author peizijian
     * @date 2021/01/25
     * @param  id
     * @return 批次
     */
    TeachProgram findById(@Param("id") Integer id);

    /**
     * 修改批次
     * @param teachProgram
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    int updateTeachPrograms(@Param("teachProgram")TeachProgram teachProgram);

    /**
     * 拼接info信息
     * @author peizijian
     * @date 2021/01/25
     * @param id
     */
    void updateInfo(@Param("id")Integer id,@Param("info") String info);

    /**
     * 批量新增教学计划
     * @param teachProgram
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    int addNewTeachProgram(@Param("teachProgram")TeachProgram teachProgram);

    /**
     *展示批次
     * @author peizijian
     * @date 2021/01/25
     */
    Batch selectBatch(@Param("batchName")String batchName);

    /**
     * 根据batchId查教学计划
     * @param batchId
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    List<TeachProgram> selectBatchByBatchId(@Param("batchId")Integer batchId);

    /**
     * 根据batchName查教学计划
     * @param batchName
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    List<TeachProgram> selectBatchByBatchName(@Param("batchName")String batchName);


    /**
     * 修改教学计划中的批次
     * @author peizijian
     * @date 2021/01/25
     * @param batchId
     */
    void updateBatchId(@Param("batchId") Integer batchId);

    /**
     * 层次下拉框
     * @param level
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    Level selectLevel(@Param("level")Level level);

    /**
     * 展示新批次
     * @param batchName
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    List<Batch> selectMoreBatch(@Param("batchName") String batchName);

    /**
     * 展示批次下拉框
     * @param batch
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    List<Batch> selectAllBatch(@Param("batch") Batch batch);

	/**
     * 学院联动专业
     * @param collegeName
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    List<TeachProgram> findCollegeByMajor(String collegeName);


    /**
     * 专业
     * @param major
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    List<Major> getMajorList(@Param("major")Major major);
    /**
     * 学年
     * @param collegeYear
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    List<CollegeYear> getYear(@Param("year")CollegeYear collegeYear);

    /**
     * 获取对应学期
     * @param collegeTerm
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    List<CollegeTerm> getTerms(@Param("CollegeTerm")CollegeTerm collegeTerm);

    /**
     * 获取对应类别
     * @param subjectCategory
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    List<SubjectCategory> getSubjectCategory(@Param("subjectCategory")SubjectCategory subjectCategory);

    /**
     * 根据学年id获取对应学期
     * @param absoYearId
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    List<CollegeTerm> getTermsByYearId(@Param("absoYearId")Integer absoYearId);

    /**
     * 确认是否有重复数据
     * @param teachProgram
     * @author peizijian
     * @date 2021/02/05
     * @return
     */
    List<TeachProgram> selectRepeat(@Param("teachProgram")TeachProgram teachProgram);


}
