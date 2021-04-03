package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.AdvertLog;
import cc.zy.base.businesses.service.IAdvertLogService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.FebsUtil;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * 广告日志
 *
 * @author 赵佳伟
 * @date 2021-01-28 09:46:04
 */

@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class AdvertLogController extends BaseController {

    private final IAdvertLogService advertLogService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "advertLog")
    public String advertLogIndex() {
        return FebsUtil.view("advertLog/advertLog");
    }

    /**
     * 查询全部广告日志
     *
     * @param advertLog 前台传来广告日志对象
     * @return
     */
    @ResponseBody
    @GetMapping("advertLog")
    public FebsResponse getAllAdvertLogs(AdvertLog advertLog) {
        log.debug("查询全部广告日志的广告对象：" + advertLog);
        return new FebsResponse().success().data(advertLogService.findAdvertLogs(advertLog));
    }

    /**
     * 查询所有广告日志，带分页
     *
     * @param request   查询条件
     * @param advertLog 广告日志
     * @return
     */
    @ResponseBody
    @GetMapping("advertLog/list")
    public FebsResponse advertLogList(QueryRequest request, AdvertLog advertLog) {
        log.debug("查询所有广告日志的广告对象：" + advertLog);
        Map<String, Object> dataTable = getDataTable(this.advertLogService.findAdvertLogs(request, advertLog));
        List<AdvertLog> advertLogsTemp = (List<AdvertLog>) dataTable.get("rows");
        List<AdvertLog> advertLogs = addTime(advertLogsTemp);
        dataTable.put("rows", advertLogs);
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * 前台点击广告记录广告日志的方法
     *
     * @param openId   小程序关联用户的id
     * @param advertId 点开广告的id
     * @return
     */
    @ResponseBody
    @PostMapping("advertLog/add")
    @ControllerEndpoint(operation = "新增广告日志", exceptionMessage = "新增广告日志异常")
    public FebsResponse addAdvertLog(@Valid String openId, Integer advertId) {
        log.debug("前台传来的openid为：" + openId);
        log.debug("前台传来的advertId为：" + advertId);
        Integer stuId = advertLogService.findStuIdByOpenId(openId);
        if (stuId != null && stuId != 0) {
            this.advertLogService.insertAdvertLogData(stuId, advertId);
            return new FebsResponse().success();
        }
        return new FebsResponse().fail();
    }

    /**
     * 用户退出广告时，执行此方法记录退出时间
     *
     * @param openId 用户关联小程序的id
     *               advertId 退出的广告id
     * @return
     */
    @ResponseBody
    @PostMapping("advertLog/update")
    public FebsResponse updateAdvertLog(String openId, Integer advertId) {
        log.debug("前台传来的openid为：" + openId);
        log.debug("前台传来的advertId为：" + advertId);
        Integer stuId = advertLogService.findStuIdByOpenId(openId);
        this.advertLogService.updateAdvertLog(stuId, advertId);
        return new FebsResponse().success();
    }

    /**
     * 导出Excel
     *
     * @param response  HttpServletResponse
     * @param advertLog 通知日志对象
     */
    @GetMapping("advertLog/excel")
    @ControllerEndpoint(exceptionMessage = "导出Excel异常")
    public void export(HttpServletResponse response, AdvertLog advertLog) {
        log.debug("导出Excel的通知日志对象：" + advertLog);
        List<AdvertLog> advertLogsTemp = this.advertLogService.exportAdvLog(advertLog);
        List<AdvertLog> advertLogs = addTime(advertLogsTemp);
        ExcelKit.$Export(AdvertLog.class, response).downXlsx(advertLogs, false);
    }

    /**
     * 给查询结果中增加阅读时长的方法
     */
    public List<AdvertLog> addTime(List<AdvertLog> advertLogs) {
        if (advertLogs != null && advertLogs.size() > 0) {
            for (AdvertLog advertLogTemp : advertLogs) {
                Timestamp enterTime = advertLogTemp.getEnterTime();
                Timestamp exitTime = advertLogTemp.getExitTime();
                if (enterTime != null && exitTime != null) {
                    long enterTimeTemp = enterTime.getTime();
                    long exitTimeTemp = exitTime.getTime();
                    long time = (exitTimeTemp - enterTimeTemp) / 1000;
                    advertLogTemp.setTime(time);
                }
            }
        }
        return advertLogs;
    }
}