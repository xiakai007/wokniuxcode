package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.City;
import cc.zy.base.businesses.entity.Province;
import cc.zy.base.businesses.service.ICityService;
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
 * 市
 *
 * @author 赵佳伟
 * @date 2021-01-26 11:50:10
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class CityController extends BaseController {

    private final ICityService cityService;
    private final IProvinceService provinceService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "city")
    public String cityIndex(){
        return FebsUtil.view("city/city");
    }

    /**
     * 省市联动，根据前台传来的省id查询对应的市信息
     * @param pid
     * @return
     */
    @GetMapping("city")
    @ResponseBody
    public FebsResponse getAllCitys(Integer pid) {
        log.info("得到的pid为："+pid);
        if(pid != null && pid != 0) {
            List<Province> provinces = provinceService.findProvinces(pid);
            String pId = provinces.get(0).getPid();
            log.info("查出来的市信息为：" + cityService.findCitys(pId));
            return new FebsResponse().success().data(cityService.findCitys(pId));
        }else{
            return null;
        }
    }

    /**
     * 查询所有的市信息
     * @return
     */
    @GetMapping("allcity")
    @ResponseBody
    public FebsResponse getAllCity() {
        return new FebsResponse().success().data(cityService.findAllCity());
    }

}
