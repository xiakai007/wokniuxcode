package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.ConfirmAddress;
import cc.zy.base.businesses.entity.Major;
import cc.zy.base.businesses.service.IMajorService;
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
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 专业表 Controller
 *
 * @author guozhikun
 * @date 2021-01-26 19:41:01
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("major")
public class MajorController extends BaseController {
    @Resource
    private final IMajorService majorService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "major")
    public String majorIndex(){
        return FebsUtil.view("major/major");
    }


    /**
     * 院校专业列表
     * @param request
     * @param major
     * @return
     */
    @ResponseBody
    @GetMapping("list")
    public FebsResponse majorList(QueryRequest request, Major major) {
        Map<String, Object> dataTable = getDataTable(this.majorService.findMajors(request, major));
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * 新增专业
     * @param major
     * @return
     */
    @ResponseBody
    @PostMapping("add")
    @ControllerEndpoint(operation = "新增Major", exceptionMessage = "新增Major失败")
    public FebsResponse addMajor(@Valid Major major) {
        this.majorService.createMajor(major);
        return new FebsResponse().success();
    }

    /**
     * 修改专业
     * @param major
     * @return
     */
    @ResponseBody
    @PostMapping("update")
    @ControllerEndpoint(operation = "修改Major", exceptionMessage = "修改Major失败")
    public FebsResponse updateMajor(Major major) {
        this.majorService.updateMajor(major);
        return new FebsResponse().success();
    }

    @GetMapping("excel")
    @RequiresPermissions("user:export")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest, Major major, HttpServletResponse response) {
        List<Major> majors = this.majorService.findMajor();
        ExcelKit.$Export(Major.class, response).downXlsx(majors, false);
    }


	  /**
     * @Description 查找专业简称
     * @param majorId  专业id
     * @author houweikang
     * @date   2021/2/3
     */
    @GetMapping("findById/{majorId}")
    @ResponseBody
    public FebsResponse findById(@PathVariable Integer majorId) {
        Major major = this.majorService.findById(majorId);
        return new FebsResponse().success().data(major);
    }

    /**
     * @Description: 根据批次id、院校id、层次id查询专业
     * @Param: 批次id、院校id、层次id
     * @return: data：专业集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    @GetMapping("majorSelect")
    @ResponseBody
    public FebsResponse findMajorForSelect(Integer batchId, Integer collegeId, Integer levelId) {
        log.info("批次id：" + batchId + "，院校id：" + collegeId + "，层次id：" + levelId);
        return new FebsResponse().success().data(this.majorService.findMajorForSelect(batchId, collegeId, levelId));
    }

}

