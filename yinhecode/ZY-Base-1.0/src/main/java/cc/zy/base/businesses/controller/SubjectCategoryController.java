package cc.zy.base.businesses.controller;



import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.Major;
import cc.zy.base.businesses.entity.SubjectCategory;
import cc.zy.base.businesses.service.ISubjectCategoryService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * 学科类别表 Controller
 *
 * @author guozhikun
 * @date 2021-01-25 19:09:36
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("subjectCategory")
public class SubjectCategoryController extends BaseController {
    @Resource
    private final ISubjectCategoryService subjectCategoryService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "subjectCategory")
    public String subjectCategoryIndex(){
        return FebsUtil.view("subjectCategory/subjectCategory");
    }


    /**
     * 专业类别列表
     * @param request
     * @param subjectCategory
     * @return
     */
    @ResponseBody
    @GetMapping("list")
    public FebsResponse subjectCategoryList(QueryRequest request, SubjectCategory subjectCategory) {
        Map<String, Object> dataTable = getDataTable(this.subjectCategoryService.findSubjectCategorys(request, subjectCategory));
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * 类别添加
     * @param subjectCategory
     * @return
     */
    @ResponseBody
    @PostMapping("add")
    @ControllerEndpoint(operation = "类别添加", exceptionMessage = "类别添加失败")
    public FebsResponse addSubjectCategory(SubjectCategory subjectCategory,Integer levelId) {
        log.info("层次Id"+levelId);
        String code = this.subjectCategoryService.createSubjectCategory(subjectCategory, levelId);
        return new FebsResponse().success().data(code);
    }

    /**
     * 类别修改
     * @param subjectCategory
     * @return
     */
    @ResponseBody
    @PostMapping("update")
    @ControllerEndpoint(operation = "修改SubjectCategory", exceptionMessage = "修改SubjectCategory失败")
    public FebsResponse updateSubjectCategory(@Valid SubjectCategory subjectCategory) {
        if(subjectCategory.getId() ==null){
            throw new FebsException("院校类别ID为空");
        }
        this.subjectCategoryService.updateSubjectCategory(subjectCategory);
        return new FebsResponse().success();
    }

    /**
     * 导出学科类别
     * @param queryRequest
     * @param subjectCategory
     * @param response
     */
    @GetMapping("excel")
    @RequiresPermissions("user:export")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest, SubjectCategory subjectCategory, HttpServletResponse response) {
        List<SubjectCategory> subjectCategorys = this.subjectCategoryService.findSubjectCategory();
        System.out.println(subjectCategorys);
        ExcelKit.$Export(SubjectCategory.class, response).downXlsx(subjectCategorys, false);
    }


}
