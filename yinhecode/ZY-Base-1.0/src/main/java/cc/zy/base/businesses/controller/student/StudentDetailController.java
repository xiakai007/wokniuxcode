package cc.zy.base.businesses.controller.student;

import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.service.*;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import cc.zy.base.system.entity.Role;
import cc.zy.base.system.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;

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
@RequestMapping("student")
public class StudentDetailController extends BaseController {

    private final IStudentService studentsService;
    private final ICollegeService collegeService;
    private final IMajorService majorService;
    private final IBatchService batchService;
    private final ITaskService taskService;
    private final IDicService dicService;
    private final ILevelService levelService;
    private final IReqResultExtensionService reqResultExtensionService;

    /**
     * 获得院校列表
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping("collegeList")
    public FebsResponse getAllCollege(College college) {
        log.debug("获得院校列表入参"+college);
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
        log.debug("获得专业列表入参"+major);
        List<Major> majors = majorService.findMajors(major);
        log.debug("获得专业列表出参"+majors);
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
        log.debug("获得批次列表入参"+batch);
        List<Batch> batches = batchService.findBatchs(batch);
        log.debug("获得批次列表出参"+batches);
        return new FebsResponse().success().data(batches);
    }

    /**
     * 获得学生学籍状态
     * @author hutengjiao
     * @return dicByType
     */
    @GetMapping("stuStageList")
    public FebsResponse getAllStuStage() {
        List<Dic> dicByType = dicService.findDicByType("state_status");
        log.debug("返回学籍状态出参"+dicByType.toString());
        return new FebsResponse().success().data(dicByType);
    }

    /**
     * 获得学生层次
     * @author hutengjiao
     * @return
     */
    @GetMapping("stuLevelList")
    public FebsResponse getAllStulevel() {
        List<Level> levels = levelService.findLevels();
        log.debug("返回层次出参"+levels.toString());
        return new FebsResponse().success().data(levels);
    }

