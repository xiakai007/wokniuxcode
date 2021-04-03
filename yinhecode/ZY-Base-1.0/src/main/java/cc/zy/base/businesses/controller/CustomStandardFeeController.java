package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.CustomStandardFee;
import cc.zy.base.businesses.service.ICustomStandardFeeService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import cc.zy.base.common.utils.FebsUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
*  controller
*
* @author guankai
* @date 2021-02-01 18:07
*/
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("customStandardFee")
public class CustomStandardFeeController extends BaseController {
     @Resource
    private final ICustomStandardFeeService customStandardFeeService;



    @GetMapping(FebsConstant.VIEW_BUS_PREFIX + "customStandardFee")
    public String customStanardFeeIndex(){
        return FebsUtil.BusinessView("customStanardFee/customStanardFee");
    }
/**
*  customStandardFeeList
*查询自定义套内缴费列表
* @author guankai
* @date 2021-02-01 18:07
*/
    @GetMapping("list")
    @ResponseBody
    @RequiresPermissions("customStandardFee:view")
    public FebsResponse customStandardFeeList(QueryRequest request, CustomStandardFee customStandardFee) {

        Map<String, Object> dataTable = getDataTable(this.customStandardFeeService.findCustomStandardFees(request, customStandardFee));
        return new FebsResponse().success().data(dataTable);
    }
/**
*  addStandardFee
*新增自定义套内缴费
* @author guankai
* @date 2021-02-01 18:07
*/
    @PostMapping("add")
    @ResponseBody
    @ControllerEndpoint(operation = "新增自定义套内缴费", exceptionMessage = "新增失败")
    public FebsResponse addStandardFee(@Valid CustomStandardFee customStandardFee) {


        try {
            customStandardFeeService.addCustomStandardFee(customStandardFee);
            return new FebsResponse().success();
        } catch (Exception e) {
           return null;
        }



    }
/**
*  deleteColleges
*删除自定义套内缴费
* @author guankai
* @date 2021-02-01 18:07
*/
    @GetMapping("delete/{customStandardFeeIds}")
    @ControllerEndpoint(operation = "删除自定义套内缴费", exceptionMessage = "删除失败")
    @ResponseBody
    public FebsResponse deleteColleges(@NotBlank(message = "{required}") @PathVariable String customStandardFeeIds) {
        String[] ids = customStandardFeeIds.split(StringPool.COMMA);
        this.customStandardFeeService.deleteCustomStandardFees(ids);
        return new FebsResponse().success();
    }
/**
*  updateCustomStandardFee
*修改自定义套内缴费信息
* @author guankai
* @date 2021-02-01 18:07
*/
    @PostMapping("update")
    @ControllerEndpoint(operation = "修改自定义套内缴费信息", exceptionMessage = "修改记录失败")
    @ResponseBody
    public FebsResponse updateCustomStandardFee(@Valid CustomStandardFee customStandardFee) {
        System.out.println("===========修改套内缴费==========="+customStandardFee.getId());
        if (customStandardFee.getId() == null) {
            throw new FebsException("院校ID为空");
        }
        this.customStandardFeeService.updateCustomStandardFee(customStandardFee);
        return new FebsResponse().success();
    }


/*************************下拉列表******************************/
/**
*  batchList
*
* @author guankai
* @date 2021-02-01 18:07
*/
     @GetMapping("batchlist")
    @ResponseBody
    @RequiresPermissions("customStandardFee:view")
    public FebsResponse batchList(Integer batchId) {
        System.out.println("================batchAll=============");
         List<Map<String, String>> maps = customStandardFeeService.batchAll(batchId);

        return new FebsResponse().success().data(maps);

    }


/**
*  collegeList
*
* @author guankai
* @date 2021-02-01 18:07
*/
     @GetMapping("collegelist")
    @ResponseBody
    @RequiresPermissions("customStandardFee:view")
    public FebsResponse collegeList(Integer batchId) {
        System.out.println("================collegeAll=============id:"+batchId);
         List<Map<String, String>> maps = customStandardFeeService.collegeAll(batchId);

        return new FebsResponse().success().data(maps);

    }
/**
*  levelList
*
* @author guankai
* @date 2021-02-01 18:07
*/
    @GetMapping("levallist")
    @ResponseBody
    @RequiresPermissions("customStandardFee:view")
    public FebsResponse levelList(Integer batchId, Integer collegeId) {
        System.out.println("================levalAll=============id:"+collegeId);
         List<Map<String, String>> maps = customStandardFeeService.levelAll(batchId,collegeId);

        return new FebsResponse().success().data(maps);

    }

/**
*  subjectcategoryList
*
* @author guankai
* @date 2021-02-01 18:07
*/

    @GetMapping("subjectcategorylist")
    @ResponseBody
    @RequiresPermissions("customStandardFee:view")
    public FebsResponse subjectcategoryList(Integer batchId, Integer collegeId,Integer levelId) {
        System.out.println("================subjectcategoryAll=============");
         List<Map<String, String>> maps = customStandardFeeService.subjectCategoryAll(batchId,collegeId,levelId);

        return new FebsResponse().success().data(maps);

    }
    /**
*  majorList
*
* @author guankai
* @date 2021-02-01 18:07
*/
     @GetMapping("majorlist")
    @ResponseBody
    @RequiresPermissions("customStandardFee:view")
    public FebsResponse majorList(Integer batchId, Integer collegeId,Integer levelId,Integer subjectCategoryId) {
        System.out.println("================majorAll=============");
         List<Map<String, String>> maps = customStandardFeeService.majorAll(batchId,collegeId,levelId,subjectCategoryId);

        return new FebsResponse().success().data(maps);

    }
/**
*  cultivateList
*
* @author guankai
* @date 2021-02-01 18:07
*/
        @GetMapping("cultivatelist")
    @ResponseBody
    @RequiresPermissions("customStandardFee:view")
    public FebsResponse cultivateList(Integer id) {
        System.out.println("================cultivatelist=============");
         List<Map<String, String>> maps = customStandardFeeService.cultivateAll();

        return new FebsResponse().success().data(maps);

    }








}
