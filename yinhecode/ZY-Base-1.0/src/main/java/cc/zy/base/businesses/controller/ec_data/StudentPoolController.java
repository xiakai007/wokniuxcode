package cc.zy.base.businesses.controller.ec_data;


import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.service.IBatchService;
import cc.zy.base.businesses.service.IDicService;
import cc.zy.base.businesses.service.IReqResultExtensionService;
import cc.zy.base.businesses.service.IStudentPoolService;
import cc.zy.base.businesses.service.impl.BatchServiceImpl;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.FebsUtil;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Controller
 *
 * @author Jiangjinlin
 * @date 2021-01-25 10:55:03
 */
@Slf4j
@Validated
@Controller
@RequestMapping("studentpool")
public class StudentPoolController extends BaseController {
    @Resource
    private   IStudentPoolService studentPoolService;
    @Resource
    private   IReqResultExtensionService iReqResultExtensionService;
    @Resource
    private   IDicService   iDicService;
    @Resource
    private   IBatchService  iBatchService;
    @GetMapping(FebsConstant.VIEW_PREFIX + "studentPool")
    public String studentPoolIndex(){
        return FebsUtil.view("studentPool/studentPool");
    }

    @GetMapping("studentPool")
    @ResponseBody
    @RequiresPermissions("studentPool:list")
    public FebsResponse getAllStudentPools(StudentPool studentPool) {
        return new FebsResponse().success().data(studentPoolService.findStudentPools(studentPool));
    }

    @GetMapping("list")
    @ResponseBody
    @RequiresPermissions("studentPool:list")
    public FebsResponse studentPoolList(QueryRequest request, StudentPool studentPool) {
        Map<String, Object> dataTable = getDataTable(this.studentPoolService.findStudentPools(request, studentPool));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增StudentPool", exceptionMessage = "新增StudentPool失败")
    @PostMapping("studentPool")
    @ResponseBody
    @RequiresPermissions("studentPool:add")
    public FebsResponse addStudentPool(@Valid StudentPool studentPool) {
        this.studentPoolService.createStudentPool(studentPool);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除StudentPool", exceptionMessage = "删除StudentPool失败")
    @GetMapping("studentPool/delete")
    @ResponseBody
    @RequiresPermissions("studentPool:delete")
    public FebsResponse deleteStudentPool(StudentPool studentPool) {
        this.studentPoolService.deleteStudentPool(studentPool);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改StudentPool", exceptionMessage = "修改StudentPool失败")
    @PostMapping("studentPool/update")
    @ResponseBody
    @RequiresPermissions("studentPool:update")
    public FebsResponse updateStudentPool(StudentPool studentPool) {
        this.studentPoolService.updateStudentPool(studentPool);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改StudentPool", exceptionMessage = "导出Excel失败")
    @PostMapping("studentPool/excel")
    @ResponseBody
    @RequiresPermissions("studentPool:export")
    public void export(QueryRequest queryRequest, StudentPool studentPool, HttpServletResponse response) {
        List<StudentPool> studentPools = this.studentPoolService.findStudentPools(queryRequest, studentPool).getRecords();
        ExcelKit.$Export(StudentPool.class, response).downXlsx(studentPools, false);
    }

}
