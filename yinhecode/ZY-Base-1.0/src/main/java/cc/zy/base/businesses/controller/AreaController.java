package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.City;
import cc.zy.base.businesses.service.IAreaService;
import cc.zy.base.businesses.service.ICityService;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.utils.FebsUtil;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 区
 *
 * @author 赵佳伟
 * @date 2021-01-26 16:29:51
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class AreaController extends BaseController {

    private final IAreaService areaService;
    private final ICityService cityService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "area")
    public String areaIndex() {
        return FebsUtil.view("area/area");
    }

    /**
     * 市区联动，根据前台传来的市id查询对应的区
     *
     * @param cid 市id
     * @return FebsResponse
     */
    @GetMapping("area")
    @ResponseBody
    public FebsResponse getAllAreas(Integer cid) {
        if (cid != null && cid != 0) {
            City cityById = cityService.findCityById(cid);
            String cId = cityById.getCid();
            log.info("cid的值事" + cId);
            log.info("查出来的市信息为：" + areaService.findAreas(cId));
            return new FebsResponse().success().data(areaService.findAreas(cId));
        } else {
            return null;
        }

    }

    /**
     * 查询所有的区信息
     *
     * @return FebsResponse
     */
    @GetMapping("allarea")
    @ResponseBody
    public FebsResponse getAllArea() {
        return new FebsResponse().success().data(areaService.findAllArea());
    }

}
