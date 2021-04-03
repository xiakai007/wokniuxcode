package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.Province;
import cc.zy.base.businesses.service.IProvinceService;
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
 *  省Controller
 *
 * @author zhaojw
 * @date 2021-01-26 11:49:58
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class ProvinceController extends BaseController {

    private final IProvinceService provinceService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "province")
    public String provinceIndex(){
        return FebsUtil.view("province/province");
    }

    /**
     * 获取所有省份
     * @return
     */
    @GetMapping("province")
    @ResponseBody
    //@RequiresPermissions("province:list")
    public FebsResponse getAllProvinces() {
        return new FebsResponse().success().data(provinceService.findProvinces(null));
    }


}
