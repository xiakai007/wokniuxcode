package cc.zy.base.businesses.controller;

import cc.zy.base.businesses.entity.TeachProgram;
import cc.zy.base.businesses.service.IStudentService;
import cc.zy.base.businesses.service.ITeachProgramService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.utils.FebsUtil;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.businesses.entity.Student;
import cc.zy.base.common.utils.TreeNode;
import cc.zy.base.system.service.IUserService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author Jiangjinlin
 * @date 2021-01-25 11:45:25
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController extends BaseController {
    @Resource
    private final IStudentService studentService;
    @Resource
    private ITeachProgramService iTeachProgramService;
    private final IUserService userService;

    /**
     *
     * @param request
     * @return
     * @Description: 使用通用组件查询所选择学生
     * @author zhizhao Zhang
     * @date 2021-02-03 11:52:14
     */
    @GetMapping("selectStudentlist")
    @ResponseBody
    public FebsResponse selectStudentlist(Student student, QueryRequest request) {
        log.info("StudentController selectStudentlist入参获取student的对象：" + student.getUserName());
        Map<String, Object> dataTable = getDataTable(this.studentService.selectStudentDetailList(student, request));
        log.info("StudentController selectStudentlist出参dataTable：" + dataTable);
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * @return
     * @Description: 查询所有的学生
     * @author zhizhao Zhang
     * @date 2021-02-03 11:52:14
     */
    @GetMapping("selectStudent")
    @ResponseBody
    public FebsResponse selectStudent(Student student) {
        log.info("StudentController selectStudent入参获取student的对象：" + student);
        List<Student> students = studentService.selectStudentDetail(student);
        log.info("StudentController selectStudent出参students：" + students);
        return new FebsResponse().success().data(students);
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "student")
    public String studentIndex() {
        return FebsUtil.view("student/student");
    }

    /**
     * @return
     * @Description: 做联合查询，通过院校id查询到对应的层次名称
     * @author zhizhao Zhang
     * @date 2021-02-03 11:52:14
     */
    @GetMapping("selectStudentlevelName")
    @ResponseBody
    public FebsResponse selectStudentlevelName(Integer collegeId) {
        log.info("StudentController selectStudentlevelName入参collegeId：" + collegeId);
        List<TeachProgram> levelNames = iTeachProgramService.findLevelNameByCollegeId(collegeId);
        log.info("StudentController selectStudentlevelName出参levelNames：" + levelNames);
        return new FebsResponse().success().data(levelNames);
    }

    /**
     * @return
     * @Description: 通过层次id查询到对应的专业名称
     * @author zhizhao Zhang
     * @date 2021-02-03 11:52:14
     */
    @GetMapping("selectStudentmajorName")
    @ResponseBody
    public FebsResponse selectStudentmajorName(Integer collegeId, Integer levelId) {
        log.debug("StudentController selectStudentmajorName入参collegeId:"+collegeId + "levelId:"+ levelId);
        List<TeachProgram> majorNames = iTeachProgramService.findMajoNameByLevelId(collegeId, levelId);
        log.debug("StudentController selectStudentmajorName出参majorNames:"+majorNames);
        return new FebsResponse().success().data(majorNames);
    }

    /**
     *
     * @return
     * @Description: 用户——部门下拉选择树通用组件
     * @author zhizhao Zhang
     * @date 2021-02-04 11:52:14
     */
    @GetMapping("selectStudentuserDeptTree")
    @ResponseBody
    public List<TreeNode> userDeptTree() {
        List<TreeNode> nodeList = userService.createUserDeptTree();
        log.info("StudentController selectStudentmajorName出参"+nodeList + "用户树");
        return nodeList;
    }

    @GetMapping("student")
    @ResponseBody
    public FebsResponse getAllStudents(Student student) {
        return new FebsResponse().success().data(studentService.findStudents(student));
    }

    @ControllerEndpoint(operation = "新增Student", exceptionMessage = "新增Student失败")
    @PostMapping("student")
    @ResponseBody
    public FebsResponse addStudent(@Valid Student student) {
        log.info("StudentController addStudent入参student："+student);
        this.studentService.createStudent(student);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Student", exceptionMessage = "删除Student失败")
    @GetMapping("student/delete")
    @ResponseBody
    public FebsResponse deleteStudent(Student student) {
        log.info("StudentController deleteStudent入参student："+student);
        this.studentService.deleteStudent(student);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Student", exceptionMessage = "修改Student失败")
    @PostMapping("student/update")
    @ResponseBody
    public FebsResponse updateStudent(Student student) {
        log.info("StudentController updateStudent入参student："+student);
        this.studentService.updateStudent(student);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Student", exceptionMessage = "导出Excel失败")
    @PostMapping("student/excel")
    @ResponseBody
    public void export(QueryRequest queryRequest, Student student, HttpServletResponse response) {
        log.info("StudentController export入参student："+student);
        List<Student> students = this.studentService.findStudents(queryRequest, student).getRecords();
        log.info("StudentController export出参students："+students);
        ExcelKit.$Export(Student.class, response).downXlsx(students, false);
    }

    /**
     * @description: 复学：给当前学生分配新的学习批次，可能同时存在换专业的情况
     * @param: student 学生对象，用来存储学生该学生新的信息
     * @return: 简单的json类型返回数据，包括状态码等信息
     * @author: LiPeng
     * @date: 2021/2/28
     */
    @ResponseBody
    @PostMapping("reentry")
    @ControllerEndpoint(operation = "学生复学", exceptionMessage = "复学失败异常")
    public FebsResponse studentReentry(Student student) {
        log.debug("StudentController studentReentry入参：" + student);
        if (student != null) {
            this.studentService.studentReentry(student);
            return new FebsResponse().success();
        } else {
            return new FebsResponse().fail();
        }
    }
}