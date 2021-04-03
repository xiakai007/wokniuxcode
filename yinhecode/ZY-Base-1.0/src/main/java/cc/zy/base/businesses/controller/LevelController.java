package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.Level;
import cc.zy.base.businesses.service.ILevelService;
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
 * 层次表 Controller
 *
 * @author LiPeng
 * @date 2021-01-27 18:42:21
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class LevelController extends BaseController {

    private final ILevelService levelService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "level")
    public String levelIndex(){
        return FebsUtil.view("level/level");
    }

    @GetMapping("level")
    @ResponseBody
//    @RequiresPermissions("level:list")
    public FebsResponse getAllLevels(Level level) {
        return new FebsResponse().success().data(levelService.findLevels(level));
    }

    @GetMapping("level/list")
    @ResponseBody
    @RequiresPermissions("level:list")
    public FebsResponse levelList(QueryRequest request, Level level) {
        Map<String, Object> dataTable = getDataTable(this.levelService.findLevels(request, level));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Level", exceptionMessage = "新增Level失败")
    @PostMapping("level")
    @ResponseBody
    @RequiresPermissions("level:add")
    public FebsResponse addLevel(@Valid Level level) {
        this.levelService.createLevel(level);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Level", exceptionMessage = "删除Level失败")
    @GetMapping("level/delete")
    @ResponseBody
    @RequiresPermissions("level:delete")
    public FebsResponse deleteLevel(Level level) {
        this.levelService.deleteLevel(level);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Level", exceptionMessage = "修改Level失败")
    @PostMapping("level/update")
    @ResponseBody
    @RequiresPermissions("level:update")
    public FebsResponse updateLevel(Level level) {
        this.levelService.updateLevel(level);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Level", exceptionMessage = "导出Excel失败")
    @PostMapping("level/excel")
    @ResponseBody
    @RequiresPermissions("level:export")
    public void export(QueryRequest queryRequest, Level level, HttpServletResponse response) {
        List<Level> levels = this.levelService.findLevels(queryRequest, level).getRecords();
        ExcelKit.$Export(Level.class, response).downXlsx(levels, false);
    }
}
