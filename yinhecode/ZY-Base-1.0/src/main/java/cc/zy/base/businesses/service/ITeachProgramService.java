package cc.zy.base.businesses.service;


import cc.zy.base.businesses.entity.*;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author peizijian
 * @date 2021/01/25
 */
public interface ITeachProgramService extends IService<TeachProgram> {

    public  List<TeachProgram> findLevelNameByCollegeId(Integer collegeId);

    public List<TeachProgram> findMajoNameByLevelId(Integer collegeId,Integer levelId);
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param teachProgram teachProgram
     * @author peizijian
     * @date 2021/01/25
     * @return IPage<TeachProgram>
     */
    IPage<TeachProgram> findTeachProgramss(QueryRequest request, TeachProgram teachProgram);

    /**
     * 导出教学计划
     * @author peizijian
     * @date 2021/01/25
     * @param teachProgram
     * @return
     */
    List<TeachProgram> export(TeachProgram teachProgram);

    /**
     * 查询（所有）
     * @author peizijian
     * @date 2021/01/25
     * @param teachProgram tTeachProgram
     * @return List<TeachProgram>
     */
    List<TeachProgram> findTeachPrograms(TeachProgram teachProgram);

    /**
     * 修改批次
     * @author peizijian
     * @date 2021/01/25
     * @param teachProgram
     */
    void updateTeachPrograms(TeachProgram teachProgram);


    /**
     * 新增
     * @author peizijian
     * @date 2021/01/25
     * @param teachProgram teachProgram
     */
    void createTeachProgram(TeachProgram teachProgram);

    /**
     * 修改
     *
     * @param teachProgram teachProgram
     */
    void updateTeachProgram(TeachProgram teachProgram);

    /**
     * 删除
     *
     * @param teachProgram teachProgram
     */
    void deleteTeachProgram(TeachProgram teachProgram);

    /**
     * 单批次停用
     * @author peizijian
     * @date 2021/01/25
     * @param id
     */
    void updateStatus(Integer id);

    /**
     * 通过ID查找批次详细信息
     * @author peizijian
     * @date 2021/01/25
     * @param id id
     * @return 院校信息
     */
    TeachProgram findTeachById(Integer id);

    /**
     * 批量增加模板教学计划
     * @author peizijian
     * @date 2021/01/25
     * @param teachProgram
     */
    void addNewTeachProgram(TeachProgram teachProgram);


    /**
     * 查询批次
     * @author peizijian
     * @date 2021/01/25
     */
    Batch selectBatch(String batchName);

    /**
     * 根据batchId查询TeachProgram
     * @param batchId
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    List<TeachProgram> selectTeachByBatchId(Integer batchId);

    /**
     * 展示批次下拉框
     * @author peizijian
     * @date 2021/01/25
     * @param batch
     * @return
     */
    List<Batch> selectAllBatch(Batch batch);

    /**
     *新建批次下拉
     * @author peizijian
     * @date 2021/01/25
     * @param batchName
     * @return
     */
    List<Batch> selectMoreBatch( String batchName);
    /**
     * 根据batchName查教学计划
     * @param batchName
     * @return
     * @author peizijian
     * @date 2021/01/25
     */
    List<TeachProgram> selectBatchByBatchName(String batchName);

	/**
     * 学院联动专业
     * @param collegeName
     * @return
     * @author peizijian
     * @date 2021/01/25
     */
    List<TeachProgram> findCollegeByMajor(String collegeName);


    /**
     * 专业
     * @param major
     * @return
     */
    List<Major> getMajorList(Major major);
    /**
     * 学年
     * @param collegeYear
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    List<CollegeYear> getYear(CollegeYear collegeYear);

    /**
     * 获取对应学期
     * @param collegeTerm
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    List<CollegeTerm> getTerms(CollegeTerm collegeTerm);

    /**
     * 获取对应类型
     * @param subjectCategory
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    List<SubjectCategory> getSubjectCategory(SubjectCategory subjectCategory);

    /**
     * 学期联动
     * @param absoYearId
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    List<CollegeTerm> getTermsByYearId(Integer absoYearId);

    /**
     * 拼接info信息
     * @param info
     * @author peizijian
     * @date 2021/02/04
     */
    void updateInfo(Integer id,String info);

    /**
     * 确认是否有重复数据
     * @param teachProgram
     * @author peizijian
     * @date 2021/02/05
     * @return
     */
    List<TeachProgram> selectRepeat(TeachProgram teachProgram);

}
