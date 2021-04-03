package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.service.ITeachProgramService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import cc.zy.base.common.utils.FebsUtil;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 *  Controller
 *
 * @author peizijian
 * @date 2021/01/25
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("teachProgram")
public class TeachProgramController extends BaseController {

    @Resource
    private final ITeachProgramService teachProgramService;

    @GetMapping(FebsConstant.VIEW_BUS_PREFIX + "teachProgram")
    public String teachProgramIndex(){
        return FebsUtil.view("teachProgram/teachProgram");
    }

    /**
     * 页面展示
     * @param teachProgram
     * @return
     * @author peizijian
     * @date 2021/01/25
     */
    @GetMapping("teachProgram")
    @ResponseBody
    @RequiresPermissions("teachProgram:list")
    public FebsResponse getAllTTeachPrograms(TeachProgram teachProgram) {
        return new FebsResponse().success().data(teachProgramService.findTeachPrograms(teachProgram));
    }
    /**
     * 页面展示
     * @param teachProgram,request
     * @return
     * @author peizijian
     * @date 2021/01/25
     */
    @GetMapping("list")
    @ResponseBody
//    @RequiresPermissions("teachProgram:view")
    public FebsResponse teachProgramList(QueryRequest request, TeachProgram teachProgram) {
        Map<String, Object> dataTable = getDataTable(this.teachProgramService.findTeachProgramss(request, teachProgram));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增TeachProgram", exceptionMessage = "新增TeachProgram失败")
    @PostMapping("teachProgram")
    @ResponseBody
    @RequiresPermissions("teachProgram:add")
    public FebsResponse addTTeachProgram(TeachProgram teachProgram) {
        this.teachProgramService.createTeachProgram(teachProgram);
        return new FebsResponse().success();
    }

    /**
     * 目标批次下拉框
     * @param batch
     * @return
     * @author peizijian
     * @date 2021/01/25
     */
    @GetMapping("batchList")
    @ResponseBody
    public FebsResponse BatchList(Batch batch) {
        return new FebsResponse().success().data(teachProgramService.selectAllBatch(batch));
    }

    /**
     * 新建批次下拉框
     * @param batchName
     * @return
     * @author peizijian
     * @date 2021/01/25
     */
    @GetMapping("newBatchList")
    @ResponseBody
    public FebsResponse newBatchList(String batchName) {
        return new FebsResponse().success().data(teachProgramService.selectMoreBatch(batchName));
    }

    /**
     * 批量增加教学计划
     * @param batchName
     * @param newBatchId
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    @ControllerEndpoint(operation = "批量增加TeachProgram", exceptionMessage = "批量增加TeachProgram失败")
    @GetMapping("add")
    @ResponseBody
//    @RequiresPermissions("teachProgram:add")
    public FebsResponse addTeachProgram(String batchName,Integer newBatchId) {
        String info;
        List<TeachProgram> teachPrograms = teachProgramService.selectBatchByBatchName(batchName);
        for(TeachProgram program : teachPrograms) {
            program.setBatchId(newBatchId);
            info = program.getBatchName() + ">" + program.getLevel() + ">" + program.getTypeName() + ">"
                    + program.getStudyMode() + ">" + program.getCollegeName() + ">" + program.getMajorName() + ">"
                    + program.getSchool() + ">" + program.getYear() + ">" + program.getSemester() + ">"
                    + program.getCourseName();
            program.setInfo(info);
            teachProgramService.addNewTeachProgram(program);
        }
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除TeachProgram", exceptionMessage = "删除TeachProgram失败")
    @GetMapping("teachProgram/delete")
    @ResponseBody
    @RequiresPermissions("TeachProgram:delete")
    public FebsResponse deleteTeachProgram(TeachProgram teachProgram) {
        this.teachProgramService.deleteTeachProgram(teachProgram);
        return new FebsResponse().success();
    }

    /**
     * 单批次停用
     * @param id
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    @ControllerEndpoint(operation = "教学计划停用", exceptionMessage = "教学计划停用失败")
    @GetMapping("remove/{id}")
    @ResponseBody
//    @RequiresPermissions("teachProgram:remove")
    public FebsResponse updateStatus(@PathVariable Integer id) {
        this.teachProgramService.updateStatus(id);
        return new FebsResponse().success();
    }
    /**
     * 修改批次
     * @param
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    @ControllerEndpoint(operation = "修改TeachProgram", exceptionMessage = "修改TeachProgram失败")
    @PostMapping("update")
    @ResponseBody
//    @RequiresPermissions("teachProgram:update")
    public FebsResponse updateTeachProgram(@Valid TeachProgram teachProgram) {
        if (teachProgram.getId() == null) {
            throw new FebsException("计划ID为空");
        }
        this.teachProgramService.updateTeachPrograms(teachProgram);
        return new FebsResponse().success();
    }

    /**
     * 导出excel
     * @param teachProgram
     * @param response
     * @author peizijian
     * @date 2021/01/25
     */
    @ControllerEndpoint(operation = "修改TeachProgram", exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @ResponseBody
//    @RequiresPermissions("teachProgram:export")
    public void export(TeachProgram teachProgram, HttpServletResponse response) {
        List<TeachProgram> teachPrograms = this.teachProgramService.export(teachProgram);
        ExcelKit.$Export(TeachProgram.class, response).downXlsx(teachPrograms, false);
    }
	
    /**
     * 学院联动专业
     * @param collegeName
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    @GetMapping("findCollegeByMajor")
    @ResponseBody
    public FebsResponse findCollegeByMajor(String collegeName) {
        List<TeachProgram> collegeByMajor = teachProgramService.findCollegeByMajor(collegeName);
        return new FebsResponse().success().data(collegeByMajor);
    }

    /**
     * 专业下拉框
     * @param major
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    @GetMapping("majorList")
    @ResponseBody
    public FebsResponse getMajorList(Major major) {
        List<Major> majorListByIds = teachProgramService.getMajorList(major);
        return new FebsResponse().success().data(majorListByIds);
    }

    /**
     * 学年下拉框
     * @param collegeYear
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    @GetMapping("yearList")
    @ResponseBody
    public FebsResponse getyearList(CollegeYear collegeYear) {
        List<CollegeYear> yearList = teachProgramService.getYear(collegeYear);
        return new FebsResponse().success().data(yearList);
    }

    /**
     * 专业类别下拉框
     * @param subjectCategory
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    @GetMapping("subjectCategoryList")
    @ResponseBody
    public FebsResponse getSubjectCategory(SubjectCategory subjectCategory) {
        List<SubjectCategory> subjectCategoryList = teachProgramService.getSubjectCategory(subjectCategory);
        return new FebsResponse().success().data(subjectCategoryList);
    }

    /**
     * 学期下拉框
     * @param absoYearId
     * @author peizijian
     * @date 2021/01/25
     * @return
     */
    @GetMapping("termList")
    @ResponseBody
    public FebsResponse getTermList(Integer absoYearId) {
        List<CollegeTerm> termsByYearId = teachProgramService.getTermsByYearId(absoYearId);
        return new FebsResponse().success().data(termsByYearId);
    }

    /**
     * 增加教学计划批次
     * @param
     * @author peizijian
     * @date 2021/02/04
     * @return
     */
    @ControllerEndpoint(operation = "增加教学计划", exceptionMessage = "增加失败")
    @GetMapping("addNew")
    @ResponseBody
//    @RequiresPermissions("teachProgram:update")
    public FebsResponse addNewTeachProgram(@Valid TeachProgram teachProgram) {
        String info;
        List<TeachProgram> teachPrograms = teachProgramService.selectRepeat(teachProgram);
        System.out.println(teachPrograms);
        if (teachPrograms != null && teachPrograms.isEmpty() ){
            teachProgramService.addNewTeachProgram(teachProgram);
            info = teachProgram.getBatchName() + ">" + teachProgram.getLevel() + ">" + teachProgram.getTypeName() + ">"
                    + teachProgram.getStudyMode() + ">" + teachProgram.getCollegeName() + ">" + teachProgram.getMajorName() + ">"
                    + teachProgram.getSchool() + ">" + teachProgram.getYear() + ">" + teachProgram.getSemester() + ">"
                    + teachProgram.getCourseName();
            teachProgramService.updateInfo(teachProgram.getId(),info);
            return new FebsResponse().success();
        }
        throw new FebsException("已有此教学计划");
    }
}
