package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.Advert;
import cc.zy.base.businesses.entity.AdvertLoop;
import cc.zy.base.businesses.service.IAdvertService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import cc.zy.base.common.utils.FebsUtil;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 广告Controller
 * 完成广告信息的增删改查，以及广告的上架下架
 *
 * @author lijian
 * @date 2021/01/25
 */
@Slf4j
@Validated
@Controller
@RequestMapping("advert")
@RequiredArgsConstructor
public class AdvertController extends BaseController {

    private final IAdvertService advertService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "advert")
    public String advertIndex() {
        return FebsUtil.BusinessView("advert/advert");
    }

    /**
     * @param request
     * @param advert
     * @return 带分页信息的json数据
     * @Description 查询所有广告信息（带分页）
     */
    @ResponseBody
    @GetMapping("list")
    @RequiresPermissions("advert:view")
    public FebsResponse advertList(QueryRequest request, Advert advert) {
        log.debug("查询所有广告信息的广告对象：" + advert);
        Map<String, Object> dataTable = getDataTable(this.advertService.findAdverts(request, advert));
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * @param request
     * @return
     * @Description 查询所有轮播广告信息
     */
    @ResponseBody
    @GetMapping("looplist")
    public FebsResponse advertLoopList(QueryRequest request) {
        Map<String, Object> dataTable = getDataTable(this.advertService.findAdvertLoops(request));
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * @param advert
     * @param time   从前台页面接收的当前时间
     * @return
     * @Description 添加广告
     */
    @ResponseBody
    @PostMapping("add")
    @ControllerEndpoint(operation = "新增广告", exceptionMessage = "新增广告失败")
    public FebsResponse addAdvert(@Valid Advert advert, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:SS") Date time) {
        log.debug("添加广告的广告对象：" + advert);
        advert.setCreateTime(time);
        this.advertService.createAdvert(advert);
        return new FebsResponse().success();
    }

    /**
     * @param advertId
     * @return
     * @Description 根据id删除广告
     */
    @ResponseBody
    @GetMapping("delete/{advertId}")
    @ControllerEndpoint(operation = "删除Advert", exceptionMessage = "删除Advert失败")
    public FebsResponse deleteAdvert(@PathVariable Integer advertId) {
        log.debug("删除广告ID:" + advertId);
        if (advertId == null) {
            throw new FebsException("广告ID为空");
        }
        advertService.findAdvertDetailById(advertId);
        this.advertService.deleteAdvert(advertId);
        return new FebsResponse().success();
    }

    /**
     * @param advert
     * @return
     * @Description 修改广告信息
     */

    @ResponseBody
    @PostMapping("update")
    @ControllerEndpoint(operation = "修改Advert", exceptionMessage = "修改Advert失败")
    public FebsResponse updateAdvert(@Valid Advert advert) {
        log.debug("修改广告信息的广告对象：" + advert);
        if (advert.getId() == null) {
            throw new FebsException("广告ID为空");
        }
        Advert adById = advertService.findAdvertDetailById(advert.getId());
        if (!adById.getStatusId().equals(advert.getStatusId()) && advert.getStatusId() == 1) {
            Integer advertLoopId;
            try {
                advertLoopId = advertService.findAdvertLoopId();
            } catch (Exception e) {
                throw new FebsException("轮播广告列表无空位");
            }
        }
        this.advertService.updateAdvert(advert);
        return new FebsResponse().success();
    }

    /**
     * @param advertId
     * @return
     * @Description 通过广告id修改广告的状态（状态值 1：上架，2：下架，3：草稿）
     */
    @ResponseBody
    @GetMapping("changeStatus/{advertId}")
    @ControllerEndpoint(operation = "修改广告状态", exceptionMessage = "修改广告状态失败")
    public FebsResponse changeAdvertStatus(@PathVariable Integer advertId) {
        log.debug("修改广告状态的广告ID:" + advertId);
        if (advertId == null) {
            throw new FebsException("广告ID为空");
        }
        Advert advertDetail = this.advertService.findAdvertDetailById(advertId);
        if (advertDetail.getStatusId() == 1) {
            advertService.delAdvrertToAdvertLoop(advertId);
            advertDetail.setStatusId(2);
        } else {
            Integer advertLoopId;
            try {
                advertLoopId = advertService.findAdvertLoopId();
            } catch (Exception e) {
                throw new FebsException("轮播广告列表无空位");
            }
            advertService.addAdvertToAdvertLoop(advertId, advertLoopId);
            advertDetail.setStatusId(1);
        }
        this.advertService.updateAdvertStatus(advertDetail);
        return new FebsResponse().success();
    }

    /**
     * @param advertLoop
     * @return
     * @Description 修改轮播广告的位置
     */
    @ResponseBody
    @PostMapping("loopAdvertSort")
    @ControllerEndpoint(operation = "修改轮播广告位置", exceptionMessage = "修改广告位置失败")
    public FebsResponse updateloopAdvertSort(@Valid AdvertLoop advertLoop) {
        log.debug("广告日志对象：" + advertLoop);
        if (advertLoop.getId() == null) {
            throw new FebsException("轮播广告的位置ID为空");
        }
        if (advertLoop.getAdvertId() == null) {
            throw new FebsException("轮播广告的广告ID为空");
        }
        this.advertService.updateAdvertLoopOrder(advertLoop);
        return new FebsResponse().success();
    }

    /**
     * @param queryRequest
     * @param advert
     * @param response
     * @Description 广告列表的导出
     */
    @GetMapping("excel")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest, Advert advert, HttpServletResponse response) {
        List<Advert> adverts = this.advertService.findAdverts(queryRequest, advert).getRecords();
        ExcelKit.$Export(Advert.class, response).downXlsx(adverts, false);
    }


}
