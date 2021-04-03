package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.mapper.CollegeMapper;

import cc.zy.base.businesses.mapper.EntranceScoreMapper;
import cc.zy.base.businesses.mapper.TermScoreMapper;
import cc.zy.base.businesses.service.IEntranceScoreService;
import cc.zy.base.businesses.service.ITermScoreService;
import cc.zy.base.businesses.utils.ReadHomeworkExcel;
import cc.zy.base.businesses.utils.ReadTermExcel;
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
 * @author zzz
 * @date 2021-01-28 16:13:11
 */
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TermScoreServiceImpl extends ServiceImpl<TermScoreMapper, TermScore> implements ITermScoreService {

    private final TermScoreMapper termScoreMapper;
    @Resource
    private EntranceScoreMapper entranceScoreMapper;
    @Resource
    private CollegeMapper collegeMapper;
    @Override
    public IPage<TermScore> findTermScores(QueryRequest request, TermScore termScore) {
        LambdaQueryWrapper<TermScore> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<TermScore> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<TermScore> findTermScores(TermScore termScore) {
	    LambdaQueryWrapper<TermScore> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createTermScore(TermScore termScore) {
        this.save(termScore);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTermScore(TermScore termScore) {
        this.saveOrUpdate(termScore);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTermScore(TermScore termScore) {
        LambdaQueryWrapper<TermScore> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
    /**
     * 查询列表
     * @author wangpin
     * @param termScore
     * @return
     */
    @Override
    public IPage<TermScore> getTermScoreList(QueryRequest request,TermScore termScore) {
        Page<TermScore> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countTermScoreDetail(termScore));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.getTermScoreList(page,termScore);
    }

    @Override
    public List<College> getCollegeList() {
        return collegeMapper.findCollegeDetail(new College());
    }

    /**
     * 通过学校id获取层次名称
     * @param collegeId
     * @return
     */
    @Override
    public List<Level> getLevelListByCollegeId(Integer collegeId) {
        return termScoreMapper.getLevelListByCollegeId(collegeId);
    }
    /**
     * 通过学校和层次获取对应专业
     * @param collegeId
     * @param levelId
     * @return
     */
    @Override
    public List<Major> getMajorListByIds(Integer collegeId, Integer levelId) {
        return termScoreMapper.getMajorListByIds(collegeId,levelId);
    }
    /**
     * 通过学校和层次及专业获取对应课程
     * @param collegeId
     * @param levelId
     * @param majorId
     * @return
     */
    @Override
    public List<TeachProgram> getCourseNameByIds(Integer collegeId, Integer levelId, Integer majorId,Integer termId) {
        return termScoreMapper.getCourseNameByIds(collegeId, levelId, majorId,termId);
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
            febsResponse = ReadTermExcel.readData(multipartFile);
            List<TermScore>  termScores=(List<TermScore>) febsResponse.get("data");
            String message =(String) febsResponse.get("message");
            log.info("状态码   "+message);
            if (message.equals("200")){
                //记录错误日志
                List<ErrorLog> errorLogs = new ArrayList<>();
                //获取一个UUID作为当次操作日志记录的唯一标记
                String unique = UUID.randomUUID().toString();
                for (TermScore termScore : termScores) {
                    //获取批次和学习形式ID
                    Integer batchId = termScoreMapper.getBatchIdByBatchName(termScore.getBatchName());
                    log.info("批次ID   "+batchId);
                    if (batchId==null||("").equals(batchId)){
                        ErrorLog errorLog = new ErrorLog();
                        errorLog.setErrorRow(termScore.getRow());
                        errorLog.setRemark(ReadTermExcel.REMARK);
                        errorLog.setUnique(unique);
                        errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                        errorLog.setReason("批次信息输入有误！");
                        errorLogs.add(errorLog);
                    }
                    Integer studyTypeId = termScoreMapper.getStudyTypeIdByStudyType(termScore.getStudyType());
                    log.info("学习形式ID   "+studyTypeId);
                    if (studyTypeId==null||("").equals(studyTypeId)){
                        ErrorLog errorLog = new ErrorLog();
                        errorLog.setErrorRow(termScore.getRow());
                        errorLog.setRemark(ReadTermExcel.REMARK);
                        errorLog.setUnique(unique);
                        errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                        errorLog.setReason("学习形式信息输入有误！");
                        errorLogs.add(errorLog);
                    }

                    Integer termId = termScoreMapper.getTermIdByTermName(termScore.getTermName());
                    if (termId==null||("").equals(termId)){
                        ErrorLog errorLog = new ErrorLog();
                        errorLog.setErrorRow(termScore.getRow());
                        errorLog.setRemark(ReadTermExcel.REMARK);
                        errorLog.setUnique(unique);
                        errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                        errorLog.setReason("学期信息输入有误！（例：第一学期）");
                        errorLogs.add(errorLog);
                        break;
                    }else {
                        termScore.setTermId(termId);
                    }

                    if (errorLogs==null||errorLogs.isEmpty()){

                        TermScore termIdsByPrimery = termScoreMapper.getTermIdsByPrimery(batchId, studyTypeId, termScore.getIdentity());
                        if (termIdsByPrimery!=null){
                            log.info("批次ID  "+termIdsByPrimery.getBatchId());
                            log.info("学校ID  "+termIdsByPrimery.getCollegeId());
                            termScore.setBatchId(termIdsByPrimery.getBatchId());
                            termScore.setCollegeId(termIdsByPrimery.getCollegeId());
                            termScore.setMajorId(termIdsByPrimery.getMajorId());
                            termScore.setIdentity(termIdsByPrimery.getIdentity());
                            termScore.setStudyTypeId(termIdsByPrimery.getStudyTypeId());
                            termScore.setLevelId(termIdsByPrimery.getLevelId());
                        }else {
                            ErrorLog errorLog = new ErrorLog();
                            errorLog.setErrorRow(termScore.getRow());
                            errorLog.setRemark(ReadTermExcel.REMARK);
                            errorLog.setUnique(unique);
                            errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                            errorLog.setReason("无此学生信息！");
                            errorLogs.add(errorLog);
                            break;
                        }

                        //获取课程ID
                        TeachProgram courseId = termScoreMapper.getCourseIdAndSubTypeIdByCourseName(termScore);
//                    log.info("课程ID   "+courseId.getId());

                        if (courseId!=null&&!("").equals(courseId)){
                            termScore.setCourseId(String.valueOf(courseId.getId()));
                            termScore.setSubtypeId(courseId.getTypeId());
                        }else {
                            ErrorLog errorLog = new ErrorLog();
                            errorLog.setErrorRow(termScore.getRow());
                            errorLog.setRemark(ReadTermExcel.REMARK);
                            errorLog.setUnique(unique);
                            errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                            errorLog.setReason("课程信息输入有误！");
                            errorLogs.add(errorLog);
                        }
                    }
                    //验证数据是否重复
                    Integer id = termScoreMapper.checkTermScoreUnique(termScore);
                    if (id!=null&&id!=0){
                        ErrorLog errorLog = new ErrorLog();
                        errorLog.setErrorRow(termScore.getRow());
                        errorLog.setRemark(ReadHomeworkExcel.REMARK);
                        errorLog.setUnique(unique);
                        errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                        errorLog.setReason("此学期成绩信息已存在！");
                        errorLogs.add(errorLog);
                    }
                }

                if (errorLogs==null||errorLogs.isEmpty()){
                    //数据验证成功，插入数据进学期成绩表中
                    //向入学成绩表中添加读取到的入学成绩的数据
                    termScoreMapper.addtermScoreList(termScores);
                    code="200";
                }else {
                    session.setAttribute("unique",unique);
                    int i = entranceScoreMapper.addErrorLogList(errorLogs);
                    code="400";
                }

            }else {
                List<ErrorLog> errorLogs =(List<ErrorLog>) febsResponse.get("data");
                String unique = errorLogs.get(0).getUnique();
                session.setAttribute("unique",unique);
                int i = entranceScoreMapper.addErrorLogList(errorLogs);
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
    /**
     * 根据层次id获取对应学期
     * @param levelId
     * @return
     */
    @Override
    public List<CollegeTerm> getTermsByLevelId(Integer levelId) {
        return termScoreMapper.getTermsByLevelId(levelId);
    }
}
