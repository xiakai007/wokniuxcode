package cc.zy.base.businesses.controller.student;

import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.mapper.StudentMapper;
import cc.zy.base.businesses.service.IReqResultExtensionService;
import cc.zy.base.businesses.service.IStudentService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.FebsUtil;
import cc.zy.base.monitor.entity.SystemLog;
import cc.zy.base.system.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import cc.zy.base.common.exception.FebsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * Controller
 *
 * @author liurunyu
 * @date 2021\1\22 0022 16:50
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentListController extends BaseController {
    private final IStudentService studentsService;
    private final StudentMapper studentMapper;
    private final IReqResultExtensionService reqResultExtensionService;

    /**
     * 返回学生表数据方法
     *
     * @author jiangweiguang
     * @date 2021\2\1 0022 16:50
     */
    @GetMapping("list")
    @ResponseBody
    @RequiresPermissions("student:view")
    public FebsResponse studentList(QueryRequest request, Student student) {
        log.debug("返回studentsList方法获取studentId"+student.getStageId());
        Map<String, Object> dataTable = getDataTable(this.studentsService.findStudents(request, student));
        log.debug("出参"+dataTable.toString());
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * 将studentIds参数中的学生id对应的学生，移入回收站
     *
     * @author jiangweiguang
     * @date 2021\2\1 0022 16:50
     */
    @GetMapping("moveToRecycle/{studentIds}")
    @ControllerEndpoint(operation = "移入回收站", exceptionMessage = "移入回收站失败")
    @ResponseBody
    @Transactional
    public FebsResponse moveToRecycle(@PathVariable String studentIds) {
        log.debug("移入回收站的id" + studentIds);
        String[] ids = studentIds.split(StringPool.COMMA);
        this.studentsService.setRecycleStatus(ids);
        List<Student> students = studentsService.selectStuForRecycle(ids);
        this.studentsService.insertIntoRecycle(students);
        return new FebsResponse().success();
    }

    /**
     * 驳回身份证审核
     *
     * @author hutengjiao
     * @date 2021\2\1
     */
    @PostMapping("affirm/rejectIden")
    @ControllerEndpoint(operation = "驳回身份证审核", exceptionMessage = "驳回身份证失败")
    @ResponseBody
    public FebsResponse rejectIden(@Valid Integer id, Integer typeId, String remark) {
        log.debug("驳回身份证审核id:"+id+",typeId:"+typeId+",remark:"+remark);
        if (id == null) {
            throw new FebsException("学生ID为空");
        } else {
            Boolean b = this.studentsService.rejectTask(id, typeId, remark);
            log.debug("驳回身份证审核验证："+b);
            if (b) {
                return new FebsResponse().success();
            } else {
                return new FebsResponse().fail();
            }
        }
    }

    /**
     * 获取学生管理日志
     *
     * @author liurunyu
     * @date 2021\2\1 0022 16:50
     */
    @GetMapping("loglist")
    @ResponseBody
    @RequiresPermissions("student:view")
    public FebsResponse loglist(QueryRequest request, SystemLog systemLog) {
        log.debug("获取学生管理日志返回loglist方法获取systemLog:"+systemLog);
        log.debug(systemLog.toString());
        Map<String, Object> dataTable = getDataTable(this.studentsService.findStuLog(systemLog, request));
        log.debug("获取学生管理日志出参"+dataTable.toString());
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * 通过身份证审核
     *
     * @author hutengjiao
     * @date 2021\2\1
     */
    @PostMapping("affirm/agreeIdentity")
    @ControllerEndpoint(operation = "通过身份证审核", exceptionMessage = "通过身份证失败")
    @ResponseBody
    @Transactional
    public FebsResponse agreeIdentity(@Valid Integer id, Integer typeId, String idenFront,
                                      String idenBack, String identityFrontN,
                                      String identityContrarynBegin, String identityContrarynEnd) {
        log.debug("通过身份证审核入参id:"+id+"typeId:"+typeId+"idenFront:"+idenFront+"idenBack:"+idenBack
                +"identityFrontN:"+identityFrontN+"identityContrarynBegin:"+identityContrarynBegin
                +"identityContrarynEnd:"+identityContrarynEnd);
        String idenFrontImgUrl = StringEscapeUtils.unescapeHtml4(idenFront);
        String idenBackImgUrl = StringEscapeUtils.unescapeHtml4(idenBack);
        log.debug("获取身份证照片正面："+idenFrontImgUrl+"反面："+idenBackImgUrl);
        if (id == null) {
            throw new FebsException("学生ID为空");
        } else {
            ReqResultExtension reqResultExtension = new ReqResultExtension();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date dateBegin = sdf.parse(identityContrarynBegin);
                Date dateEnd = sdf.parse(identityContrarynEnd);
                reqResultExtension.setIdenBeginDate(dateBegin);
                reqResultExtension.setIdecEndDate(dateEnd);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            reqResultExtension.setId(id);
            reqResultExtension.setIdFrontImgUrl(idenFrontImgUrl);
            reqResultExtension.setIdBackImgUrl(idenBackImgUrl);
            reqResultExtension.setIdentity(identityFrontN);
            Boolean task = this.studentsService.passedTask(id, typeId, reqResultExtension);
            log.debug("通过身份证审核验证："+task);
            if (task) {
                return new FebsResponse().success();
            } else {
                throw new FebsException("审核失败");
            }
        }
    }

    /**
     * 驳回照片审核
     *
     * @author hutengjiao
     * @date 2021\2\1
     */
    @PostMapping("affirm/rejectPhoto")
    @ControllerEndpoint(operation = "驳回照片审核", exceptionMessage = "驳回照片失败")
    @ResponseBody
    public FebsResponse rejectPhoto(@Valid Integer id, Integer typeId, String remark) {
        log.debug("驳回照片审核入参id："+id+"typeId:"+typeId+"remark:"+remark);
        if (id == null) {
            throw new FebsException("学生ID为空");
        } else {
            Boolean b = this.studentsService.rejectTask(id, typeId, remark);
            log.debug("驳回照片审核验证："+b);
            if (b) {
                return new FebsResponse().success();
            } else {
                return new FebsResponse().fail();
            }
        }
    }

    /**
     * 通过照片审核
     *
     * @author hutengjiao
     * @date 2021\2\1
     */
    @PostMapping("affirm/agreePhoto")
    @ControllerEndpoint(operation = "通过照片审核", exceptionMessage = "照片审核失败")
    @ResponseBody
    public FebsResponse agreePhoto(@Valid Integer id, Integer typeId, String photo) {
        String headPhoto = StringEscapeUtils.unescapeHtml4(photo);
        log.debug("通过照片审核入参id："+id+"typeId:"+typeId+"photo转换前:"+photo+"photo转换后："+headPhoto);
        if (id == null) {
            throw new FebsException("学生ID为空");
        } else {
            ReqResultExtension student = new ReqResultExtension();
            student.setId(id);
            student.setHeadImgUrl(headPhoto);
            Boolean task = this.studentsService.passedTask(id, typeId, student);
            log.debug("通过照片审核验证："+task);
            if (task) {
                return new FebsResponse().success();
            } else {
                return new FebsResponse().fail();
            }
        }
    }

    /**
     * 驳回毕业证审核
     *
     * @author hutengjiao
     * @date 2021\2\1
     */
    @PostMapping("affirm/rejectDiploma")
    @ControllerEndpoint(operation = "驳回毕业证审核", exceptionMessage = "驳回毕业证失败")
    @ResponseBody
    public FebsResponse rejectDiploma(@Valid Integer id, Integer typeId, String remark) {
        log.debug("驳回毕业证审核入参id："+id+"typeId:"+typeId+"remark:"+remark);
        if (id == null) {
            throw new FebsException("学生ID为空");
        } else {
            Boolean b = this.studentsService.rejectTask(id, typeId, remark);
            log.debug("驳回毕业证审核验证："+b);
            if (b) {
                return new FebsResponse().success();
            } else {
                return new FebsResponse().fail();
            }
        }
    }

    /**
     * 通过毕业证审核
     *
     * @author hutengjiao
     * @date 2021\2\1
     */
    @PostMapping("affirm/agreeDiploma")
    @ControllerEndpoint(operation = "通过毕业证审核", exceptionMessage = "毕业证审核失败")
    @ResponseBody
    public FebsResponse agreeDiploma(@Valid Integer id, Integer typeId, String diploma,
                                     String diplomaNum, String diplomaDate) {
        String diplomaImgUrl = StringEscapeUtils.unescapeHtml4(diploma);
        log.debug("通过毕业证审核入参id："+id+"typeId:"+typeId+"diploma转换前:"+diploma+
                "diploma转换后："+diplomaImgUrl+"diplomaNum:"+diplomaNum+"diplomaDate:"+
                diplomaDate);
        if (id == null) {
            throw new FebsException("学生ID为空");
        } else {
            ReqResultExtension student = new ReqResultExtension();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date graduDate = sdf.parse(diplomaDate);
                student.setGraduDate(graduDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            student.setId(id);
            student.setDiplomaNum(diplomaNum);
            student.setDiplomaImgUrl(diplomaImgUrl);
            Boolean task = this.studentsService.passedTask(id, typeId, student);
            log.debug("通过毕业证审核验证："+task);
            if (task) {
                return new FebsResponse().success();
            } else {
                return new FebsResponse().fail();
            }
        }
    }

    /**
     * 创建标签
     *
     * @author jiangweiguang
     * @date 2021\2\1 0022 16:50
     */
    @PostMapping("createLabel")
    @ResponseBody
    @ControllerEndpoint(operation = "创建标签", exceptionMessage = "创建标签失败")
    public FebsResponse createLabel(StuLabelContent stuLabelContent) {
        log.debug("创建标签" + stuLabelContent.toString());
        User user = getCurrentUser();
        JSONObject obj = JSONObject.fromObject(stuLabelContent);
        String jsonContent = obj.toString();
        log.debug(jsonContent);
        StuLabel stuLabel = new StuLabel();
        stuLabel.setCreateUserId(user.getUserId().intValue());
        stuLabel.setLabelName(stuLabelContent.getMediaLabelName());
        stuLabel.setConditionContent(jsonContent);
        this.studentsService.creatStuLable(stuLabel);
        return new FebsResponse().success();
    }

    /**
     * 查询标签
     *
     * @author jiangweiguang
     * @date 2021\2\1 0022 16:50
     */
    @GetMapping("checkYourLabel")
    @ResponseBody
    @ControllerEndpoint(operation = "查询标签", exceptionMessage = "查询标签失败")
    public List<StuLabel> checkYourLabel() {
        User user = getCurrentUser();
        return studentsService.checkYourLabel(user.getUserId());
    }

    /**
     * 删除标签
     *
     * @author jiangweiguang
     * @date 2021\2\1 0022 16:50
     */
    @DeleteMapping("delLabel")
    @ResponseBody
    @ControllerEndpoint(operation = "删除标签", exceptionMessage = "删除标签失败")
    public FebsResponse delYourLabel(Integer id) {
        log.debug("删除标签id" + id);
        studentsService.delLable(id);
        return new FebsResponse().success();
    }

    /**
     * 设置逾期毕业
     *
     * @author jiangweiguang
     * @date 2021\2\1 0022 16:50
     */
    @GetMapping("overdueSet/{studentIds}")
    @ControllerEndpoint(operation = "逾期毕业", exceptionMessage = "逾期毕业失败")
    @ResponseBody
    public FebsResponse overdueSet(@PathVariable String studentIds) {
        log.debug("逾期毕业id" + studentIds);
        String[] ids = studentIds.split(StringPool.COMMA);
        int[] arr = new int[ids.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(ids[i]);
            log.debug(arr[i] + "");
        }
        for (int i : arr) {
            this.studentsService.overdueSet(i);
        }
        return new FebsResponse().success();
    }


    @GetMapping("studyList")
    @ResponseBody
    @RequiresPermissions("student:view")
    public FebsResponse studyDetailList(QueryRequest request, Student student) {
        log.debug("返回学习详情的方法入参student："+student);
        Map<String, Object> dataTable = getDataTable(this.studentsService.findStudents(request, student));
        log.debug(" 返回学习详情的方法出参"+dataTable);
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * 根据userId查询该id下管理学生组学生信息
     * @param request
     * @param reqResultExtension
     * @return
     */
    @GetMapping("recruitList")
    @ResponseBody
    @RequiresPermissions("student:view")
    public FebsResponse recruitStudentList(QueryRequest request, ReqResultExtension reqResultExtension) {
        log.debug("返回studentsList方法获取studentId"+reqResultExtension);
        Long userIds = FebsUtil.getCurrentUser().getUserId();
        Integer userId=userIds.intValue();
        log.debug(userId+"5555555555555");
        Map<String, Object> grouping = getDataTable(
                this.reqResultExtensionService.findStudentForGroupingByUId(request, reqResultExtension,userId));
        log.debug("出参"+grouping.toString());
        return new FebsResponse().success().data(grouping);
    }
}