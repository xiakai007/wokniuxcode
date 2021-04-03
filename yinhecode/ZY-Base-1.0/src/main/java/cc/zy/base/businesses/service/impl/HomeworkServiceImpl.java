package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.mapper.CollegeMapper;
import cc.zy.base.businesses.entity.Homework;
import cc.zy.base.businesses.entity.CollegeTerm;
import cc.zy.base.businesses.entity.Homework;
import cc.zy.base.businesses.mapper.EntranceScoreMapper;
import cc.zy.base.businesses.mapper.HomeworkMapper;
import cc.zy.base.businesses.mapper.TermScoreMapper;
import cc.zy.base.businesses.service.IHomeworkService;
import cc.zy.base.businesses.utils.ReadExcel;
import cc.zy.base.businesses.utils.ReadHomeworkExcel;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.SortUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *  Service实现
 *
 * @author peizijian
 * @date 2021/01/29
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class HomeworkServiceImpl extends ServiceImpl<HomeworkMapper, Homework> implements IHomeworkService {
    @Resource
    private CollegeMapper collegeMapper;
    private final HomeworkMapper homeworkMapper;
    @Resource
    private EntranceScoreMapper entranceScoreMapper;
    @Resource
    private TermScoreMapper termScoreMapper;

    @Override
    public IPage<Homework> findHomeworks(QueryRequest request, Homework homework) {
        LambdaQueryWrapper<Homework> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Homework> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Homework> findHomeworks(Homework homework) {

		return homeworkMapper.export(homework);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createHomework(Homework homework) {
        this.save(homework);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateHomework(Homework homework) {
        this.saveOrUpdate(homework);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteHomework(Homework homework) {
        LambdaQueryWrapper<Homework> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
    /**
     * 查询列表
     * @param homework
     * @author peizijian
     * @date 2021/01/29
     * @return
     */
    @Override
    public IPage<Homework> getHomeworkList(QueryRequest request, Homework homework) {
        Page<Homework> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countHomeworkDetail(homework));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.getHomeworkList(page,homework);
    }

    /**
     * 学校下拉框
     * @return
     * @author peizijian
     * @date 2021/01/29
     */
    @Override
    public List<College> getCollegeList() {
        return collegeMapper.findCollegeDetail(new College());
    }

    /**
     * 通过学校id获取层次名称
     * @param collegeId
     * @author peizijian
     * @date 2021/01/29
     * @return
     */
    @Override
    public List<Level> getLevelListByCollegeId(Integer collegeId) {
        return homeworkMapper.getLevelListByCollegeId(collegeId);
    }
    /**
     * 通过学校和层次获取对应专业
     * @param collegeId
     * @param levelId
     * @author peizijian
     * @date 2021/01/29
     * @return
     */
    @Override
    public List<Major> getMajorListByIds(Integer collegeId, Integer levelId) {
        return homeworkMapper.getMajorListByIds(collegeId,levelId);
    }
    /**
     * 通过学校和层次及专业获取对应课程
     * @param collegeId
     * @param levelId
     * @param majorId
     * @author peizijian
     * @date 2021/01/29
     * @return
     */
    @Override
    public List<TeachProgram> getCourseNameByIds(Integer collegeId, Integer levelId, Integer majorId,Integer termId) {
        return homeworkMapper.getCourseNameByIds(collegeId, levelId, majorId,termId);
    }
    /**
     * 根据层次id获取对应学期
     * @param levelId
     *@author peizijian
     * @date 2021/01/29
     * @return
     */
    @Override
    public List<CollegeTerm> getTermsByLevelId(Integer levelId) {
        return homeworkMapper.getTermsByLevelId(levelId);
    }
    /**
     * 根据层次id获取对应学年
     * @param levelId
     * @author peizijian
     * @date 2021/01/29
     * @return
     */
    @Override
    public List<CollegeYear> getYearByLevelId(Integer levelId) {
        return homeworkMapper.getYearByLevelId(levelId);
    }
    /**
     * 根据id查找该学生已经上过的学期
     * @author hutengjiao
     * @date 2021/02/01
     */
    @Override
    public List<CollegeTerm> findTermByStuid(Integer id) {
        return this.homeworkMapper.selectTermByStuId(id);
    }
    /**
     * 根据id查找学习信息
     * @author hutengjiao
     * @date 2021/02/01
     */
    @Override
    public List<Homework> findHomeWorkBystuid(Integer id, Integer termId) {
        return this.homeworkMapper.selectHomeworkByStuId(id,termId);
    }
    /**
     * 根据ID查询学生作业
     * @param id
     * @author pzj
     * @date 2021/02/01
     * @return
     */
    @Override
    public Homework findHomeworkById(Integer id) {
        return this.homeworkMapper.findHomeworkById(id);
    }

    /**
     * 读取excel数据
     *
     * @param multipartFile
     * @return
     */
    @Override
    @Transactional
    public String readData(MultipartFile multipartFile, HttpSession session){
        String code="";
        log.info("开始   ");
        FebsResponse febsResponse = null;
        try {
            febsResponse = ReadHomeworkExcel.readData(homeworkMapper,multipartFile);

            List<Homework>  homeworks=(List<Homework>) febsResponse.get("data");
            String message =(String) febsResponse.get("message");
            log.info("状态码   "+message);
            if (message.equals("200")){

                System.out.println(homeworks);
                //记录错误日志
                List<ErrorLog> errorLogs = new ArrayList<>();
                //获取一个UUID作为当次操作日志记录的唯一标记
                String unique = UUID.randomUUID().toString();
                for (Homework homework : homeworks) {
                    //获取批次ID
                    Integer batchId = termScoreMapper.getBatchIdByBatchName(homework.getBatchName());
                    log.info("批次ID   "+batchId);
                    if (batchId==null||("").equals(batchId)){
                        ErrorLog errorLog = new ErrorLog();
                        errorLog.setErrorRow(homework.getRow());
                        errorLog.setRemark(ReadHomeworkExcel.REMARK);
                        errorLog.setUnique(unique);
                        errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                        errorLog.setReason("批次信息输入有误！");
                        errorLogs.add(errorLog);
                    }else {
                        homework.setBatchId(String.valueOf(batchId));
                    }

                    Integer studyTypeId = termScoreMapper.getStudyTypeIdByStudyType(homework.getStudyType());
                    log.info("学习形式ID   "+studyTypeId);
                    if (studyTypeId==null||("").equals(studyTypeId)){
                        ErrorLog errorLog = new ErrorLog();
                        errorLog.setErrorRow(homework.getRow());
                        errorLog.setRemark(ReadHomeworkExcel.REMARK);
                        errorLog.setUnique(unique);
                        errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                        errorLog.setReason("学习形式信息输入有误！");
                        errorLogs.add(errorLog);
                    }

                    Integer termId = termScoreMapper.getTermIdByTermName(homework.getTermName());
                    if (termId==null||("").equals(termId)){
                        ErrorLog errorLog = new ErrorLog();
                        errorLog.setErrorRow(homework.getRow());
                        errorLog.setRemark(ReadHomeworkExcel.REMARK);
                        errorLog.setUnique(unique);
                        errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                        errorLog.setReason("学期信息输入有误！（例：第一学期）");
                        errorLogs.add(errorLog);
                        break;
                    }else {
                        homework.setTermId(termId);
                    }

                    Integer yearId = termScoreMapper.getYearIdByYearName(homework.getYearName());
                    if (yearId==null||("").equals(yearId)){
                        ErrorLog errorLog = new ErrorLog();
                        errorLog.setErrorRow(homework.getRow());
                        errorLog.setRemark(ReadHomeworkExcel.REMARK);
                        errorLog.setUnique(unique);
                        errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                        errorLog.setReason("学年信息填写错误");
                        errorLogs.add(errorLog);
                        break;
                    }else {
                        homework.setYearId(yearId);
                    }

                    Integer isPass = homeworkMapper.getIspassByIspassName(homework.getIspassName());
                    if (isPass==null||("").equals(isPass)){
                        ErrorLog errorLog = new ErrorLog();
                        errorLog.setErrorRow(homework.getRow());
                        errorLog.setRemark(ReadHomeworkExcel.REMARK);
                        errorLog.setUnique(unique);
                        errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                        errorLog.setReason("学年信息填写错误");
                        errorLogs.add(errorLog);
                        break;
                    }else {
                        homework.setIspass(isPass);
                    }

                    if (errorLogs==null||errorLogs.isEmpty()){

                        TermScore termIdsByPrimery = termScoreMapper.getTermIdsByPrimery(batchId, studyTypeId, homework.getIdentity());
                        if (termIdsByPrimery!=null){
                            log.info("批次ID  "+termIdsByPrimery.getBatchId());
                            log.info("学校ID  "+termIdsByPrimery.getCollegeId());
                            homework.setBatchId(termIdsByPrimery.getBatchId());
                            homework.setCollegeId(termIdsByPrimery.getCollegeId());
                            homework.setMajorId(termIdsByPrimery.getMajorId());
                            homework.setIdentity(termIdsByPrimery.getIdentity());
                            homework.setStudyTypeId(termIdsByPrimery.getStudyTypeId());
                            homework.setLevelId(termIdsByPrimery.getLevelId());
                        }else {
                            ErrorLog errorLog = new ErrorLog();
                            errorLog.setErrorRow(homework.getRow());
                            errorLog.setRemark(ReadHomeworkExcel.REMARK);
                            errorLog.setUnique(unique);
                            errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                            errorLog.setReason("无此学生信息！");
                            errorLogs.add(errorLog);
                            break;
                        }

                        //获取课程ID
                        Integer courseId = homeworkMapper.getCourseIdByCourseName(homework);

                        log.info("课程ID   "+courseId);

                        if (courseId!=null&&!("").equals(courseId)){
                            homework.setCourseId(courseId);
                        }else {
                            ErrorLog errorLog = new ErrorLog();
                            errorLog.setErrorRow(homework.getRow());
                            errorLog.setRemark(ReadHomeworkExcel.REMARK);
                            errorLog.setUnique(unique);
                            errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                            errorLog.setReason("课程信息输入有误！");
                            errorLogs.add(errorLog);
                        }

                    }
                    //验证数据是否重复
                    Homework homework1 = homeworkMapper.checkUniqueByHomework(homework);
                    if (homework1!=null){
                        ErrorLog errorLog = new ErrorLog();
                        errorLog.setErrorRow(homework.getRow());
                        errorLog.setRemark(ReadHomeworkExcel.REMARK);
                        errorLog.setUnique(unique);
                        errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                        errorLog.setReason("此学生作业信息已存在！");
                        errorLogs.add(errorLog);
                    }


                }
                if (errorLogs==null||errorLogs.isEmpty()){
                    //数据验证成功，插入数据进学期成绩表中
                    //向作业表中添加读取到的作业信息的数据
                    int i = homeworkMapper.addHomeworkList(homeworks);
                    code="200";
                }else {
                    session.setAttribute("unique",unique);
                    int i = entranceScoreMapper.addErrorLogList(errorLogs);
                    code="400";
                }

            }else {
                List<ErrorLog> errorLogs =(List<ErrorLog>) febsResponse.get("data");
                log.info("错误日志"+errorLogs);
                System.out.println(errorLogs);
                String unique = errorLogs.get(0).getUnique();
//            session.setAttribute("unique",unique);
                int i =entranceScoreMapper.addErrorLogList(errorLogs);
                code="400";
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }

}