    /**
     * 修改学生报考信息
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @PostMapping("updateExamInfo")
    @ControllerEndpoint(operation = "修改学生报考信息", exceptionMessage = "修改学生报考信息失败")
    public FebsResponse updateExamInfo(@Valid Student student) {

        log.debug("修改学生报考信息入参"+student);
        boolean b = this.studentsService.updateById(student);
        if (b == true)
            return new FebsResponse().success();
        else {
            throw new FebsException("修改学生信息失败");
        }
    }

    /**
     * 学生报考信息审核通过
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @PostMapping("passExamTask")
    @ControllerEndpoint(operation = "学生报考信息审核通过", exceptionMessage = "学生报考信息审核失败")
    public FebsResponse passExamTask(Integer taskId, ReqResultExtension reqResultExtension) {
        log.debug("审核通过后的学生" + reqResultExtension);
        studentsService.passExamTask(taskId, reqResultExtension);
        return new FebsResponse().success();
    }

    /**
     * 学生报考信息审核不通过
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @PostMapping("noPassExamTask")
    @ControllerEndpoint(operation = "学生报考信息审核不通过", exceptionMessage = "学生报考信息审核不通过失败")
    public FebsResponse noPassExamTask(Integer taskId) {
        log.debug("学生报考信息审核不通过taskId:" + taskId );
        studentsService.noPassExamTask(taskId);
        return new FebsResponse().success();
    }

    /**
     * 学生考场审核通过
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @PostMapping("passExamLocation")
    @ControllerEndpoint(operation = "学生考场审核通过", exceptionMessage = "学生考场审核通过报错")
    public FebsResponse passExamLocation(Integer taskId, Integer stuId, Integer examLocationId,Integer confirmAddressId) {
        log.debug("学生考场审核通过入参taskId:"+taskId+"stuid:"+ stuId+"examLocationId:"+examLocationId+
                "confirmAddressId:"+confirmAddressId);
        studentsService.passExamLocation(taskId, stuId, examLocationId,confirmAddressId);
        return new FebsResponse().success();
    }

    /**
     * 学生考场审核不通过
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @PostMapping("noPassExamLocation")
    @ControllerEndpoint(operation = "学生考场审核不通过", exceptionMessage = "学生考场审核不通过报错")
    public FebsResponse noPassExamLocation(Integer taskId, String remark) {
        log.debug("学生考场审核不通过入参taskId:" + taskId + "remark" + remark);
        studentsService.noPassExamLocation(taskId, remark);
        return new FebsResponse().success();
    }
    /**
     * 获取待办任务数量成功
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping("getTaskNum")
    @ControllerEndpoint(operation = "获取待办任务数量成功", exceptionMessage = "获取待办任务数量失败")
    public FebsResponse getTaskNum(Integer userId) {
        log.debug("获取待办任务数量userId:" + userId);
        try {
            int taskNum = taskService.findTotalTaskByUserId(userId);
            log.debug("出参 taskNum:" + taskNum);
            return new FebsResponse().data(taskNum);
        } catch (Exception e) {
            return new FebsResponse().data(0);
        }
    }
    /**
     * 获取本学生报考信息待办任务成功
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping("getStudentExamTask")
    @ControllerEndpoint(operation = "获取本学生报考信息待办任务成功", exceptionMessage = "获取本学生报考信息待办任务失败")
    public FebsResponse getStudentExamTask(Integer stuId) {
        log.debug("获取本学生报考信息待办任务成功入参stuId:" + stuId);
        List<Task> list = null;
        try {
            list = taskService.findExamInfoTaskByStuId(stuId);
            for (Task task : list) {
                String after_update = task.getAfterUpdate();
                JSONObject jsonObject = new JSONObject(after_update);
                String jsonParseInfo = jsonObject.getString("afterUpdate");
                task.setJsonParseInfo(jsonParseInfo);
                String jsonParseName = jsonObject.getString("name");
                task.setJsonParseName(jsonParseName);
            }
            log.debug("获取本学生报考信息待办任务成功出参list:" + list);
            return new FebsResponse().success().data(list);
        } catch (Exception e) {
            return new FebsResponse().fail().data(list);
        }
    }
    /**
     * 获取招生老师待办列表
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping("userTaskList")
    @ResponseBody
    public FebsResponse studentList(QueryRequest request, UserTask userTask) {
        log.debug("到达获取待办列表" + userTask);
        Map<String, Object> dataTable = getDataTable(this.taskService.findUserTasks(request, userTask));
        log.debug("待办列表数据" + dataTable);
        return new FebsResponse().success().data(dataTable);
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
        log.debug("获取学生id：" + id);
        ReqResultExtension reqResultExtension = null;
        try {
            reqResultExtension = reqResultExtensionService.findReqStudentByStuId(id);
        } catch (Exception e) {
            throw new FebsException("查找学生失败");
        }
        log.debug("获取学生出参reqResultExtension：" + reqResultExtension);
        return new FebsResponse().success().data(reqResultExtension);
    }
    /**
     * 获取此学生待办任务的分类数量
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping("getTaskTypeNumByStuId")
    @ResponseBody
    public FebsResponse getTaskTypeNumByStuId(Integer stuId) {
        log.debug("获取此学生待办任务的分类数量入参stuId：" + stuId);
        List<Map<String, String>> list=null;
        try {
            list = taskService.findTaskTypeNumByStuId(stuId);
        } catch (Exception e) {
            throw new FebsException("查找学生待办任务的分类数量失败"+e.getMessage());
        }
        log.debug("获取此学生待办任务的分类数量出参list：" + list);
        return new FebsResponse().success().data(list);
    }

    /**
     * 获取此学生的费用支付情况
     *
     * @author 刘润雨
     * @date 2021-02-2
     */
    @GetMapping("getStuPayDetail")
    @ResponseBody
    public FebsResponse getStuExamPayDetail(Integer stuId,String paymenExplain){
        log.debug("获取此学生的费用支付情况入参stuId：" + stuId+","+paymenExplain);
        Map<String, Object> stuPayInfo=null;

        try {
            stuPayInfo  =studentsService.getStuExamPayInfo(stuId);
        }
        catch (Exception e){
            throw new FebsException("获取学生缴费情况错误"+e.getMessage());
        }
        log.debug("获取此学生的费用支付情况出参stuPayInfo：" + stuPayInfo);
        return new FebsResponse().data(stuPayInfo);
    }
}