package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.StandardFee;
import cc.zy.base.businesses.service.IStandardFeeService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import cc.zy.base.common.utils.FebsUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.wuwenze.poi.ExcelKit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 *  Controller
 *
 * @author guankai
 * @date 2021-02-01 18:07
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("standardFee")
public class StandardFeeController extends BaseController {

     @Resource
    private final IStandardFeeService standardFeeService;

    @GetMapping(FebsConstant.VIEW_BUS_PREFIX + "stanardFee")
    public String stanardFeeIndex(){
        return FebsUtil.BusinessView("stanardFee/stanardFee");
    }
/**
*  standardFeeList
*
* @author guankai
* @date 2021-02-01 18:07
*/
    @GetMapping("list")
    @ResponseBody
    @RequiresPermissions("standardFee:view")
    public FebsResponse standardFeeList(QueryRequest request, StandardFee standardFee) {
        System.out.println("===================套内缴费列表===================="+standardFee.getEntryFee()+standardFee.getCollegeName());
        Map<String, Object> dataTable = getDataTable(this.standardFeeService.findStandardFees(request, standardFee));
        return new FebsResponse().success().data(dataTable);
    }
/**
*  addStandardFee
*新增套内缴费
* @author guankai
* @date 2021-02-01 18:07
*/
    @PostMapping("add")
    @ResponseBody
    @ControllerEndpoint(operation = "新增套内缴费", exceptionMessage = "新增套内缴费失败")
    public FebsResponse addStandardFee(@Valid StandardFee standardFee) {


        int count = 0;
        try {
            count = standardFeeService.count(standardFee);
              if(count>=4){
                    return new FebsResponse().success();


                }else {

            return null;
              }

        } catch (Exception e) {
            return null;
        }










    }
/**
*  deleteColleges
*删除套内缴费记录
* @author guankai
* @date 2021-02-01 18:07
*/
    @GetMapping("delete/{standardFeeIds}")
    @ControllerEndpoint(operation = "删除套内缴费记录", exceptionMessage = "删除失败")
    @ResponseBody
    public FebsResponse deleteColleges(@NotBlank(message = "{required}") @PathVariable String standardFeeIds) {
        String[] ids = standardFeeIds.split(StringPool.COMMA);
        this.standardFeeService.deleteStandardFees(ids);
        return new FebsResponse().success();
    }
/**
*  updateStandardFee
*修改套内缴费信息
* @author guankai
* @date 2021-02-01 18:07
*/
    @PostMapping("update")
    @ControllerEndpoint(operation = "修改套内缴费信息", exceptionMessage = "修改记录失败")
    @ResponseBody
    public FebsResponse updateStandardFee(@Valid StandardFee standardFee) {
        System.out.println("===========修改套内缴费==========="+standardFee.getId());
        if (standardFee.getId() == null) {
            throw new FebsException("院校ID为空");
        }
        this.standardFeeService.updateStandardFee(standardFee);
        return new FebsResponse().success();
    }


/*************************下拉列表******************************/
/**
*  batchList
*获取所有批次
* @author guankai
* @date 2021-02-01 18:07
*/
     @GetMapping("batchlist")
    @ResponseBody
    @RequiresPermissions("standardFee:view")
    public FebsResponse batchList(Integer batchId) {
        System.out.println("================batchAll=============");
         List<Map<String, String>> maps = standardFeeService.batchAll(batchId);

        return new FebsResponse().success().data(maps);

    }


/**
*  collegeList
*获取所有院校
* @author guankai
* @date 2021-02-01 18:07
*/
     @GetMapping("collegelist")
    @ResponseBody
    @RequiresPermissions("standardFee:view")
    public FebsResponse collegeList(Integer batchId) {
        System.out.println("================collegeAll=============id:"+batchId);
         List<Map<String, String>> maps = standardFeeService.collegeAll(batchId);

        return new FebsResponse().success().data(maps);

    }
/**
*  batchList
*获取所有层次
* @author guankai
* @date 2021-02-01 18:07
*/
    @GetMapping("levallist")
    @ResponseBody
    @RequiresPermissions("standardFee:view")
    public FebsResponse levelList(Integer batchId, Integer collegeId) {
        System.out.println("================levalAll=============id:"+collegeId);
         List<Map<String, String>> maps = standardFeeService.levelAll(batchId,collegeId);

        return new FebsResponse().success().data(maps);

    }


/**
*  subjectcategoryList
*获取所有类别
* @author guankai
* @date 2021-02-01 18:07
*/
    @GetMapping("subjectcategorylist")
    @ResponseBody
    @RequiresPermissions("standardFee:view")
    public FebsResponse subjectcategoryList(Integer batchId, Integer collegeId,Integer levelId) {
        System.out.println("================subjectcategoryAll=============");
         List<Map<String, String>> maps = standardFeeService.subjectCategoryAll(batchId,collegeId,levelId);

        return new FebsResponse().success().data(maps);

    }
    /**
*  majorList
*获取所有专业
* @author guankai
* @date 2021-02-01 18:07
*/
     @GetMapping("majorlist")
    @ResponseBody
    @RequiresPermissions("standardFee:view")
    public FebsResponse majorList(Integer batchId, Integer collegeId,Integer levelId,Integer subjectCategoryId) {
        System.out.println("================majorAll=============");
         List<Map<String, String>> maps = standardFeeService.majorAll(batchId,collegeId,levelId,subjectCategoryId);

        return new FebsResponse().success().data(maps);

    }
/**
*  cultivateList
*获取所有学习形式
* @author guankai
* @date 2021-02-01 18:07
*/
        @GetMapping("cultivatelist")
    @ResponseBody
    @RequiresPermissions("standardFee:view")
    public FebsResponse cultivateList(Integer id) {
        System.out.println("================cultivatelist=============");
         List<Map<String, String>> maps = standardFeeService.cultivateAll();

        return new FebsResponse().success().data(maps);

    }
/**
*  oldBatchAll
*获取已存在批次
* @author guankai
* @date 2021-02-01 18:07
*/
         @GetMapping("oldBatchAll")
    @ResponseBody
    @RequiresPermissions("standardFee:view")
    public FebsResponse oldBatchAll(Integer id) {
        System.out.println("================oldBatchAll=============");
         List<Map<String, String>> maps = standardFeeService.oldBatchAll();

        return new FebsResponse().success().data(maps);

    }
/**
*  newBatchAll
*获取新创建批次
* @author guankai
* @date 2021-02-01 18:07
*/
    @GetMapping("newBatchAll")
    @ResponseBody
    @RequiresPermissions("standardFee:view")
    public FebsResponse newBatchAll() {
        System.out.println("================newBatchAll=============");
         List<Map<String, String>> maps = standardFeeService.newBatchAll();

        return new FebsResponse().success().data(maps);

    }
    /**
*  verify
*判断状态
* @author guankai
* @date 2021-02-01 18:07
*/
    @GetMapping("verify")
    @ResponseBody
    @RequiresPermissions("standardFee:view")
    public FebsResponse verify(Integer id) {
        System.out.println("================verify=============id:"+id);
               int verify = standardFeeService.verify(id);

                    return new FebsResponse().success().data(verify);


    }
    /**
*  copy
*批次复制
* @author guankai
* @date 2021-02-01 18:07
*/
   @GetMapping("copy")
    @ResponseBody
    @RequiresPermissions("standardFee:view")
    public FebsResponse copy(Integer oldid,Integer newid) {
        System.out.println("================copy=============id:"+newid);

       int copy = standardFeeService.copy(oldid, newid);

       return new FebsResponse().success().data(copy);


    }
    /**
*  copy
*批次复制
* @author guankai
* @date 2021-02-01 18:07
*/
   @GetMapping("verifys")
    @ResponseBody
    @RequiresPermissions("standardFee:view")
    public FebsResponse verifys(Integer batchId,Integer collegeId,Integer studyLevelId,Integer subjectCategoryId,Integer majorId,Integer cultivate ) {
        System.out.println("============RequestBody=================id:"+batchId);
//       List<StandardFee> verifys = standardFeeService.verifys(standardFee);


       int count =  standardFeeService.verifys(batchId, collegeId, studyLevelId, subjectCategoryId, majorId, cultivate);
       System.out.println("int===="+count);
         return new FebsResponse().success().data(count);

    }
     @GetMapping("excel")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest, StandardFee standardFee, HttpServletResponse response) {
        List<StandardFee> standardFees = this.standardFeeService.findStandardFees(queryRequest, standardFee).getRecords();
         System.out.println(standardFees.size()+"standardFee大小");
        ExcelKit.$Export(StandardFee.class, response).downXlsx(standardFees, false);
    }

}
