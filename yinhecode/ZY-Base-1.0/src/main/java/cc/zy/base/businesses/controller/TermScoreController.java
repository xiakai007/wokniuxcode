package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.mapper.TestSubjectMapper;
import cc.zy.base.businesses.service.IEntranceScoreService;
import cc.zy.base.businesses.service.ILevelService;
import cc.zy.base.businesses.service.ISubjectCategoryService;
import cc.zy.base.businesses.service.ITermScoreService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import cc.zy.base.others.entity.Eximport;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.wuwenze.poi.ExcelKit;
import com.wuwenze.poi.handler.ExcelReadHandler;
import com.wuwenze.poi.pojo.ExcelErrorField;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ?????????????????? Controller
 *
 * @author wangpin
 * @date 2021/02/01
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("termScore")
public class TermScoreController extends BaseController {
    @Resource
    private ITermScoreService iTermScoreService;

    /**
     * @author wangpin
     * ??????????????????
     * @date 2021/02/01
     * @param request
     * @param termScore
     * @return
     */
    @GetMapping("list")
    @ResponseBody
    public FebsResponse getAll(QueryRequest request, TermScore termScore) {

        Map<String, Object> dataTable = getDataTable(this.iTermScoreService.getTermScoreList(request,termScore));
        if (dataTable!=null){
            return new FebsResponse().success().data(dataTable);
        }else {
            return new FebsResponse().success().data("");
        }
    }

    /**
     * @author wangpin
     * ??????????????????
     * @date 2021/02/01
     * @return
     */
    @GetMapping("collegeList")
    @ResponseBody
    public FebsResponse getCollegeList() {
        List<College> collegeList = iTermScoreService.getCollegeList();

        return new FebsResponse().success().data(collegeList);
    }

    /**
     * ??????Excel???????????????????????? T_EXIMPORT???
     */


    /**
     * @author wangpin
     * ????????????????????????
     * @date 2021/02/01
     * @param collegeId
     * @return
     */
    @GetMapping("levelList")
    @ResponseBody
    public FebsResponse getLevelList(Integer collegeId) {

        List<Level> levelList = iTermScoreService.getLevelListByCollegeId(collegeId);

        return new FebsResponse().success().data(levelList);
    }

    /**
     * @author wangpin
     * ????????????????????????
     * @date 2021/02/01
     * @param collegeId
     * @param levelId
     * @return
     */
    @GetMapping("majorList")
    @ResponseBody
    public FebsResponse getMajorList(Integer collegeId,Integer levelId) {

        List<Major> majorListByIds = iTermScoreService.getMajorListByIds(collegeId, levelId);

        return new FebsResponse().success().data(majorListByIds);
    }

    /**
     * @author wangpin
     * ????????????????????????
     * @date 2021/02/01
     * @param collegeId
     * @param levelId
     * @param majorId
     * @param termId
     * @return
     */
    @GetMapping("courseList")
    @ResponseBody
    public FebsResponse getCourseList(Integer collegeId,Integer levelId,Integer majorId,Integer termId) {

        List<TeachProgram> courseNameByIds = iTermScoreService.getCourseNameByIds(collegeId, levelId, majorId,termId);

        return new FebsResponse().success().data(courseNameByIds);
    }

    /**
     * @author wangpin
     * ??????????????????
     * @date 2021/02/01
     * @param levelId
     * @return
     */
    @GetMapping("termList")
    @ResponseBody
    public FebsResponse getTermList(Integer levelId) {
        List<CollegeTerm> termsByLevelId = iTermScoreService.getTermsByLevelId(levelId);
        return new FebsResponse().success().data(termsByLevelId);
    }
    /**
     * @author wangpin
     * ??????excel
     * @date 2021/02/01
     * @return
     */
    @GetMapping("excel")
    @ControllerEndpoint(exceptionMessage = "??????Excel??????")
    public void export(QueryRequest request, HttpServletResponse response, TermScore termScore) {
        TermScore termScore1 = new TermScore();
        IPage<TermScore> termScoreList = this.iTermScoreService.getTermScoreList(request, termScore1);
        if (termScoreList!=null){
            List<TermScore> records = termScoreList.getRecords();
            ExcelKit.$Export(TermScore.class, response).downXlsx(records, false);
        }else {
            ExcelKit.$Export(TermScore.class, response).downXlsx(null, false);
        }
    }


    /**
     * @author wangpin
     * ??????????????????
     * @date 2021/02/01
     * @param request
     * @param termScore
     * @return
     */
    @GetMapping("errorLogList")
    @ResponseBody
    public FebsResponse errorLogList(QueryRequest request, TermScore termScore) {

        Map<String, Object> dataTable = getDataTable(this.iTermScoreService.getTermScoreList(request,termScore));
        if (dataTable!=null){
            return new FebsResponse().success().data(dataTable);
        }else {
            return new FebsResponse().success().data("");
        }
    }

    /**
     * ??????Excel???????????????????????? T_EXIMPORT???
     */
    @PostMapping("import")
    @RequiresPermissions("eximport:import")
    @ControllerEndpoint(exceptionMessage = "??????Excel????????????")
    @ResponseBody
    public FebsResponse importExcels(MultipartFile file, HttpSession session){
        if (file.isEmpty()) {
            throw new FebsException("??????????????????");
        }
        String filename = file.getOriginalFilename();
        if (!StringUtils.endsWith(filename, ".xlsx")) {
            throw new FebsException("?????????.xlsx??????????????????");
        }
        try{
            String code = iTermScoreService.readData(file,session);
            return new FebsResponse().success().message(code);
        }catch (Exception e){
            e.printStackTrace();
            String code = iTermScoreService.readData(file,session);
            return new FebsResponse().success().message("500");
        }

    }

    /**
     * ?????? Excel????????????
     */
    @GetMapping("template")
//    @RequiresPermissions("eximport:template")
    public void generateImportTemplate(HttpServletResponse response) {
        List<TermExport> list = new ArrayList<TermExport>();
        // ????????????
        ExcelKit.$Export(TermExport.class, response).downXlsx(list, true);
    }
}
