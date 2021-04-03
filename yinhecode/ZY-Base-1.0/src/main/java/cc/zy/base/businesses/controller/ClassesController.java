package cc.zy.base.businesses.controller;

import cc.zy.base.businesses.entity.Classes;
import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.entity.StudentGroup;
import cc.zy.base.businesses.entity.TeacherChangeLog;
import cc.zy.base.businesses.service.IClassesService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.TreeNode;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.wuwenze.poi.ExcelKit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 班级表 Controller
 *
 * @author LiPeng
 * @date 2021/01/27 14:58:25
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("class")
public class ClassesController extends BaseController {

    private final IClassesService classesService;

    /**
     * @Description: 根据班级id查询历史班主任
     * @Param: request 含分页参数；classId 班级id
     * @return: 包含分页信息的json数据
     * @author: LiPeng
     * @date: 2021/2/1
     */
    @ResponseBody
    @GetMapping("changeTeacherLog/{classId}")
    public FebsResponse findChangeTeacherLog(QueryRequest request, @PathVariable Integer classId) {
        log.info("班级id：" + classId);
        Map<String, Object> dataTable = getDataTable(this.classesService.findTeacherChangeLogByClassesId(request, classId));
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * @param request 请求对象
     * @param classes 班级对象
     * @author houweikang
     * @date 2021/2/1
     * @Description 班级展示
     */
    @ResponseBody
    @GetMapping("list")
    @RequiresPermissions("class:view")
    public FebsResponse classList(QueryRequest request, Classes classes) {
        log.debug("query对象：" + classes);
        Map<String, Object> dataTable = getDataTable(this.classesService.findClassess(request, classes));
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * @param classIds 班级id数组
     * @author houweikang
     * @date 2021/2/1
     * @Description 删除班级
     */
    @ResponseBody
    @GetMapping("delete/{classIds}")
    @ControllerEndpoint(operation = "删除班级", exceptionMessage = "删除班级失败")
    public FebsResponse deleteClass(@NotBlank(message = "{required}") @PathVariable String classIds) {
        log.debug("班级id："+classIds);
        if (classIds != null && !classIds.isEmpty()) {
            String[] ids = classIds.split(StringPool.COMMA);
            ArrayList<Integer> list = new ArrayList<>();
            for (String id : ids) {
                list.add(Integer.parseInt(id));
            }
            this.classesService.deleteClass(list);
            return new FebsResponse().success();
        }else {
            return new FebsResponse().fail().message("班级id为空，删除班级失败");
        }

    }

    /**
     * @param teacherChangeLog 班主任更换对象
     * @author houweikang
     * @date 2021/2/1
     * @Description 更换班主任
     */
    @ResponseBody
    @PostMapping("updateTeacher")
    @ControllerEndpoint(operation = "更换班主任", exceptionMessage = "更换班主任失败")
    public FebsResponse updateTeacher(@Valid TeacherChangeLog teacherChangeLog) {
        log.debug("班主任更换日志对象：" + teacherChangeLog);
        this.classesService.updateTeacher(teacherChangeLog);
        return new FebsResponse().success();
    }

    /**
     * @param classes 班级对象
     * @author houweikang
     * @date 2021/2/1
     * @Description 增加班级
     */
    @ResponseBody
    @PostMapping("add")
    @ControllerEndpoint(operation = "新增班", exceptionMessage = "新增班失败")
    public FebsResponse addCollege(@Valid Classes classes) {
        log.debug("班级对象：" + classes);
        Boolean aClass = this.classesService.createClass(classes);
        return new FebsResponse().success().data(aClass);
    }

    /**
     * 用户——部门下拉选择树通用组件
     *
     * @return
     */
    @ResponseBody
    @GetMapping("userDeptTree")
    public List<TreeNode> userDeptTree() {
        List<TreeNode> nodeList = classesService.createUserDeptTree();
        log.info(nodeList + "用户树");
        return nodeList;
    }

    /**
     * @param classes 班级对象
     * @author houweikang
     * @date 2021/2/1
     * @Description 导出班级的Excel表
     */
    @GetMapping("excel")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(Classes classes, HttpServletResponse response) {
        log.debug("导出班级时的查询条件：" + classes);
        List<Classes> classesList = this.classesService.findClassess(classes);
        log.debug("导出的班级集合：" + classesList);
        ExcelKit.$Export(Classes.class, response).downXlsx(classesList, false);
    }

    /**
     * @param student 学生对象
     * @author houweikang
     * @date 2021/2/1
     * @Description 给学生更换专业
     */
    @ResponseBody
    @PostMapping("updateStuMajor")
    @ControllerEndpoint(operation = "更换专业", exceptionMessage = "更换专业失败")
    public FebsResponse updateStuMajor(@Valid Student student) {
        log.debug("学生对象：" + student);
        this.classesService.updateStuMajor(student);
        return new FebsResponse().success();
    }

    /**
     * @description: 树形班级下拉菜单
     * @return: 树形节点集合
     * @author: LiPeng
     * @date: 2021/2/8
     */
    @ResponseBody
    @GetMapping("classesTree")
    public List<TreeNode> findClassesTree() {
        List<TreeNode> nodeList = classesService.findClassesTree();
        return nodeList;
    }

    /**
     * @description: 学生分班时的查询结果列表
     * @param: request 含分页参数；student query对象，传递查询条件
     * @return: 包含分页信息的json数据
     * @author: LiPeng
     * @date: 2021/2/8
     */
    @ResponseBody
    @GetMapping("studentList")
    public FebsResponse findStudentForClassGrouping(QueryRequest request, Student student) {
        log.debug("query对象：" + student);
        Map<String, Object> dataTable = getDataTable(
                this.classesService.findStudentForClassGrouping(request, student));
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * @description: 根据学生id对学生进行分班
     * @param: studentIds 学生id数组 字符串；classId 班级id
     * @return: json格式的简单响应数据
     * @author: LiPeng
     * @date: 2021/2/8
     */
    @ResponseBody
    @PostMapping("updateClassId/{studentIds}/{classId}")
    @ControllerEndpoint(operation = "学生分班", exceptionMessage = "学生分班失败异常")
    public FebsResponse updateClassIdByIds(@NotBlank(message = "{required}") @PathVariable String studentIds,
                                           @NotBlank(message = "{required}") @PathVariable String classId) {
        log.debug("学生id字符串：" + studentIds);
        log.debug("分班的班级id：" + classId);
        if (studentIds != null && !studentIds.isEmpty() && classId != null) {
            String[] ids = studentIds.split(StringPool.COMMA);
            ArrayList<Integer> list = new ArrayList<>();
            for (String id : ids) {
                list.add(Integer.parseInt(id));
            }
            this.classesService.updateClassId(list, Integer.parseInt(classId) - 1000000);
            return new FebsResponse().success();
        } else {
            return new FebsResponse().fail().message("学生数量为0或班级id为空，分班失败");
        }
    }

    /**
     * @description: 根据查询条件查询学生，然后对其进行分班
     * @param: student query对象，传递查询条件；classId 班级id
     * @return: json格式的简单响应数据
     * @author: LiPeng
     * @date: 2021/2/8
     */
    @ResponseBody
    @PostMapping("updateClassIdAll")
    @ControllerEndpoint(operation = "学生分班", exceptionMessage = "学生分班失败异常")
    public FebsResponse updateClassIdAll(Student student, @NotBlank(message = "{required}") String classId) {
        log.debug("query对象：" + student);
        log.debug("分班的班级id：" + classId);
        if (classId != null) {
            this.classesService.updateClassIdAll(student, Integer.parseInt(classId) - 1000000);
            return new FebsResponse().success();
        } else {
            return new FebsResponse().fail().message("班级id为空，分班失败");
        }
    }
}