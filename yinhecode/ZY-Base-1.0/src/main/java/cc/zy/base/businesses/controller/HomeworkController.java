package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.entity.Homework;
import cc.zy.base.businesses.entity.CollegeTerm;
import cc.zy.base.businesses.entity.Homework;
import cc.zy.base.businesses.service.IHomeworkService;
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

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Controller
 *
 * @author PeiZijian
 * @date 2021/01/29
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("homework")
public class HomeworkController extends BaseController {

    private final IHomeworkService homeworkService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "homework")
    public String homeworkIndex(){
        return FebsUtil.view("homework/homework");
    }

    /**
     * 作业展示
     * @param request
     * @param homework
     * @author PeiZijian
     * @date 2021/01/29
     * @return
     */
    @GetMapping("list")
    @ResponseBody
    public FebsResponse getAll(QueryRequest request, Homework homework) {
        System.out.println(homework);
        System.out.println(homework.getCourseId());
        Map<String, Object> dataTable = getDataTable(this.homeworkService.getHomeworkList(request,homework));
        if (dataTable!=null){
            return new FebsResponse().success().data(dataTable);
        }else {
            return new FebsResponse().success().data("");
        }
    }

    /**
     * 学校联动
     * @author PeiZijian
     * @date 2021/01/29
     * @return
     */
    @GetMapping("collegeList")
    @ResponseBody
    public FebsResponse getCollegeList() {
        List<College> collegeList = homeworkService.getCollegeList();
        return new FebsResponse().success().data(collegeList);
    }

    /**
     * 层次联动
     * @param collegeId
     * @author PeiZijian
     * @date 2021/01/29
     * @return
     */
    @GetMapping("levelList")
    @ResponseBody
    public FebsResponse getLevelList(Integer collegeId) {
        System.out.println(collegeId);
        List<Level> levelList = homeworkService.getLevelListByCollegeId(collegeId);
        System.out.println(levelList);
        return new FebsResponse().success().data(levelList);
    }

    /**
     * 专业联动
     * @param collegeId
     * @param levelId
     * @author PeiZijian
     * @date 2021/01/29
     * @return
     */
    @GetMapping("majorList")
    @ResponseBody
    public FebsResponse getMajorList(Integer collegeId,Integer levelId) {
        System.out.println(collegeId);
        List<Major> majorListByIds = homeworkService.getMajorListByIds(collegeId,levelId);
        System.out.println(majorListByIds);
        return new FebsResponse().success().data(majorListByIds);
    }

    /**
     * 课程搜索联动
     * @param collegeId
     * @param levelId
     * @param majorId
     * @param termId
     * @author PeiZijian
     * @date 2021/01/29
     * @return
     */
    @GetMapping("courseList")
    @ResponseBody
    public FebsResponse getCourseList(Integer collegeId,Integer levelId,Integer majorId,Integer termId) {
        System.out.println(collegeId);
        List<TeachProgram> courseNameByIds = homeworkService.getCourseNameByIds(collegeId, levelId, majorId,termId);
        System.out.println(courseNameByIds);
        return new FebsResponse().success().data(courseNameByIds);
    }

    /**
     * 学期联动
     * @param levelId
     * @author PeiZijian
     * @date 2021/01/29
     * @return
     */
    @GetMapping("termList")
    @ResponseBody
    public FebsResponse getTermList(Integer levelId) {
        List<CollegeTerm> termsByLevelId = homeworkService.getTermsByLevelId(levelId);
        return new FebsResponse().success().data(termsByLevelId);
    }

    /**
     * 学年联动
     * @param levelId
     * @author PeiZijian
     * @date 2021/01/29
     * @return
     */
    @GetMapping("yearList")
    @ResponseBody
    public FebsResponse getYearList(Integer levelId) {
        List<CollegeYear> yearByLevelId = homeworkService.getYearByLevelId(levelId);
        return new FebsResponse().success().data(yearByLevelId);
    }

    @ControllerEndpoint(operation = "删除Homework", exceptionMessage = "删除Homework失败")
    @GetMapping("homework/delete")
    @ResponseBody
    @RequiresPermissions("homework:delete")
    public FebsResponse deleteHomework(Homework homework) {
        this.homeworkService.deleteHomework(homework);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Homework", exceptionMessage = "修改Homework失败")
    @PostMapping("homework/update")
    @ResponseBody
    @RequiresPermissions("homework:update")
    public FebsResponse updateHomework(Homework homework) {
        this.homeworkService.updateHomework(homework);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Homework", exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @ResponseBody
//    @RequiresPermissions("homework:export")
    public void export(Homework homework, HttpServletResponse response) {
        List<Homework> homeworks = this.homeworkService.findHomeworks(homework);
        System.out.println(homeworks);
        ExcelKit.$Export(Homework.class, response).downXlsx(homeworks,false);
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
        log.debug("根据id查找学习作业信息入参id："+id);
        Map<String,Object> study = new HashMap<>();
        List<CollegeTerm> term = homeworkService.findTermByStuid(id);
        study.put("term",term);
        for (int i = 0; i < term.size(); i++) {
            Integer termId = term.get(i).getId();
            List<Homework> homework = homeworkService.findHomeWorkBystuid(id, termId);
            study.put("study" + i,homework);
        }
        log.debug("根据id查找学习作业信息出参study"+study);
        return new FebsResponse().success().data(study);
    }

    /**
     * 生成 Excel导出模板
     */
    @GetMapping("template")
//    @RequiresPermissions("eximport:template")
    public void generateImportTemplate(HttpServletResponse response) {
        List<HomeworkExport> list = new ArrayList<HomeworkExport>();
        // 构建模板
        ExcelKit.$Export(HomeworkExport.class, response).downXlsx(list, true);
    }

    /**
     * 导入Excel数据，并批量插入 T_EXIMPORT表
     */
    @PostMapping("import")
    @RequiresPermissions("eximport:import")
    @ControllerEndpoint(exceptionMessage = "导入Excel数据失败")
    @ResponseBody
    public FebsResponse importExcels(MultipartFile file, HttpSession session){
        log.info("导入作业数据");
        if (file.isEmpty()) {
            throw new FebsException("导入数据为空");
        }
        String filename = file.getOriginalFilename();
        if (!StringUtils.endsWith(filename, ".xlsx")) {
            throw new FebsException("只支持.xlsx类型文件导入");
        }
        try{
            String code = homeworkService.readData(file,session);
            return new FebsResponse().success().message(code);
        }catch (Exception e){
            e.printStackTrace();
            return new FebsResponse().success().message("500");
        }

    }
    
}
