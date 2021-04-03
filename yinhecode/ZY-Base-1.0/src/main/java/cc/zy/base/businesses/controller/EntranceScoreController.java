package cc.zy.base.businesses.controller;
import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.mapper.EntranceScoreMapper;
import cc.zy.base.businesses.mapper.TestSubjectMapper;
import cc.zy.base.businesses.service.IEntranceScoreService;
import cc.zy.base.businesses.service.ILevelService;
import cc.zy.base.businesses.service.ISubjectCategoryService;
import cc.zy.base.businesses.utils.ReadExcel;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import cc.zy.base.others.entity.Eximport;
import cc.zy.base.system.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.wuwenze.poi.ExcelKit;
import com.wuwenze.poi.handler.ExcelReadHandler;
import com.wuwenze.poi.pojo.ExcelErrorField;
import com.wuwenze.poi.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.IntStream;

/**
 * 入学成绩模块 Controller
 *
 * @author wangpin
 * @date 2021/02/01
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("entranceScore")
public class EntranceScoreController extends BaseController {
    @Resource
    private IEntranceScoreService iEntranceScoreService;
    @Resource
    private TestSubjectMapper testSubjectMapper;
    @Resource
    private ISubjectCategoryService iSubjectCategoryService;
    @Resource
    private ILevelService iLevelService;
    @Resource
    private EntranceScoreMapper entranceScoreMapper;
    /**
     * 查询列表信息
     * @author wangpin
     * @date 2021/02/01
     * @param request
     * @param entranceScore
     * @return
     */
    @GetMapping("list")
    @ResponseBody
    public FebsResponse getAll(QueryRequest request, EntranceScore entranceScore) {
        log.debug("批次  "+entranceScore.getBatchId());

        //判断总数据是否有数据
        Boolean flag = true;
        IPage<EntranceScore> list = this.iEntranceScoreService.findList(entranceScore, request);
        if (list!=null){
            List<EntranceScore> records = list.getRecords();
            if (records!=null&&!records.isEmpty()){
                for (EntranceScore score : records) {
                    if (score.getStuName() == null || score.getStuName().equals("")) {
                        flag = false;
                        break;
                    }
                }
            }else {
                flag=false;
            }
            //如果总数据是空返回空，反之则返回数据
            if (flag) {
                //查所有
                Map<String, Object> dataTable = getDataTable(list);
                return new FebsResponse().success().data(dataTable);
            } else {
                return new FebsResponse().success().data("");
            }
        }else {
            return new FebsResponse().success().data("");
        }
    }

    /**
     * 导入Excel数据，并批量插入 T_EXIMPORT表
     */
    @PostMapping("import")
    @RequiresPermissions("eximport:import")
    @ControllerEndpoint(exceptionMessage = "导入Excel数据失败")
    @ResponseBody
    public FebsResponse importExcels(MultipartFile file, HttpSession session){
        if (file.isEmpty()) {
            throw new FebsException("导入数据为空");
        }
        String filename = file.getOriginalFilename();
        if (!StringUtils.endsWith(filename, ".xlsx")) {
            throw new FebsException("只支持.xlsx类型文件导入");
        }
        try {
            String code = iEntranceScoreService.readData(iEntranceScoreService, file,session);
            return new FebsResponse().success().message(code);
        }catch (Exception e){
            e.printStackTrace();
            return new FebsResponse().success().message("500");
        }

    }

    /**
     * 查询入学考试科目
     * @author wangpin
     * @date 2021/02/01
     * @param levelId
     * @param subtypeId
     * @return
     */
    @GetMapping("subjects")
    @ResponseBody
    public FebsResponse getSubjects(Integer levelId, Integer subtypeId) {
//        System.out.println("subtypeId" + subtypeId);
//        System.out.println("levelId" + levelId);
        List<TestSubject> subjests = testSubjectMapper.getSubjestsById(levelId, subtypeId);
        System.out.println(subjests);
        return new FebsResponse().success().data(subjests);
    }

    /**
     * 查询层次
     * @author wangpin
     * @date 2021/02/01
     * @return
     */
    @GetMapping("levelList")
    @ResponseBody
    public FebsResponse getlevelList() {
        List<Level> levels = iLevelService.findLevels();
        System.out.println(levels);
        return new FebsResponse().success().data(levels);
    }

    /**
     * 获取所有科目类别
     * @param levelId
     * @return
     */
    @GetMapping("subTypeList")
    @ResponseBody
    public FebsResponse getSubTypeList(Integer levelId) {
//        System.out.println(levelId);
        List<SubjectCategory> subjectCategorys = iSubjectCategoryService.getSubjectCategorys(levelId);

        return new FebsResponse().success().data(subjectCategorys);
    }
    /**
     * @author wangpin
     * @date 2021/02/01
     * 获取所有批次
     * @return
     */
    @GetMapping("batchs")
    @ResponseBody
    public FebsResponse getBatchs() {
        List<EntranceScore> batchs = iEntranceScoreService.getBatchs();
        return new FebsResponse().success().data(batchs);
    }

    /**
     * 通过批次Id获取院校名称
     * @author wangpin
     * @date 2021/02/01
     * @return
     */
    @GetMapping("colleges")
    @ResponseBody
    public FebsResponse getCollegeByBatchId(Integer batchId) {
        System.out.println(batchId);
        List<EntranceScore> colleges = iEntranceScoreService.getCollegesByBatchId(batchId);
        return new FebsResponse().success().data(colleges);
    }

    /**
     * 导出信息
     * @author wangpin
     * @date 2021/02/01
     * @return
     */
    @GetMapping("excel")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest request, HttpServletResponse response, EntranceScore entranceScore) {
        List<EntranceScore> list = this.iEntranceScoreService.exportList(entranceScore,request);
        for (EntranceScore record : list) {
            String status = record.getStatus();
            if (status.equals("1")){
                record.setStatus("通过");
            }else if (status.equals("2")){
                record.setStatus("未过");
            }else if (status.equals("3")){
                record.setStatus("缺考");
            }else if (status.equals("4")){
                record.setStatus("其他");
            }
        }
        ExcelKit.$Export(EntranceScore.class, response).downXlsx(list, false);


    }

    /**
     * 修改学生状态
     * @author wangpin
     * @date 2021/02/01
     * @return
     */
    @GetMapping("changeStatus")
    @ResponseBody
    public FebsResponse getChangeStatus(EntranceScore entranceScore) {
        System.out.println(entranceScore.getIdentity());
        System.out.println(entranceScore.getStatus());
        int i = iEntranceScoreService.changeEntranceScoreStatus(entranceScore);
        if (i==1){
            return new FebsResponse().success();
        }else {
            return new FebsResponse().data("");
        }

    }



    /**
     * 生成 Excel导出模板
     */
    @GetMapping("template")
//    @RequiresPermissions("eximport:template")
    public void generateImportTemplate(HttpServletResponse response) {
        List<EntranceExport> list = new ArrayList<EntranceExport>();
        // 构建模板
        ExcelKit.$Export(EntranceExport.class, response).downXlsx(list, true);
    }

    /**
     * @author wangpin
     * 查询列表数据
     * @date 2021/02/01
     * @param request
     * @param
     * @return
     */
    @GetMapping("errorLogList")
    @ResponseBody
    public FebsResponse errorLogList(QueryRequest request,HttpSession session) {

        String unique =(String) session.getAttribute("unique");
        IPage<ErrorLog> errorLogs = this.iEntranceScoreService.getErrorLogs(request,session);
        Map<String, Object> dataTable = getDataTable(errorLogs);
        return new FebsResponse().success().data(dataTable);
    }
}
