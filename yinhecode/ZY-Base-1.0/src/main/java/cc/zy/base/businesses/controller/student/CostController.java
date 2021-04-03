package cc.zy.base.businesses.controller.student;


import cc.zy.base.businesses.entity.Cost;
import cc.zy.base.businesses.service.ICostService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.FebsUtil;
import com.wuwenze.poi.ExcelKit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 *  Controller
 *
 * @author hu
 * @date 2021-01-25 11:42:38
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class CostController extends BaseController {

    private final ICostService costService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "cost")
    public String costIndex(){
        return FebsUtil.view("cost/cost");
    }

    @GetMapping("cost")
    @ResponseBody
    @RequiresPermissions("cost:list")
    public FebsResponse getAllCosts(Cost cost) {
        log.debug("缴费信息"+cost.toString());
        return new FebsResponse().success().data(costService.findCosts(cost));
    }

    @GetMapping("cost/list")
    @ResponseBody
    @RequiresPermissions("cost:list")
    public FebsResponse costList(QueryRequest request, Cost cost) {
        Map<String, Object> dataTable = getDataTable(this.costService.findCosts(request, cost));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Cost", exceptionMessage = "新增Cost失败")
    @PostMapping("cost")
    @ResponseBody
    @RequiresPermissions("cost:add")
    public FebsResponse addCost(@Valid Cost cost) {
        this.costService.createCost(cost);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Cost", exceptionMessage = "删除Cost失败")
    @GetMapping("cost/delete")
    @ResponseBody
    @RequiresPermissions("cost:delete")
    public FebsResponse deleteCost(Cost cost) {
        this.costService.deleteCost(cost);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Cost", exceptionMessage = "修改Cost失败")
    @PostMapping("cost/update")
    @ResponseBody
    @RequiresPermissions("cost:update")
    public FebsResponse updateCost(Cost cost) {
        this.costService.updateCost(cost);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Cost", exceptionMessage = "导出Excel失败")
    @PostMapping("cost/excel")
    @ResponseBody
    @RequiresPermissions("cost:export")
    public void export(QueryRequest queryRequest, Cost cost, HttpServletResponse response) {
        List<Cost> costs = this.costService.findCosts(queryRequest, cost).getRecords();
        ExcelKit.$Export(Cost.class, response).downXlsx(costs, false);
    }
}
