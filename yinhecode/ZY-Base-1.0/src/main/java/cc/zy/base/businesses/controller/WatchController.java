package cc.zy.base.businesses.controller;

import cc.zy.base.businesses.entity.Watch;
import cc.zy.base.businesses.service.IWatchService;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 *  Controller
 *
 * @author Jiangjinlin
 * @date 2021-01-25 15:11:02
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class WatchController extends BaseController {

    private final IWatchService watchService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "watch")
    public String watchIndex(){
        return FebsUtil.view("watch/watch");
    }

    @GetMapping("watch")
    @ResponseBody
    @RequiresPermissions("watch:list")
    public FebsResponse getAllWatchs(Watch watch) {
        return new FebsResponse().success().data(watchService.findWatchs(watch));
    }

    @GetMapping("watch/list")
    @ResponseBody
    @RequiresPermissions("watch:list")
    public FebsResponse watchList(QueryRequest request, Watch watch) {
        Map<String, Object> dataTable = getDataTable(this.watchService.findWatchs(request, watch));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Watch", exceptionMessage = "新增Watch失败")
    @PostMapping("watch")
    @ResponseBody
    @RequiresPermissions("watch:add")
    public FebsResponse addWatch(@Valid Watch watch) {
        this.watchService.createWatch(watch);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Watch", exceptionMessage = "删除Watch失败")
    @GetMapping("watch/delete")
    @ResponseBody
    @RequiresPermissions("watch:delete")
    public FebsResponse deleteWatch(Watch watch) {
        this.watchService.deleteWatch(watch);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Watch", exceptionMessage = "修改Watch失败")
    @PostMapping("watch/update")
    @ResponseBody
    @RequiresPermissions("watch:update")
    public FebsResponse updateWatch(Watch watch) {
        this.watchService.updateWatch(watch);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Watch", exceptionMessage = "导出Excel失败")
    @PostMapping("watch/excel")
    @ResponseBody
    @RequiresPermissions("watch:export")
    public void export(QueryRequest queryRequest, Watch watch, HttpServletResponse response) {
        List<Watch> watchs = this.watchService.findWatchs(queryRequest, watch).getRecords();
        ExcelKit.$Export(Watch.class, response).downXlsx(watchs, false);
    }
    @ControllerEndpoint(operation = "插入Watch记录", exceptionMessage = "插入Watch记录失败")
    @PostMapping("watch/insert")
    @ResponseBody
    @RequiresPermissions("watch:insert")
    public FebsResponse insert(Watch watch) {
        this.watchService.insert(watch);
        return new FebsResponse().success();
    }
    @ControllerEndpoint(operation = "添加Watch时间结束记录", exceptionMessage = "添加Watch时间结束记录失败")
    @PostMapping("watch/updateWatchEndTime")
    @ResponseBody
    @RequiresPermissions("watch:updateWatchEndTime")
    public FebsResponse updateWatchEndTime(Watch watch) {
        this.watchService.insert(watch);
        return new FebsResponse().success();
    }
}
