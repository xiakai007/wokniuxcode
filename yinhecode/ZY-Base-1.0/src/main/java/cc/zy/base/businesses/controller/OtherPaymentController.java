package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.OtherPayment;
import cc.zy.base.businesses.service.IOtherPaymentService;
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

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 *  Controller
 *
 * @author zzz
 * @date 2021-01-30 15:58:27
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("otherPayment")
public class OtherPaymentController extends BaseController {

    private final IOtherPaymentService otherPaymentService;


    @GetMapping(FebsConstant.VIEW_BUS_PREFIX + "otherPayment")
    public String otherPaymentIndex(){
        return FebsUtil.BusinessView("otherPayment/otherPayment");
    }
/**
*  customStandardFeeList
*查询自定义套内缴费列表
* @author guankai
* @date 2021-02-01 18:07
*/
    @GetMapping("list")
    @ResponseBody
    @RequiresPermissions("otherPayment:view")
    public FebsResponse otherPaymentList(QueryRequest request, OtherPayment otherPayment) {
        System.out.println("=====================进入其他缴费页面======================");
//        if(otherPayment==null){
//
//
//        }else {
//             System.out.println(otherPayment.getBatchId()+otherPayment.getCollegeId()+otherPayment.getMajorId()+otherPayment.getStudyLevelId()+otherPayment.getStuName());
        System.out.println("===:"+otherPayment.getBatchId()+" "+otherPayment.getCultivate());
//        }


        Map<String, Object> dataTable = getDataTable(this.otherPaymentService.findOtherPayments(request, otherPayment));
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
    public FebsResponse addOtherPayment(@Valid OtherPayment otherPayment) {


        try {
           otherPaymentService.addOtherPayment(otherPayment);
            return new FebsResponse().success();
        } catch (Exception e) {
           return null;
        }



    }
/**
*  deleteColleges
*删除其他缴费
* @author guankai
* @date 2021-02-01 18:07
*/
    @GetMapping("delete/{otherPaymentIds}")
    @ControllerEndpoint(operation = "删除自定义套内缴费", exceptionMessage = "删除失败")
    @ResponseBody
    public FebsResponse deleteColleges(@NotBlank(message = "{required}") @PathVariable String otherPaymentIds) {
        String[] ids = otherPaymentIds.split(StringPool.COMMA);
        this.otherPaymentService.deleteOtherPayments(ids);
        return new FebsResponse().success();
    }
/**
*  updateOtherPayment
*修改自定义套内缴费信息
* @author guankai
* @date 2021-02-01 18:07
*/
    @PostMapping("update")
    @ControllerEndpoint(operation = "修改其他缴费信息", exceptionMessage = "修改记录失败")
    @ResponseBody
    public FebsResponse updateOtherPayment(@Valid OtherPayment otherPayment) {
        System.out.println("===========修改套内缴费==========="+otherPayment.getId());
        if (otherPayment.getId() == null) {
            throw new FebsException("院校ID为空");
        }
        this.otherPaymentService.updateOtherPayment(otherPayment);
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
    @RequiresPermissions("otherPayment:view")
    public FebsResponse batchList(Integer batchId) {
        System.out.println("================batchAll=============");
         List<Map<String, String>> maps = otherPaymentService.batchAll(batchId);

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
    @RequiresPermissions("otherPayment:view")
    public FebsResponse collegeList(Integer batchId) {
        System.out.println("================collegeAll=============id:"+batchId);
         List<Map<String, String>> maps = otherPaymentService.collegeAll(batchId);

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
    @RequiresPermissions("otherPayment:view")
    public FebsResponse levelList(Integer batchId, Integer collegeId) {
        System.out.println("================levalAll=============id:"+collegeId);
         List<Map<String, String>> maps = otherPaymentService.levelAll(batchId,collegeId);

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
    @RequiresPermissions("otherPayment:view")
    public FebsResponse subjectcategoryList(Integer batchId, Integer collegeId,Integer levelId) {
        System.out.println("================subjectcategoryAll=============");
         List<Map<String, String>> maps = otherPaymentService.subjectCategoryAll(batchId,collegeId,levelId);

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
    @RequiresPermissions("otherPayment:view")
    public FebsResponse majorList(Integer batchId, Integer collegeId,Integer levelId,Integer subjectCategoryId) {
        System.out.println("================majorAll=============");
         List<Map<String, String>> maps = otherPaymentService.majorAll(batchId,collegeId,levelId,subjectCategoryId);

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
    @RequiresPermissions("otherPayment:view")
    public FebsResponse cultivateList(Integer id) {
        System.out.println("================cultivatelist=============");
         List<Map<String, String>> maps = otherPaymentService.cultivateAll();

        return new FebsResponse().success().data(maps);

    }
}
