package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.AbsenteeCost;
import cc.zy.base.businesses.entity.CostExport;
import cc.zy.base.businesses.entity.CostExportExcel;
import cc.zy.base.businesses.entity.EntranceScore;
import cc.zy.base.businesses.service.IAbsenteeCostService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.FebsUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
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

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Controller
 * 在籍缴费表控制层
 *
 * @author guozhaodi
 * @date 2021-02-03 16:29:47
 */


@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("absenteeCost")
public class AbsenteeCostController extends BaseController {

    private final IAbsenteeCostService absenteeCostService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "absenteeCost")
    public String absenteeCostIndex() {
        return FebsUtil.view("absenteeCost/absenteeCost");
    }

    @GetMapping("absenteeCost")
    @ResponseBody
    @RequiresPermissions("absenteeCost:list")
    public FebsResponse getAllAbsenteeCosts(AbsenteeCost absenteeCost) {
        return new FebsResponse().success().data(absenteeCostService.findAbsenteeCosts(absenteeCost));
    }

//    /**
//     * subjectcategoryList
//     * 获取所有类别
//     *
//     * @author guozhaodi
//     * @date 2021-02-03 17:06
//     */
//    @GetMapping("selectbyexample")
//    @ResponseBody
//    public FebsResponse selectbyexample(Integer batchId,
//                                        Integer collegeId,
//                                        Integer levelId,
//                                        Integer subjectCategoryId,
//                                        Integer majorId,
//                                        String startdate,
//                                        String enddate) {
//        System.out.println("AbsenteeCostController.selectbyexample"+startdate);
//        System.out.println("AbsenteeCostController.selectbyexample"+enddate);
//        List<Map<String, String>> maps = absenteeCostService.selectbyexample(batchId, collegeId, levelId, subjectCategoryId, majorId, startdate, enddate);
//        return new FebsResponse().success().data(maps);
//    }

    /**
     * 导出信息
     * @author guozhaodi
     * @date 2021/02/04
     * @return
     */

    @GetMapping("selectbyexample")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void selectbyexample(HttpServletResponse response, CostExport costExport) {

        System.out.println("AbsenteeCostController.selectbyexample"+costExport);

        System.out.println("AbsenteeCostController.selectbyexample--------------------------"+costExport);

        List<CostExportExcel> costExportExcelList = this.absenteeCostService.selectbyexample(costExport);

        ExcelKit.$Export(CostExportExcel.class, response).downXlsx(costExportExcelList, false);
    }


    @GetMapping("absenteeCost/list")
    @ResponseBody
    @RequiresPermissions("absenteeCost:list")
    public FebsResponse absenteeCostList(QueryRequest request, AbsenteeCost absenteeCost) {
        Map<String, Object> dataTable = getDataTable(this.absenteeCostService.findAbsenteeCosts(request, absenteeCost));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增AbsenteeCost", exceptionMessage = "新增AbsenteeCost失败")
    @PostMapping("absenteeCost")
    @ResponseBody
    @RequiresPermissions("absenteeCost:add")
    public FebsResponse addAbsenteeCost(@Valid AbsenteeCost absenteeCost) {
        this.absenteeCostService.createAbsenteeCost(absenteeCost);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除AbsenteeCost", exceptionMessage = "删除AbsenteeCost失败")
    @GetMapping("absenteeCost/delete")
    @ResponseBody
    @RequiresPermissions("absenteeCost:delete")
    public FebsResponse deleteAbsenteeCost(AbsenteeCost absenteeCost) {
        this.absenteeCostService.deleteAbsenteeCost(absenteeCost);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改AbsenteeCost", exceptionMessage = "修改AbsenteeCost失败")
    @PostMapping("absenteeCost/update")
    @ResponseBody
    @RequiresPermissions("absenteeCost:update")
    public FebsResponse updateAbsenteeCost(AbsenteeCost absenteeCost) {
        this.absenteeCostService.updateAbsenteeCost(absenteeCost);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改AbsenteeCost", exceptionMessage = "导出Excel失败")
    @PostMapping("absenteeCost/excel")
    @ResponseBody
    @RequiresPermissions("absenteeCost:export")
    public void export(QueryRequest queryRequest, AbsenteeCost absenteeCost, HttpServletResponse response) {
        List<AbsenteeCost> absenteeCosts = this.absenteeCostService.findAbsenteeCosts(queryRequest, absenteeCost).getRecords();
        ExcelKit.$Export(AbsenteeCost.class, response).downXlsx(absenteeCosts, false);
    }
}
