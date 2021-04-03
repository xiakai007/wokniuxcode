package cc.zy.base.businesses.controller.student;

import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.service.*;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author lalala
 * @date 2021\1\22 0022 16:50
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("recruitStudent")
public class RecruitStudentDetailController extends BaseController {
    private final IRecruitStudentService recruitStudentService;
    private final ICollegeService collegeService;
    private final IMajorService majorService;
    private final IBatchService batchService;
    private final ITaskService taskService;
    private final IHomeworkService homeworkService;
    /**
     * 获得院校列表
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping("collegeList")
    public FebsResponse getAllCollege(College college) {
        log.debug("院校列表入参"+college);
        log.debug("院校列表出参"+collegeService.findColleges(college));
        return new FebsResponse().success().data(collegeService.findColleges(college));
    }
    /**
     * 获得专业列表
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping("majorList")
    public FebsResponse getAllMajor(Major major) {
        log.debug("获取专业列表入参"+major);
        List<Major> majors = majorService.findMajors(major);
        log.debug("获取专业列表出参"+majors);
        return new FebsResponse().success().data(majors);
    }
    /**
     * 获得批次列表
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping("batchList")
    public FebsResponse getAllMajor(Batch batch) {
        log.debug("获取批次列表入参"+batch);
        List<Batch> batches = batchService.findBatchs(batch);
        log.debug("获取批次列表出参"+batches);
        return new FebsResponse().success().data(batches);
    }


    /**
     * 获取学生
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping("getStudentByIdLry")
    @ResponseBody
    public FebsResponse getStudentByIdLry(Integer id) {
        log.debug("获取学生入参id"+id);
        Student student = null;
        try {
            student = recruitStudentService.findById(id);
        } catch (Exception e) {
            throw new FebsException("查找学生失败");
        }
        log.debug("获取学生出参"+student);
        return new FebsResponse().success().data(student);
    }


    /**
     * 获取此学生的考试费费用支付情况
     *
     * @author 刘润雨
     * @date 2021-02-2
     */
    @GetMapping("getStuPayDetail")
    @ResponseBody
    public FebsResponse getStuExamPayDetail(Integer stuId,String paymenExplain){
        log.debug("获取此学生的考试费费用支付情况入参"+stuId+","+paymenExplain);
        Map<String, String> stuPayInfo=null;
        try {
            stuPayInfo  =recruitStudentService.getStuExamPayInfo(stuId, paymenExplain);
        } catch (Exception e){
            throw new FebsException("获取学生缴费情况错误"+e.getMessage());
        }
        log.debug("获取此学生的考试费费用支付情况出参"+stuPayInfo);
        return new FebsResponse().data(stuPayInfo);
    }

    /**
     * 根据id查找学习信息
     * @author hutengjiao
     * @date 2021/02/01
     */
    @GetMapping("semester")
    @ResponseBody
    @RequiresPermissions("others:datapermission")
    public FebsResponse getSemester(Integer id) {
        log.debug("根据id查找学习信息入参"+id);
        Map<String,Object> study=new HashMap<>();
        List<CollegeTerm> term = homeworkService.findTermByStuid(id);
        study.put("term", term);
        for (int i = 0; i < term.size(); i++) {
            Integer termId = term.get(i).getId();
            List<Homework> homework = homeworkService.findHomeWorkBystuid(id, termId);
            study.put("study" + i, homework);
        }
        log.debug("根据id查找学习信息出参"+study);
        return new FebsResponse().success().data(study);
    }

    /**
     * 获取此学生的学费费用支付情况
     *
     * @author 刘润雨
     * @date 2021-02-2
     */
    @GetMapping("getStuStudyPayDetail")
    @ResponseBody
    public FebsResponse getStuStudyPayDetail(Integer stuId,String paymenExplain){
        log.debug("获取此学生的学费费用支付情况入参"+stuId+","+paymenExplain);
        Map<String, String> stuPayInfo=null;
        try {
            stuPayInfo  =recruitStudentService.getStuStudyPayInfo(stuId, paymenExplain);
        }
        catch (Exception e){
            throw new FebsException("获取学生缴费情况错误"+e.getMessage());
        }
        log.debug("获取此学生的学费费用支付情况出参"+stuPayInfo);
        return new FebsResponse().data(stuPayInfo);
    }

    /**
     * 获取此学生的学习年数
     *
     * @author 刘润雨
     * @date 2021-02-4
     */
    @GetMapping("getStuStudyYear")
    @ResponseBody
    public FebsResponse getStuStudyYear(Integer stuId){
        log.debug("获取此学生的学习年数入参"+stuId);
        int studyYear=0;
        try {
            studyYear  =recruitStudentService.findStudentStudyYear(stuId);
        }
        catch (Exception e){
            throw new FebsException("获取学生学习年数错误"+e.getMessage());
        }
        log.debug("获取此学生的学习年数出参"+studyYear);
        return new FebsResponse().data(studyYear);
    }
}
