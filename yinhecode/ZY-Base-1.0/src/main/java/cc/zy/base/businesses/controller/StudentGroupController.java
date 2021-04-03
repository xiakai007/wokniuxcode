package cc.zy.base.businesses.controller;

import cc.zy.base.businesses.entity.StudentGroup;
import cc.zy.base.businesses.service.IStudentGroupService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
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
import java.util.List;
import java.util.Map;

/**
 * 学生组表	 Controller
 *
 * @author LiPeng
 * @date 2021-01-26 16:24:15
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("group")
public class StudentGroupController extends BaseController {

    private final IStudentGroupService studentGroupService;

    /**
     * @Description: 查询所有学生组，倒序
     * @return: data：学生组集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    @ResponseBody
    @GetMapping("select")
    public FebsResponse getAllStudentGroups() {
        List<StudentGroup> studentGroups = studentGroupService.findStudentGroups();
        log.debug("查询到的学生组集合--下拉框：" + studentGroups);
        return new FebsResponse().success().data(studentGroups);
    }

    /**
     * @param studentGroup 学生组对象
     * @Description 展示学生组列表
     * @author houweikang
     * @date 2021/2/1
     */
    @GetMapping("list")
    @ResponseBody
    @RequiresPermissions("studentGroup:view")
    public FebsResponse studentGroupList(QueryRequest request, StudentGroup studentGroup) {
        log.debug("分页对象：" + request);
        log.debug("query对象：" + studentGroup);
        Map<String, Object> dataTable = getDataTable(this.studentGroupService.findStudentGroups(request, studentGroup));
        log.debug("查询到的结果--学生组：" + dataTable);
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * @param groupIds 学生组id数组
     * @Description 删除学生组
     * @author houweikang
     * @date 2021/2/1
     */
    @ControllerEndpoint(operation = "删除学生组", exceptionMessage = "删除学生组失败")
    @GetMapping("delete/{groupIds}")
    @ResponseBody
    public FebsResponse deleteStudentGroup(@NotBlank(message = "{required}") @PathVariable String groupIds) {
        log.debug("删除的学生组id：" + groupIds);
        if (groupIds != null && !groupIds.isEmpty()) {
            String[] ids = groupIds.split(StringPool.COMMA);
            this.studentGroupService.deleteStudentGroup(ids);
            return new FebsResponse().success();
        } else {
            return new FebsResponse().fail().message("学生组id为空，删除学生组失败");
        }

    }

    /**
     * @param studentGroup 学生组对象
     * @Description 新增学生组
     * @author houweikang
     * @date 2021/2/1
     */
    @PostMapping("add")
    @ResponseBody
    @ControllerEndpoint(operation = "新增组", exceptionMessage = "新增组失败")
    public FebsResponse addCollege(@Valid StudentGroup studentGroup) {
        log.debug("新增的学生组对象：" + studentGroup);
        this.studentGroupService.createGroup(studentGroup);
        return new FebsResponse().success();
    }

    /**
     * @param studentGroup 学生组对象
     * @Description 导出学生组Excel表
     * @author houweikang
     * @date 2021/2/1
     */
    @GetMapping("excel")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(StudentGroup studentGroup, HttpServletResponse response) {
        log.debug("导出学生组时的查询条件：" + studentGroup);
        List<StudentGroup> studentGroups = this.studentGroupService.findStudentGroups(studentGroup);
        log.debug("导出的学生组集合：" + studentGroups);
        ExcelKit.$Export(StudentGroup.class, response).downXlsx(studentGroups, false);
    }
}