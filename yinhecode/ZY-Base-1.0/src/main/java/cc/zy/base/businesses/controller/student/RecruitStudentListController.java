package cc.zy.base.businesses.controller.student;

import cc.zy.base.businesses.entity.StuLabel;
import cc.zy.base.businesses.entity.StuLabelContent;
import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.mapper.RecruitStudentMapper;
import cc.zy.base.businesses.mapper.StudentMapper;
import cc.zy.base.businesses.service.IRecruitStudentService;
import cc.zy.base.businesses.service.IStudentService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import cc.zy.base.system.entity.User;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
@RequestMapping("recruitStudent")
public class RecruitStudentListController extends BaseController {
    private final IRecruitStudentService recruitStudentService;
    private final RecruitStudentMapper recruitStudentMapper;

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
        log.debug("返回studentsList方法入参"+request+","+student.toString());
        Map<String, Object> dataTable = getDataTable(this.recruitStudentService.findStudents(request, student));
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
    public FebsResponse moveToRecycle(@PathVariable String studentIds) {
        log.debug("移入回收站的id" + studentIds);
        String[] ids = studentIds.split(StringPool.COMMA);
        int[] arr = new int[ids.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(ids[i]);
            log.debug(arr[i] + "");
        }
        for (int i : arr) {
            this.recruitStudentService.setRecycleStatus(i);
        }
        for (int i : arr) {
            Student student = recruitStudentService.selectStuForRecycle(i);
            log.debug("移入回收站"+student.toString());
            this.recruitStudentService.insertIntoRecycle(student);
        }
        return new FebsResponse().success();
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
        log.debug("创建标签入参" + stuLabelContent.toString());
        User user = getCurrentUser();
        JSONObject obj = JSONObject.fromObject(stuLabelContent);
        String jsonContent = obj.toString();
        log.debug("创建标签"+jsonContent);
        StuLabel stuLabel = new StuLabel();
        stuLabel.setCreateUserId(user.getUserId().intValue());
        stuLabel.setLabelName(stuLabelContent.getMediaLabelName());
        stuLabel.setConditionContent(jsonContent);
        this.recruitStudentService.creatStuLable(stuLabel);
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
        return recruitStudentService.checkYourLabel(user.getUserId());
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
        recruitStudentService.delLable(id);
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
            this.recruitStudentService.overdueSet(i);
        }
        return new FebsResponse().success();
    }



    @GetMapping("studyList")
    @ResponseBody
    @RequiresPermissions("student:view")
    public FebsResponse studyDetailList(QueryRequest request, Student student) {
        log.debug("返回学习详情的方法入参"+student.toString());
        Map<String, Object> dataTable = getDataTable(this.recruitStudentService.findStudents(request, student));
        log.debug("返回学习详情的方法出参"+dataTable);
        return new FebsResponse().success().data(dataTable);
    }
}