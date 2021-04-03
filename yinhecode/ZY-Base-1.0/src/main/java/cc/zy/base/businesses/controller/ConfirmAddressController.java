package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.service.*;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import cc.zy.base.common.utils.FebsUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
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
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * 现场确认地点
 * @author linan
 * @date 2021-02-01
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("confirmAddress")
public class ConfirmAddressController extends BaseController {

    @Resource
    private final IConfirmAddressService confirmAddressService;
    private final IDicService dicService;

    /**
     *确认点列表展示
     * @author linan
     * @date 2021-02-03
     * @param request
     * @param confirmAddress
     * @return 带分页信息的jason数据
     */
    @GetMapping("list")
    @ResponseBody
    public FebsResponse collegeList(QueryRequest request, ConfirmAddress confirmAddress) {
        Map<String, Object> dataTable = getDataTable(this.confirmAddressService.findConfirmAddresss(request, confirmAddress));
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * 新增地点
     * @author linan
     * @date 2021-02-03
     * @param confirmAddress
     * @param status 状态id
     * @return 
     */
    @PostMapping("add")
    @ResponseBody
    @ControllerEndpoint(operation = "新增确认地点", exceptionMessage = "新增确认地失败")
    public FebsResponse addAddress(@Valid ConfirmAddress confirmAddress, String status) {

        Dic dic = dicService.findDicBid(Integer.parseInt(status));
        status = dic.getDetail();
        confirmAddress.setStatus(status);
        if (confirmAddress.getSpecificLocation().equals("")){
            throw new FebsException("详细地址为空");
        }
        this.confirmAddressService.createConfirmAddress(confirmAddress);
        return new FebsResponse().success();
    }

    /**
     * 修改确认地点
     * @author linan
     * @date 2021-02-04
     * @param confirmAddress
     * @return
     */
    @PostMapping("update")
    @ControllerEndpoint(operation = "修改确认地", exceptionMessage = "修改确认点失败")
    @ResponseBody
    public FebsResponse updateAddress(@Valid ConfirmAddress confirmAddress) {

        if (confirmAddress.getId() == null) {
            throw new FebsException("确认地ID为空");
        }
        this.confirmAddressService.updateConfirmAddress(confirmAddress);
        return new FebsResponse().success();
    }

    /**
     * 删除确认地点
     * @author linan
     * @date 2021-02-03
     * @param addressIds 删除点的id数组
     * @return
     */
    @GetMapping("delete/{addressIds}")
    @ControllerEndpoint(operation = "删除确认地点", exceptionMessage = "删除地点失败")
    @ResponseBody
    public FebsResponse deleteAddress(@NotBlank(message = "{required}") @PathVariable String addressIds) {
        String[] ids = addressIds.split(StringPool.COMMA);
        this.confirmAddressService.deleteAddress(ids);
        return new FebsResponse().success();
    }

    /**
     * 导出地点excel
     * @author linan
     * @date 2021-02-03
     * @param queryRequest
     * @param confirmAddress
     * @param response
     */
    @GetMapping("excel")
    @RequiresPermissions("user:export")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest, ConfirmAddress confirmAddress, HttpServletResponse response) {
        List<ConfirmAddress> address = this.confirmAddressService.findConfirmAddresss(queryRequest,confirmAddress).getRecords();
        ExcelKit.$Export(ConfirmAddress.class, response).downXlsx(address, false);
    }

//-------------------------------------------------------------------------------------------刘润雨
	@GetMapping(FebsConstant.VIEW_PREFIX + "confirmAddress")
    public String confirmAddressIndex(){
        return FebsUtil.view("confirmAddress/confirmAddress");
    }

    @GetMapping("confirmAddress")
    @ResponseBody
    public FebsResponse getAllConfirmAddresss(ConfirmAddress confirmAddress) {
        return new FebsResponse().success().data(confirmAddressService.findConfirmAddresss(confirmAddress));
    }

    @GetMapping("confirmAddress/list")
    @ResponseBody
    public FebsResponse confirmAddressList() {
        List<ConfirmAddress> confirmAddresss = confirmAddressService.findConfirmAddresss(null);
        System.out.println("confirm为"+confirmAddresss+"-----------------------------");
        return new FebsResponse().success().data(confirmAddresss);
    }



}
