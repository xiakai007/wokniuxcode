package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.mapper.TeachProgramMapper;
import cc.zy.base.businesses.service.ITeachProgramService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.SortUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 *  Service实现
 *
 * @author peizijian
 * @date 2021-01-25
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TeachProgramServiceImpl extends ServiceImpl<TeachProgramMapper, TeachProgram> implements ITeachProgramService {
    @Resource
    private final TeachProgramMapper teachProgramMapper;

    /**
     * 教学计划展示
     * @param request QueryRequest
     * @param teachProgram teachProgram
     * @author peizijian
     * @date 2021-01-25
     * @return
     */
    @Override
    public IPage<TeachProgram> findTeachProgramss(QueryRequest request, TeachProgram teachProgram) {
        Page<TeachProgram> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countTeachProgramDetail(teachProgram));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findTeachProgramDetailPage(page,teachProgram);
    }

    @Override
    public List<TeachProgram> export(TeachProgram teachProgram) {
        return teachProgramMapper.findTeachProgramDetail(teachProgram);
    }

    @Override
    public List<TeachProgram> findTeachPrograms(TeachProgram teachProgram) {
	    LambdaQueryWrapper<TeachProgram> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    /**
     * 修改批次
     * @param teachProgram
     * @author peizijian
     * @date 2021-01-25
     */
    @Override
    public void updateTeachPrograms(TeachProgram teachProgram) {
        int i = teachProgramMapper.updateTeachPrograms(teachProgram);
        String info;
        if (i > 0) {
            info = teachProgram.getBatchName()+ ">" +teachProgram.getLevel() + ">" +teachProgram.getTypeName() + ">"
                    + teachProgram.getStudyMode() + ">" + teachProgram.getCollegeName() + ">" + teachProgram.getMajorName() + ">"
                    +teachProgram.getSchool() + ">" +teachProgram.getYear() + ">" +teachProgram.getSemester() + ">" +
                    teachProgram.getCourseName();
            teachProgramMapper.updateInfo(teachProgram.getId(),info);
        }

    }




    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createTeachProgram(TeachProgram teachProgram) {
        this.save(teachProgram);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTeachProgram(TeachProgram teachProgram) {
        this.saveOrUpdate(teachProgram);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTeachProgram(TeachProgram teachProgram) {
        LambdaQueryWrapper<TeachProgram> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    /**
     * 单批次停用
     * @param id
     * @author peizijian
     * @date 2021-01-25
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStatus(Integer id) {
         teachProgramMapper.updateStatus(id);
    }

    /**
     * 根据id查询教学计划
     * @param id
     * @return
     * @author peizijian
     * @date 2021-01-25
     */
    @Override
    public TeachProgram findTeachById(Integer id) {
        return this.baseMapper.findById(id);
    }

    /**
     * 新增教学计划
     * @param teachProgram
     * @author peizijian
     * @date 2021-01-25
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addNewTeachProgram(TeachProgram teachProgram) {
     teachProgramMapper.addNewTeachProgram(teachProgram);
    }

    /**
     * 批次展示
     * @param batchName
     * @return
     * @author peizijian
     * @date 2021-01-25
     */
    @Override
    public Batch selectBatch(String batchName) {

        return teachProgramMapper.selectBatch(batchName);
    }

    /**
     *根据批次id查找批次
     * @param batchId
     * @return
     * @author peizijian
     * @date 2021-01-25
     */
    @Override
    public List<TeachProgram> selectTeachByBatchId(Integer batchId) {
        return teachProgramMapper.selectBatchByBatchId(batchId);
    }

    /**
     * 展示批次下拉框
     * @param batch
     * @return
     * @author peizijian
     * @date 2021-01-25
     */
    @Override
    public List<Batch> selectAllBatch(Batch batch) {
        return teachProgramMapper.selectAllBatch(batch);
    }

    /**
     * 展示新建批次
     * @param batchName
     * @author peizijian
     * @date 2021-01-25
     * @return
     */
    @Override
    public List<Batch> selectMoreBatch(String batchName) {
        return teachProgramMapper.selectMoreBatch(batchName);
    }

    /**
     * 根据批次名称查找批次
     * @param batchName
     * @return
     * @author peizijian
     * @date 2021-01-25
     */
    @Override
    public List<TeachProgram> selectBatchByBatchName(String batchName) {
        return teachProgramMapper.selectBatchByBatchName(batchName);
    }

    /**
     * 院校层次联动
     * @param collegeId
     * @return
     * @author peizijian
     * @date 2021-01-25
     */
    @Override
    public List<TeachProgram> findLevelNameByCollegeId(Integer collegeId) {
        List<TeachProgram> levelName = teachProgramMapper.findLevelName(collegeId);
        return levelName ;
    }

    /**
     * 专业层次联动
     * @param collegeId
     * @param levelId
     * @author peizijian
     * @date 2021-01-25
     * @return
     */
    @Override
    public List<TeachProgram> findMajoNameByLevelId(Integer collegeId,Integer levelId) {
        return teachProgramMapper.getMajorName(collegeId,levelId);
    }

	/**
     * 学院联动专业
     * @param collegeName
     * @author peizijian
     * @date 2021-01-25
     * @return
     */
    @Override
    public List<TeachProgram> findCollegeByMajor(String collegeName) {
        List<TeachProgram> collegeByMajor = baseMapper.findCollegeByMajor(collegeName);
        return collegeByMajor;
    }

    /**
     * 展示专业下拉框
     * @param major
     * @return
     * @author peizijian
     * @date 2021-01-25
     */
    @Override
    public List<Major> getMajorList(Major major) {
        return teachProgramMapper.getMajorList(major);
    }

    /**
     * 展示学年下拉框
     * @param collegeYear
     * @author peizijian
     * @date 2021-01-25
     * @return
     */
    @Override
    public List<CollegeYear> getYear(CollegeYear collegeYear) {
        return teachProgramMapper.getYear(collegeYear);
    }

    /**
     * 展示学期下拉框
     * @param collegeTerm
     * @return
     * @author peizijian
     * @date 2021-01-25
     */
    @Override
    public List<CollegeTerm> getTerms(CollegeTerm collegeTerm) {
        return teachProgramMapper.getTerms(collegeTerm);
    }

    /**
     * 展示类别下拉框
     * @param subjectCategory
     * @author peizijian
     * @date 2021-01-25
     * @return
     */
    @Override
    public List<SubjectCategory> getSubjectCategory(SubjectCategory subjectCategory) {
        return teachProgramMapper.getSubjectCategory(subjectCategory);
    }

    /**
     * 学年联动学期
     * @param absoYearId
     * @return
     * @author peizijian
     * @date 2021-01-25
     */
    @Override
    public List<CollegeTerm> getTermsByYearId(Integer absoYearId) {
        return teachProgramMapper.getTermsByYearId(absoYearId);
    }

    /**
     * info字段拼接
     * @param info
     * @author peizijian
     * @date 2021/02/05
     * @return
     */
    @Override
    public void updateInfo(Integer id,String info) {
        this.teachProgramMapper.updateInfo(id,info);
    }

    /**
     * 确认是否有重复数据
     * @param teachProgram
     * @author peizijian
     * @date 2021/02/05
     * @return
     */
    @Override
    public List<TeachProgram> selectRepeat(TeachProgram teachProgram) {
        return teachProgramMapper.selectRepeat(teachProgram);
    }


}
