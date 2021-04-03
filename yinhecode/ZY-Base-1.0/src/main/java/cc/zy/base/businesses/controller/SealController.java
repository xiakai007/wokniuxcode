package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.Seal;
import cc.zy.base.businesses.service.ISealService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 印章控制层
 *
 * @author guozhaodi
 * @date 2021-01-27 09:56:39
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("seal")
public class SealController extends BaseController {

    private final ISealService sealService;

    /**
     * 印章列表显示控制层
     *
     * @author guozhaodi
     * @date 2021-01-27 09:56:39
     */

    @GetMapping("list")
    @ResponseBody
    @RequiresPermissions("seal:view")
    public FebsResponse sealList(QueryRequest request, College college) {
        Map<String, Object> dataTable = getDataTable(this.sealService.findSeals(request, college));
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * 修改学校印章图片
     *
     * @author guozhaodi
     * @date 2021-01-27 09:56:39
     */
    @ControllerEndpoint(operation = "修改Seal", exceptionMessage = "修改Seal失败")
    @PostMapping("seal/update")
    @ResponseBody
    @RequiresPermissions("seal:update")
    public FebsResponse updateSeal(Seal seal) {
        this.sealService.updateSeal(seal);
        return new FebsResponse().success();
    }
}
